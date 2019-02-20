package br.com.cateno.sdk.domain.establishment;

import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

public class MachineService {

    private final MachineApiClient apiClient;

    @Inject
    public MachineService(final MachineApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Machine create(final MachineRequest machine) throws IOException {
        checkNotNull(machine);

        final Call<Machine> call = this.apiClient.create(machine);
        final Response<Machine> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Machine fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Machine> call = this.apiClient.findById(id.toString());
        final Response<Machine> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Machine> list() throws IOException {
        final Call<List<Machine>> call = this.apiClient.findAll();
        final Response<List<Machine>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Machine update(final UUID id, final MachineRequest machine) throws IOException {
        checkNotNull(id);
        checkNotNull(machine);

        final Call<Machine> call = this.apiClient.update(id.toString(), machine);
        final Response<Machine> response = call.execute();
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
