package org.bedu.spotify.model.builders;

import org.bedu.spotify.model.RespuestaErrorServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespuestaErrorServerBuilder {
    private int estatus;
    private String error;
    private String mensaje;
    private String ruta;

    public RespuestaErrorServerBuilder estatus(int estatus) {
        this.estatus = estatus;
        return this;
    }

    public RespuestaErrorServerBuilder status(HttpStatus estatus) {
        this.estatus = estatus.value();

        if (estatus.isError()) {
            this.error = estatus.getReasonPhrase();
        }

        return this;
    }

    public RespuestaErrorServerBuilder error(String error) {
        this.error = error;
        return this;
    }

    public RespuestaErrorServerBuilder message(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public RespuestaErrorServerBuilder ruta(String ruta) {
        this.ruta = ruta;
        return this;
    }

    public RespuestaErrorServer build() {
        RespuestaErrorServer respuesta = new RespuestaErrorServer();
        respuesta.setEstatus(estatus);
        respuesta.setError(error);
        respuesta.setMensaje(mensaje);
        respuesta.setRuta(ruta);
        return respuesta;
    }

    public ResponseEntity<RespuestaErrorServer> entidad() {
        return ResponseEntity.status(estatus).headers(HttpHeaders.EMPTY).body(build());
    }
}
