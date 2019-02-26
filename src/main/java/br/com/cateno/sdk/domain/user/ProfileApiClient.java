package br.com.cateno.sdk.domain.user;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProfileApiClient {

    @POST("profiles/")
    Call<Profile> create(@Body ProfileRequest user);

    @GET("profiles/")
    Call<List<Profile>> findAll();

    @GET("profiles/{id}")
    Call<Profile> findById(@Path("id") String id);

    @PUT("profiles/{id}")
    Call<Profile> update(@Path("id") String id, @Body ProfileRequest user);
}
