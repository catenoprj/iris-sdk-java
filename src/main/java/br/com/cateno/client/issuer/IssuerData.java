package br.com.cateno.client.issuer;

import br.com.cateno.client.issuer.model.Issuer;
import br.com.cateno.client.issuer.model.IssuerRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.UUID;

public class IssuerData {

    private static final String ISSUER_REST_URI  = "https://api-cateno.sensedia.com/hlg/iris/v1/issuers/";

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";

    private static final String ACCESS_TOKEN = "ee713e55-b6b7-3cc2-a198-07eec6f614dc";

    private Client client = ClientBuilder.newClient();

    public Issuer fetchIssuerById(UUID id) {

        return client
                .target(ISSUER_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(authenticate())
                .get(Issuer.class);

    }

    public List<Issuer> fetchIssuers() {
        return client
                .target(ISSUER_REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .headers(authenticate())
                .get(new GenericType<List<Issuer>>() {});
    }

    public Response createIssuer(IssuerRequest issuer) {
        return client
                .target(ISSUER_REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .headers(authenticate())
                .post(Entity.entity(issuer, MediaType.APPLICATION_JSON));

    }

    public Response updateIssuer(UUID id, IssuerRequest issuer) {
        return client
                .target(ISSUER_REST_URI)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .headers(authenticate())
                .put(Entity.entity(issuer, MediaType.APPLICATION_JSON));
    }

    private MultivaluedMap<String, Object> authenticate() {
        final MultivaluedMap<String, Object> args = new MultivaluedHashMap<>();
        args.add("client_id", CLIENT_ID);
        args.add("access_token", ACCESS_TOKEN);
        return args;
    }
}
