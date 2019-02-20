package br.com.cateno.sdk.domain.auth;

class Authorization {

  private final String clientId;
  private final String accessToken;

  Authorization(final String clientId, final String accessToken) {
    this.clientId = clientId;
    this.accessToken = accessToken;
  }

  public String getClientId() {
    return this.clientId;
  }

  public String getAccessToken() {
    return this.accessToken;
  }
}
