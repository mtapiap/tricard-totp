package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.model.dbResetResponse.DbResetResp;
import cl.tricotcorp.financial.totp.model.dbVerifyResponse.DbVerifyResp;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import dev.samstevens.totp.code.CodeVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyService {
    @Autowired
    private SqlRepository sqlRepository;
    @Autowired
    private CodeVerifier verifier;

    public DbVerifyResp verifyClient(String id, String code) {
        return sqlRepository.verifyClient(id, code);
    }
    public DbResetResp lockedCode(String id) {
        return sqlRepository.lockedCode(id);
    }

    public DbResetResp updateValidCode(String id) {
        return sqlRepository.updateValidCode(id);
    }

    public boolean verifyCode(String code, String secret) {
        return verifier.isValidCode(secret, code);
    }
    public DbResetResp updateInvalidCode(String id) {
        return sqlRepository.updateInvalidCode(id);
    }

}
