package com.evernet.amkdiscography.webservice.controller;

import com.evernet.amkdiscography.control.store.adapter.ConverteCategory;
import com.evernet.amkdiscography.control.store.ui.constructor.CategoriesFilterView;
import com.evernet.amkdiscography.webservice.AmkMusicAPI;
import com.evernet.amkdiscography.webservice.musicobject.Category;
import com.evernet.amkdiscography.webservice.musicobject.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class CategoryController implements Callback<Result> {
    CategoriesFilterView mCategoriesListener;
    static final String BASE_URL = "http://itunes.apple.com/";

    public void start(CategoriesFilterView categoriesListener) {
        mCategoriesListener = categoriesListener;
        Type listType = new TypeToken<List<Category>>() {
        }.getType();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AmkMusicAPI gerritAPI = retrofit.create(AmkMusicAPI.class);

        Call<Result> call = gerritAPI.loadCategories("rock");
        call.enqueue(this);

    }


    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        if (response.isSuccessful()) {
            Result changesList = response.body();
            for (Category result : changesList.getResults())
                System.out.println(result.getArtistName());
            mCategoriesListener.updateCategories(ConverteCategory.convert(changesList.getResults()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {
        t.printStackTrace();
    }
}
