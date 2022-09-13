package com.upc.pe.practicing.api;

import com.upc.pe.practicing.domain.service.ClientService;
import com.upc.pe.practicing.mapping.ClientMapper;
import com.upc.pe.practicing.resource.ClientResource;
import com.upc.pe.practicing.resource.CreateClientResource;
import com.upc.pe.practicing.resource.UpdateClientResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Client")
@RestController
@CrossOrigin
@RequestMapping("api/v1/clients")
public class ClientsController {
    private final ClientService clientService;
    private final ClientMapper mapper;


    public ClientsController(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ClientResource> getAllClients(Pageable pageable) {
        return mapper.modelListPage(clientService.getAll(), pageable);
    }

    @GetMapping("{clientId}")
    public ClientResource getClientById (@PathVariable Long clientId) {
        return mapper.toResource(clientService.getById(clientId));
    }

    @PostMapping
    public ClientResource createClient(@RequestBody CreateClientResource resource) {
        return mapper.toResource(clientService.create(mapper.toModel(resource)));
    }

    @PutMapping("{clientId}")
    public ClientResource updateClient(@PathVariable Long clientId, @RequestBody UpdateClientResource resource) {
        return mapper.toResource(clientService.update(clientId, mapper.toModel(resource)));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientService.delete(clientId);
    }
}
