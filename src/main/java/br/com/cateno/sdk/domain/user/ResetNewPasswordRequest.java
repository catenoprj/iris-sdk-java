package br.com.cateno.sdk.domain.user;

import java.util.Objects;

/**
 * Represents object necessary to reset a password of user
 */
public class ResetNewPasswordRequest {
    private String password;
    private String token;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResetNewPasswordRequest that = (ResetNewPasswordRequest) o;
        return Objects.equals(password, that.password) &&
                Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, token);
    }
}
