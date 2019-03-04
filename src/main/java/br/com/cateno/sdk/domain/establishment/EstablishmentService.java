package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding, updating and deleting an Establishment
 */
@Reusable
public class EstablishmentService {

    private final EstablishmentApiClient apiClient;

    @Inject
    public EstablishmentService(final EstablishmentApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a new Establishment
     *
     * @param establishment object necessary to create a new Establishment
     * @return Establishment that was created
     * @throws IOException does occur if response by server for unsuccessful
     * @see EstablishmentRequest
     * @see Establishment
     */
    public Establishment create(final EstablishmentRequest establishment) throws IOException {
        checkNotNull(establishment);

        final Call<Establishment> call = this.apiClient.create(establishment);
        final Response<Establishment> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch an Establishment by Id existent
     *
     * @param id Establishment already created
     * @return Establishment that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see Establishment
     */
    public Establishment fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Establishment> call = this.apiClient.findById(id.toString());
        final Response<Establishment> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch all Establishments
     *
     * @return list of Establishments
     * @throws IOException does occur if response by server for unsuccessful
     * @see Establishment
     */
    public List<Establishment> list() throws IOException {
        final Call<List<Establishment>> call = this.apiClient.findAll();
        final Response<List<Establishment>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Update an Establishment
     *
     * @param id Establishment already created
     * @param establishment object necessary to update an Establishment
     * @return Establishment that was updated
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see EstablishmentRequest
     * @see Establishment
     */
    public Establishment update(final UUID id, final EstablishmentRequest establishment) throws IOException {
        checkNotNull(id);
        checkNotNull(establishment);

        final Call<Establishment> call = this.apiClient.update(id.toString(), establishment);
        final Response<Establishment> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Delete an Establishment
     *
     * @param id Establishment already created
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     */
    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        final Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch all SampleMachine by Establishment Id
     *
     * @param id Establishment already created
     * @return list of Sample Machines
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see SampleMachine
     */
    public List<SampleMachine> listMachines(final UUID id) throws  IOException {
        checkNotNull(id);

        final Call<List<SampleMachine>>  call = this.apiClient.findMachinesByEstablishmentId(id.toString());
        final Response<List<SampleMachine>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
