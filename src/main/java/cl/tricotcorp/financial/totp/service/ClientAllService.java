package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.entity.clients.ClientsResp;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAllService {

    @Autowired
    private SqlRepository sqlRepository;
    public ClientsResp getClients() {
        return sqlRepository.getClients();
    }

}
