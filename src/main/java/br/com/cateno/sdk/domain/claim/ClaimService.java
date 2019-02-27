package br.com.cateno.sdk.domain.claim;

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

@Reusable
public class ClaimService {

  private final ClaimApiClient apiClient;

  @Inject
  public ClaimService(final ClaimApiClient apiClient) {
    checkNotNull(apiClient);
    this.apiClient = apiClient;
  }

  public long count() throws IOException {
    final Call<Void> call = this.apiClient.count();
    final Response<Void> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return Long.parseLong(response.headers().get("x-total-count"));
  }

  public long count(final ClaimFilters filters) throws IOException {
    checkNotNull(filters);

    final Call<Void> call = this.apiClient.count(filters);
    final Response<Void> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return Long.parseLong(response.headers().get("x-total-count"));
  }

  public Claim create(final ClaimRequest claim) throws IOException {
    final Call<Claim> call = this.apiClient.create(claim);
    final Response<Claim> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  public Claim fetch(final UUID id) throws IOException {
    checkNotNull(id);

    final Call<Claim> call = this.apiClient.findById(id.toString());
    final Response<Claim> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return response.body();
  }

  public List<Status> findStatuses(final UUID id, final String statusType) throws IOException {
    checkNotNull(id);

    final Call<List<Status>> call = this.apiClient.findStatuses(id.toString(), statusType);
    Response<List<Status>> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

    return response.body();
  }

  public List<Claim> list(final Pagination pagination) throws IOException {
    checkNotNull(pagination);

    final Call<List<Claim>> call = this.apiClient.find(pagination.getLimit(), pagination.getOffset());
    Response<List<Claim>> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return Optional.ofNullable(response.body()).orElseGet(Collections::emptyList);
  }

  public List<Claim> list(final ClaimFilters filters, final Pagination pagination) throws IOException {
    checkNotNull(filters);
    checkNotNull(pagination);

    final Call<List<Claim>> call = this.apiClient.find(filters, pagination.getLimit(), pagination.getOffset());
    Response<List<Claim>> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    return Optional.ofNullable(response.body()).orElseGet(Collections::emptyList);
  }

  public void update(final UUID id, final ClaimRequest claim) throws IOException {
    checkNotNull(id);
    checkNotNull(claim);

    final Call<Void> call = this.apiClient.update(id.toString(), claim);
    final Response<Void> response = call.execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
  }
}
