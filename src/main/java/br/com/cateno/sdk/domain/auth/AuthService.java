package br.com.cateno.sdk.domain.auth;

import com.github.benmanes.caffeine.cache.Cache;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import static dagger.internal.Preconditions.checkNotNull;
import static okhttp3.Credentials.basic;

public class AuthService {

  private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());
  private final OAuthApiClient apiClient;
  private final ClientCredentials client;
  private final UserCredentials user;
  private final Cache<String, Authorization> cache;

  public AuthService(final ClientCredentials client,
                     final UserCredentials user,
                     final OAuthApiClient apiClient,
                     final Cache<String, Authorization> cache) {
    checkNotNull(client);
    checkNotNull(user);
    checkNotNull(apiClient);
    checkNotNull(cache);

    this.client = client;
    this.user = user;
    this.apiClient = apiClient;
    this.cache = cache;
  }

  public Authorization askForAuthorization() {
    return this.getAuthentication().orElseGet(this::newAuthorization);
  }

  private Optional<Authorization> getAuthentication() {
    return Optional.ofNullable(this.cache.getIfPresent("authentication"));
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

  private Authorization newAuthorization() {
    try {
      final Authentication authentication = this.login();
      final Authorization authorization = new Authorization(this.client.getId(), authentication.getAccessToken());
      this.cache.put("authentication", authorization);

      return authorization;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
