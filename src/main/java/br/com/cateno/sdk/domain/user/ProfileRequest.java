package br.com.cateno.sdk.domain.user;

import java.util.List;
import java.util.Objects;

public class ProfileRequest {

    private String name;
    private UserType userType;
    private List<Operation> operations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileRequest that = (ProfileRequest) o;
        return Objects.equals(name, that.name) &&
                userType == that.userType &&
                Objects.equals(operations, that.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userType, operations);
    }
}
