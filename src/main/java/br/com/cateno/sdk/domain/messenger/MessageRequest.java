package br.com.cateno.sdk.domain.messenger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a body to create a Message
 */
public class MessageRequest {
    /**
     * The List content types of user
     * @see br.com.cateno.sdk.domain.user.UserType
     */
    private List<String> userTypes;
    /**
     * The list content ids of profiles of user
     * @see br.com.cateno.sdk.domain.user.Profile
     */
    private List<UUID> profiles;
    /**
     * The list content ids of issuers of user
     * @see UUID
     * @see br.com.cateno.sdk.domain.issuer.Issuer
     */
    private List<UUID> issuers;
    /**
     * The list content ids of establishments of user
     * @see UUID
     * @see br.com.cateno.sdk.domain.establishment.Establishment
     */
    private List<UUID> establishments;
    /**
     * The schedule of Message
     * @see LocalDateTime
     */
    private LocalDateTime scheduleDate;
    /**
     * The subject of Message
     */
    private String subject;
    /**
     * The text of Message
     */
    private String text;

    public List<String> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<String> userTypes) {
        this.userTypes = userTypes;
    }

    public List<UUID> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UUID> profiles) {
        this.profiles = profiles;
    }

    public List<UUID> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<UUID> issuers) {
        this.issuers = issuers;
    }

    public List<UUID> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<UUID> establishments) {
        this.establishments = establishments;
    }

    public LocalDateTime getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDateTime scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRequest that = (MessageRequest) o;
        return Objects.equals(userTypes, that.userTypes) &&
                Objects.equals(profiles, that.profiles) &&
                Objects.equals(issuers, that.issuers) &&
                Objects.equals(establishments, that.establishments) &&
                Objects.equals(scheduleDate, that.scheduleDate) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userTypes, profiles, issuers, establishments, scheduleDate, subject, text);
    }
}
