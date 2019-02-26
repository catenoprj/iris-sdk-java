package br.com.cateno.sdk.domain.claim;

import java.util.HashMap;

import static java.util.Optional.ofNullable;

public class ClaimFilters extends HashMap<String, String> {

  ClaimFilters(final CloseDateRange closeDate, final String establishment, final String issuer, final PurchaseDateRange purchaseDate, final String status, final String term, final ValueRange value) {
    ofNullable(closeDate).ifPresent(this::putAll);
    ofNullable(establishment).ifPresent(establishmentId -> this.put("establishmentCode", establishmentId));
    ofNullable(issuer).ifPresent(issuerId -> this.put("issuerId", issuerId));
    ofNullable(purchaseDate).ifPresent(this::putAll);
    ofNullable(status).ifPresent(statusCode -> this.put("status", statusCode));
    ofNullable(term).ifPresent(searchTerm -> this.put("search_term", searchTerm));
    ofNullable(value).ifPresent(this::putAll);
  }

  public static ClaimFiltersBuilder builder() {
    return new ClaimFiltersBuilder();
  }
}
