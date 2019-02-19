package br.com.cateno.sdk.domain.user;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraInfo extraInfo = (ExtraInfo) o;
        return Objects.equals(mainPhone, extraInfo.mainPhone) &&
                Objects.equals(backupPhone, extraInfo.backupPhone) &&
                Objects.equals(email, extraInfo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainPhone, backupPhone, email);
    }
}
