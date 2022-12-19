package org.bedu.spotify.repository;

import org.bedu.spotify.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepository extends JpaRepository<Track,Long> {

}
