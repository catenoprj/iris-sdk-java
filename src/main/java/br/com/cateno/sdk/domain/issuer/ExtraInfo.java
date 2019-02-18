package br.com.cateno.sdk.domain.issuer;

public class ExtraInfo {
    private String mainPhone;
    private String backupPhone;
    private String email;

    public String getBackupPhone() {
        return this.backupPhone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMainPhone() {
        return this.mainPhone;
    }

    public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }
}
