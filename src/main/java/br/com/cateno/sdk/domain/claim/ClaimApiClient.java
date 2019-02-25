package br.com.cateno.sdk.domain.claim;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface ClaimApiClient {

    @GET("claims/count")
    Call<Void> count(@QueryMap Map<String, String> options);

    @GET("claims")
    Call<List<Claim>> findByFilters(@QueryMap Map<String, String> filters, @Query("_limit") int pageSize, @Query("_offset") int page);

    @POST("claims")
    Call<Claim> create(@Body ClaimRequest claim);

    @GET("claims/{id}")
    Call<Claim> findById(@Path("id") String id);

    @PATCH("issuers/{id}")
    Call<Void> update(@Path("id") String toString, @Body ClaimRequest issuer);

    @GET("claims/{id}/status")
    Call<List<Status>> findStatuses(@Path("id") String id, @Query("statusType") String statusType);
}
