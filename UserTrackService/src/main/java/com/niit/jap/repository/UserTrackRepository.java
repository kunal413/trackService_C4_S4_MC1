package com.niit.jap.repository;

import com.niit.jap.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserTrackRepository extends MongoRepository<Track,String> {
    Track findByTrackId(String trackId);
}
