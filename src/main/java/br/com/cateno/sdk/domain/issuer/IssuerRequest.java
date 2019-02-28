package br.com.cateno.sdk.domain.issuer;

/**
 * Represents an Issuer used to does request a operation in server
 */
public class IssuerRequest {
    /**
     * The CNPJ of Issuer
     */
    private String cnpj;
    /**
     * The name of Issuer
     */
    private String name;
    /**
     * The code identification of Issuer
     */
    private String issuerCode;
    /**
     * The extra information of Issuer
     * @see ExtraInfo
     */
    private ExtraInfo extraInfo;

    public String getCnpj() {
        return this.cnpj;
    }

    public ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public String getIssuerCode() {
        return this.issuerCode;
    }

    public String getName() {
        return this.name;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public void setName(String name) {
        this.name = name;
    }
}


