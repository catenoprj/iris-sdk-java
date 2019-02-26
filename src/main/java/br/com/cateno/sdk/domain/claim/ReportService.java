package br.com.cateno.sdk.domain.claim;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class ReportService {

    private final ReportApiClient apiClient;

    @Inject
    public ReportService(final ReportApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public void downloadReportClaimXLSX() throws IOException {

        final Call<String> call = this.apiClient.downloadReportClaimXLSX();
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportClaimXLSX(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<String> call = this.apiClient.downloadReportClaimXLSX(filters);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportClaimCSV() throws IOException {

        final Call<String> call = this.apiClient.downloadReportClaimCSV();
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportClaimCSV(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<String> call = this.apiClient.downloadReportClaimCSV(filters);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportHistoryXLSX() throws IOException {

        final Call<String> call = this.apiClient.downloadReportHistoryXLSX();
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportHistoryXLSX(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<String> call = this.apiClient.downloadReportHistoryXLSX(filters);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportHistoryCSV() throws IOException {

        final Call<String> call = this.apiClient.downloadReportHistoryCSV();
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    public void downloadReportHistoryCSV(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<String> call = this.apiClient.downloadReportHistoryCSV(filters);
        final Response<String> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

}
