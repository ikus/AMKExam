package com.evernet.amkdiscography.control.store.adapter;

import com.evernet.amkdiscography.control.store.ui.model.CategoryModel;
import com.evernet.amkdiscography.webservice.musicobject.Category;

import java.util.ArrayList;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class ConverteCategory {
    public static ArrayList<CategoryModel> convert(ArrayList<Category> categories) {
        ArrayList<CategoryModel> list = new ArrayList<>();
        for (Category cat : categories
                ) {
            list.add(new CategoryModel(cat.getArtistName(),cat.getArtworkUrl100()));
        }
        return list;
    }
}
