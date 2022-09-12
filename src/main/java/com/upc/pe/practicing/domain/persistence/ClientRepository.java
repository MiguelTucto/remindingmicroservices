package com.upc.pe.practicing.domain.persistence;

import com.upc.pe.practicing.domain.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long > {
    List<Client> findAllByAge(int age);
    Client findByName(String name);
}
