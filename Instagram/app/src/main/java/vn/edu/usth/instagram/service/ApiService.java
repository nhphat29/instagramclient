package vn.edu.usth.instagram.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.edu.usth.instagram.dto.request.LoginRequest;
import vn.edu.usth.instagram.dto.request.RegisterRequest;
import vn.edu.usth.instagram.dto.response.ApiResponse;


public interface ApiService {
    @POST("users")
    Call<ApiResponse> register(@Body RegisterRequest request);

    @POST("users/login")
    Call<ApiResponse> login(@Body LoginRequest request);

    @GET("users")
    Call<ApiResponse> getAll();
}