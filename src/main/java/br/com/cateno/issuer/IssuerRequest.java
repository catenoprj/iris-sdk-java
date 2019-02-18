package br.com.cateno.issuer;

public class IssuerRequest {
    private String cnpj;
    private String name;
    private String issuerCode;
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


