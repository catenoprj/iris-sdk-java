package br.com.cateno.sdk.domain.issuer;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IssuerApiClient {

  @POST("issuers/")
  Call<Issuer> create(@Body IssuerRequest issuer);

  @GET("issuers/")
  Call<List<Issuer>> findAll();

  @GET("issuers/{id}")
  Call<Issuer> findById(@Path("id") String id);

  @PUT("issuers/{id}")
  Call<Issuer> update(@Path("id") String toString, @Body IssuerRequest issuer);
}
