package com.example.pmakkaraphon.freelancewroks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmakkaraphon.freelancewroks.API.ConnectionManager;
import com.example.pmakkaraphon.freelancewroks.API.LoginCallbackListener;
import com.example.pmakkaraphon.freelancewroks.Model.LoginModel;
import com.example.pmakkaraphon.freelancewroks.Utils.StaticClass;
import com.google.firebase.iid.FirebaseInstanceId;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {


    private EditText edUsername, edPassword;
    private Button btLogin, btRegister;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;
    ConnectionManager connect = new ConnectionManager();
    LoginCallbackListener loginCallbackListener;
    String TAG = "LoginActivity";
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = (Button) findViewById(R.id.btLogin);
        btRegister = (Button) findViewById(R.id.btRegister);
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        mPrefs = getSharedPreferences("prefs_user", Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLogin();
            }
        });
        loginCallbackListener = new LoginCallbackListener() {

            @Override
            public void onResponse(LoginModel loginModel, Retrofit retrofit) {
                StaticClass.loginModel = loginModel;
                Log.d(TAG, "onResponse: " + loginModel.getCode());
                if (loginModel.getCode() == 1) {
                    onLoginSucced();
                } else {
                    onLoginFailed();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                StaticClass.toast(getApplicationContext(), "ข้อมูลผิดพลาด");
                Log.d(TAG, "onFailure: " + t.toString());
            }

            @Override
            public void onBodyError(ResponseBody responseBody) {
                StaticClass.toast(getApplicationContext(), "ข้อมูลผิดพลาด");
                Log.d(TAG, "onBodyError: " + responseBody.toString());
            }

            @Override
            public void onBodyErrorIsNull() {
                Log.d(TAG, "onBodyErrorIsNull: ");
            }
        };
    }

    public void getLogin() {
        Log.d(TAG, "Login");
//        if (!validate()) {
//            onLoginFailed();
//            return;
//        }

//        String username = edUsername.getText().toString();
//        String password = edPassword.getText().toString();
        String username = "cust1";
        String password = "123456789";

//        token = FirebaseInstanceId.getInstance().getToken();
//        Log.d(TAG, "Token : " + token);

        Log.d(TAG, username + " : " + password);
        connect.authentication(loginCallbackListener, username, password);
    }

    public boolean validate() {
        boolean valid = true;

        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        mEditor.putString("username", username);
        mEditor.putString("password", password);
        mEditor.commit();
        if (username.isEmpty()) {
            edUsername.setError("please fill username");
            valid = false;
        } else {
            edUsername.setError(null);
        }
        if (password.isEmpty()) {
            edPassword.setError("please fill password");
            valid = false;
        } else {
            edPassword.setError(null);
        }
        return valid;
    }

    private void onLoginSucced() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void onLoginFailed() {
        StaticClass.toast(getApplicationContext(), "Login failed");
    }
}
