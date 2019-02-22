package br.com.cateno.sdk.domain.messenger;

import java.util.Objects;

public class MessageParameters {

    private MessageType type = MessageType.RECEIVED;
    private boolean read;
    private boolean text;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageParameters that = (MessageParameters) o;
        return read == that.read &&
                text == that.text &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, read, text);
    }
}
