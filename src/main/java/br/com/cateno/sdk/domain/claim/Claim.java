package br.com.cateno.sdk.domain.claim;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Claim {

    private String id;
    private String issuerId;
    private String issuerCode;
    private String issuerName;
    private String machine;
    private String machineLabel;
    private String cardNumber;
    private String companyCode;
    private String companyName;
    private ZonedDateTime authorizationDate;
    private BigDecimal authorizationValue;
    private String authorizationNumber;
    private String reference;
    private String industry;
    private String transactionReference;
    private String currency;
    private String claimStatus;
    private String claimStatusDescription;
    private String deliveryStatusId;
    private String deliveryStatusDescription;
    private String financeStatusId;
    private String financeStatusDescription;
    private String username;
    private String userId;
    private ZonedDateTime captureDate;
    private LocalDate closeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
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

    public String getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(String deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    public String getDeliveryStatusDescription() {
        return deliveryStatusDescription;
    }

    public void setDeliveryStatusDescription(String deliveryStatusDescription) {
        this.deliveryStatusDescription = deliveryStatusDescription;
    }

    public String getFinanceStatusId() {
        return financeStatusId;
    }

    public void setFinanceStatusId(String financeStatusId) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

  public ZonedDateTime getCaptureDate() {
    return this.captureDate;
  }

  public void setCaptureDate(final ZonedDateTime captureDate) {
    this.captureDate = captureDate;
  }

  public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
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
