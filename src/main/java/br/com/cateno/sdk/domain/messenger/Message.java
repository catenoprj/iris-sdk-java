package br.com.cateno.sdk.domain.messenger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Represents a message
 */
public class Message {

    /**
     * The Id of Message
     */
    private String id;
    /**
     * The List content types of user
     * @see br.com.cateno.sdk.domain.user.UserType
     */
    private List<String> userTypes;
    /**
     * The list content ids of profiles of user
     * @see br.com.cateno.sdk.domain.user.Profile
     */
    private List<String> profiles;
    /**
     * The list content ids of issuers of user
     * @see br.com.cateno.sdk.domain.issuer.Issuer
     */
    private List<String> issuers;
    /**
     * The list content ids of establishments of user
     * @see br.com.cateno.sdk.domain.establishment.Establishment
     */
    private List<String> establishments;
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
    /**
     * Who send Message
     */
    private String from;
    /**
     * Who created the Message
     */
    private String createdBy;
    /**
     * When was created the Message
     */
    private LocalDateTime createdAt;
    /**
     * The Message is read
     */
    private Boolean read;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<String> userTypes) {
        this.userTypes = userTypes;
    }

    public List<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }

    public List<String> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<String> issuers) {
        this.issuers = issuers;
    }

    public List<String> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<String> establishments) {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(userTypes, message.userTypes) &&
                Objects.equals(profiles, message.profiles) &&
                Objects.equals(issuers, message.issuers) &&
                Objects.equals(establishments, message.establishments) &&
                Objects.equals(scheduleDate, message.scheduleDate) &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(text, message.text) &&
                Objects.equals(from, message.from) &&
                Objects.equals(createdBy, message.createdBy) &&
                Objects.equals(createdAt, message.createdAt) &&
                Objects.equals(read, message.read);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userTypes, profiles, issuers, establishments, scheduleDate, subject, text, from, createdBy, createdAt, read);
    }
}
