package com.niit.jap.domain;

import org.springframework.data.annotation.Id;

public class Artist {
    @Id
    private String artistId;
    private String artistName;

    public Artist(String artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "artistId='" + artistId + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }

    public Artist() {
    }
}
