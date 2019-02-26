package br.com.cateno.sdk.domain.claim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static java.util.Optional.ofNullable;

public class CloseDateRange extends HashMap<String, String> {

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private CloseDateRange(final LocalDate from, final LocalDate to) {
    ofNullable(from).map(localDate -> localDate.format(DATE_FORMATTER)).ifPresent(localDate -> this.put("dtCloseFrom", localDate));
    ofNullable(to).map(localDate -> localDate.format(DATE_FORMATTER)).ifPresent(localDate -> this.put("dtCloseTo", localDate));
  }

  public static CloseDateRange between(final LocalDate from, final LocalDate to) {
    return new CloseDateRange(from, to);
  }

  public static CloseDateRange from(final int year, final int month, final int dayOfMonth) {
    final LocalDate date = LocalDate.of(year, month, dayOfMonth);
    return new CloseDateRange(date, null);
  }

  public static CloseDateRange from(final LocalDate from) {
    return new CloseDateRange(from, null);
  }

  public static CloseDateRange to(final int year, final int month, final int dayOfMonth) {
    final LocalDate date = LocalDate.of(year, month, dayOfMonth);
    return new CloseDateRange(null, date);
  }

  public static CloseDateRange to(final LocalDate to) {
    return new CloseDateRange(null, to);
  }
}
