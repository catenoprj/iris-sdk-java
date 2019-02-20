package br.com.cateno.sdk.domain.claim;

import java.util.Objects;

public class ClaimRequest {

    private String claimStatus;
    private String claimStatusDescription;
    private String deliveryStatusId;
    private String financeStatusId;
    private String reason;


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

    public String getFinanceStatusId() {
        return financeStatusId;
    }

    public void setFinanceStatusId(String financeStatusId) {
        this.financeStatusId = financeStatusId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimRequest that = (ClaimRequest) o;
        return Objects.equals(claimStatus, that.claimStatus) &&
                Objects.equals(claimStatusDescription, that.claimStatusDescription) &&
                Objects.equals(deliveryStatusId, that.deliveryStatusId) &&
                Objects.equals(financeStatusId, that.financeStatusId) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claimStatus, claimStatusDescription, deliveryStatusId, financeStatusId, reason);
    }
}
