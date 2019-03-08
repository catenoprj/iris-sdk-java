package br.com.cateno.sdk.domain.establishment;

import java.util.Objects;

/**
 * Represents a body to create or update a Machine
 */
public class MachineRequest {

    /**
     * The number of Machine
     */
    private String number;
    /**
     * The label of Machine
     */
    private String label;
    /**
     * The Id of Establishment of Machine
     * @see Establishment
     */
    private String establishmentId;
    /**
     * The Validity of Machine
     * @see Validity
     */
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

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
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
