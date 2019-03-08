package br.com.cateno.sdk.domain.claim;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static dagger.internal.Preconditions.checkNotNull;
import static java.util.Optional.ofNullable;

/**
 * Represents purchase date range of Claims
 */
public class PurchaseDateRange extends HashMap<String, String> {

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private PurchaseDateRange(final LocalDate from, final LocalDate to) {
    ofNullable(from).map(date -> date.format(DATE_FORMATTER)).ifPresent(date -> this.put("dtPurchaseFrom", date));
    ofNullable(to).map(date -> date.format(DATE_FORMATTER)).ifPresent(date -> this.put("dtPurchaseTo", date));
  }

  public static PurchaseDateRange between(final LocalDate from, final LocalDate to) {
    checkNotNull(from);
    checkNotNull(to);

    return new PurchaseDateRange(from, to);
  }

  public static PurchaseDateRange between(final ZonedDateTime from, final ZonedDateTime to) {
    checkNotNull(from);
    checkNotNull(to);

    return new PurchaseDateRange(from.toLocalDate(), to.toLocalDate());
  }

  public static PurchaseDateRange from(final int year, final int month, final int dayOfMonth) {
    final LocalDate date = LocalDate.of(year, month, dayOfMonth);
    return new PurchaseDateRange(date, null);
  }

  public static PurchaseDateRange from(final LocalDate from) {
    checkNotNull(from);

    return new PurchaseDateRange(from, null);
  }

  public static PurchaseDateRange to(final int year, final int month, final int dayOfMonth) {
    final LocalDate date = LocalDate.of(year, month, dayOfMonth);
    return new PurchaseDateRange(null, date);
  }

  public static PurchaseDateRange to(final LocalDate to) {
    checkNotNull(to);

    return new PurchaseDateRange(null, to);
  }
}
