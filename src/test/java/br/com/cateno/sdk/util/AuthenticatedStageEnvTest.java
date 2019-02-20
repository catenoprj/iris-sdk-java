package br.com.cateno.sdk.util;

import br.com.cateno.sdk.domain.auth.AuthService;
import br.com.cateno.sdk.domain.auth.AuthorizationInterceptor;
import br.com.cateno.sdk.domain.auth.OAuthApiClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public interface AuthenticatedStageEnvTest extends StageEnvTest {

  default OAuthApiClient getOAuthApiClient() {
    final Retrofit retrofit = this.getRetrofit();
    return retrofit.create(OAuthApiClient.class);
  }

  default Retrofit getAuthenticatedRetrofit() {
    final AuthService authService = new AuthService(this.getClientCredentials(), this.getUserCredentials(), this.getOAuthApiClient());
    final Interceptor interceptor = new AuthorizationInterceptor(authService);
    final OkHttpClient httpClient = new OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .build();
    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(this.getConverterFactory())
        .client(httpClient)
        .build();
  }
}
