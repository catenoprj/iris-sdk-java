package br.com.cateno.issuer;

import java.util.UUID;

public class Issuer {
    private UUID id;
    private String issuerCode;
    private String cnpj;
    private String name;
    private Status status;
    private ExtraInfo extraInfo;

    public String getCnpj() {
        return this.cnpj;
    }

    public ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public UUID getId() {
        return this.id;
    }

    public String getIssuerCode() {
        return this.issuerCode;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
