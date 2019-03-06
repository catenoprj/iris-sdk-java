package br.com.cateno.sdk.domain.claim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

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
    return new PurchaseDateRange(from, to);
  }

  public static PurchaseDateRange from(final int year, final int month, final int dayOfMonth) {
    final LocalDate date = LocalDate.of(year, month, dayOfMonth);
    return new PurchaseDateRange(date, null);
  }

  public static PurchaseDateRange from(final LocalDate from) {
    return new PurchaseDateRange(from, null);
  }

  public static PurchaseDateRange to(final int year, final int month, final int dayOfMonth) {
    final LocalDate date = LocalDate.of(year, month, dayOfMonth);
    return new PurchaseDateRange(null, date);
  }

  public static PurchaseDateRange to(final LocalDate to) {
    return new PurchaseDateRange(null, to);
  }
}
