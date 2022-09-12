package com.upc.pe.practicing.service;

import com.upc.pe.practicing.domain.model.entity.Client;
import com.upc.pe.practicing.domain.persistence.ClientRepository;
import com.upc.pe.practicing.domain.service.ClientService;
import com.upc.pe.shared.exception.ResourceNotFoundException;
import com.upc.pe.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private static final String ENTITY = "Client";
    private final ClientRepository clientRepository;
    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getById(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Client clientWithName = clientRepository.findByName(client.getName());

        if (clientWithName != null)
            throw new ResourceValidationException(ENTITY, "An client with the same name already exists");

        return clientRepository.save(client);
    }

    @Override
    public Client update(Long clientId, Client request) {
        Set<ConstraintViolation<Client>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Client clientWithName = clientRepository.findByName(request.getName());

        if (clientWithName != null)
            throw new ResourceValidationException(ENTITY, "An client with the same name already exists");

        return clientRepository.findById(clientId).map(client ->
                clientRepository.save(client
                        .withName(request.getName())
                        .withLastName(request.getLastName())
                        .withAddress(request.getAddress())
                        .withPhone(request.getPhone())
                        .withAge(request.getAge())
                        .withDate(request.getDate())
                        .withEvent(request.getEvent())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            clientRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }
}
