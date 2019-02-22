package br.com.cateno.sdk.domain.claim;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Map;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class ReportService {

    private final ReportApiClient apiClient;

    @Inject
    public ReportService(final ReportApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public void downloadReportClaimXLSX(final Map<String, String> options) throws IOException {
        checkNotNull(options);

        final Call<String> call = this.apiClient.downloadReportClaimXLSX(options);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportClaimCSV(final Map<String, String> options) throws IOException {
        checkNotNull(options);

        final Call<String> call = this.apiClient.downloadReportClaimCSV(options);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportHistoryXLSX(final Map<String, String> options) throws IOException {
        checkNotNull(options);

        final Call<String> call = this.apiClient.downloadReportHistoryXLSX(options);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportHistoryCSV(final Map<String, String> options) throws IOException {
        checkNotNull(options);

        final Call<String> call = this.apiClient.downloadReportHistoryCSV(options);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

}
