package br.com.cateno.sdk.domain.establishment;

/**
 * Represents a body to create or update an Establishment
 */
public class EstablishmentRequest {
    /**
     * The CNPJ of Establishment
     */
    private String cnpj;
    /**
     * The name of Establishment
     */
    private String name;
    /**
     * The extra information of Establishment
     * @see ExtraInfo
     */
    private ExtraInfo extraInfo;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }
}
