package br.com.cateno.sdk.domain.user;

import retrofit2.Call;
import retrofit2.http.*;

public interface PasswordApiClient {

    @POST("password/")
    Call<Void> reset(@Body String cpf);

    @PATCH("password/")
    Call<Void> update(@Body UpdatePasswordRequest password);

    @PUT("password/{token}")
    Call<Void> reset(@Path("id") String token, @Body ResetNewPasswordRequest password);
}
