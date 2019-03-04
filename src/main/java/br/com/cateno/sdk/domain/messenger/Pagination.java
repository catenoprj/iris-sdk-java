package br.com.cateno.sdk.domain.messenger;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Represents pagination of Messages
 */
public class Pagination {
    /**
     * The quantity Messages
     */
    private final Integer limit;
    /**
     * The specify page of Messages
     */
    private final Integer offset;

    private Pagination(final Integer limit, final Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public static Pagination with(final Integer limit, final Integer offset) {
        checkNotNull(limit);
        checkNotNull(offset);

        return new Pagination(limit, offset);
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer getOffset() {
        return this.offset;
    }
}
