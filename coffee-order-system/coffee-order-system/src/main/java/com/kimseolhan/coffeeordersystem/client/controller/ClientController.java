package com.kimseolhan.coffeeordersystem.client.controller;

import com.kimseolhan.coffeeordersystem.client.domain.Client;
import com.kimseolhan.coffeeordersystem.client.model.ClientModel;
import com.kimseolhan.coffeeordersystem.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/join")
    public String mainView() {
        return "index";
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody ClientModel clientModel) {
        return clientService.createClient(clientModel);
    }
}
