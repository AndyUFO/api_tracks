package org.bedu.spotify.service;

import org.bedu.spotify.entity.Track;

import java.io.IOException;
import java.util.List;

public interface ISpotifyService {
    String getToken() throws IOException, InterruptedException;
    List<Track> findTracks(String token, String search) throws Exception;

    List<Track> findTracks(String token, String search, int size) throws Exception;

}
