package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.establishment.Establishment;
import br.com.cateno.sdk.domain.establishment.EstablishmentRequest;
import br.com.cateno.sdk.domain.issuer.Issuer;
import br.com.cateno.sdk.domain.issuer.IssuerRequest;

import java.util.List;
import java.util.UUID;

public interface Iris {

  Issuer fetchIssuer(UUID id);

  List<Issuer> listIssuers();

  Issuer createIssuer(IssuerRequest issuer);

  Issuer updateIssuer(UUID id, IssuerRequest issuer);

  Establishment fetchEstablishment(UUID id);

  List<Establishment> listEstablishments();

  Establishment createEstablishment(EstablishmentRequest establishment);

  Establishment updateEstablishment(UUID id, EstablishmentRequest establishment);

  Void deleteEstablishment(UUID id);

}