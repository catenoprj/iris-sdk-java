package br.com.cateno.sdk.domain.user;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class OperationService {

    private final OperationApiClient apiClient;

    @Inject
    public OperationService(OperationApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public List<OperationResponse> list() throws IOException {
        final Call<List<OperationResponse>> call = this.apiClient.findAll();
        final Response<List<OperationResponse>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }
}
