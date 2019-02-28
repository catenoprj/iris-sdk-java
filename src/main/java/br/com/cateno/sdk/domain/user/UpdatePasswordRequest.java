package br.com.cateno.sdk.domain.user;

import java.util.Objects;

/**
 * Represents object necessary to update a password of user
 */
public class UpdatePasswordRequest {
    /**
     * The CPF of user
     */
    private String cpf;
    /**
     * The new password
     */
    private String passwordNew;
    /**
     * The old password
     */
    private String passwordOld;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatePasswordRequest that = (UpdatePasswordRequest) o;
        return Objects.equals(cpf, that.cpf) &&
                Objects.equals(passwordNew, that.passwordNew) &&
                Objects.equals(passwordOld, that.passwordOld);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, passwordNew, passwordOld);
    }
}
