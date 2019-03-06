package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing all types of Operation
 */
@Reusable
public class OperationService {

    private final OperationApiClient apiClient;

    @Inject
    public OperationService(OperationApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Fetch all Operations
     *
     * @return list of Operations
     * @throws IOException does occur if response by server for unsuccessful
     * @see OperationResponse
     */
    public List<OperationResponse> list() throws IOException {
        final Call<List<OperationResponse>> call = this.apiClient.findAll();
        final Response<List<OperationResponse>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
