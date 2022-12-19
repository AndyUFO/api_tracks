package org.bedu.spotify.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bedu.spotify.entity.Track;
import org.bedu.spotify.repository.ITrackRepository;
import org.bedu.spotify.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrackServiceImpl implements ITrackService {
    private ITrackRepository repository;

    @Autowired
    public TrackServiceImpl(ITrackRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Track> findAll() {
        List<Track> tracks = repository.findAll();
        if(tracks.isEmpty()){
            String errorMsg = "No existen registros en la base de datos";
            log.info(errorMsg);
        }
        return tracks;
    }

    @Override
    public Optional<Track> findById(long id) throws Exception {
        Optional <Track> res = repository.findById(id);

        if(res.isEmpty()){
            String errorMsg = "No existe el track id:"+id+" en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else{
            log.info("Track Id :"+res.get().getId()+" encontrado");
            log.info(res.get().toString());
            return res;
        }
    }

    @Override
    public Track save(Track track) {
        Track insertedTrack = repository.save(track);
        log.info("Track Id :"+insertedTrack.getId()+" Insertado correctamente");
        return insertedTrack;
    }

    @Override
    public List<Track> saveList(List<Track> trackList) {
        List<Track> insertedTrackList  = new LinkedList<>();
        for (Track track:trackList){
            Track insertedTrack = repository.save(track);
            log.info("Track Id :"+insertedTrack.getId()+" Insertado correctamente");
            insertedTrackList.add(insertedTrack);
        }
        log.info("Se insertaron "+insertedTrackList.size()+" tracks");

        return insertedTrackList;
    }

    @Override
    public void update(long id, Track track) throws Exception {
        Optional <Track> res = repository.findById(id);
        if(res.isEmpty()){
            String errorMsg = "No existe es track id:"+id+" en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else{
            res.get().setDescription(track.getDescription());
            repository.save(res.get());
            log.info("Track Id :"+id+" Actualizado correctamente");
        }
    }

    @Override
    public void delete(long id) throws Exception {
        Optional<Track> res = repository.findById(id);
        if (res.isEmpty()) {
            String errorMsg = "No existe el track id:"+id+" en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else {
            repository.deleteById(id);
            log.info("Track Id :"+id+" Borrado correctamente");
        }
    }
}
