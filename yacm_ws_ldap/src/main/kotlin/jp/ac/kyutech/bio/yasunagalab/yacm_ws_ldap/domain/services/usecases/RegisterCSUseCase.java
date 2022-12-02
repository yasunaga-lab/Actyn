package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.services.usecases;


import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.Ldap;
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.LdapUser;
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.ExternalInterface;
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.persistence.Files;
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.service.ParseExeCMD;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class RegisterCSUseCase {
    private String lastName;
    private String firstName;
    private String accountName;
    private String password;

    public LdapUser ldapUser;

    RegisterCSUseCase() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Register user on ldap server
     */
    public List<String> registerLdapUser() throws IOException, InterruptedException {
        this.createLdapUser();
        String filePath = Files.createLdifFile(Ldap.Manipulation.Add, this.ldapUser);
        return ExternalInterface.execExternalCommand(Ldap.Commands.generateAddCmd(filePath));
    }


    // create LdapUser model
    void createLdapUser() throws IOException, InterruptedException {
        String userName = this.firstName + " " + this.lastName;
        this.ldapUser = new LdapUser(this.accountName, userName, this.password);
        this.ldapUser.setUidNumber(this.getUidNumber());
        this.setPassword(this.password);
    }

    /**
     * Get uid number at machine (ldap server)
     * Determination uidNumber is that increment last assign uidNumber,
     * if new uidNumber is already used, assign minimum number upper than last assign uidNumber.
     *
     * @return New assign uidNumber
     */
    int getUidNumber() throws IOException, InterruptedException {
        String[] search_cmd = {"ldapsearch", "-x", "-LL", "-b", "\"dc=yasunaga-lab,dc=bio,dc=kyutech,dc=ac,dc=jp\"", "uidNumber", "|", "grep", "uid"};

        List<String> result = ExternalInterface.execExternalCommand(search_cmd);
        List<Integer> uidList = ParseExeCMD.parseUIDNumber(result);

        int uid = uidList.get(uidList.size() - 1) + 1;

        // uid is already exists
        if (uidList.contains(uid)) {
            Collections.sort(uidList);
            int index = uidList.indexOf(uid);

            while (true) {
                index = index + 1;
                // Whether number space exist between uidList(i) to uidList(i+1)
                int nextUid = uidList.get(index + 1);
                if (uid - nextUid != 1) {
                    uid = uid + 1;
                    break;
                }
                uid = nextUid;
            }
        }
        return uid;
    }

}
