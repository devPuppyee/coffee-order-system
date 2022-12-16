package com.kimseolhan.coffeeordersystem.client.repository;

import com.kimseolhan.coffeeordersystem.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByName(String name);
}
