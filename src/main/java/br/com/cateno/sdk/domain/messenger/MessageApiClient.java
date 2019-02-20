package br.com.cateno.sdk.domain.messenger;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MessageApiClient {

    @GET("messages/{id}")
    Call<Message> findById(@Path("id") String id);

    @PATCH("messages/{id}")
    Call<Void> readMessage(@Path("id") String id, @Body MessageReadRequest message);

    @POST("messages/")
    Call<Message> create(@Body MessageRequest message);

    @GET("messages/")
    Call<List<Message>> findAll(@Query("_limit") int pageSize, @Query("_offset") int page);
}
