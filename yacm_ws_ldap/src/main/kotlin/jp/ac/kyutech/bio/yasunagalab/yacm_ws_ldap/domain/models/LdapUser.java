package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models;


import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.ExternalInterface;

import java.io.IOException;
import java.util.List;

public class LdapUser {
    private String uid; // account name on client machine
    private int uidNumber; // serial number
    private String userName; // cn
    private String password; // encrypted pass word by sha-1

    public LdapUser(String uid, String userName, String password) throws IOException, InterruptedException {
        this.uid = uid;
        this.userName = userName;
        this.password = this.encryptPassword(password);
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getUidNumber() {
        return this.uidNumber;
    }

    public void setUidNumber(int uidNumber) {
        this.uidNumber = uidNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String encryptPassword(String password) throws IOException, InterruptedException {
        List<String> result = ExternalInterface.execExternalCommand(Ldap.Commands.generateEncryptCmd(password));
        return result.get(0);
    }


}
