package br.com.cateno.sdk.domain.user;

import java.util.List;
import java.util.Objects;

/**
 * Represents a body to create an User
 */
public class UserCreateRequest {
    /**
     * The CPF of user
     */
    private String cpf;
    /**
     * The name of user
     */
    private String name;
    /**
     * The type of user
     * @see UserType
     */
    private UserType userType;
    /**
     * The list content ids of issuers of user
     */
    private List<String> issuerIds;
    /**
     * The extra information of user
     * @see ExtraInfo
     */
    private ExtraInfo extraInfo;
    /**
     * The list of content machines of user
     * @see Machine
     */
    private List<Machine> machines;
    /**
     * The id of profile of user
     */
    private String profileId;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

    public List<String> getIssuerIds() {
        return issuerIds;
    }

    public void setIssuerIds(List<String> issuerIds) {
        this.issuerIds = issuerIds;
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateRequest that = (UserCreateRequest) o;
        return Objects.equals(cpf, that.cpf) &&
                Objects.equals(name, that.name) &&
                userType == that.userType &&
                Objects.equals(issuerIds, that.issuerIds) &&
                Objects.equals(extraInfo, that.extraInfo) &&
                Objects.equals(machines, that.machines) &&
                Objects.equals(profileId, that.profileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, userType, issuerIds, extraInfo, machines, profileId);
    }
}
