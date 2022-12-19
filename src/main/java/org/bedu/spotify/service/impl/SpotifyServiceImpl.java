package org.bedu.spotify.service.impl;

import org.bedu.spotify.entity.Track;
import org.bedu.spotify.repository.ISpotifyRepository;
import org.bedu.spotify.service.ISpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SpotifyServiceImpl implements ISpotifyService {
    private ISpotifyRepository repository;

    @Autowired
    public SpotifyServiceImpl(ISpotifyRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getToken() throws IOException, InterruptedException {
        return repository.getToken();
    }

    @Override
    public List<Track> findTracks(String token, String search) throws Exception {
        return repository.findTracks(token, search);
    }

    @Override
    public List<Track> findTracks(String token, String search,int size) throws Exception {
        return repository.findTracks(token, search,size);
    }
}
