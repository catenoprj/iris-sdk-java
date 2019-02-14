package br.com.cateno;

import br.com.cateno.auth.Authentication;
import br.com.cateno.auth.Establishment;
import lombok.NonNull;

import java.util.List;

class DefaultIrisClient implements Iris {

  private final Authentication authentication;

  DefaultIrisClient(final @NonNull Authentication authentication) {
    this.authentication = authentication;
  }

  @Override
  public List<Establishment> listEstablishments() {
    // TODO: implements this
    throw new UnsupportedOperationException();
  }
}
