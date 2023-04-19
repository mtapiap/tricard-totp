package cl.tricotcorp.financial.totp.controller;


import cl.tricotcorp.financial.totp.entity.clients.ClientReq;
import cl.tricotcorp.financial.totp.entity.lockresponse.LockReq;
import cl.tricotcorp.financial.totp.entity.lockresponse.LockResp;
import cl.tricotcorp.financial.totp.model.login.VxcLoginResp;
import cl.tricotcorp.financial.totp.entity.smssend.SendSmsResp;
import cl.tricotcorp.financial.totp.entity.smssend.TricotSendSmsReq;
import cl.tricotcorp.financial.totp.entity.setup.SetupReq;
import cl.tricotcorp.financial.totp.entity.setup.SetupResp;
import cl.tricotcorp.financial.totp.model.token.TokenResp;
import cl.tricotcorp.financial.totp.entity.smsvalidate.ValidateSmsReq;
import cl.tricotcorp.financial.totp.entity.smsvalidate.ValidateSmsResp;
import cl.tricotcorp.financial.totp.entity.verify.VerifyReq;
import cl.tricotcorp.financial.totp.entity.verify.VerifyResp;
import cl.tricotcorp.financial.totp.entity.clients.ClientsResp;
import cl.tricotcorp.financial.totp.model.dbResetResponse.DbResetResp;
import cl.tricotcorp.financial.totp.model.dbSetupResponse.DbSetupResp;
import cl.tricotcorp.financial.totp.model.dbVerifyResponse.DbVerifyResp;
import cl.tricotcorp.financial.totp.entity.movements.MovementsReq;
import cl.tricotcorp.financial.totp.entity.movements.MovementsResp;

import cl.tricotcorp.financial.totp.service.*;
import cl.tricotcorp.financial.totp.utils.Tools;
import dev.samstevens.totp.exceptions.QrGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Voxcom S.A. on July, 2019
 * Email : contacto@voxcom.cl
 */

@RestController
@RequestMapping("/totp")
public class TotpController {

    @Autowired
    private SetupService setupService;
    @Autowired
    private SmsSendService smsSendService;
    @Autowired
    private SmsValidateService smsValidateService;

    @Autowired
    private VerifyService verifyService;
    @Autowired
    private LockService lockService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientAllService clientAllService;
    @Autowired
    MovementsService movementsService;


    @GetMapping("/v1/setup")
    @ResponseBody
    public SetupResp ctrlSetupDevice(@RequestBody SetupReq setupReq) {


        SetupResp setupResp = new SetupResp();
// Obtiene Token
        TokenResp tokenResp = setupService.getToken();

        if (tokenResp.getErrorCode() != 0) {
            setupResp.setCodError(tokenResp.getErrorCode());
            setupResp.setMsgError(tokenResp.getError());
            setupResp.setDesError(tokenResp.getErrorDescription());
            return setupResp;
        }

// Valida Login

        VxcLoginResp vxcLoginResp = setupService.validateLogin(setupReq.getRut(), setupReq.getPassword(), tokenResp.getAccessToken());

        if (vxcLoginResp.getErrorCode() != 0) {
            setupResp.setCodError(vxcLoginResp.getErrorCode());
            setupResp.setMsgError(vxcLoginResp.getError());
            setupResp.setDesError(vxcLoginResp.getErrorDescription());
            return setupResp;
        }
        SendSmsResp sendSmsResp = setupService.sendSMS(vxcLoginResp.getProcessId(), tokenResp.getAccessToken());

        if (sendSmsResp.getCodError() != 0) {
            setupResp.setCodError(sendSmsResp.getCodError());
            setupResp.setMsgError("Error");
            setupResp.setDesError("Error al enviar SMS");
            setupResp.setProcessId(vxcLoginResp.getProcessId());
        } else {
            setupResp.setCodError(0);
            setupResp.setMsgError("OK");
            setupResp.setDesError("OK");
            setupResp.setProcessId(vxcLoginResp.getProcessId());
            setupResp.setPhoneNumber(sendSmsResp.getPhoneNumber());
        }
        return setupResp;

    }

    @GetMapping("/v1/setup/sms/send")
    @ResponseBody
    public SendSmsResp ctrlSendSMS(@RequestBody TricotSendSmsReq tricotSendSmsReq) throws QrGenerationException {

        SendSmsResp sendSmsResp = new SendSmsResp();
// Obtiene Token
        TokenResp tokenResp = smsSendService.getToken();
        if (tokenResp.getErrorCode() != 0) {
            sendSmsResp.setCodError(2301);
            sendSmsResp.setMsgError("Error al re-enviar SMS ");
            return sendSmsResp;
        }

        sendSmsResp = smsSendService.sendSMS(tricotSendSmsReq.getProcessId(), tokenResp.getAccessToken());

        return sendSmsResp;

    }

    @PostMapping("/v1/setup/sms/validate")
    @ResponseBody
    public ValidateSmsResp validateSetupDevice(@RequestBody ValidateSmsReq validateSmsReq) throws QrGenerationException {


// Obtiene Token
        TokenResp tokenResp = smsValidateService.getToken();
        ValidateSmsResp validateSmsResp = new ValidateSmsResp();

        if (tokenResp.getErrorCode() != 0) {
            validateSmsResp.setCodError(tokenResp.getErrorCode());
            validateSmsResp.setMsgError(tokenResp.getError());
            validateSmsResp.setDesError(tokenResp.getErrorDescription());
            return validateSmsResp;
        }

//        validateSmsResp = smsValidateService.validateSMS(validateSmsReq.getProcessId(), validateSmsReq.getCode(), tokenResp.getAccessToken());
//        TODO: Descomentar y eliminar respuesta por defecto, una vez que se implemente el servicio de validacion de SMS
        validateSmsResp.setCodError(0);
        validateSmsResp.setMsgError("OK");

        if (validateSmsResp.getCodError() == 0) {


            String uri = smsValidateService.generateTOTP(validateSmsReq.getId());
            validateSmsResp.setUri(uri);


            DbSetupResp dbSetupResp = smsValidateService.storeDbSetup(validateSmsReq.getId(), Tools.getSecretFromUri(uri), validateSmsReq.getOs());
            if (dbSetupResp.getCodError() != 0) {
                validateSmsResp.setCodError(99);
                validateSmsResp.setMsgError("Error en enrolamiento");
                validateSmsResp.setDesError("Error al enrolar cliente en base de datos");
            }

        }
        return validateSmsResp;
    }

    @GetMapping("/v1/verify")
    @ResponseBody
    public VerifyResp verify(@RequestBody VerifyReq verifyReq) {
        VerifyResp verifyResp = new VerifyResp();
        // secret is fetched from some storage

        DbVerifyResp dbVerifyResp = verifyService.verifyClient(verifyReq.getId(), verifyReq.getCode());

        if (dbVerifyResp.getCodError() != 0) {
            verifyResp.setCodError(dbVerifyResp.getCodError());
            verifyResp.setMsgError(dbVerifyResp.getMsgError());
            DbResetResp dbResetResp = verifyService.lockedCode(verifyReq.getId());
        } else {
            String secret = dbVerifyResp.getKey();
            if (verifyService.verifyCode(secret, verifyReq.getCode())) {
//                return "CORRECT CODE";

                DbResetResp dbResetResp = verifyService.updateValidCode(verifyReq.getId());
                if (dbResetResp.getCodError() != 0) {
                    verifyResp.setCodError(dbResetResp.getCodError());
                    verifyResp.setMsgError(dbResetResp.getMsgError());
                } else {
                    verifyResp.setCodError(dbVerifyResp.getCodError());
                    verifyResp.setMsgError(dbVerifyResp.getMsgError());
                }
            } else {
//                return "INCORRECT CODE";
                DbResetResp dbResetResp = verifyService.updateInvalidCode(verifyReq.getId());
                if (dbResetResp.getCodError() != 0) {
                    verifyResp.setCodError(dbResetResp.getCodError());
                    verifyResp.setMsgError(dbResetResp.getMsgError());
                } else {
                    verifyResp.setCodError(2100);
                    verifyResp.setMsgError("Codigo invalido !!!");
                }
            }
        }
        return verifyResp;
    }

    @PatchMapping("/v1/lock")
    @ResponseBody
    public LockResp locked(@RequestBody LockReq lockReq) {
        LockResp lockResp = new LockResp();
        lockResp = lockService.lockedClient(lockReq.getId());
        return lockResp;
    }

    @GetMapping("/v1/client")
    @ResponseBody
    public ClientsResp client(@RequestBody ClientReq clientReq) {
        ClientsResp clientsResp = new ClientsResp();
        clientsResp = clientService.getClient(clientReq.getId());
        return clientsResp;
    }

    @GetMapping("/v1/client/all")
    @ResponseBody
    public ClientsResp clients() {
        ClientsResp clientsResp;
        clientsResp = clientAllService.getClients();
        return clientsResp;
    }

    @GetMapping("/v1/client/movements")
    @ResponseBody
    public MovementsResp movement(@RequestBody MovementsReq movementsReq) {
        MovementsResp movementsResp;
        movementsResp = movementsService.getMovements(movementsReq);
        return movementsResp;
    }
}