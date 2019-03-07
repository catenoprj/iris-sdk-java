package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding, updating and deleting a Machine
 */
@Reusable
public class MachineService {

    private final MachineApiClient apiClient;

    @Inject
    public MachineService(final MachineApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a new Machine
     *
     * @param machine object necessary to create a new Machine
     * @return Machine that was created
     * @throws IOException does occur if response by server for unsuccessful
     * @see MachineRequest
     * @see Machine
     */
    public Machine create(final MachineRequest machine) throws IOException {
        checkNotNull(machine);

        final Call<Machine> call = this.apiClient.create(machine);
        final Response<Machine> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch a Machine by Id existent
     *
     * @param id Machine already created
     * @return Machine that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see Machine
     */
    public Machine fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Machine> call = this.apiClient.findById(id.toString());
        final Response<Machine> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch a Machine by Number existent
     *
     * @param number Machine already created
     * @return Machine that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see Machine
     */
    public Machine fetchByNumber(final String number) throws IOException {
        final Call<Machine> call = this.apiClient.findByNumber(number);
        final Response<Machine> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Update a Machine
     *
     * @param id Machine already created
     * @param machine object necessary to update a Machine
     * @return Machine that was updated
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see MachineRequest
     * @see Machine
     */
    public Machine update(final UUID id, final MachineRequest machine) throws IOException {
        checkNotNull(id);
        checkNotNull(machine);

        final Call<Machine> call = this.apiClient.update(id.toString(), machine);
        final Response<Machine> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Delete a Machine
     *
     * @param id Machine already created
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     */
    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        final Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
