package br.com.cateno.issuer.model;

public class ExtraInfo {
    public String mainPhone;
    public String backupPhone;
    public String email;

    public ExtraInfo(){
        super();
    }

    public ExtraInfo(String mainPhone, String backupPhone, String email) {
        this.mainPhone = mainPhone;
        this.backupPhone = backupPhone;
        this.email = email;
    }
}
