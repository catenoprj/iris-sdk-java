package br.com.cateno.sdk.domain.establishment;

import java.util.Objects;
import java.util.UUID;

/**
 * Represents an Establishment
 */
public class Establishment {
    /**
     * The Id of Establishment
     * @see UUID
     */
    private UUID id;
    /**
     * The CNPJ of Establishment
     */
    private String cnpj;
    /**
     * The extra information of Establishment
     * @see ExtraInfo
     */
    private ExtraInfo extraInfo;
    /**
     * The name of Establishment
     */
    private String name;
    /**
     * The status of Establishment
     * @see Status
     */
    private Status status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Establishment that = (Establishment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(extraInfo, that.extraInfo) &&
                Objects.equals(name, that.name) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, extraInfo, name, status);
    }
}
