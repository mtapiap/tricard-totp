package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.entity.lockresponse.LockResp;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockService {
    @Autowired
    private SqlRepository sqlRepository;


    public LockResp lockedClient(String id) {
        return sqlRepository.lockClient(id);
    }
}
