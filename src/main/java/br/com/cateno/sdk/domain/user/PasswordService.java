package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class PasswordService {

    private final PasswordApiClient apiClient;

    @Inject
    public PasswordService(PasswordApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public void reset(final String cpf) throws IOException {
        checkNotNull(cpf);

        final Call<Void> call = this.apiClient.reset(cpf);
        final Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public void update(final UpdatePasswordRequest password) throws IOException {
        checkNotNull(password);

        final Call<Void> call = this.apiClient.update(password);
        final Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public void reset(String token, ResetNewPasswordRequest password) throws IOException {
        final Call<Void> call = this.apiClient.reset(token, password);
        final Response<Void> response = call.execute();
    }
}
