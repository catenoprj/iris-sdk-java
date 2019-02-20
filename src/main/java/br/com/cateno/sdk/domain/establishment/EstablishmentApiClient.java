package br.com.cateno.sdk.domain.establishment;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface EstablishmentApiClient {

  @POST("establishments/")
  Call<Establishment> create(@Body EstablishmentRequest establishment);

  @DELETE("establishments/{id}")
  Call<Void> delete(@Path("id") String id);

  @GET("establishments/")
  Call<List<Establishment>> findAll();

  @GET("establishments/{id}")
  Call<Establishment> findById(@Path("id") String id);

  @PUT("establishments/{id}")
  Call<Establishment> update(@Path("id") String toString, @Body EstablishmentRequest establishment);
}
