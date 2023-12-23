package com.client.Client.services;

import com.client.Client.entities.Client;
import com.client.Client.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServices {

    private final ClientRepository cr;

    public void save(Client client){
        cr.save(client);
    }

    public void update(Client client){
        cr.save(client);
    }

    public void delete(Client client){
        cr.delete(client);
    }

    public Client findClient(int id) throws Exception{
        return cr.findById(id).orElseThrow(
                () -> new Exception("Invalid client ID.")
        );
    }

    public List<Client> findAll(){
        return cr.findAll();
    }
}
