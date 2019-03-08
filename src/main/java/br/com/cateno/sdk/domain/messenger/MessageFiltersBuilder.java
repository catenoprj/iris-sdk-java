package br.com.cateno.sdk.domain.messenger;

public class MessageFiltersBuilder {

    private MessageType type = MessageType.RECEIVED;
    private Boolean read;
    private Boolean text;

    public MessageFilters build() {
        return new MessageFilters(this.type, this.read, this.text);
    }

    public MessageFiltersBuilder type(MessageType type) {
        this.type = type;
        return this;
    }

    public MessageFiltersBuilder read(Boolean read) {
        this.read = read;
        return this;
    }

    public MessageFiltersBuilder text (Boolean text) {
        this.text = text;
        return this;
    }
}
