package br.com.cateno.sdk.domain.claim;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a Status of Claim
 */
public class Status {
    /**
     * The Id of Status of Claim
     * @see UUID
     */
    private UUID id;
    /**
     * The Id of Claim
     * @see UUID
     */
    private UUID idClaim;
    /**
     * The code of Status
     */
    private String statusCode;
    /**
     * The type of Status
     */
    private String statusType;
    /**
     * The description of Status
     */
    private String description;
    /**
     * The username of Status of Claim
     */
    private String username;
    /**
     * The Id of User of Claim
     * @see UUID
     */
    private UUID userId;
    /**
     * The date of Status
     * @see LocalDateTime
     */
    private LocalDateTime date;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdClaim() {
        return idClaim;
    }

    public void setIdClaim(UUID idClaim) {
        this.idClaim = idClaim;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id) &&
                Objects.equals(idClaim, status.idClaim) &&
                Objects.equals(statusCode, status.statusCode) &&
                Objects.equals(statusType, status.statusType) &&
                Objects.equals(description, status.description) &&
                Objects.equals(username, status.username) &&
                Objects.equals(userId, status.userId) &&
                Objects.equals(date, status.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClaim, statusCode, statusType, description, username, userId, date);
    }
}
