package com.example.pmakkaraphon.freelancewroks.API;

import com.example.pmakkaraphon.freelancewroks.Model.LogoutModel;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public interface LogoutCallbackListener {
    public void onResponse(LogoutModel loginModel, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
