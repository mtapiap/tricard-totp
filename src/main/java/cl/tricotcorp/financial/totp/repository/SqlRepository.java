package cl.tricotcorp.financial.totp.repository;

import cl.tricotcorp.financial.totp.entity.lockresponse.LockResp;
import cl.tricotcorp.financial.totp.entity.clients.ClientsResp;
import cl.tricotcorp.financial.totp.model.dbResetResponse.DbResetResp;
import cl.tricotcorp.financial.totp.model.dbSetupResponse.DbSetupResp;
import cl.tricotcorp.financial.totp.model.dbVerifyResponse.DbVerifyResp;
import cl.tricotcorp.financial.totp.entity.movements.MovementsReq;
import cl.tricotcorp.financial.totp.entity.movements.MovementsResp;

/**
 * Created by Voxcom S.A. on July, 2019
 * Email : contacto@voxcom.cl
 */
public interface SqlRepository {

    DbSetupResp setupClient(String id,String key, String os);
    DbVerifyResp verifyClient(String id, String code);
    DbResetResp updateValidCode(String id);
    DbResetResp updateInvalidCode(String id);
    LockResp lockClient(String id);
    DbResetResp lockedCode(String id);
    ClientsResp getClient(String id);
    ClientsResp getClients();
    MovementsResp getMovements(MovementsReq movementsReq);


}
