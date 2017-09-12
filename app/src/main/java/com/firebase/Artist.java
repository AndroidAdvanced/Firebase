package com.firebase;

/**
 * Created by Rupal on 9/12/2017.
 */

public class Artist {

    String artistId;
    String artistName;
    String artistGenre;

    public Artist() {

    }

    public Artist(String artistName, String artistId, String artistGenre) {
        this.artistName = artistName;
        this.artistId = artistId;
        this.artistGenre = artistGenre;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistGenre() {
        return artistGenre;
    }

    public String getArtistName() {
        return artistName;
    }
}
