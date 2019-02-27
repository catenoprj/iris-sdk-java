package br.com.cateno.sdk.domain.claim;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ClaimCreateRequest {
    private String issuerCode;
    private String machine;
    private String cardNumber;
    private LocalDateTime authorizationDate;
    private BigDecimal authorizationValue;
    private String authorizationNumber;
    private String reference;
    private String industry;
    private String transactionReference;

    public String getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDateTime getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(LocalDateTime authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public BigDecimal getAuthorizationValue() {
        return authorizationValue;
    }

    public void setAuthorizationValue(BigDecimal authorizationValue) {
        this.authorizationValue = authorizationValue;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimCreateRequest that = (ClaimCreateRequest) o;
        return authorizationValue == that.authorizationValue &&
                Objects.equals(issuerCode, that.issuerCode) &&
                Objects.equals(machine, that.machine) &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(authorizationDate, that.authorizationDate) &&
                Objects.equals(authorizationNumber, that.authorizationNumber) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(industry, that.industry) &&
                Objects.equals(transactionReference, that.transactionReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuerCode, machine, cardNumber, authorizationDate, authorizationValue, authorizationNumber, reference, industry, transactionReference);
    }
}
