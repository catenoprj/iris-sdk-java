package br.com.cateno.sdk.domain.claim;

import java.util.Objects;
import java.util.UUID;

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
     * @see UUID
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private UUID deliveryStatusId;
    /**
     * The id of action finance of Claim
     * @see UUID
     * @see br.com.cateno.sdk.domain.status.Action
     */
    private UUID financeStatusId;

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

    public UUID getFinanceStatusId() {
        return financeStatusId;
    }

    public void setFinanceStatusId(UUID financeStatusId) {
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
