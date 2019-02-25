package br.com.cateno.sdk.domain.uploader;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploaderApiClient {
    @Multipart
    @POST("claim-file/")
    Call<Response<?>> upload(@Part MultipartBody.Part file);
}
