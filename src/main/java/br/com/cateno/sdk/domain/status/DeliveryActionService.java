package br.com.cateno.sdk.domain.status;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding, updating and deleting an Action Delivery
 */
@Reusable
public class DeliveryActionService {

    private final DeliveryActionApiClient apiClient;

    @Inject
    public DeliveryActionService(DeliveryActionApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Create a new Action Delivery
     *
     * @param action necessary to create a new Action Delivery
     * @return action delivery that was created
     * @throws IOException does occur if response by server for unsuccessful
     * @see ActionRequest
     * @see Action
     */
    public Action create(final ActionRequest action) throws IOException {
        checkNotNull(action);

        final Call<Action> call = this.apiClient.create(action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Fetch an Action Delivery by Id existent
     *
     * @param id action delivery already create
     * @return action that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see Action
     */
    public Action fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Action> call = this.apiClient.findById(id.toString());
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Fetch all Actions Delivery
     *
     * @return list of Actions Delivery
     * @throws IOException does occur if response by server for unsuccessful
     * @see Action
     */
    public List<Action> list() throws IOException {
        final Call<List<Action>> call = this.apiClient.findAll();
        final Response<List<Action>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Update Action Delivery by Id existent
     *
     * @param id action delivery already created
     * @param action  object necessary to update a Action Delivery
     * @return action delivery that was updated
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see ActionRequest
     */
    public Action update(final UUID id, final ActionRequest action) throws IOException {
        checkNotNull(id);
        checkNotNull(action);

        final Call<Action> call = this.apiClient.update(id.toString(), action);
        final Response<Action> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Delete Action Delivery by Id existent
     *
     * @param id action delivery already created
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     */
    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
