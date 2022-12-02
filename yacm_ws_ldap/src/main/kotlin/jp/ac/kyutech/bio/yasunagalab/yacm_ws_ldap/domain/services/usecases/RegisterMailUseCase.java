package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.services.usecases;

import jp.ac.yasunagalab.yacm_ws_ldap.domain.models.MailUser;

public class RegisterMailUseCase {
    private String userName;
    private String password;

    MailUser mailUser;

    RegisterMailUseCase() {
        this.mailUser = new MailUser();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
