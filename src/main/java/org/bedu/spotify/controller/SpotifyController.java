package org.bedu.spotify.controller;

import org.bedu.spotify.entity.Track;
import org.bedu.spotify.service.ISpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {
    private ISpotifyService spotifyService;

    @Autowired
    public SpotifyController(ISpotifyService service) {
        this.spotifyService = service;
    }

    @GetMapping("/{search}")
    public List<Track> getTracks(@PathVariable("search") String search) throws Exception {
        String token = spotifyService.getToken();
        List<Track> tracks = spotifyService.findTracks(token, search);
        return tracks;
    }

    @GetMapping("/{search}/{size}")
    public List<Track> getTracks(@PathVariable("search") String search,@PathVariable int size) throws Exception {
        String token = spotifyService.getToken();
        List<Track> tracks = spotifyService.findTracks(token, search,size);
        return tracks;
    }

}
