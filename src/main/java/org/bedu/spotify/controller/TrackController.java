package org.bedu.spotify.controller;

import jakarta.validation.Valid;
import org.bedu.spotify.entity.Track;
import org.bedu.spotify.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    private ITrackService service;

    @Autowired
    public TrackController(ITrackService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Track> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track findById(@PathVariable long id) throws Exception {
        return service.findById(id).get();
    }

    @PostMapping()
    public ResponseEntity<Track> saveTrack(@Valid @RequestBody Track track) throws Exception {
        Track insertedTrack = service.save(track);
        if(insertedTrack!=null) {
            return ResponseEntity.ok(insertedTrack);
        }else{
            throw new Exception("Error al guardar el track ");
        }
        }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Track> saveListTracks(@RequestBody List<Track> tracks) {
        return service.saveList(tracks);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean update(@PathVariable long id, @RequestBody Track track) throws Exception {
        return service.update(id, track);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") long id) throws Exception {
        return service.delete(id);
    }

}
