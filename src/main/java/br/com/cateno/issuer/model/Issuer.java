package br.com.cateno.issuer.model;

import java.util.UUID;

public class Issuer {
    public UUID id;
    public String issuerCode;
    public String cnpj;
    public String name;
    public Status status;
    public ExtraInfo extraInfo;

    public Issuer() {
        super();
    }

    public Issuer(UUID id, String issuerCode, String cnpj, String name, Status status, ExtraInfo extraInfo) {
        this.id = id;
        this.issuerCode = issuerCode;
        this.cnpj = cnpj;
        this.name = name;
        this.status = status;
        this.extraInfo = extraInfo;
    }
}
