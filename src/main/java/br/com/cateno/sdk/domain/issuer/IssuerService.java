package br.com.cateno.sdk.domain.issuer;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding and updating an Issuer
 */
@Reusable
public class IssuerService {

  private final IssuerApiClient apiClient;

  @Inject
  public IssuerService(final IssuerApiClient apiClient) {
    checkNotNull(apiClient);
    this.apiClient = apiClient;
  }

  /**
   * Create a new Issuer
   *
   * @param issuer object necessary to create a new Issuer
   * @return Issuer that was created
   * @throws IOException does occur if response by server for unsuccessful
   * @see IssuerRequest
   * @see Issuer
   */
  public Issuer create(final IssuerRequest issuer) throws IOException {
    checkNotNull(issuer);

    final Call<Issuer> call = this.apiClient.create(issuer);
    final Response<Issuer> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  /**
   * Fetch an Issuer by Id existent
   *
   * @param id issuer already created
   * @return Issuer that was found
   * @throws IOException does occur if response by server for unsuccessful
   * @see UUID
   * @see Issuer
   */
  public Issuer fetch(final UUID id) throws IOException {
    checkNotNull(id);

    final Call<Issuer> call = this.apiClient.findById(id.toString());
    final Response<Issuer> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  /**
   * Fetch all Issuers
   *
   * @return list of Issuers
   * @throws IOException does occur if response by server for unsuccessful
   * @see Issuer
   */
  public List<Issuer> list() throws IOException {
    final Call<List<Issuer>> call = this.apiClient.findAll();
    final Response<List<Issuer>> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  /**
   * Update Issuer by Id existent
   *
   * @param id issuer already created
   * @param issuer object necessary to update a Issuer
   * @return Issuer that was updated
   * @throws IOException does occur if response by server for unsuccessful
   * @see UUID
   * @see IssuerRequest
   * @see Issuer
   */
  public Issuer update(final UUID id, final IssuerRequest issuer) throws IOException {
    checkNotNull(id);
    checkNotNull(issuer);

    final Call<Issuer> call = this.apiClient.update(id.toString(), issuer);
    final Response<Issuer> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }
}
