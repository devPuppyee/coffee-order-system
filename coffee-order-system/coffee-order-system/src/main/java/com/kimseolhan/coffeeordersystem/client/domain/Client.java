package com.kimseolhan.coffeeordersystem.client.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String role;
    private String password;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    @Builder
    private Client(String name, String role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public static Client of(String name, String role, String password) {
        return Client.builder()
                .name(name)
                .role(role)
                .password(password)
                .build();
    }
}
