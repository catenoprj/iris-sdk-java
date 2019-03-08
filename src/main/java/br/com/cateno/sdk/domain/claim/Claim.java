package br.com.cateno.sdk.domain.claim;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a Claim
 */
public class Claim {

    /**
     * The Id of Claim
     */
    private String id;
    /**
     * The Id of Issuer of Claim
     * @see UUID
     */
    private UUID issuerId;
    /**
     * The code of Issuer of Claim
     * @see br.com.cateno.sdk.domain.issuer.Issuer
     */
    private String issuerCode;
    /**
     * The name of Issuer of Claim
     * @see br.com.cateno.sdk.domain.issuer.Issuer
     */
    private String issuerName;
    /**
     * The machine of Claim
     * @see br.com.cateno.sdk.domain.establishment.Machine
     */
    private String machine;
    /**
     * The label of Machine of Claim
     */
    private String machineLabel;
    /**
     * The card number of Claim
     */
    private String cardNumber;
    /**
     * The company code of Claim
     */
    private String companyCode;
    /**
     * The company name of Claim
     */
    private String companyName;
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
    /**
     * The currency of Claim
     */
    private String currency;
    /**
     * The status of Claim
     * @see Status
     */
    private String claimStatus;
    /**
     * The description of status of Claim
     * @see Status
     */
    private String claimStatusDescription;
    /**
     * The id of action delivery of Claim
     * @see UUID
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private UUID deliveryStatusId;
    /**
     * The id description action delivery of Claim
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private String deliveryStatusDescription;
    /**
     * The id of action finance of Claim
     * @see UUID
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private UUID financeStatusId;
    /**
     * The id description action finance of Claim
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private String financeStatusDescription;
    /**
     * The username of Claim
     */
    private String username;
    /**
     * The id of User of Claim
     * @see UUID
     * @see br.com.cateno.sdk.domain.user.User
     */
    private UUID userId;
    /**
     * The date of capture of Claim
     * @see ZonedDateTime
     */
    private ZonedDateTime captureDate;
    /**
     * The date of close of Claim
     * @see ZonedDateTime
     */
    private ZonedDateTime closeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(UUID issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getMachineLabel() {
        return machineLabel;
    }

    public void setMachineLabel(String machineLabel) {
        this.machineLabel = machineLabel;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getClaimStatusDescription() {
        return claimStatusDescription;
    }

    public void setClaimStatusDescription(String claimStatusDescription) {
        this.claimStatusDescription = claimStatusDescription;
    }

    public UUID getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(UUID deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    public String getDeliveryStatusDescription() {
        return deliveryStatusDescription;
    }

    public void setDeliveryStatusDescription(String deliveryStatusDescription) {
        this.deliveryStatusDescription = deliveryStatusDescription;
    }

    public UUID getFinanceStatusId() {
        return financeStatusId;
    }

    public void setFinanceStatusId(UUID financeStatusId) {
        this.financeStatusId = financeStatusId;
    }

    public String getFinanceStatusDescription() {
        return financeStatusDescription;
    }

    public void setFinanceStatusDescription(String financeStatusDescription) {
        this.financeStatusDescription = financeStatusDescription;
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

    public ZonedDateTime getCaptureDate() {
        return this.captureDate;
    }

    public void setCaptureDate(final ZonedDateTime captureDate) {
        this.captureDate = captureDate;
    }

    public ZonedDateTime getCloseDate() {
        return this.closeDate;
    }

    public void setCloseDate(final ZonedDateTime closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return Objects.equals(id, claim.id) &&
                Objects.equals(issuerId, claim.issuerId) &&
                Objects.equals(issuerCode, claim.issuerCode) &&
                Objects.equals(issuerName, claim.issuerName) &&
                Objects.equals(machine, claim.machine) &&
                Objects.equals(machineLabel, claim.machineLabel) &&
                Objects.equals(cardNumber, claim.cardNumber) &&
                Objects.equals(companyCode, claim.companyCode) &&
                Objects.equals(companyName, claim.companyName) &&
                Objects.equals(authorizationDate, claim.authorizationDate) &&
                Objects.equals(authorizationValue, claim.authorizationValue) &&
                Objects.equals(authorizationNumber, claim.authorizationNumber) &&
                Objects.equals(reference, claim.reference) &&
                Objects.equals(industry, claim.industry) &&
                Objects.equals(transactionReference, claim.transactionReference) &&
                Objects.equals(currency, claim.currency) &&
                Objects.equals(claimStatus, claim.claimStatus) &&
                Objects.equals(claimStatusDescription, claim.claimStatusDescription) &&
                Objects.equals(deliveryStatusId, claim.deliveryStatusId) &&
                Objects.equals(deliveryStatusDescription, claim.deliveryStatusDescription) &&
                Objects.equals(financeStatusId, claim.financeStatusId) &&
                Objects.equals(financeStatusDescription, claim.financeStatusDescription) &&
                Objects.equals(username, claim.username) &&
                Objects.equals(userId, claim.userId) &&
                Objects.equals(captureDate, claim.captureDate) &&
                Objects.equals(closeDate, claim.closeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issuerId, issuerCode, issuerName, machine, machineLabel, cardNumber, companyCode, companyName, authorizationDate, authorizationValue, authorizationNumber, reference, industry, transactionReference, currency, claimStatus, claimStatusDescription, deliveryStatusId, deliveryStatusDescription, financeStatusId, financeStatusDescription, username, userId, captureDate, closeDate);
    }
}
