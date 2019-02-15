package br.com.cateno;

import br.com.cateno.issuer.Issuer;
import br.com.cateno.issuer.IssuerRequest;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

public interface Iris {

   String ISSUER_REST_URI  = "https://api-cateno.sensedia.com/hlg/iris/v1/issuers/";

  // Issuer
  Issuer fetchIssuerById(UUID id);

  List<Issuer> fetchIssuers();

  Response createIssuer(IssuerRequest issuer);

  Response updateIssuer(UUID id, IssuerRequest issuer);

}
