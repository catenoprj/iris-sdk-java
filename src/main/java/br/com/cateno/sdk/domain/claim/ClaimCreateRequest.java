package br.com.cateno.sdk.domain.claim;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Represents a body to create a Claim
 */
public class ClaimCreateRequest {
    /**
     * The code of Issuer of Claim
     * @see br.com.cateno.sdk.domain.issuer.Issuer
     */
    private String issuerCode;
    /**
     * The Machine of Claim
     * @see br.com.cateno.sdk.domain.establishment.Machine
     */
    private String machine;
    /**
     * The card number of Claim
     */
    private String cardNumber;
    /**
     * The date of authorization of Claim
     * @see ZonedDateTime
     */
    private ZonedDateTime authorizationDate;
    /**
     * The value of authorization of Claim
     */
    private BigDecimal authorizationValue;
    /**
     * The number of authorization of Claim
     */
    private String authorizationNumber;
    /**
     * Tne reference of Claim
     */
    private String reference;
    /**
     * The industry of Claim
     */
    private String industry;
    /**
     * The reference transaction of Claim
     */
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

    public ZonedDateTime getAuthorizationDate() {
        return this.authorizationDate;
    }

    public void setAuthorizationDate(final ZonedDateTime authorizationDate) {
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
