package br.com.cateno.sdk.domain.user;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

public interface UserApiClient {

    @POST("users/")
    Call<User> create(@Body UserCreateRequest user);

    @GET("users/")
    Call<List<User>> findAll();

    @GET("users/{id}")
    Call<User> findById(@Path("id") String id);

    @PUT("users/{id}")
    Call<User> update(@Path("id") String id, @Body UserUpdateRequest user);

    @PATCH("users/{id}")
    Call<User> partialUpdate(@Path("id") String id, @Body UserUpdateRequest user);

    @DELETE("users/{id}")
    Call<Void> delete(@Path("id") String id);
}
