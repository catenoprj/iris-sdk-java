package br.com.cateno.sdk.domain.claim;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ReportApiClient {

    @GET("report/download.xlsx")
    Call<String> downloadReportClaimXLSX();

    @GET("report/download.xlsx")
    Call<String> downloadReportClaimXLSX(@QueryMap Map<String, String> filters);

    @GET("report/download.csv")
    Call<String> downloadReportClaimCSV();

    @GET("report/download.csv")
    Call<String> downloadReportClaimCSV(@QueryMap Map<String, String> filters);

    @GET("report/history.xlsx")
    Call<String> downloadReportHistoryXLSX();

    @GET("report/history.xlsx")
    Call<String> downloadReportHistoryXLSX(@QueryMap Map<String, String> filters);

    @GET("report/history.csv")
    Call<String> downloadReportHistoryCSV();

    @GET("report/history.csv")
    Call<String> downloadReportHistoryCSV(@QueryMap Map<String, String> filters);
}
