package com.kimseolhan.coffeeordersystem.point.service;

import com.kimseolhan.coffeeordersystem.point.domain.Point;
import com.kimseolhan.coffeeordersystem.point.model.PointModel;
import com.kimseolhan.coffeeordersystem.point.repository.PointRepository;
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
public class PointService {
    private final PointRepository pointRepository;

    public PointModel chargePoint(PointModel pointModel) {
        Point point = Point.of(pointModel);
        return PointModel.of(pointRepository.save(point));
    }
}
