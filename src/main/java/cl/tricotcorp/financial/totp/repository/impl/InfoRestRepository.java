package cl.tricotcorp.financial.totp.repository.impl;

import cl.tricotcorp.financial.totp.model.TricotErrorResp;
import cl.tricotcorp.financial.totp.model.login.TricotLoginReq;
import cl.tricotcorp.financial.totp.model.login.TricotLoginResp;
import cl.tricotcorp.financial.totp.model.login.VxcLoginResp;
import cl.tricotcorp.financial.totp.entity.smssend.SendSmsResp;
import cl.tricotcorp.financial.totp.entity.smssend.TricotSendSmsReq;
import cl.tricotcorp.financial.totp.model.smssend.TricotSendSmsResp;
import cl.tricotcorp.financial.totp.model.token.TokenResp;
import cl.tricotcorp.financial.totp.model.token.TricotTokenReq;
import cl.tricotcorp.financial.totp.model.token.TricotTokenResp;
import cl.tricotcorp.financial.totp.model.smsvalidate.TricotValidateSmsReq;
import cl.tricotcorp.financial.totp.model.smsvalidate.TricotValidateSmsResp;
import cl.tricotcorp.financial.totp.entity.smsvalidate.ValidateSmsResp;
import cl.tricotcorp.financial.totp.repository.InfoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Repository
public class InfoRestRepository implements InfoRepository {


    @Value("${totp.token.url}")
    private String tokenUrl;

    @Value("${totp.token.grant_type}")
    private String tokenGrantType;
    @Value("${totp.token.client_id}")
    private String tokenClientId;
    @Value("${totp.token.client_secret}")
    private String tokenClientSecret;
    @Value("${totp.token.scope}")
    private String tokenScope;

    @Value("${totp.login.url}")
    private String loginUrl;
    @Value("${totp.sendsms.url}")
    private String sendSmsUrl;
    @Value("${totp.validasms.url}")
    private String validaSmsUrl;

    @Value("${totp.token.readtimeout}")
    private int tokenReadTimeout;
    @Value("${totp.token.conntimeout}")
    private int tokenConnTimeout;

    @Value("${totp.login.readtimeout}")
    private int loginReadTimeout;
    @Value("${totp.login.conntimeout}")
    private int loginConnTimeout;

    @Value("${totp.sndsms.readtimeout}")
    private int sndSmsReadTimeout;
    @Value("${totp.sndsms.conntimeout}")
    private int sndSmsConnTimeout;

    @Value("${totp.valsms.readtimeout}")
    private int valSmsReadTimeout;
    @Value("${totp.valsms.conntimeout}")
    private int valSmsConnTimeout;


    @Autowired
    public InfoRestRepository() {

    }

    @Override
    public TokenResp getToken() {

        TricotTokenReq tricotTokenReq = new TricotTokenReq();

        TricotTokenResp tricotTokenResp = new TricotTokenResp();
        TokenResp tokenResp = new TokenResp();

        tricotTokenReq.setGrantType(tokenGrantType);
        tricotTokenReq.setClientId(tokenClientId);
        tricotTokenReq.setClientSecret(tokenClientSecret);
        tricotTokenReq.setScope(tokenScope);

        String uri = tokenUrl;


        RestTemplate restTemplate = new RestTemplate();

// Manejo de Time Out
        SimpleClientHttpRequestFactory  rf = new SimpleClientHttpRequestFactory();
        rf.setReadTimeout(tokenReadTimeout);
        rf.setConnectTimeout(tokenConnTimeout);
        restTemplate.setRequestFactory(rf);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        Gson gson = new Gson();

        HttpEntity<TricotTokenReq> entity = new HttpEntity<>(tricotTokenReq, headers);


        ResponseEntity<TricotTokenResp> response = restTemplate.exchange(
                uri ,
                HttpMethod.POST,
                entity,
                TricotTokenResp.class);
        if (response.getStatusCode() == HttpStatus.OK){
            tricotTokenResp = response.getBody();
            tokenResp.setErrorCode(0);
            tokenResp.setTokenType(tricotTokenResp.getTokenType());
            tokenResp.setAccessToken(tricotTokenResp.getAccessToken());
            tokenResp.setExpiresIn(tricotTokenResp.getExpiresIn());

        } else
        {
//            tokenErrResp = response.getBody();
            tokenResp.setErrorCode(response.getStatusCodeValue());
//            tokenVxcResp.setError(tokenErrResp.getError());
//            tokenVxcResp.setErrorDescription(tokenErrResp.getErrorDescription());
        }

        return tokenResp;
    }

    @Override
    public VxcLoginResp validateLogin(TricotLoginReq tricotLoginReq, String tokenId) {

        VxcLoginResp vxcLoginResp = new VxcLoginResp();
        TricotLoginResp tricotLoginResp = new TricotLoginResp();

        String uri = loginUrl;

        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ tokenId);

// Manejo de Time Out
        SimpleClientHttpRequestFactory  rf = new SimpleClientHttpRequestFactory();
        rf.setReadTimeout(loginReadTimeout);
        rf.setConnectTimeout(loginConnTimeout);
        restTemplate.setRequestFactory(rf);

        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        Gson gson = new Gson();

        HttpEntity<TricotLoginReq> entity = new HttpEntity<>(tricotLoginReq, headers);


        ResponseEntity<TricotLoginResp> response = restTemplate.exchange(
                uri ,
                HttpMethod.POST,
                entity,
                TricotLoginResp.class);
        if (response.getStatusCode() == HttpStatus.OK){
            tricotLoginResp = response.getBody();
            vxcLoginResp.setErrorCode(0);
            vxcLoginResp.setCode(tricotLoginResp.getCode());
            vxcLoginResp.setDescription(tricotLoginResp.getDescription());
            vxcLoginResp.setProcessId(tricotLoginResp.getProcessId());
        } else
        {
//            tokenErrResp = response.getBody();
            vxcLoginResp.setErrorCode(response.getStatusCodeValue());
//            tokenVxcResp.setError(tokenErrResp.getError());
//            tokenVxcResp.setErrorDescription(tokenErrResp.getErrorDescription());
        }

        return vxcLoginResp;
    }

    @Override
    public SendSmsResp sendSMS(String processId, String tokenId) {

        TricotSendSmsReq tricotSendSmsReq = new TricotSendSmsReq();
        tricotSendSmsReq.setProcessId(processId);
        TricotSendSmsResp tricotSendSmsResp = new TricotSendSmsResp();
        SendSmsResp sendSmsResp = new SendSmsResp();
        String uri = sendSmsUrl;

        String ret = "";

        RestTemplate restTemplate = new RestTemplate();

// Manejo de Time Out
        SimpleClientHttpRequestFactory  rf = new SimpleClientHttpRequestFactory();
        rf.setReadTimeout(sndSmsReadTimeout);
        rf.setConnectTimeout(sndSmsConnTimeout);
        restTemplate.setRequestFactory(rf);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ tokenId);

        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        Gson gson = new Gson();

        HttpEntity<TricotSendSmsReq> entity = new HttpEntity<>(tricotSendSmsReq, headers);


        ResponseEntity<TricotSendSmsResp> response = restTemplate.exchange(
                uri ,
                HttpMethod.POST,
                entity,
                TricotSendSmsResp.class);
        if (response.getStatusCode() == HttpStatus.OK){
            tricotSendSmsResp = response.getBody();
            sendSmsResp.setCodError(tricotSendSmsResp.getCode());
            sendSmsResp.setMsgError("Ok");
            sendSmsResp.setPhoneNumber(tricotSendSmsResp.getPhoneNumber());
        } else
        {
            sendSmsResp.setCodError(response.getStatusCodeValue());
            sendSmsResp.setMsgError("Error al enviar SMS");
        }
        return sendSmsResp;
    }
    @Override
    public ValidateSmsResp validateSMS(TricotValidateSmsReq tricotValidateSmsReq, String tokenId) {

        TricotValidateSmsResp tricotValidateSmsResp = new TricotValidateSmsResp();
        TricotErrorResp tricotErrorResp = new TricotErrorResp();
        ValidateSmsResp validateSmsResp = new ValidateSmsResp();
        String uri = validaSmsUrl;

        String ret = "";

        RestTemplate restTemplate = new RestTemplate();

// Manejo de Time Out
        SimpleClientHttpRequestFactory  rf = new SimpleClientHttpRequestFactory();
        rf.setReadTimeout(valSmsReadTimeout);
        rf.setConnectTimeout(valSmsConnTimeout);
        restTemplate.setRequestFactory(rf);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ tokenId);


        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        Gson gson = new Gson();

        HttpEntity<TricotValidateSmsReq> entity = new HttpEntity<>(tricotValidateSmsReq, headers);


        ResponseEntity<TricotValidateSmsResp> response = restTemplate.exchange(
                uri ,
                HttpMethod.POST,
                entity,
                TricotValidateSmsResp.class);
        if (response.getStatusCode() == HttpStatus.OK){
            tricotValidateSmsResp = response.getBody();
//            validateSmsResp.setCodError(response.getStatusCodeValue());
            validateSmsResp.setCodError(0);
            validateSmsResp.setMsgError("OK");
            validateSmsResp.setDesError("OK");
        } else
        {
           validateSmsResp.setCodError(response.getStatusCodeValue());
           validateSmsResp.setMsgError(tricotErrorResp.getError());
           validateSmsResp.setDesError(tricotErrorResp.getErrorDescription());
        }
        return validateSmsResp;
    }

}
