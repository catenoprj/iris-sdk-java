package br.com.cateno.sdk.domain.claim;

import java.util.Objects;

public class ClaimUpdateRequest {
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
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private String deliveryStatusId;
    /**
     * The id of action finance of Claim
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private String financeStatusId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimUpdateRequest that = (ClaimUpdateRequest) o;
        return Objects.equals(claimStatus, that.claimStatus) &&
                Objects.equals(claimStatusDescription, that.claimStatusDescription) &&
                Objects.equals(deliveryStatusId, that.deliveryStatusId) &&
                Objects.equals(financeStatusId, that.financeStatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claimStatus, claimStatusDescription, deliveryStatusId, financeStatusId);
    }
}
