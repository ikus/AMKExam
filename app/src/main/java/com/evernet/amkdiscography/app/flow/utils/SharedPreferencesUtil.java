package com.evernet.amkdiscography.app.flow.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.evernet.amkdiscography.AMKApplication;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */


public class SharedPreferencesUtil {

    private static final String SHARED_PROJECT = "SharedPreferences_AMK";

    /**
     * Method that saves a String in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The String that is going to be saved
     */
    public static void setAppPreference(String key, String value) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Integer in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The Integer that is going to be saved
     */
    public static void setAppPreference(String key, int value) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Boolean in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The String that is going to be saved
     */
    public static void setAppPreference(String key, boolean value) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Long in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The Long that is going to be saved
     */
    public static void setAppPreference(String key, long value) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Float in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The Long that is going to be saved
     */
    public static void setAppPreference(String key, float value) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * Method that returns a String from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return String The string that was saved with the key
     */
    public static String getString(String key, String defValue) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getString(key, defValue);
    }

    /**
     * Method that returns a String from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return String The string that was saved with the key
     */
    public static String getString(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getString(key, "");
    }

    /**
     * Method that returns a Integer from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Integer that was saved with the key
     */
    public static int getInt(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getInt(key, 0);
    }

    /**
     * Method that returns a Integer from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Integer that was saved with the key
     */
    public static int getInt(String key, int defValue) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getInt(key, defValue);
    }

    /**
     * Method that returns a Long from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Long that was saved with the key
     */
    public static long getLong(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getLong(key, 0);
    }

    /**
     * Method that returns a Long from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Long that was saved with the key
     */
    public static long getLong(String key, long defValue) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getLong(key, defValue);
    }

    /**
     * Method that returns a Long from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Float that was saved with the key
     */
    public static float getFloat(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getFloat(key, 0);
    }

    /**
     * Method that returns a Long from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Float that was saved with the key
     */
    public static float getFloat(String key, float defValue) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getFloat(key, defValue);
    }

    /**
     * Method that returns a Boolean from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Boolean that was saved with the key
     */
    public static boolean getBoolean(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getBoolean(key, false);
    }

    /**
     * Method that returns a Boolean from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Boolean that was saved with the key
     */
    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getBoolean(key, defValue);
    }

    public static boolean contains(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.contains(key);
    }

    public static void remove(String key) {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.remove(key);
        editor.commit();
    }

    public static void clearAllPreferences() {
        SharedPreferences manager = AMKApplication.getmContext().getSharedPreferences(SHARED_PROJECT, 0);
        SharedPreferences.Editor editor = manager.edit();
        editor.clear();
        editor.commit();
    }

    public static SharedPreferences getPreferences(Context context, String app) {
        return context.getSharedPreferences(app, Context.MODE_PRIVATE);
    }
}
