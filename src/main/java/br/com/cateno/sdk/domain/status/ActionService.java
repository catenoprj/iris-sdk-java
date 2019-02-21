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
public class ActionService {

    private final ActionApiClient apiClient;

    @Inject
    public ActionService(ActionApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public Action createDeliveryAction(final ActionRequest action) throws IOException {
        checkNotNull(action);

        final Call<Action> call = this.apiClient.createDeliveryAction(action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Action fetchDeliveryAction(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Action> call = this.apiClient.findDeliveryActionById(id.toString());
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Action> listDeliveryAction() throws IOException {
        final Call<List<Action>> call = this.apiClient.findAllDeliveryAction();
        final Response<List<Action>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Action updateDeliveryAction(final UUID id, final ActionRequest action) throws IOException {
        checkNotNull(id);
        checkNotNull(action);

        final Call<Action> call = this.apiClient.updateDeliveryAction(id.toString(), action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public void deleteDeliveryAction(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.deleteDeliveryAction(id.toString());
        Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public Action createFinanceAction(final ActionRequest action) throws IOException {
        checkNotNull(action);

        final Call<Action> call = this.apiClient.createFinanceAction(action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Action fetchFinanceAction(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Action> call = this.apiClient.findFinanceActionById(id.toString());
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Action> listFinanceAction() throws IOException {
        final Call<List<Action>> call = this.apiClient.findAllFinanceAction();
        final Response<List<Action>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Action updateFinanceAction(final UUID id, final ActionRequest action) throws IOException {
        checkNotNull(id);
        checkNotNull(action);

        final Call<Action> call = this.apiClient.updateFinanceAction(id.toString(), action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public void deleteFinanceAction(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.deleteFinanceAction(id.toString());
        Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
