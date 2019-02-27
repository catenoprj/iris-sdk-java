package br.com.cateno.sdk.domain.messenger;

public class MessageFilters {

    private MessageType type;
    private Boolean read;
    private Boolean text;

    MessageFilters(MessageType type, Boolean read, Boolean text) {
        this.type = type;
        this.read = read;
        this.text = text;
    }

    public static MessageFiltersBuilder builder() {
        return new MessageFiltersBuilder();
    }
}
