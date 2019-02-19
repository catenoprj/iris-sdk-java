package br.com.cateno.sdk.domain.issuer;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issuer issuer = (Issuer) o;
        return Objects.equals(id, issuer.id) &&
                Objects.equals(issuerCode, issuer.issuerCode) &&
                Objects.equals(cnpj, issuer.cnpj) &&
                Objects.equals(name, issuer.name) &&
                status == issuer.status &&
                Objects.equals(extraInfo, issuer.extraInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issuerCode, cnpj, name, status, extraInfo);
    }
}
