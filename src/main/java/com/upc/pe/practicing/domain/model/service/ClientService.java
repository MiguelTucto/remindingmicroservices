package com.upc.pe.practicing.domain.model.service;

import com.upc.pe.practicing.domain.model.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Page<Client> getAll(Pageable pageable);
    Client getById(Long clientId);
    Client create(Client client);
    Client update(Long clientId, Client request);
    ResponseEntity<?> delete(Long clientId);
}
