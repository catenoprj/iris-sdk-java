package br.com.cateno.sdk.domain.establishment;

import lombok.Data;

import java.util.UUID;

@Data
public class Establishment {
    private UUID id;
    private String cnpj;
    private ExtraInfo extraInfo;
    private String name;
    private Status status;
}
