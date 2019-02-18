package br.com.cateno.issuer;

import lombok.Data;

import java.util.UUID;

@Data
public class Issuer {
    private UUID id;
    private String issuerCode;
    private String cnpj;
    private String name;
    private Status status;
    private ExtraInfo extraInfo;
}
