package br.com.cateno.sdk.domain.user;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface OperationApiClient {

    @GET("operations/")
    Call<List<OperationResponse>> findAll();
}
