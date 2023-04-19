package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.model.login.TricotLoginReq;
import cl.tricotcorp.financial.totp.model.login.VxcLoginResp;
import cl.tricotcorp.financial.totp.entity.smssend.SendSmsResp;
import cl.tricotcorp.financial.totp.model.token.TokenResp;
import cl.tricotcorp.financial.totp.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupService {
    @Autowired
    private InfoRepository infoRepository;

    public TokenResp getToken() {
        TokenResp tokenResp;
        tokenResp = infoRepository.getToken();
        return tokenResp;
    }

    public VxcLoginResp validateLogin(String rut, String password, String tokenId) {

        TricotLoginReq tricotLoginReq = new TricotLoginReq();
        tricotLoginReq.setIdentificationNumber(rut);
        tricotLoginReq.setPassword(password);


        return infoRepository.validateLogin(tricotLoginReq, tokenId);
    }

    public SendSmsResp sendSMS(String processId, String tokenId) {

        return infoRepository.sendSMS(processId, tokenId);
    }


}
