package br.com.cateno.sdk.domain.user;

import java.util.Objects;

public class Machine {
    private String id;
    private String number;
    private String label;
    private String establishmentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return Objects.equals(id, machine.id) &&
                Objects.equals(number, machine.number) &&
                Objects.equals(label, machine.label) &&
                Objects.equals(establishmentId, machine.establishmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, label, establishmentId);
    }
}
