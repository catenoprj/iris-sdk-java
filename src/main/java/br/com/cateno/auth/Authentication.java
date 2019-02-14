package br.com.cateno.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
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
}