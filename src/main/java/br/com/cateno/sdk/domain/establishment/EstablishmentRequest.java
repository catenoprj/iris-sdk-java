package br.com.cateno.sdk.domain.establishment;

import lombok.Data;

@Data
public class EstablishmentRequest {
    private String cnpj;
    private String name;
    private ExtraInfo extraInfo;
}
