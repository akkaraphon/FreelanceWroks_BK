package com.example.pmakkaraphon.freelancewroks.API;

import com.example.pmakkaraphon.freelancewroks.Model.LoginModel;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public interface LoginCallbackListener {
    public void onResponse(LoginModel loginModel, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
