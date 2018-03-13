/*
 *
 *  * Copyright (c) 2016, 360ITPRO and/or its affiliates. All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  *  - Redistributions of source code must retain the above copyright
 *  *    notice, this list of conditions and the following disclaimer.
 *  *
 *  *  - Redistributions in binary form must reproduce the above copyright
 *  *    notice, this list of conditions and the following disclaimer in the
 *  *    documentation and/or other materials provided with the distribution.
 *
 */

package com.structure.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.structure.R;

/**
 * Created by deepakgoyal on 24/02/16.
 */
public class Preferences {
    private static SharedPreferences sp;
    private static Preferences preference;

    public static Preferences getInstance(Context ctx) {
        if (preference == null) {
            preference = new Preferences();
        }
        if (sp == null) {
            sp = ctx.getSharedPreferences(ctx.getResources().getString(R.string.preferencesFile), Context.MODE_PRIVATE);
        }
        return preference;
    }

    private Preferences() {

    }

    /**
     * function store the user id to shared preferences
     *
     * @param id      user ID to store
     * @param context context to be used
     */
    public void storeUserId(Context context, String id) {
        sp.edit().putString(context.getString(R.string.pref_user_id), id).apply();
    }

    /**
     * function to return the saved user id from shared preferences
     *
     * @param context context to be used
     * @return user id if exists else empty string
     */
    public String getUserId(Context context) {
        return sp.getString(context.getString(R.string.pref_user_id), "");
    }

    /**
     * function to check the session of user
     *
     * @param context context to be used
     * @return true if userID exists else return false
     */
    public boolean checkUserSession(Context context) {
        return sp.contains(context.getString(R.string.pref_user_id));
    }

    /**
     * function to clear all the stored preference values
     *
     * @return @empty
     */
    public void clearPreferences() {
        sp.edit().clear().apply();
    }

    /**
     * function to get the stored string value based on key provided
     *
     * @param key the key against value to be fetched
     * @return value based on the key provided
     */
    public String getStringValue(String key) {
        return sp.getString(key, "");
    }

    /**
     * function to store the string value with key
     *
     * @param key
     * @param value
     */
    public void setStringValue(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    /**
     * function to get the stored integer value based on key provided
     *
     * @param key the key against value to be fetched
     * @return value based on the key provided
     */
    public int getIntValue(String key) {
        return sp.getInt(key, 0);
    }

    /**
     * function to store the integer value with key
     *
     * @param key
     * @param value
     */
    public void setIntValue(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    /**
     * function to get the stored boolean value based on key provided
     *
     * @param key the key against value to be fetched
     * @return value based on the key provided
     */
    public boolean getBooleanValue(String key) {
        return sp.getBoolean(key, false);
    }

    /**
     * function to store the boolean value with key
     *
     * @param key
     * @param value
     */
    public void setBooleanValue(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * function to get the stored fragment tag
     *
     * @param context context to be used
     * @return fragment tag
     */
    public String getFragmentTag(Context context) {
        return sp.getString(context.getString(R.string.pref_fragment), "");
    }

    /**
     * function to store the fragment tag
     *
     * @param context context to be used
     * @param tag     fragment tag to be stored
     */
    public void storeFragmentTag(Context context, String tag) {
        sp.edit().putString(context.getString(R.string.pref_fragment), tag).apply();
    }
}
