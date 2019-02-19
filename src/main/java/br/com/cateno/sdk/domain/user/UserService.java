package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.domain.auth.AuthService;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class UserService {

    private static final String USER_REST_URI = "https://api-cateno.sensedia.com/hlg/iris/v1/users/";

    private final AuthService authService;
    private final Client webClient;

    @Inject
    public UserService(final AuthService authService, final Client webClient) {
        this.authService = authService;
        this.webClient = webClient;
    }

    public User create(final UserCreateRequest user) {
        checkNotNull(user);

        return this.webClient
                .target(USER_REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .post(Entity.entity(user, MediaType.APPLICATION_JSON), User.class);
    }

    public User fetch(final UUID id) {
        checkNotNull(id);

        return this.webClient
                .target(USER_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .get(User.class);
    }

    public List<User> list() {
        return this.webClient
                .target(USER_REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .get(new GenericType<List<User>>() {});
    }

    public User update(final UUID id, final UserUpdateRequest user) {
        checkNotNull(id);
        checkNotNull(user);

        return this.webClient
                .target(USER_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .put(Entity.entity(user, MediaType.APPLICATION_JSON), User.class);
    }

    public void delete(final  UUID id) {
        checkNotNull(id);

        this.webClient
                .target(USER_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .delete();
    }
}
