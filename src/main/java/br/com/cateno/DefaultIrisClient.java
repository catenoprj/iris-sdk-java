package br.com.cateno;

import br.com.cateno.auth.Authentication;
import br.com.cateno.auth.Establishment;

import java.util.List;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

class DefaultIrisClient implements Iris {

  private final Authentication authentication;

  DefaultIrisClient(final Authentication authentication) {
    checkNotNull(authentication);

    this.authentication = authentication;
  }

  @Override
  public List<Establishment> listEstablishments() {
    // TODO: implements this
    throw new UnsupportedOperationException();
  }
}
