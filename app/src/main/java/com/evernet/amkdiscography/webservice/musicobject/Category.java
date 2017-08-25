package com.evernet.amkdiscography.webservice.musicobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class Category {

    @SerializedName("artworkUrl100")
    private String artworkUrl100;
    @SerializedName("artistName")
    private String artistName;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }
}
