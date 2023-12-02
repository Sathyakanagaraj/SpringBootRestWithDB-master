package com.example.sample_5.service;

import com.example.sample_5.model.Client;
import com.example.sample_5.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

   /* public Client update(Client clientser){
        return repository.save(clientser);
    }*/
    public Client getStudentById(int id) {
        return repository.findById(id).get();
    }
}
