package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.entity.movements.MovementsReq;
import cl.tricotcorp.financial.totp.entity.movements.MovementsResp;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsService {
    @Autowired
    private SqlRepository sqlRepository;
    public MovementsResp getMovements(MovementsReq movementsReq) {
        return sqlRepository.getMovements(movementsReq);
    }
}
