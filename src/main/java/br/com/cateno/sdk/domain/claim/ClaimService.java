package br.com.cateno.sdk.domain.claim;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, counting, adding and updating a Claim
 */
@Reusable
public class ClaimService {

  private final ClaimApiClient apiClient;

  @Inject
  public ClaimService(final ClaimApiClient apiClient) {
    checkNotNull(apiClient);
    this.apiClient = apiClient;
  }

  /**
   * Count Claims
   *
   * @return count of Claims
   * @throws IOException does occur if response by server for unsuccessful
   */
  public long count() throws IOException {
    final Call<Void> call = this.apiClient.count();
    final Response<Void> response = call.execute();
    new ApiResponseBody<>(response).successfulBodyOrThrow();
    return Long.parseLong(response.headers().get("x-total-count"));
  }

  /**
   * Count Claims
   *
   * @param filters object necessary to filter Claims
   * @return count of Claims
   * @throws IOException does occur if response by server for unsuccessful
   * @see ClaimFilters
   */
  public long count(final ClaimFilters filters) throws IOException {
    checkNotNull(filters);

    final Call<Void> call = this.apiClient.count(filters);
    final Response<Void> response = call.execute();
    new ApiResponseBody<>(response).successfulBodyOrThrow();
    return Long.parseLong(response.headers().get("x-total-count"));
  }

  /**
   * Create a new Claim
   *
   * @param claim object necessary to create a new Claim
   * @return Claim that was created
   * @throws IOException does occur if response by server for unsuccessful
   * @see ClaimCreateRequest
   * @see Claim
   */
  public Claim create(final ClaimCreateRequest claim) throws IOException {
    final Call<Claim> call = this.apiClient.create(claim);
    final Response<Claim> response = call.execute();
    return new ApiResponseBody<>(response).successfulBodyOrThrow();
  }

  /**
   * Fetch a Claim by Id existent
   *
   * @param id Claim already created
   * @return Claim that was found
   * @throws IOException does occur if response by server for unsuccessful
   * @see UUID
   * @see Claim
   */
  public Claim fetch(final UUID id) throws IOException {
    checkNotNull(id);

    final Call<Claim> call = this.apiClient.findById(id.toString());
    final Response<Claim> response = call.execute();
    return new ApiResponseBody<>(response).successfulBodyOrThrow();
  }

  /**
   * Fetch a Status of Claim by Id Claim existent and type of Status
   *
   * @param id Claim already created
   * @param statusType type of Status
   * @return Status that was found
   * @throws IOException does occur if response by server for unsuccessful
   * @see UUID
   * @see Status
   */
  public List<Status> findStatuses(final UUID id, final String statusType) throws IOException {
    checkNotNull(id);

    final Call<List<Status>> call = this.apiClient.findStatuses(id.toString(), statusType);
    Response<List<Status>> response = call.execute();
    return new ApiResponseBody<>(response).successfulBodyOrThrow();
  }

  /**
   * Fetch Claims
   *
   * @param pagination object necessary to define quantity Claims
   * @return list of Claim
   * @throws IOException does occur if response by server for unsuccessful
   * @see Pagination
   * @see Claim
   */
  public List<Claim> list(final Pagination pagination) throws IOException {
    checkNotNull(pagination);

    final Call<List<Claim>> call = this.apiClient.find(pagination.getLimit(), pagination.getOffset());
    Response<List<Claim>> response = call.execute();
    final List<Claim> claims = new ApiResponseBody<>(response).successfulBodyOrThrow();
    return Optional.ofNullable(claims).orElseGet(Collections::emptyList);
  }

  /**
   * Fetch Claims
   *
   * @param filters object necessary to filter Claims
   * @param pagination object necessary to define quantity Claims
   * @return list of Claim
   * @throws IOException does occur if response by server for unsuccessful
   * @see ClaimFilters
   * @see Pagination
   * @see Claim
   */
  public List<Claim> list(final ClaimFilters filters, final Pagination pagination) throws IOException {
    checkNotNull(filters);
    checkNotNull(pagination);

    final Call<List<Claim>> call = this.apiClient.find(filters, pagination.getLimit(), pagination.getOffset());
    Response<List<Claim>> response = call.execute();
    final List<Claim> claims = new ApiResponseBody<>(response).successfulBodyOrThrow();
    return Optional.ofNullable(claims).orElseGet(Collections::emptyList);
  }

  /**
   * Update a Claim
   *
   * @param id Claim already created
   * @param claim object necessary to update a Claim
   * @throws IOException does occur if response by server for unsuccessful
   * @see UUID
   * @see ClaimUpdateRequest
   */
  public void update(final UUID id, final ClaimUpdateRequest claim) throws IOException {
    checkNotNull(id);
    checkNotNull(claim);

    final Call<Void> call = this.apiClient.update(id.toString(), claim);
    final Response<Void> response = call.execute();
    new ApiResponseBody<>(response).successfulBodyOrThrow();
  }
}
