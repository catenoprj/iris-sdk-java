package br.com.cateno.sdk.domain.uploader;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for uploading a file Claim
 */
@Reusable
public class UploaderService {

    private UploaderApiClient apiClient;

    @Inject
    public UploaderService(UploaderApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Update a file claim
     *
     * @param pathFile path of file
     * @throws IOException does occur if response by server for unsuccessful
     */
    public void upload(final String pathFile) throws IOException {
        checkNotNull(pathFile);

        File file = new File(pathFile);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("upload claim file", file.getName(), requestBody);

        final Call<Response<?>> call = this.apiClient.upload(body);
        Response<Response<?>> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
