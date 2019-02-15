package br.com.cateno.issuer.model;

import lombok.Data;

@Data
public class IssuerRequest {

    private String cnpj;
    private String name;
    private String issuerCode;
    private ExtraInfoRequest extraInfo;
}


