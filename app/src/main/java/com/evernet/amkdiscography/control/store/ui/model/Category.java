package com.evernet.amkdiscography.control.store.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class Category implements Parcelable {
    public static final String TAG = Category.class.getSimpleName();
    public static final String TAG_LIST = Category.class.getSimpleName() + "List";

    public static final String KEY_FLASHCARDS = "category";
    //public static final String KEY_QUESTION = "question";
    //public static final String KEY_ANSWER = "answer";

    //@SerializedName("question")
    //public final String question;
    //@SerializedName("answer")
    //public final String answer;

    public Category(String name) {
        this.name = name;
    }

    private String name;


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
}
