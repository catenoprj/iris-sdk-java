package br.com.cateno.sdk.domain.claim;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ReportApiClient {

    @GET("report/download.xlsx")
    Call<ResponseBody> xlsxClaimReport(@QueryMap Map<String, String> filters);

    @GET("report/download.csv")
    Call<ResponseBody> csvClaimReport(@QueryMap Map<String, String> filters);

    @GET("report/history.xlsx")
    Call<ResponseBody> xlsxClaimHistory(@QueryMap Map<String, String> filters);

    @GET("report/history.csv")
    Call<ResponseBody> csvClaimHistory(@QueryMap Map<String, String> filters);
}
