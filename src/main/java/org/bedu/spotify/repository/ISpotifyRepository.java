package org.bedu.spotify.repository;

import org.bedu.spotify.entity.Track;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

public interface ISpotifyRepository  {
    String getToken() throws IOException, InterruptedException;
    List<Track> findTracks(String token, String search) throws Exception;

    List<Track> findTracks(String token, String search,int size) throws Exception;
}
