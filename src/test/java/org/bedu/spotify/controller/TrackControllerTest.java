package org.bedu.spotify.controller;

import lombok.SneakyThrows;
import org.bedu.spotify.entity.Track;
import org.bedu.spotify.service.ITrackService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrackControllerTest {

    @Mock
    private ITrackService service;

    @InjectMocks
    TrackController trackController;

    @SneakyThrows
    @Test
    @DisplayName("Prueba de buscar todos los registros en la base de datos")
    void findAll() {
        Track track1 = new Track();
        track1.setId(1);
        Track track2 = new Track();
        track2.setId(2);
        Track track3 = new Track();
        track3.setId(3);
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);

        when(service.findAll()).thenReturn(tracks);

        List<Track> result = trackController.findAll();

        assertEquals(3,result.size());
        assertEquals((result.get(0)).getId(),track1.getId());
        assertEquals((result.get(1)).getId(),track2.getId());
        assertEquals((result.get(2)).getId(),track3.getId());

    }

    @SneakyThrows
    @Test
    @DisplayName("Listado de registros mayor que 0")
    void findAllTracks() {
        Track track1 = new Track();
        track1.setId(1);
        Track track2 = new Track();
        track2.setId(2);
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);

        when(service.findAll()).thenReturn(tracks);

        List<Track> result = trackController.findAll();
        assertTrue(result.size()>0);
    }


    @SneakyThrows
    @Test
    @DisplayName("Prueba de guardado de registros")
    void saveTrack(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Track track = new Track();
        track.setId(1);
        when(service.save((any(Track.class)))).thenReturn(track);

        Track track1 = new Track();
        track1.setId(1);
        ResponseEntity<Track> responseEntity = trackController.saveTrack(track);

        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }


    @SneakyThrows
    @Test
    @DisplayName("Prueba de lanzado de excepcion en el guardado de registros")
    void saveTrackError(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Track track = new Track();
        track.setId(1);
        when(service.save((any(Track.class)))).thenThrow(Exception.class);

        Track track1 = new Track();
        track1.setId(1);
        assertThrows(Exception.class, ()-> trackController.saveTrack(track1));
    }

    @SneakyThrows
    @Test
    @DisplayName("Prueba de busqueda de un registro")
    void findById() {
        Track track1 = new Track();
        track1.setId(1);

        when(service.findById(1)).thenReturn(Optional.of(track1));

        Track result = trackController.findById(1);

        assertEquals(result.getId(),track1.getId());
        assertFalse(result.getId()==2);
    }

    @SneakyThrows
    @Test
    @DisplayName("Prueba del tipo regresado por la busqueda de un registro")
    void findByIdInstanceOf() {
        Track track1 = new Track();
        track1.setId(1);
        when(service.findById(1)).thenReturn(Optional.of(track1));
        Track result = trackController.findById(1);
        assertInstanceOf(Track.class,result);
    }

    @SneakyThrows
    @Test
    @DisplayName("Prueba de busqueda de un registro y que el valor regreado no sea nulo")
    void findByIdNotNull() {
        Track track1 = new Track();
        track1.setId(1);

        when(service.findById(1)).thenReturn(Optional.of(track1));

        Track result = trackController.findById(1);

        assertTrue(result!=null);
    }



    @SneakyThrows
    @Test
    @DisplayName("Prueba de actualizacion de un registro")
    void update() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Track track = new Track();
        track.setId(1);
        when(service.update(any(Long.class),any(Track.class))).thenReturn(track);

        Track track1 = new Track();
        track1.setId(1);
        ResponseEntity<Track> responseEntity = trackController.update(1,track);

        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @SneakyThrows
    @Test
    @DisplayName("Prueba de borrado de registros")
    void delete() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(service.delete(any(Long.class))).thenReturn(true);
        String response = trackController.delete(1);

        assertTrue(service.delete(1) && response.contains("Borrado correctamente"));
    }

}