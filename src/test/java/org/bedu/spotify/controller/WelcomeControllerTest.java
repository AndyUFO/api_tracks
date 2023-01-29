package org.bedu.spotify.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WelcomeControllerTest {


    @Mock
    WelcomeController welcomeController;

    @SneakyThrows
    @Test
    @DisplayName("Validando mensaje de bienvenida de la API")
    void hello() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(welcomeController.hello()).thenReturn("Bienvenido a la API tracks");
        assertEquals("Bienvenido a la API tracks",welcomeController.hello());
    }
}