package com.kimseolhan.coffeeordersystem.client.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private Integer id;
    private String webId;
    private String name;
    private String role;
    private String password;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    @Builder
    private Client(String name, String webId, String role, String password) {
        this.webId = webId;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public static Client of(String name, String webId, String role, String password) {
        return Client.builder()
                .webId(webId)
                .name(name)
                .role(role)
                .password(password)
                .build();
    }
}
