package org.bedu.spotify.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.util.Date;

@Entity
@Table(name = "Track")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
@Data
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    @JsonIgnore
    private long id;


    @JsonProperty("id")
    @NotBlank(message="El identificador del track no puede estar vacio")
    @Column(name = "id_spotify",nullable = false,length = 25)
    @Size(min = 0,max = 25,message = "El identificador del track debe tener una longitud de 25 caracteres")
    private String idSpotify;

    @JsonProperty("disc_number")
    @Column(length = 3)
    @Positive(message = "El campo disc_number debe de ser un numero positivo y mayor que 0")
    @Max(value = 999,message = "El campo disc_number no puede ser mayor que 999")
    private int discNumber;


    @JsonProperty("type")
    @Column(length = 50)
    @NotBlank(message = "El campo type no puede estar en blanco")
    @Size(min=0,max=50,message = "El campo type no puede tener mas de 50 caracteres")
    private String type;


    @JsonProperty("uri")
    @Column(length = 255)
    @NotBlank(message = "El campo uri no puede estar en blanco")
    @Size(min=0,max=255,message = "El campo uri no puede tener mas de 255 caracteres")
    private String uri;

    @JsonProperty("duration_ms")
    @Column(length = 10)
    @Max(value=999999,message = "El campo duration_ms no puede ser mayor que 999999")
    @Positive(message = "El campo duracion_ms debe de ser un numero positivo y mayor que 0")
    private int durationMs;

    @JsonProperty("explicit")
    @Column(length = 10)
    @NotNull(message = "El campo explicit no puede ser nulo")
    private boolean explicit;

    @JsonProperty("is_playable")
    @Column(length = 10)
    @NotNull(message = "El campo is_playable no puede ser nulo")
    private boolean isPlayable;

    @JsonProperty("preview_url")
    @Column(length = 250)
    @NotBlank(message = "El campo preview_url no puede estar en blanco")
    @Size(min=0,max=250,message = "El campo preview_url no puede tener mas de 250 caracteres")
    @URL(message = "El campo preview_url debe contener una direccion url valida ")
    private String preview_url;

    @JsonProperty("popularity")
    @Column(length = 3)
    @Max(value=999,message = "El campo popularity no puede ser mayor que 999")
    @PositiveOrZero(message = "El campo popularity debe de ser un numero positivo y mayor que 0")
    private int popularity;

    @JsonProperty("name")
    @Column(length = 250)
    @NotBlank(message = "El campo name no puede estar en blanco")
    @Size(min=0,max=250,message = "El campo name no puede tener mas de 250 caracteres")
    private String name;

    @JsonProperty("track_number")
    @Column(length = 2)
    @Max(value=99,message = "El campo track_number no puede ser mayor que 99")
    @Positive(message = "El campo track_number debe de ser un numero positivo y mayor que 0")
    private int trackNumber;

    @JsonProperty("href")
    @Column(length = 250)
    @NotBlank(message = "El campo href no puede estar en blanco")
    @Size(min=0,max=250,message = "El campo href no puede tener mas de 250 caracteres")
    @URL(message = "El campo href debe contener una direccion url valida ")
    private String href;

    @JsonProperty("is_local")
    @Column(length = 10)
    @NotNull(message = "El campo is_local no puede ser nulo")
    private boolean isLocal;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "description",length = 255)
    private String Description;

    @JsonGetter("id")
    public long getId() {
        return id;
    }

    @JsonGetter("idSpotify")
    public String getIdSpotify() {
        return idSpotify;
    }

    @JsonSetter("idSpotify")
    public void setIdSpotify(String idSpotify) {
        this.idSpotify = idSpotify;
    }


}