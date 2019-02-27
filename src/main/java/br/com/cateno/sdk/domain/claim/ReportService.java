package br.com.cateno.sdk.domain.claim;

import dagger.Reusable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class ReportService {

    private final ReportApiClient apiClient;

    @Inject
    public ReportService(final ReportApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public InputStream xlsxClaimReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.xlsxClaimReport(filters);
        final Response<ResponseBody> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().byteStream();
    }

    public InputStream csvClaimReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.csvClaimReport(filters);
        final Response<ResponseBody> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().byteStream();
    }

    public InputStream xlsxHistoryReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.xlsxClaimHistory(filters);
        final Response<ResponseBody> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().byteStream();
    }

    public InputStream csvHistoryReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.csvClaimHistory(filters);
        final Response<ResponseBody> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().byteStream();
    }
}