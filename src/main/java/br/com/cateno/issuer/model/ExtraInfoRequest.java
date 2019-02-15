package br.com.cateno.issuer.model;

import lombok.Data;

@Data
public class ExtraInfoRequest {
    private String mainPhone;
    private String backupPhone;
    private String email;
}
