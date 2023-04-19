package cl.tricotcorp.financial.totp.repository;


import cl.tricotcorp.financial.totp.model.login.TricotLoginReq;
import cl.tricotcorp.financial.totp.model.login.VxcLoginResp;
import cl.tricotcorp.financial.totp.entity.smssend.SendSmsResp;
import cl.tricotcorp.financial.totp.model.token.TokenResp;
import cl.tricotcorp.financial.totp.model.smsvalidate.TricotValidateSmsReq;
import cl.tricotcorp.financial.totp.entity.smsvalidate.ValidateSmsResp;

public interface InfoRepository {

    TokenResp getToken();
    VxcLoginResp validateLogin(TricotLoginReq tricotLoginReq, String tokenId);
    SendSmsResp sendSMS(String processId, String tokenId);
    ValidateSmsResp validateSMS(TricotValidateSmsReq tricotValidateSmsReq, String tokenId);


}
