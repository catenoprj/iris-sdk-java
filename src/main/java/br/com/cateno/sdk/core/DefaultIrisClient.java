package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.establishment.Establishment;
import br.com.cateno.sdk.domain.establishment.EstablishmentRequest;
import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.issuer.Issuer;
import br.com.cateno.sdk.domain.issuer.IssuerRequest;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.domain.user.User;
import br.com.cateno.sdk.domain.user.UserCreateRequest;
import br.com.cateno.sdk.domain.user.UserService;
import br.com.cateno.sdk.domain.user.UserUpdateRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class DefaultIrisClient implements Iris {

  private final IssuerService issuerService;
  private final EstablishmentService establishmentService;
  private final UserService userService;

  @Inject
  public DefaultIrisClient(final IssuerService issuerService, final EstablishmentService establishmentService, final UserService userService) {
    this.issuerService = issuerService;
    this.establishmentService = establishmentService;
    this.userService = userService;
  }

  @Override
  public Issuer fetchIssuer(UUID id) {
    return this.issuerService.fetch(id);
  }

  @Override
  public List<Issuer> listIssuers() {
    return this.issuerService.list();
  }

  @Override
  public Issuer createIssuer(IssuerRequest issuer) {
    return this.issuerService.create(issuer);
  }

  @Override
  public Issuer updateIssuer(UUID id, IssuerRequest issuer) {
    return this.issuerService.update(id, issuer);
  }

  @Override
  public Establishment fetchEstablishment(UUID id) {
    return this.establishmentService.fetch(id);
  }

  @Override
  public List<Establishment> listEstablishments() {
    return this.establishmentService.list();
  }

  @Override
  public Establishment createEstablishment(EstablishmentRequest establishment) {
    return this.establishmentService.create(establishment);
  }

  @Override
  public Establishment updateEstablishment(UUID id, EstablishmentRequest establishment) {
    return this.establishmentService.update(id, establishment);
  }

  @Override
  public void deleteEstablishment(UUID id) {
      this.establishmentService.delete(id);
  }

  @Override
  public User fetchUser(UUID id) {
    return this.userService.fetch(id);
  }

  @Override
  public List<User> listUsers() {
    return this.listUsers();
  }

  @Override
  public User createUser(UserCreateRequest user) {
    return this.userService.create(user);
  }

  @Override
  public User updateUser(UUID id, UserUpdateRequest user) {
    return this.userService.update(id, user);
  }

  @Override
  public void deleteUser(UUID id) {
    this.userService.delete(id);
  }
}
