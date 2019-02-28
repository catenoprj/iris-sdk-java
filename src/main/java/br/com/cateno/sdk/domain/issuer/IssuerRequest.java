package br.com.cateno.sdk.domain.issuer;

/**
 *
 * Represents a issuer used to does request a operation in server
 */
public class IssuerRequest {
    /**
     *  The CNPJ of an issuer
     */
    private String cnpj;
    /**
     * The name of an issuer
     */
    private String name;
    /**
     * The code identification to an issuer
     */
    private String issuerCode;
    /**
     * The extra information of an issuer
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


