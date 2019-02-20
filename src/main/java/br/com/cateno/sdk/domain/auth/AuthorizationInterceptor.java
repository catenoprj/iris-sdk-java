package br.com.cateno.sdk.domain.auth;

import dagger.Reusable;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import javax.inject.Inject;
import java.io.IOException;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class AuthorizationInterceptor implements Interceptor {

  private final AuthService service;

  @Inject
  public AuthorizationInterceptor(final AuthService service) {
    checkNotNull(service);
    this.service = service;
  }

  @Override
  public Response intercept(final Chain chain) throws IOException {
    final Authorization authorization = service.askForAuthorization();
    final Request request = chain.request()
        .newBuilder()
        .header("client_id", authorization.getClientId())
        .header("access_token", authorization.getAccessToken())
        .build();

    return chain.proceed(request);
  }
}
