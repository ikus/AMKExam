package com.evernet.amkdiscography.webservice.musicobject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class Result {
    @SerializedName("resultCount")
    private int resultCount;
    @SerializedName("results")
    private ArrayList<Category> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ArrayList<Category> getResults() {
        return results;
    }

    public void setResults(ArrayList<Category> results) {
        this.results = results;
    }
}
