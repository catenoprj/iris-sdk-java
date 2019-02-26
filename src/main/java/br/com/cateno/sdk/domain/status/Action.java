package br.com.cateno.sdk.domain.status;

import java.util.Objects;
import java.util.UUID;

public class Action {

    private String description;
    private UUID id;
    private ActionType type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(description, action.description) &&
                Objects.equals(id, action.id) &&
                type == action.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id, type);
    }
}
