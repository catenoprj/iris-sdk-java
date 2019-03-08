package br.com.cateno.sdk.domain.messenger;

/**
 * Represents a filter to find message
 */
public class MessageFilters {
    /**
     * The type of Message
     */
    private MessageType type;
    /**
     * The Message is read
     */
    private Boolean read;
    /**
     * The Message has text
     */
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
