package vn.edu.usth.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.instagram.dto.request.LoginRequest;
import vn.edu.usth.instagram.dto.response.ApiResponse;


public class LoginActivity extends AppCompatActivity {
    private EditText loginUsernameEditText, loginPasswordEditText;
    private Button loginButton, createacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_login);

        loginUsernameEditText = findViewById(R.id.etEmail);
        loginPasswordEditText = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.login);
        createacc = findViewById(R.id.createacc);

        loginButton.setOnClickListener(v -> loginUser());
        createacc.setOnClickListener(v -> createccUser());

    }

    private void createccUser(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void loginUser() {
        String username = loginUsernameEditText.getText().toString().trim();
        String password = loginPasswordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this, "Input full information", Toast.LENGTH_SHORT).show();
        }else{
            LoginRequest request = new LoginRequest(username, password);

            ApiClient.getApiService().login(request).enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}