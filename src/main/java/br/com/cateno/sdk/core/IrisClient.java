package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.AuthService;
import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {IrisModule.class, AuthModule.class})
public interface IrisClient {

  IssuerService loadIssuerService();

  EstablishmentService loadEstablishmentService();
}
