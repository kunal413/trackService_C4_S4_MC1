package com.niit.jap.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class Track {
    private int userId;
    @Id
    private String trackId;
    private String trackName;
    private List<Artist> artistList;

    public Track() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    public Track(int userId, String trackId, String trackName,List<Artist> artistList) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.artistList = artistList;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Track{" +
                "userId=" + userId +
                ", trackId='" + trackId + '\'' +
                ", trackName='" + trackName + '\'' +
                ", artistList=" + artistList +
                '}';
    }
}
