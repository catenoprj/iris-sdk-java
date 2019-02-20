package br.com.cateno.sdk.domain.establishment;

import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

public class EstablishmentService {

    private final EstablishmentApiClient apiClient;

    @Inject
    public EstablishmentService(final EstablishmentApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Establishment create(final EstablishmentRequest establishment) throws IOException {
        checkNotNull(establishment);

        final Call<Establishment> call = this.apiClient.create(establishment);
        final Response<Establishment> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Establishment fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Establishment> call = this.apiClient.findById(id.toString());
        final Response<Establishment> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Establishment> list() throws IOException {
        final Call<List<Establishment>> call = this.apiClient.findAll();
        final Response<List<Establishment>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Establishment update(final UUID id, final EstablishmentRequest establishment) throws IOException {
        checkNotNull(id);
        checkNotNull(establishment);

        final Call<Establishment> call = this.apiClient.update(id.toString(), establishment);
        final Response<Establishment> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        final Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
