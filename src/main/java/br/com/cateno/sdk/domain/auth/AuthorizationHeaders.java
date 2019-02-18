package br.com.cateno.sdk.domain.auth;

import org.glassfish.jersey.internal.util.collection.ImmutableMultivaluedMap;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Base64;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class AuthorizationHeaders extends ImmutableMultivaluedMap<String, Object> {

  private AuthorizationHeaders(final MultivaluedMap<String, Object> delegate) {
    super(delegate);
  }

  static AuthorizationHeaders of(final ClientCredentials credentials) {
    checkNotNull(credentials);

    final String clientId = credentials.getId();
    final String clientSecret = credentials.getSecret();
    final String token = format("%s:%s", clientId, clientSecret);

    final MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
    headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString(token.getBytes(UTF_8)));
    headers.add("client_id", clientId);

    return new AuthorizationHeaders(headers);
  }

  static AuthorizationHeaders of(final ClientCredentials credentials, final Authentication authentication) {
    checkNotNull(credentials);
    checkNotNull(authentication);

    final MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
    headers.add("client_id", credentials.getId());
    headers.add("access_token", authentication.getAccessToken());
    return new AuthorizationHeaders(headers);
  }
}