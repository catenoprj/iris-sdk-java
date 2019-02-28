package br.com.cateno.sdk.domain.user;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding, updating and deleting an User
 */
@Reusable
public class UserService {

    private final UserApiClient apiClient;

    @Inject
    public UserService(UserApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Create a new User
     *
     * @param user object necessary to create a new User
     * @return User that was created
     * @throws IOException does occur if response by server for unsuccessful
     * @see UserCreateRequest
     * @see User
     */
    public User create(final UserCreateRequest user) throws IOException {
        checkNotNull(user);

        final Call<User> call = this.apiClient.create(user);
        final Response<User> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Fetch an User by Id existent
     *
     * @param id user already created
     * @return User that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see User
     */
    public User fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<User> call = this.apiClient.findById(id.toString());
        final Response<User> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Fetch all Users
     *
     * @return list of Users
     * @throws IOException does occur if response by server for unsuccessful
     * @see User
     */
    public List<User> list() throws IOException {
        final Call<List<User>> call = this.apiClient.findAll();
        final Response<List<User>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Update User by Id existent
     *
     * @param id user already created
     * @param user object necessary to update a User
     * @return User that was updated
     * @throws IOException does occur if response by server for unsuccessful
     * @see UserUpdateRequest
     * @see User
     */
    public User update(final UUID id, final UserUpdateRequest user) throws IOException {
        checkNotNull(id);
        checkNotNull(user);

        final Call<User> call = this.apiClient.update(id.toString(), user);
        final Response<User> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Partial update User by Id existent
     *
     * @param id user already created
     * @param user object necessary to update a User (will be updated only fields present in object)
     * @return User thas was partial updated
     * @throws IOException does occur if response by server for unsuccessful
     * @see UUID
     * @see UserUpdateRequest
     * @see User
     */
    public User partialUpdate(final UUID id, final UserUpdateRequest user) throws IOException {
        checkNotNull(id);
        checkNotNull(user);

        final Call<User> call = this.apiClient.partialUpdate(id.toString(), user);
        final Response<User> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    /**
     * Delete User by Id existent
     *
     * @param id user already created
     * @throws IOException does occur if response by server for unsuccessful
     */
    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }

    /**
     * Fetch all Types user
     *
     * @return list of types of user
     * @throws IOException does occur if response by server for unsuccessful
     */
    public List<String> types() throws IOException {
        final Call<List<String>> call = this.apiClient.types();
        final Response<List<String>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }
}
