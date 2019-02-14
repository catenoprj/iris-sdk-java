package br.com.cateno.client.issuer.model;

import lombok.Data;

@Data
public class IssuerRequest {

    private String cnpj;
    private String name;
    private String issuerCode;
    private ExtraInfoRequest extraInfo;

    /*public IssuerRequest() {
        super();
    }

    public IssuerRequest(String issuerCode, String cnpj, String name, Status status, ExtraInfo extraInfo) {
        this.issuerCode = issuerCode;
        this.cnpj = cnpj;
        this.name = name;
        this.extraInfo = extraInfo;
    }*/
}


