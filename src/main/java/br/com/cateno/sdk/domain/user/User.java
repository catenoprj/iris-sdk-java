package br.com.cateno.sdk.domain.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Represents a user
 */
public class User {
    /**
     * The Id of user
     * */
    private String id;
    /**
     * The cpf of user
     */
    private String cpf;
    /**
     * The name of user
     */
    private String name;
    /**
     * The extra information of user
     * @see ExtraInfo
     */
    private ExtraInfo extraInfo;
    /**
     * The status of user
     * @see Status
     */
    private Status status;
    /**
     * The type of user
     * @see UserType
     */
    private UserType userType;
    /**
     * The list content ids of issuers of user
     * @see Profile
     */
    private List<String> issuerIds;
    /**
     * The list of content machines of user
     * @see Machine
     */
    private List<Machine> machines;
    /**
     * The id of profile
     * @see Profile
     */
    private String profileId;
    /**
     * The date that created password
     * @see LocalDateTime
     */
    private LocalDateTime passwordDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public LocalDateTime getPasswordDate() {
        return passwordDate;
    }

    public void setPasswordDate(LocalDateTime passwordDate) {
        this.passwordDate = passwordDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(cpf, user.cpf) &&
                Objects.equals(name, user.name) &&
                Objects.equals(extraInfo, user.extraInfo) &&
                status == user.status &&
                userType == user.userType &&
                Objects.equals(issuerIds, user.issuerIds) &&
                Objects.equals(machines, user.machines) &&
                Objects.equals(profileId, user.profileId) &&
                Objects.equals(passwordDate, user.passwordDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, name, extraInfo, status, userType, issuerIds, machines, profileId, passwordDate);
    }
}
