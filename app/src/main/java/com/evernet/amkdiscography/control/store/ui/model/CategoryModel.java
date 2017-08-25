package com.evernet.amkdiscography.control.store.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class CategoryModel implements Parcelable {
    public static final String TAG = CategoryModel.class.getSimpleName();
    public static final String TAG_LIST = CategoryModel.class.getSimpleName() + "List";

    private String name;
    private String urlPrevew;

    public CategoryModel(String name, String urlPrevew) {
        this.name = name;
        this.urlPrevew = urlPrevew;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPrevew() {
        return urlPrevew;
    }

    public void setUrlPrevew(String urlPrevew) {
        this.urlPrevew = urlPrevew;
    }
}
