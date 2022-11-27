package com.niit.jap.service;

import com.niit.jap.domain.Artist;
import com.niit.jap.domain.Track;
import com.niit.jap.exception.UserAlreadyExistsException;
import com.niit.jap.exception.UserNotFoundException;
import com.niit.jap.repository.UserTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class UserTrackServiceImpl implements UserTrackService {
    public UserTrackRepository userTrackRepository;
    @Autowired
    public UserTrackServiceImpl(UserTrackRepository userRepository){
        this.userTrackRepository =userRepository;
    }

    @Override
    public Track addUser(Track track) throws UserAlreadyExistsException {
        if (userTrackRepository.findById(track.getTrackId()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userTrackRepository.insert(track);
    }

    @Override
    public Track addTrackForUser(String trackId, Artist artist) throws UserNotFoundException {
        if(userTrackRepository.findById(trackId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        Track track = userTrackRepository.findByTrackId(trackId);
        if(track.getArtistList() == null)
        {
            track.setArtistList(Arrays.asList(artist));
        }
        else {
            List<Artist> artists = track.getArtistList();
            artists.add(artist);
            track.setArtistList(artists);
        }
        return userTrackRepository.save(track);
    }

//    @Override
//    public List<Movies> getAllUserMovies(String emailId) throws MoviesNotFoundException {
//        if (userMoviesRepository.findById(emailId).isEmpty()){
//            throw  new MoviesNotFoundException();
//        }else {
//            return userMoviesRepository.findById(emailId).get().getMoviesList();
//        }
//    }
}
