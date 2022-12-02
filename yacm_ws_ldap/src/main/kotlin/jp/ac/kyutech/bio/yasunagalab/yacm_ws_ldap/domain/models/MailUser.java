package jp.ac.yasunagalab.yacm_ws_ldap.domain.models;

public class MailUser {
    private String uidNumber; // serial uid
    private String userName; // mail user name
    private String password; // encrypted pass word by sha-1

    public void setUidNumber(String uidNumber) {
        this.uidNumber = uidNumber;
    }

    public String getUidNumber() {
        return uidNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
}
