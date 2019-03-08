package br.com.cateno.sdk.domain.status;

import java.util.Objects;

/**
 * Represents a body to create or update an Action
 */
public class ActionRequest {
    /**
     * The description of Action
     */
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionRequest that = (ActionRequest) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
