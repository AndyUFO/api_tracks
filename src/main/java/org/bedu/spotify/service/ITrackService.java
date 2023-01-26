package org.bedu.spotify.service;

import org.bedu.spotify.entity.Track;

import java.util.List;
import java.util.Optional;

public interface ITrackService {
    List<Track> findAll() throws Exception;
    Optional<Track> findById(long id) throws Exception;

    Track save(Track track) throws Exception;

    List<Track> saveList(List<Track> trackList);

    boolean update(long id,Track track) throws Exception;

    boolean delete(long id) throws Exception;
}
