package com.kimseolhan.coffeeordersystem.client.controller;

import com.kimseolhan.coffeeordersystem.client.domain.Client;
import com.kimseolhan.coffeeordersystem.client.model.ClientModel;
import com.kimseolhan.coffeeordersystem.client.service.ClientService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/join")
    public ModelAndView mainView(Model model) {
        model.addAttribute("client", ClientModel.builder().build());
        return new ModelAndView("join");
    }

    @PostMapping("/client")
    public void createClient(HttpServletResponse response, @ModelAttribute ClientModel clientModel) throws IOException {
        clientService.createClient(clientModel);
        response.sendRedirect("/main");
    }

    @GetMapping("/main")
    public ModelAndView createClient(Model model) {
        model.addAttribute("client", ClientModel.builder().build());
        return new ModelAndView("main");
    }
}
