package br.com.cateno.sdk.domain.establishment;

import java.util.Objects;
import java.util.UUID;

public class MachineRequest {

    private String number;
    private String label;
    private UUID establishmentId;
    private Validity validity;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public UUID getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(UUID establishmentId) {
        this.establishmentId = establishmentId;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineRequest that = (MachineRequest) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(label, that.label) &&
                Objects.equals(establishmentId, that.establishmentId) &&
                Objects.equals(validity, that.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, label, establishmentId, validity);
    }
}
