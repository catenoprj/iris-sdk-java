package br.com.cateno.sdk.domain.status;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ActionApiClient {

    @GET("delivery-actions/")
    Call<List<Action>> findAllDeliveryAction();

    @POST("delivery-actions/")
    Call<Action> createDeliveryAction(@Body ActionRequest action);

    @GET("delivery-actions/{id}")
    Call<Action> findDeliveryActionById(@Path("id") String id);

    @PUT("delivery-actions/{id}")
    Call<Action> updateDeliveryAction(@Path("id") String id, @Body ActionRequest action);

    @DELETE("delivery-actions/{id}")
    Call<Void> deleteDeliveryAction(@Path("id") String id);

    @GET("finance-actions/")
    Call<List<Action>> findAllFinanceAction();

    @POST("finance-actions/")
    Call<Action> createFinanceAction(@Body ActionRequest action);

    @GET("finance-actions/{id}")
    Call<Action> findFinanceActionById(@Path("id") String id);

    @PUT("finance-actions/{id}")
    Call<Action> updateFinanceAction(@Path("id") String id, @Body ActionRequest action);

    @DELETE("finance-actions/{id}")
    Call<Void> deleteFinanceAction(@Path("id") String id);
}
