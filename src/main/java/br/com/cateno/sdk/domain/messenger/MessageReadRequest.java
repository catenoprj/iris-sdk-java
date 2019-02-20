package br.com.cateno.sdk.domain.messenger;

import java.util.Objects;

public class MessageReadRequest {

    private Boolean read;

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageReadRequest that = (MessageReadRequest) o;
        return Objects.equals(read, that.read);
    }

    @Override
    public int hashCode() {
        return Objects.hash(read);
    }
}
