package br.com.cateno.sdk.domain.messenger;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MessageApiClient {

    @GET("messages/{id}")
    Call<Message> findById(@Path("id") String id);

    @PATCH("messages/{id}")
    Call<Void> update(@Path("id") String id, @Body boolean read);

    @POST("messages/")
    Call<Message> create(@Body MessageRequest message);

    @GET("messages/")
    Call<List<Message>> findAll(@Query("parameters") MessageParameters parameters, @Query("_limit") int pageSize, @Query("_offset") int page);
}
