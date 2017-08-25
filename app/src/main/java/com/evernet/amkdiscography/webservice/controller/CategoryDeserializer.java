package com.evernet.amkdiscography.webservice.controller;

import com.evernet.amkdiscography.webservice.musicobject.Category;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public  class CategoryDeserializer implements JsonDeserializer<List<Category>>
{

    public List<Category> deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        JsonArray data = je.getAsJsonObject().getAsJsonArray("data");
        ArrayList<Category> myList = new ArrayList<Category>();

        for (JsonElement e : data)
        {
            myList.add((Category)jdc.deserialize(e, Category.class));
        }

        return myList;

    }

}