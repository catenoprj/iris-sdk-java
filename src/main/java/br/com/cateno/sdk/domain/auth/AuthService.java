package br.com.cateno.sdk.domain.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.logging.Logger;

import static dagger.internal.Preconditions.checkNotNull;
import static okhttp3.Credentials.basic;

public class AuthService {

  private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());

  private final ClientCredentials client;
  private final UserCredentials user;
  private final OAuthApiClient apiClient;

  public AuthService(final ClientCredentials client, final UserCredentials user, final OAuthApiClient apiClient) {
    checkNotNull(client);
    checkNotNull(user);
    checkNotNull(apiClient);

    this.client = client;
    this.user = user;
    this.apiClient = apiClient;
  }

  public Authorization askForAuthorization() throws IOException {

    final Authentication authentication = this.login();
    return new Authorization(this.client.getId(), authentication.getAccessToken());
  }

  private Authentication login() throws IOException {
    LOGGER.info("login into the API");

    final String clientId = this.client.getId();
    final String secret = this.client.getSecret();
    final String username = this.user.getUsername();
    final String password = this.user.getPassword();

    final retrofit2.Call<Authentication> call = this.apiClient.authenticate(basic(clientId, secret), clientId, username, password);
    final retrofit2.Response<Authentication> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }
}
