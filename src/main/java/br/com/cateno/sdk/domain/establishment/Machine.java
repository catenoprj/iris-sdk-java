package br.com.cateno.sdk.domain.establishment;

import java.util.Objects;

/**
 * Represents a Machine
 */
public class Machine {

    /**
     * The Establishment of Machine
     * @see Establishment
     */
    private Establishment establishment;
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
     * @see Validity
     */
    private Validity validity;

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

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
        Machine machine = (Machine) o;
        return Objects.equals(establishment, machine.establishment) &&
                Objects.equals(id, machine.id) &&
                Objects.equals(label, machine.label) &&
                Objects.equals(number, machine.number) &&
                Objects.equals(validity, machine.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(establishment, id, label, number, validity);
    }
}
