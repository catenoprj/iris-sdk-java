package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = IrisModule.class)
public interface Iris {

  IssuerService loadIssuerService();

  EstablishmentService loadEstablishmentService();
}
