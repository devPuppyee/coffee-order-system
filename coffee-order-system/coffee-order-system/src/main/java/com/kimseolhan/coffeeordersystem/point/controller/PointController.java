package com.kimseolhan.coffeeordersystem.point.controller;

import com.kimseolhan.coffeeordersystem.point.model.PointModel;
import com.kimseolhan.coffeeordersystem.point.service.PointService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;

    // 포인트 충전 화면
    @GetMapping("/point")
    public ModelAndView pointView(Model model) {
        return new ModelAndView("point");
    }

    // 포인트 충전
    @PostMapping("/point")
    public void chargePoint(HttpServletResponse response, @ModelAttribute PointModel pointModel) throws IOException {
        pointService.chargePoint(pointModel);
        response.sendRedirect("main");
    }
}
