/*
 *
 *  *
 *  *  * Copyright (c) 2016, Mobilyte Tech India Pvt. Ltd. and/or its affiliates. All rights reserved.
 *  *  *
 *  *  * Redistribution and use in source and binary forms, with or without
 *  *  * modification, are permitted provided that the following conditions are met:
 *  *  *
 *  *  *  - Redistributions of source code must retain the above copyright
 *  *  *    notice, this list of conditions and the following disclaimer.
 *  *  *
 *  *  *  - Redistributions in binary form must reproduce the above copyright
 *  *  *    notice, this list of conditions and the following disclaimer in the
 *  *  *    documentation and/or other materials provided with the distribution.
 *  *
 *
 */

package com.structure.io.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by deepakgoyal on 21/3/16.
 */
public class APIHandler {

    private static APIHandler instance;
    private APIs handler; // Interface where all API methods are getting called

    private APIHandler() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(APIs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        handler = retrofit.create(APIs.class);
    }

    public static APIHandler getInstance() {
        if (instance == null) {
            instance = new APIHandler();
        }
        return instance;
    }

    public void login(String params, final APIResponseListener callback) {
        handler.login(params).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onSuccess(call, response, APIs.login);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFailure(call, t, APIs.login);
            }
        });
    }
}
