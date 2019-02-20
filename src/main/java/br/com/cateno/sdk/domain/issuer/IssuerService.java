package br.com.cateno.sdk.domain.issuer;

import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

public class IssuerService {

  private final IssuerApiClient apiClient;

  @Inject
  public IssuerService(final IssuerApiClient apiClient) {
    checkNotNull(apiClient);
    this.apiClient = apiClient;
  }

  public Issuer create(final IssuerRequest issuer) throws IOException {
    checkNotNull(issuer);

    final Call<Issuer> call = this.apiClient.create(issuer);
    final Response<Issuer> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  public Issuer fetch(final UUID id) throws IOException {
    checkNotNull(id);

    final Call<Issuer> call = this.apiClient.findById(id.toString());
    final Response<Issuer> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  public List<Issuer> list() throws IOException {
    final Call<List<Issuer>> call = this.apiClient.findAll();
    final Response<List<Issuer>> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  public Issuer update(final UUID id, final IssuerRequest issuer) throws IOException {
    checkNotNull(id);
    checkNotNull(issuer);

    final Call<Issuer> call = this.apiClient.update(id.toString(), issuer);
    final Response<Issuer> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }
}
