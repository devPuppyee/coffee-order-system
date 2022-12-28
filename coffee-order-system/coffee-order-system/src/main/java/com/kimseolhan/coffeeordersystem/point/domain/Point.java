package com.kimseolhan.coffeeordersystem.point.domain;

import com.kimseolhan.coffeeordersystem.client.domain.Client;
import com.kimseolhan.coffeeordersystem.point.model.PointModel;
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
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="point_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;
    private Integer amount; // 양
    private Integer type; // -1 = 음, +1 = 양

    @Builder
    private Point(Client client, Integer amount, Integer type) {
        this.client = client;
        this.amount = amount;
        this.type = type;
    }

    public static Point of(PointModel pointModel) {
        return Point.builder()
                .client(pointModel.getClient())
                .amount(pointModel.getAmount())
                .type(pointModel.getType())
                .build();
    }
}
