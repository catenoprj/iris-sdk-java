package br.com.cateno.sdk.domain.status;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;
/**
 * Provides the local service for accessing, adding, updating and deleting an Action Finance
 */
@Reusable
public class FinanceActionService {

    private final FinanceActionApiClient apiClient;

    @Inject
    public FinanceActionService(FinanceActionApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Create a new Action Finance
     *
     * @param action necessary to create a new Action Finance
     * @return action finance that was created
     * @throws IOException does occur if response by server for unsuccessful
     * @see ActionRequest
     * @see Action
     */
    public Action create(final ActionRequest action) throws IOException {
        checkNotNull(action);

        final Call<Action> call = this.apiClient.create(action);
        final Response<Action> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch an Action Finance by Id existent
     *
     * @param id action finance already create
     * @return action that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see Action
     */
    public Action fetch(final String id) throws IOException {
        checkNotNull(id);

        final Call<Action> call = this.apiClient.findById(id);
        final Response<Action> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch all Actions Finance
     *
     * @return list of Actions Finance
     * @throws IOException does occur if response by server for unsuccessful
     * @see Action
     */
    public List<Action> list() throws IOException {
        final Call<List<Action>> call = this.apiClient.findAll();
        final Response<List<Action>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Update Action Finance by Id existent
     *
     * @param id action finance already created
     * @param action  object necessary to update a Action Finance
     * @return action finance that was updated
     * @throws IOException does occur if response by server for unsuccessful
     * @see ActionRequest
     */
    public Action update(final String id, final ActionRequest action) throws IOException {
        checkNotNull(id);
        checkNotNull(action);

        final Call<Action> call = this.apiClient.update(id, action);
        final Response<Action> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Delete Action Finance by Id existent
     *
     * @param id action finance already created
     * @throws IOException does occur if response by server for unsuccessful
     */
    public void delete(final String id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id);
        Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
