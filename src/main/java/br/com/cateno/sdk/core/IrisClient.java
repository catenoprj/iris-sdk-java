package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.establishment.MachineService;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.domain.user.OperationService;
import br.com.cateno.sdk.domain.user.ProfileService;
import br.com.cateno.sdk.domain.user.UserService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
    ApiClientModule.class,
    AuthModule.class,
    RetrofitModule.class
})
public interface IrisClient {

  IssuerService loadIssuerService();

  EstablishmentService loadEstablishmentService();

  UserService loadUserService();

  ProfileService loadProfileService();

  MachineService loadMachineService();

  OperationService loadOperationService();
}
