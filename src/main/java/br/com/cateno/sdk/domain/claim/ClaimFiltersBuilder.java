package br.com.cateno.sdk.domain.claim;

public class ClaimFiltersBuilder {

  private CloseDateRange closeDate;
  private String establishment;
  private String issuer;
  private PurchaseDateRange purchaseDate;
  private String status;
  private String term;
  private ValueRange value;

  public ClaimFilters build() {
    return new ClaimFilters(this.closeDate, this.establishment, this.issuer, this.purchaseDate, this.status, this.term, this.value);
  }

  public ClaimFiltersBuilder closeDate(final CloseDateRange closeDate) {
    this.closeDate = closeDate;
    return this;
  }

  public ClaimFiltersBuilder establishment(final String establishment) {
    this.establishment = establishment;
    return this;
  }

  public ClaimFiltersBuilder issuer(final String issuer) {
    this.issuer = issuer;
    return this;
  }

  public ClaimFiltersBuilder purchaseDate(final PurchaseDateRange purchaseDate) {
    this.purchaseDate = purchaseDate;
    return this;
  }

  public ClaimFiltersBuilder status(final String status) {
    this.status = status;
    return this;
  }

  public ClaimFiltersBuilder term(final String term) {
    this.term = term;
    return this;
  }

  public ClaimFiltersBuilder value(final ValueRange value) {
    this.value = value;
    return this;
  }
}
