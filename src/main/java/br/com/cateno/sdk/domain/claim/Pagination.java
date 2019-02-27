package br.com.cateno.sdk.domain.claim;

import static dagger.internal.Preconditions.checkNotNull;

public class Pagination {

  private final Integer limit;
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