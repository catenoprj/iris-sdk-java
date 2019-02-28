package br.com.cateno.sdk.domain.user;

import java.util.Objects;

/**
 * Represents an operation
 */
public class OperationResponse {
    /**
     * The functionality of operation
     */
    private String functionality;
    /**
     * The action of operation
     */
    private String action;
    /**
     * The role of operation
     */
    private String role;

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationResponse that = (OperationResponse) o;
        return Objects.equals(functionality, that.functionality) &&
                Objects.equals(action, that.action) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionality, action, role);
    }
}
