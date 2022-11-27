package com.niit.jap.controller;

import com.niit.jap.domain.Artist;
import com.niit.jap.domain.Track;
import com.niit.jap.exception.UserAlreadyExistsException;
import com.niit.jap.exception.UserNotFoundException;
import com.niit.jap.service.UserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usermovieapi/user")
public class UserTrackController {
    private UserTrackService userTrackService;
    private ResponseEntity<?> responseEntity;
    @Autowired
    public UserTrackController(UserTrackService userTrackService){
        this.userTrackService = userTrackService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody Track track) throws UserAlreadyExistsException{
        try {
            track.setArtistList(new ArrayList<>());
            responseEntity =new ResponseEntity<>(userTrackService.addUser(track), HttpStatus.CREATED);
        }catch (UserAlreadyExistsException e){
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }
    @PutMapping("/addmovie/{trackId}")
    public ResponseEntity<?> saveUserTrack(@PathVariable String trackId, @RequestBody Artist artist) throws UserNotFoundException{
       try {
           return  new ResponseEntity<>(userTrackService.addTrackForUser(trackId,artist),HttpStatus.OK);
       } catch (Exception e) {
          throw new UserNotFoundException();
       }
    }
//    @GetMapping("/user/movies")
//    public ResponseEntity<?>getAllMoviesDetails(HttpServletRequest request)throws MoviesNotFoundException{
//        try {
//            System.out.println("header" + request.getHeader("Authorization"));
//            Claims claims = (Claims) request.getAttribute("claims");
//            System.out.println("email from claims :: " + claims.getSubject());
//            String email = claims.getSubject();
//            System.out.println("email :: " + email);
//            responseEntity = new ResponseEntity<>(userMoviesService.getAllUserMovies(email), HttpStatus.CREATED);
//        }catch (MoviesNotFoundException e){
//            throw  new MoviesNotFoundException();
//        }
//        return responseEntity;
//    }

}
