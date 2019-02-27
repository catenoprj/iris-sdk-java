package br.com.cateno.sdk.domain.claim;

import java.util.Date;
import java.util.Objects;

public class Status {
    private String id;
    private String idClaim;
    private String statusCode;
    private String statusType;
    private String description;
    private String username;
    private String userId;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClaim() {
        return idClaim;
    }

    public void setIdClaim(String idClaim) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
