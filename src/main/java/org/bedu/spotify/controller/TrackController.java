package org.bedu.spotify.controller;

import org.bedu.spotify.entity.Track;
import org.bedu.spotify.service.ITrackService;
import org.bedu.spotify.service.impl.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Track> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track findById(@PathVariable long id) throws Exception {
        return service.findById(id).get();
    }

    /*
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Track save(@RequestBody Track track) {
        return service.save(track);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Track> save(@RequestBody List<Track> tracks) {
        return service.saveList(tracks);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Track track) throws Exception {
        service.update(id, track);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
    }

}
