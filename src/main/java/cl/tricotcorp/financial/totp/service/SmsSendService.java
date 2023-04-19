package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.entity.smssend.SendSmsResp;
import cl.tricotcorp.financial.totp.model.token.TokenResp;
import cl.tricotcorp.financial.totp.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsSendService {
    @Autowired
    private  InfoRepository infoRepository;


    public TokenResp getToken(){
        TokenResp tokenResp;
        tokenResp = infoRepository.getToken();
        return tokenResp;
    }
    public SendSmsResp sendSMS(String processId, String tokenId) {

        return infoRepository.sendSMS(processId, tokenId);
    }
}
