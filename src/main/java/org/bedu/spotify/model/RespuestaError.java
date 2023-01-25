package org.bedu.spotify.model;

import lombok.Data;
import org.bedu.spotify.model.builders.RespuestaErrorBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class RespuestaError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int estatus;
    private Map<String, String> errores;
    private String ruta;

    public static RespuestaErrorBuilder builder() {
        return new RespuestaErrorBuilder();
    }

}
