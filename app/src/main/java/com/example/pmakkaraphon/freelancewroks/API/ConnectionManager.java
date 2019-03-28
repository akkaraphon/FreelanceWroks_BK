package com.example.pmakkaraphon.freelancewroks.API;

import android.util.Log;

import com.example.pmakkaraphon.freelancewroks.Model.LoginModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionManager {
    public static int unique_id;
//    private static String URL = "https://freelance.thddns.net:1100/apiFreelance/";
    private static String URL = "http://192.168.1.105/apiFreelance/";

    public ConnectionManager() {

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    APIService con = retrofit.create(APIService.class);

    public void authentication(final LoginCallbackListener listener, String user, String pass) {
        Call call = con.authentication(user,pass);
        call.enqueue(new Callback<LoginModel>() {

            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                LoginModel user = response.body();
                if (user == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(user, retrofit);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }
}
