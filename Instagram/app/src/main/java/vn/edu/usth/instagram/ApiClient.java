package vn.edu.usth.instagram;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.instagram.service.ApiService;

public class ApiClient {
    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
