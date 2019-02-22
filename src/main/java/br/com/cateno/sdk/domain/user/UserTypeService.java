package br.com.cateno.sdk.domain.user;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class UserTypeService {

    private final UserTypeApiClient apiClient;

    @Inject
    public UserTypeService(UserTypeApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public List<String> list() throws IOException {
        final Call<List<String>> call = this.apiClient.findAll();
        final Response<List<String>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }
}
