package com.example.develop.progect2;



import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ServiceAPI {

    @GET("/messages/v2/send/")
    Call<Object> sendRequest(@Query("phone") String phone, @Query("text") String text, @Query("login") String login, @Query("password") String password);

    @FormUrlEncoded
    @GET("/messages/v2/send/")
    Call<Object> send(@FieldMap Map<String, String> map);

}
