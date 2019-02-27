package br.com.cateno.sdk.domain.messenger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class MessageRequest {

    private List<String> userTypes;
    private List<String> profiles;
    private List<String> issuers;
    private List<String> establishments;
    private LocalDateTime scheduleDate;
    private String subject;
    private String text;

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
