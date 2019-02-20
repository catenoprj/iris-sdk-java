package br.com.cateno.sdk.domain.claim;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface ClaimApiClient {

    @GET("claims/count")
    Call<Void> countClaims(@QueryMap Map<String, String> options);

    @POST("claims")
    Call<Claim> create(@Body ClaimRequest issuer);



    @GET("claims")
    Call<List<Claim>> findAll();

    @GET("claims/{id}")
    Call<Claim> findById(@Path("id") String id);

    @PATCH("issuers/{id}")
    Call<Claim> update(@Path("id") String toString, @Body ClaimRequest issuer);
}
