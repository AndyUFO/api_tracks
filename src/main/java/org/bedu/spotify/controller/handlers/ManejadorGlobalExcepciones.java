package org.bedu.spotify.controller.handlers;

import org.bedu.spotify.model.RespuestaError;
import org.bedu.spotify.model.RespuestaErrorServer;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request) {

        return RespuestaError.builder()
                .exception(ex)
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }
/*
    @ExceptionHandler(Json.class)
    public ResponseEntity<?> manejaException(JsonParseException ex, WebRequest request) {
        return RespuestaErrorServer.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }*/


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejaException(Exception ex, WebRequest request) {
        return RespuestaErrorServer.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }

}
