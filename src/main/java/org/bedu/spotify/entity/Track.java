package org.bedu.spotify.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.apache.logging.log4j.message.Message;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "Track")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
@Data
//todo implementar validaciones en todos los campos
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    @JsonIgnore
    private long id;


    @JsonProperty("id")
    @Column(name = "id_spotify",nullable = false)
    @NotNull(message="El identificador del track no puede ser nulo" )
    @NotEmpty(message="El identificador del track no puede estar vacio")
    @Size(min = 22,max = 22,message = "El identificador del track debe tener una longitud de 22 caracteres")
    private String idSpotify;

    @JsonProperty("disc_number")
    @Column(length = 10)
    @NotNull(message = "El numero de disco no puede ser nulo")
    private int discNumber;


    @JsonProperty("type")
    @Column(length = 50)
    @NotNull(message = "El type no puede ser nulo")
    private String type;


    @JsonProperty("uri")
    @Column(length = 100)
    private String uri;

    @JsonProperty("duration_ms")
    private int durationMs;

    @JsonProperty("explicit")
    private boolean explicit;

    @JsonProperty("is_playable")
    private boolean isPlayable;

    @JsonProperty("preview_url")
    @Column(length = 250)
    private String previewUrl;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("name")
    @Column(length = 250)
    private String name;

    @JsonProperty("track_number")
    @Column(length = 3)
    private int trackNumber;

    @JsonProperty("href")
    @Column(length = 200)
    private String href;

    @JsonProperty("is_local")
    private boolean isLocal;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "description")
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