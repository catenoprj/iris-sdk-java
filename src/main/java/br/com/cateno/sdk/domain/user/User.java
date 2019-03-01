package br.com.cateno.sdk.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String cpf;
    private String name;
    private ExtraInfo extraInfo;
    private Status status;
    private UserType userType;
    private List<UUID> issuerIds;
    private List<Machine> machines;
    private UUID profileId;
    private LocalDateTime passwordDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public List<UUID> getIssuerIds() {
        return issuerIds;
    }

    public void setIssuerIds(List<UUID> issuerIds) {
        this.issuerIds = issuerIds;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public UUID getProfileId() {
        return profileId;
    }

    public void setProfileId(UUID profileId) {
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
