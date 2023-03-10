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
    public List<Track> findAll() throws Exception {
        List<Track> tracks = repository.findAll();
        if(tracks.isEmpty()){
            String errorMsg = "No existen registros en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else{
            return tracks;
        }

    }

    @Override
    public Optional<Track> findById(long id) throws Exception {
        Optional <Track> res = repository.findById(id);
        if(res.isEmpty()){
            String errorMsg = "No existe el track id:"+id+" en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else{
            log.info("Track id :"+res.get().getId()+" encontrado");
            log.info(res.get().toString());
            return res;
        }
    }

    @Override
    public Track save(Track track) throws Exception {
        if(repository.findByIdSpotify(track.getIdSpotify())!=null){
            String error = "El registro con id_spotify :"+track.getIdSpotify()+" ya existe en la base de datos";
            log.error(error);
            throw new Exception(error);
        }else{
            Track insertedTrack = repository.save(track);
            log.info("Track id: "+insertedTrack.getIdSpotify()+" Nombre :"+insertedTrack.getName()+" Insertado correctamente");
            return insertedTrack;
        }
    }

    @Override
    public List<Track> saveList(List<Track> trackList) {
        List<Track> insertedTrackList  = new LinkedList<>();
        for (Track track:trackList){
            Track insertedTrack = repository.save(track);
            log.info("Track id :"+insertedTrack.getId()+" Insertado correctamente");
            insertedTrackList.add(insertedTrack);
        }
        log.info("Se insertaron "+insertedTrackList.size()+" tracks");

        return insertedTrackList;
    }

    @Override
    public Track update(long id, Track track) throws Exception {
        Optional <Track> res = repository.findById(id);
        if(res.isEmpty()){
            String errorMsg = "No existe el track id:"+id+" en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else{
            res.get().setDescription(track.getDescription());
            log.info("Track id :"+id+" Actualizado correctamente");
            return repository.save(res.get());
        }
    }

    @Override
    public boolean delete(long id) throws Exception {
        Optional<Track> res = repository.findById(id);
        if (res.isEmpty()) {
            String errorMsg = "No existe el track id:"+id+" en la base de datos";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }else {
            repository.deleteById(id);
            log.info("Track id :"+id+" Borrado correctamente");
            return true;
        }
    }
}
