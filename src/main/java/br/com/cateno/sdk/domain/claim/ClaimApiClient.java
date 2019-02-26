package br.com.cateno.sdk.domain.claim;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface ClaimApiClient {

  @GET("claims/count")
  Call<Void> count();

  @GET("claims/count")
  Call<Void> count(@QueryMap Map<String, String> filters);

  @POST("claims")
  Call<Claim> create(@Body ClaimRequest claim);

  @GET("claims")
  Call<List<Claim>> find(@Query("_limit") Integer limit, @Query("_offset") Integer offset);

  @GET("claims")
  Call<List<Claim>> find(@QueryMap Map<String, String> filters, @Query("_limit") Integer limit, @Query("_offset") Integer offset);

  @GET("claims/{id}")
  Call<Claim> findById(@Path("id") String id);

  @GET("claims/{id}/status")
  Call<List<Status>> findStatuses(@Path("id") String id, @Query("statusType") String statusType);

  @PATCH("claims/{id}")
  Call<Void> update(@Path("id") String id, @Body ClaimRequest issuer);
}
