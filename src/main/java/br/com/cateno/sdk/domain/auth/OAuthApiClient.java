package br.com.cateno.sdk.domain.auth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OAuthApiClient {

  @FormUrlEncoded
  @POST("oauth/login")
  Call<Authentication> authenticate(@Header("Authorization") String credentials,
                                    @Header("client_id") String clientId,
                                    @Field("username") String username,
                                    @Field("password") String password);
}
