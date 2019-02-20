package br.com.cateno.sdk.domain.establishment;

import java.time.LocalDate;
import java.util.Objects;

public class Validity {
    private LocalDate from;
    private LocalDate to;

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Validity validity = (Validity) o;
        return Objects.equals(from, validity.from) &&
                Objects.equals(to, validity.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
