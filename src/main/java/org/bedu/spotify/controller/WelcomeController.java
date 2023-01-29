package org.bedu.spotify.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class WelcomeController {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String hello() throws Exception {
        return "Bienvenido a la API tracks";
    }
}
