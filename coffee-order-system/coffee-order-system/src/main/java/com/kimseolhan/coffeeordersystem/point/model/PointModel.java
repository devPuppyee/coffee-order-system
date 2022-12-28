package com.kimseolhan.coffeeordersystem.point.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kimseolhan.coffeeordersystem.client.domain.Client;
import com.kimseolhan.coffeeordersystem.point.domain.Point;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointModel {
    private Integer id;
    private Client client;
    private Integer amount; // 양
    private Integer type; // -1 = 음, +1 = 양

    @Builder
    private PointModel(Integer id,
            Client client,
            Integer amount,
            Integer type) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.type = type;
    }

    public static PointModel of(Point point) {
        return PointModel.builder()
                .client(point.getClient())
                .amount(point.getAmount())
                .type(point.getType())
                .build();
    }
}
