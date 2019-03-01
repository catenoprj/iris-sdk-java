package br.com.cateno.sdk.infra;

import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;

public class ApiResponseBody<T> {

  private final Response<T> response;

  public ApiResponseBody(final Response<T> response) {
    this.response = response;
  }

  public T successfulBodyOrThrow() throws IOException {
    if (!this.response.isSuccessful()) {
      try (final ResponseBody responseBody = this.response.errorBody()) {
        final String errorMessage = (responseBody != null) ? responseBody.string() : "";
        throw new IOException("Unexpected response " + errorMessage);
      }
    }
    return this.response.body();
  }
}
