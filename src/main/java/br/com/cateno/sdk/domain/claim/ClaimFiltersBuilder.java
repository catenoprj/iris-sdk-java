package br.com.cateno.sdk.domain.claim;

/**
 * Represents a builder of filters of Claims
 */
public class ClaimFiltersBuilder {
  /**
   * The close date range of Claim
   * @see CloseDateRange
   */
  private CloseDateRange closeDate;
  /**
   * The Establishment of Claim
   * @see br.com.cateno.sdk.domain.establishment.Establishment
   */
  private String establishment;
  /**
   * The Issuer of Claim
   * @see br.com.cateno.sdk.domain.issuer.Issuer
   */
  private String issuer;
  /**
   * The purchase date range of Claim
   * @see PurchaseDateRange
   */
  private PurchaseDateRange purchaseDate;
  /**
   * The Status of Claim
   * @see Status
   */
  private String status;
  /**
   * The any term related with Claim
   */
  private String term;
  /**
   * The value range of Claim
   * @see ValueRange
   */
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
