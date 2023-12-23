package com.client.Client.controllers;

import com.client.Client.entities.Client;
import com.client.Client.services.ClientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientServices cs;

    @GetMapping
    public List<Client> findAll(){
        return cs.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable("id") int id) throws Exception{
        return cs.findClient(id);
    }

}
