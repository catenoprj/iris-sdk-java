package br.com.cateno.sdk.domain.status;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface FinanceActionApiClient {
    @GET("finance-actions/")
    Call<List<Action>> findAll();

    @POST("finance-actions/")
    Call<Action> create(@Body ActionRequest action);

    @GET("finance-actions/{id}")
    Call<Action> findById(@Path("id") String id);

    @PUT("finance-actions/{id}")
    Call<Action> update(@Path("id") String id, @Body ActionRequest action);

    @DELETE("finance-actions/{id}")
    Call<Void> delete(@Path("id") String id);
}
