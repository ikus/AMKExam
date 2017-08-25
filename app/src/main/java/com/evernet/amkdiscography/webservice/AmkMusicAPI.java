package com.evernet.amkdiscography.webservice;

import com.evernet.amkdiscography.webservice.musicobject.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public interface AmkMusicAPI {

    @GET("search")
    Call<Result> loadCategories(@Query("term") String status);
}
