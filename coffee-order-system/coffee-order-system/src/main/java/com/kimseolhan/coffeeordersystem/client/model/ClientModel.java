package com.kimseolhan.coffeeordersystem.client.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientModel {
    private String id;
    private String webId;
    private String name;
    private String role;
    private String password;

    @Builder
    private ClientModel(String id, String name, String webId, String role, String password) {
        this.id = id;
        this.webId = webId;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public static ClientModel of(String webId, String name, String role, String password) {
        return ClientModel.builder()
                .webId(webId)
                .name(name)
                .role(role)
                .password(password)
                .build();
    }
}
