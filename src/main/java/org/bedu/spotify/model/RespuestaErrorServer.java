package org.bedu.spotify.model;

import lombok.Data;
import org.bedu.spotify.model.builders.RespuestaErrorServerBuilder;

import java.time.LocalDateTime;

@Data
public class RespuestaErrorServer {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int estatus;
    private String error;
    private String mensaje;
    private String ruta;

    public static RespuestaErrorServerBuilder builder() {
        return new RespuestaErrorServerBuilder();
    }
}
