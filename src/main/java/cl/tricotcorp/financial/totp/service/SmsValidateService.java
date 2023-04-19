package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.model.dbSetupResponse.DbSetupResp;
import cl.tricotcorp.financial.totp.model.token.TokenResp;
import cl.tricotcorp.financial.totp.model.smsvalidate.TricotValidateSmsReq;
import cl.tricotcorp.financial.totp.entity.smsvalidate.ValidateSmsResp;
import cl.tricotcorp.financial.totp.repository.InfoRepository;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrDataFactory;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsValidateService {
    @Autowired
    private  InfoRepository infoRepository;
    @Autowired
    private SecretGenerator secretGenerator;
    @Autowired
    private QrDataFactory qrDataFactory;

    @Autowired
    private QrGenerator qrGenerator;

    @Autowired
    private SqlRepository sqlRepository;


    public TokenResp getToken(){
        TokenResp tokenResp;
        tokenResp = infoRepository.getToken();
        return tokenResp;
    }

    public ValidateSmsResp validateSMS(String processId, int code, String token) {


        TricotValidateSmsReq tricotValidateSmsReq = new TricotValidateSmsReq();
        tricotValidateSmsReq.setProcessId(processId);
        tricotValidateSmsReq.setCode(code);


        return infoRepository.validateSMS(tricotValidateSmsReq, token);

    }

    public String generateTOTP(String label){
        // Generate and store the secret
        String secret = secretGenerator.generate();

        String issuer = "Voxcom";

        QrData data = qrDataFactory.newBuilder()
                .label(label)
                .secret(secret)
                .issuer(issuer)
                .build();

        // Si se desea crear un QR en un base64  descomentar el codigo de abajo
        // Generate the QR code image data as a base64 string which
        // can be used in an <img> tag:
//        try {
//            String qrCodeImage = getDataUriForImage(
//                    qrGenerator.generate(data),
//                    qrGenerator.getImageMimeType()
//            );
//        } catch (QrGenerationException e) {
//            throw new RuntimeException(e);
//        }

        return "otpauth://totp/" + issuer + ":" + label + "?secret=" + secret + "&issuer=" + issuer;
    }

    public DbSetupResp storeDbSetup(String id, String key, String os){

        return sqlRepository.setupClient(id, key, os);
    }


}
