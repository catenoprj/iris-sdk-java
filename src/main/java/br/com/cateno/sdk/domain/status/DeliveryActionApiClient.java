package br.com.cateno.sdk.domain.status;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface DeliveryActionApiClient {

    @GET("delivery-actions/")
    Call<List<Action>> findAll();

    @POST("delivery-actions/")
    Call<Action> create(@Body ActionRequest action);

    @GET("delivery-actions/{id}")
    Call<Action> findById(@Path("id") String id);

    @PUT("delivery-actions/{id}")
    Call<Action> update(@Path("id") String id, @Body ActionRequest action);

    @DELETE("delivery-actions/{id}")
    Call<Void> delete(@Path("id") String id);
}
