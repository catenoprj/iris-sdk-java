package br.com.cateno.sdk.domain.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authentication {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("authorities")
  private List<String> authorities;
  @JsonProperty("user_name")
  private String userName;
  @JsonProperty("name")
  private String name;
  @JsonProperty("user_id")
  private String userId;

  public String getAccessToken() {
    return this.accessToken;
  }

  public List<String> getAuthorities() {
    return this.authorities;
  }

  public String getName() {
    return this.name;
  }

  public String getRefreshToken() {
    return this.refreshToken;
  }

  public String getUserId() {
    return this.userId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setAuthorities(List<String> authorities) {
    this.authorities = authorities;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}