package vn.edu.usth.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.function.ToLongBiFunction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.instagram.ApiClient;
import vn.edu.usth.instagram.R;
import vn.edu.usth.instagram.dto.request.RegisterRequest;
import vn.edu.usth.instagram.dto.response.ApiResponse;


public class RegisterActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText, emailEditText;
    private Button registerButton, tologinButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        emailEditText = findViewById(R.id.emailEditText);
        registerButton = findViewById(R.id.registerButton);
        tologinButton = findViewById(R.id.tologinButton);

        registerButton.setOnClickListener(v -> registerUser());
        tologinButton.setOnClickListener(v -> tologinUser());
    }
    private void tologinUser(){
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    // Method to register a user
    private void registerUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        // Check if any of the input fields are empty
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(email)){
            // Display a message prompting the user to fill in all fields
            Toast.makeText(RegisterActivity.this, "Input full information", Toast.LENGTH_SHORT).show();
        }else {
            RegisterRequest request = new RegisterRequest(username, password, email);

            // Make a network call to the API to register the user
            ApiClient.getApiService().register(request).enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    Toast.makeText(RegisterActivity.this, response.body().getCode() + "", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
