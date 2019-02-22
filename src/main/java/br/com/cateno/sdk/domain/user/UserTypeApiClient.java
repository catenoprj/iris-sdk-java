package br.com.cateno.sdk.domain.user;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface UserTypeApiClient {

    @GET("user-types/")
    Call<List<String>> findAll();
}
