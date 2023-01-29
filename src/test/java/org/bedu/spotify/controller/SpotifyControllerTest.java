package org.bedu.spotify.controller;

import lombok.SneakyThrows;
import org.bedu.spotify.entity.Track;
import org.bedu.spotify.service.ISpotifyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpotifyControllerTest {

    @Mock
    private ISpotifyService service;

    @InjectMocks
    SpotifyController spotifyController;

    @SneakyThrows
    @Test
    @DisplayName("Validando obtencion de lista de canciones de spotify")
    void getTracks() {
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track();
        track1.setId(1);
        Track track2 = new Track();
        track2.setId(2);
        Track track3 = new Track();
        track3.setId(3);
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);

        when(service.findTracks(any(String.class),any(String.class))).thenReturn(tracks);
        assertTrue(service.findTracks("token","palabra").size()>0);
    }

}