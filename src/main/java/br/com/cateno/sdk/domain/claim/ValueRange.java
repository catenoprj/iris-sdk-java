package br.com.cateno.sdk.domain.claim;

import java.math.BigDecimal;
import java.util.HashMap;

import static dagger.internal.Preconditions.checkNotNull;
import static java.math.RoundingMode.HALF_UP;
import static java.util.Optional.ofNullable;

public class ValueRange extends HashMap<String, String> {

  private ValueRange(final BigDecimal from, final BigDecimal to) {
    ofNullable(from)
        .map(value -> value.setScale(2, HALF_UP))
        .map(BigDecimal::toPlainString)
        .ifPresent(value -> this.put("valueFrom", value));
    ofNullable(to)
        .map(value -> value.setScale(2, HALF_UP))
        .map(BigDecimal::toPlainString)
        .ifPresent(value -> this.put("valueTo", value));
  }

  public static ValueRange between(final Double from, final Double to) {
    checkNotNull(from);
    checkNotNull(to);
    if (from > to)
      throw new IllegalArgumentException("The initial value of the range cannot be greater than the final one");
    return new ValueRange(BigDecimal.valueOf(from), BigDecimal.valueOf(to));
  }

  public static ValueRange between(final BigDecimal from, final BigDecimal to) {
    checkNotNull(from);
    checkNotNull(to);
    if (from.compareTo(to) > 0)
      throw new IllegalArgumentException("The initial value of the range cannot be greater than the final one");
    return new ValueRange(from, to);
  }

  public static ValueRange from(final Double from) {
    checkNotNull(from);
    return new ValueRange(BigDecimal.valueOf(from), null);
  }

  public static ValueRange from(final BigDecimal from) {
    checkNotNull(from);
    return new ValueRange(from, null);
  }

  public static ValueRange to(final BigDecimal to) {
    checkNotNull(to);
    return new ValueRange(null, to);
  }
}
