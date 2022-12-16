package com.kimseolhan.coffeeordersystem.client.service;

import com.kimseolhan.coffeeordersystem.client.domain.Client;
import com.kimseolhan.coffeeordersystem.client.model.ClientModel;
import com.kimseolhan.coffeeordersystem.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByName(username);
        if (Objects.isNull(client)) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(client.getName())
                .password(client.getPassword())
                .roles(client.getRole())
                .build();
    }

    public Client createClient(ClientModel clientModel) {
        Client client = Client.of(clientModel.getName(), clientModel.getRole(), clientModel.getPassword());
        client.encodePassword(passwordEncoder);
        return clientRepository.save(client);
    }
}
