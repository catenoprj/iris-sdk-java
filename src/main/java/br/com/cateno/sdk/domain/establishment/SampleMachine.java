package br.com.cateno.sdk.domain.establishment;

import java.util.Objects;
import java.util.UUID;

public class SampleMachine {
    private UUID id;
    private String label;
    private String number;
    private Validity validity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
