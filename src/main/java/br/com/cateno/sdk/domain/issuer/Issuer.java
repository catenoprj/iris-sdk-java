package br.com.cateno.sdk.domain.issuer;

import java.util.Objects;
import java.util.UUID;

/**
 * Represents an Issuer
 */
public class Issuer {
    /**
     * The Id of Issuer
     */
    private UUID id;
    /**
     * The code of Issuer
     */
    private String issuerCode;
    /**
     * The CMPJ of Issuer
     */
    private String cnpj;
    /**
     * The name of Issuer
     */
    private String name;
    /**
     * The status of Issuer
     * @see Status
     */
    private Status status;
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
