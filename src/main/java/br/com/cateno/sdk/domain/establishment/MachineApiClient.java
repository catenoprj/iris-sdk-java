package br.com.cateno.sdk.domain.establishment;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MachineApiClient {

    @POST("machines/")
    Call<Machine> create(@Body MachineRequest machine);

    @GET("machines/")
    Call<List<Machine>> findAll();

    @GET("machines/{id}")
    Call<Machine> findById(@Path("id") String id);

    @PUT("machines/{id}")
    Call<Machine> update(@Path("id") String id, @Body MachineRequest machine);

    @DELETE("machines/{id}")
    Call<Void> delete(@Path("id") String id);
}
