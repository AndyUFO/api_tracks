package org.bedu.spotify.service;

import org.bedu.spotify.entity.Track;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

public interface ITrackService {
    List<Track> findAll() ;
    Optional<Track> findById(long id) throws Exception;

    Track save(Track track);

    List<Track> saveList(List<Track> trackList);

    void update(long id,Track track) throws Exception;

    void delete(long id) throws Exception;
}
