package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.domain.auth.AuthService;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class EstablishmentService {

    private static final String ESTABLISHMENT_REST_URI = "https://api-cateno.sensedia.com/hlg/iris/v1/establishment/";
    private final AuthService authService;
    private final Client webClient;

    @Inject
    public EstablishmentService(final AuthService authService, final Client webClient) {
        this.authService = authService;
        this.webClient = webClient;
    }

    public Establishment create(final EstablishmentRequest issuer) {
        checkNotNull(issuer);

        return this.webClient
                .target(ESTABLISHMENT_REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .post(Entity.entity(issuer, MediaType.APPLICATION_JSON), Establishment.class);
    }

    public Establishment fetch(final UUID id) {
        checkNotNull(id);

        return this.webClient
                .target(ESTABLISHMENT_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .get(Establishment.class);
    }

    public List<Establishment> list() {
        return this.webClient
                .target(ESTABLISHMENT_REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .get(new GenericType<List<Establishment>>() {});
    }

    public Establishment update(final UUID id, final EstablishmentRequest establishment) {
        checkNotNull(id);
        checkNotNull(establishment);

        return this.webClient
                .target(ESTABLISHMENT_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .put(Entity.entity(establishment, MediaType.APPLICATION_JSON), Establishment.class);
    }

    public Void delete(final UUID id) {
        checkNotNull(id);

        return this.webClient
                .target(ESTABLISHMENT_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(this.authService.requestHeaders())
                .delete(Void.class);
    }
}
