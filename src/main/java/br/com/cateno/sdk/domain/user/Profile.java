package br.com.cateno.sdk.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a profile of user
 */
public class Profile {
    /**
     * The id of profile
     * @see UUID
     */
    private UUID id;
    /**
     * The name of profile
     */
    private String name;
    /**
     * The date of creation of profile
     * @see LocalDateTime
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;
    /**
     * The type de user
     * @see UserType
     */
    private UserType userType;
    /**
     * The operations that profile has
     * @see Operation
     */
    private List<Operation> operations;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) &&
                Objects.equals(name, profile.name) &&
                Objects.equals(createdDate, profile.createdDate) &&
                userType == profile.userType &&
                Objects.equals(operations, profile.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdDate, userType, operations);
    }
}
