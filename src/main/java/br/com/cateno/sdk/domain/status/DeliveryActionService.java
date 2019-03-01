package br.com.cateno.sdk.domain.status;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class DeliveryActionService {

    private final DeliveryActionApiClient apiClient;

    @Inject
    public DeliveryActionService(DeliveryActionApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public Action create(final ActionRequest action) throws IOException {
        checkNotNull(action);

        final Call<Action> call = this.apiClient.create(action);
        final Response<Action> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public Action fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Action> call = this.apiClient.findById(id.toString());
        final Response<Action> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public List<Action> list() throws IOException {
        final Call<List<Action>> call = this.apiClient.findAll();
        final Response<List<Action>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public Action update(final UUID id, final ActionRequest action) throws IOException {
        checkNotNull(id);
        checkNotNull(action);

        final Call<Action> call = this.apiClient.update(id.toString(), action);
        final Response<Action> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
