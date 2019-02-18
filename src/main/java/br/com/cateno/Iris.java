package br.com.cateno;

import br.com.cateno.issuer.Issuer;
import br.com.cateno.issuer.IssuerRequest;

import java.util.List;
import java.util.UUID;

public interface Iris {

   String ISSUER_REST_URI  = "https://api-cateno.sensedia.com/hlg/iris/v1/issuers/";

  // Issuer
  Issuer fetchIssuer(UUID id);

  List<Issuer> listIssuers();

  Issuer createIssuer(IssuerRequest issuer);

  Issuer updateIssuer(UUID id, IssuerRequest issuer);

}
