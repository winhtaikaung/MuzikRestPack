package com.win.muzikrestpack.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by win on 3/22/17.
 */
public class RestClient {

    private final static String API_URL = "http://restpack-serializer-sample.herokuapp.com/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit != null) {
            return retrofit;
        }


        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static <T> T getService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
