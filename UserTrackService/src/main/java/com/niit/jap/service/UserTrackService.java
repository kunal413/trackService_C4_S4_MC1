package com.niit.jap.service;

import com.niit.jap.domain.Artist;
import com.niit.jap.domain.Track;
import com.niit.jap.exception.UserAlreadyExistsException;
import com.niit.jap.exception.UserNotFoundException;

public interface UserTrackService {
    Track addUser(Track track) throws UserAlreadyExistsException;
    Track addTrackForUser(String trackId, Artist artist) throws UserNotFoundException;
   // List<Movies> getAllUserMovies(String emailId) throws MoviesNotFoundException;

}
