package br.com.cateno.sdk.domain.establishment;

import java.util.Objects;

/**
 * Represents a sample Machine
 */
public class SampleMachine {
    /**
     * The Id of Machine
     */
    private String id;
    /**
     * The label of Machine
     */
    private String label;
    /**
     * The number of Machine
     */
    private String number;
    /**
     * The validity of Machine
     */
    private Validity validity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        SampleMachine that = (SampleMachine) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(label, that.label) &&
                Objects.equals(number, that.number) &&
                Objects.equals(validity, that.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, number, validity);
    }
}
