package com.example.pmakkaraphon.freelancewroks.API;

import com.example.pmakkaraphon.freelancewroks.Model.LoginModel;
import com.example.pmakkaraphon.freelancewroks.Model.LogoutModel;

import java.io.File;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface APIService {

    @FormUrlEncoded
    @POST("authentication")
    Call<LoginModel> authentication(
            @Field("username") String user,
            @Field("password") String pass
    );

    @FormUrlEncoded
    @POST("setLogout")
    Call<LogoutModel> setLogout(
            @Field("id_mem") String user
    );


}
