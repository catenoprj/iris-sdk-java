package br.com.cateno.sdk.domain.claim;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for downloading file content info of a Claim
 */
@Reusable
public class ReportService {

    private final ReportApiClient apiClient;

    @Inject
    public ReportService(final ReportApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Download Claim Report format xlsx
     *
     * @param filters object necessary to filter Claims
     * @return Stream bytes of Claim Report
     * @throws IOException does occur if response by server for unsuccessful
     * @see ClaimFilters
     * @see InputStream
     */
    public InputStream xlsxClaimReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.xlsxClaimReport(filters);
        final Response<ResponseBody> response = call.execute();
        try (final ResponseBody body = new ApiResponseBody<>(response).successfulBodyOrThrow()) {
            return body.byteStream();
        }
    }

    /**
     * Download Claim Report format csv
     *
     * @param filters object necessary to filter Claims
     * @return Stream bytes of Claim Report
     * @throws IOException does occur if response by server for unsuccessful
     * @see ClaimFilters
     * @see InputStream
     */
    public InputStream csvClaimReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.csvClaimReport(filters);
        final Response<ResponseBody> response = call.execute();
        try (final ResponseBody body = new ApiResponseBody<>(response).successfulBodyOrThrow()) {
            return body.byteStream();
        }
    }

    /**
     * Download Claim History Report format xlsx
     *
     * @param filters object necessary to filter Claims
     * @return Stream bytes of Claim History Report
     * @throws IOException does occur if response by server for unsuccessful
     * @see ClaimFilters
     * @see InputStream
     */
    public InputStream xlsxHistoryReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.xlsxClaimHistory(filters);
        final Response<ResponseBody> response = call.execute();
        try (final ResponseBody body = new ApiResponseBody<>(response).successfulBodyOrThrow()) {
            return body.byteStream();
        }
    }

    /**
     * Download Claim History Report format csv
     *
     * @param filters object necessary to filter Claims
     * @return Stream bytes of Claim History Report
     * @throws IOException does occur if response by server for unsuccessful
     * @see ClaimFilters
     * @see InputStream
     */
    public InputStream csvHistoryReport(final ClaimFilters filters) throws IOException {
        checkNotNull(filters);

        final Call<ResponseBody> call = this.apiClient.csvClaimHistory(filters);
        final Response<ResponseBody> response = call.execute();
        try (final ResponseBody body = new ApiResponseBody<>(response).successfulBodyOrThrow()) {
            return body.byteStream();
        }
    }
}