package com.kimseolhan.coffeeordersystem.client.model;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ClientModel {
    private Integer id;
    private String name;
    private String role;
    private String password;

    @Builder
    private ClientModel(String name, String role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public static ClientModel of(String name, String role, String password) {
        return ClientModel.builder()
                .name(name)
                .role(role)
                .password(password)
                .build();
    }
}
