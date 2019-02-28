package br.com.cateno.sdk.domain.user;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for resetting e updating a Password of User
 */
@Reusable
public class PasswordService {

    private final PasswordApiClient apiClient;

    @Inject
    public PasswordService(PasswordApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Reset a Password
     *
     * @param cpf user
     * @throws IOException does occur if response by server for unsuccessful
     */
    public void reset(final String cpf) throws IOException {
        checkNotNull(cpf);

        final Call<Void> call = this.apiClient.reset(cpf);
        final Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    /**
     * Update a Password
     *
     * @param password object necessary to update a Password
     * @throws IOException does occur if response by server for unsuccessful
     * @see UpdatePasswordRequest
     */
    public void update(final UpdatePasswordRequest password) throws IOException {
        checkNotNull(password);

        final Call<Void> call = this.apiClient.update(password);
        final Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    /**
     * Reset a Password
     *
     * @param token necessary to update a Password
     * @param password object necessary to update a Password
     * @throws IOException does occur if response by server for unsuccessful
     * @see UpdatePasswordRequest
     */
    public void reset(String token, ResetNewPasswordRequest password) throws IOException {
        final Call<Void> call = this.apiClient.reset(token, password);
        final Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
