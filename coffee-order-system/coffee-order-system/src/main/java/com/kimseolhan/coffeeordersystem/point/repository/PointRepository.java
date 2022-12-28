package com.kimseolhan.coffeeordersystem.point.repository;

import com.kimseolhan.coffeeordersystem.point.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Integer> {
    Point save(Point point);
}
