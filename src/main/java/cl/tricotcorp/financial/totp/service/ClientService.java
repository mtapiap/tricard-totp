package cl.tricotcorp.financial.totp.service;

import cl.tricotcorp.financial.totp.entity.clients.ClientsResp;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    @Autowired
    private SqlRepository sqlRepository;
    public ClientsResp getClient(String id) {
        return sqlRepository.getClient(id);
    }
}
