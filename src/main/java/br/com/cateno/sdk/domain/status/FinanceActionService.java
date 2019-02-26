package br.com.cateno.sdk.domain.status;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class FinanceActionService {

    private final FinanceActionApiClient apiClient;

    @Inject
    public FinanceActionService(FinanceActionApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public Action create(final ActionRequest action) throws IOException {
        checkNotNull(action);

        final Call<Action> call = this.apiClient.create(action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Action fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Action> call = this.apiClient.findById(id.toString());
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Action> list() throws IOException {
        final Call<List<Action>> call = this.apiClient.findAll();
        final Response<List<Action>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Action update(final UUID id, final ActionRequest action) throws IOException {
        checkNotNull(id);
        checkNotNull(action);

        final Call<Action> call = this.apiClient.update(id.toString(), action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
