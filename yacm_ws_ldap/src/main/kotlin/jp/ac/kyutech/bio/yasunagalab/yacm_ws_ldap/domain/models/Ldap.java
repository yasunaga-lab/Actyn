package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models;

import java.util.Arrays;
import java.util.List;

public class Ldap {
    static final String domain = "dc=yasunaga-lab,dc=bio,dc=kyutech,dc=ac,dc=jp";
    public static final String gidNumber = "1001";
    public static final String homeDirectory = "/home/people/"; // + uid
    public static final String loginShell = "/bin/bash";
    public static final List<String> objectClasses = Arrays.asList("account", "posixAccount");

    public static String getDomainName() {
        return "ou=People," + domain;
    }

    public static String getObjectClass() {
        return "objectclass: " + objectClasses.get(0) + "\n" +
                "objectclass: " + objectClasses.get(1);
    }

    public enum Manipulation {
        Add,
        Delete,
        Modify,
    }

    // Commands
    public static class Commands {
        private static final String[] addCmd = {"ldapadd", "-x", "-D", "cn=Manager,dc=yasunaga-lab,dc=bio,dc=kyutech,dc=ac,dc=jp", "-f", "[file path]"};
        private static final int addCmdArgIndex = 5;
        private static final String[] delCmd = {"ldapdelete", "-x", "-D", "cn=Manager,dc=yasunaga-lab,dc=bio,dc=kyutech,dc=ac,dc=jp", "-f", "[file path]"};
        private static final int delCmdArgIndex = 5;
        private static final String[] encryptCmd = {"slappasswd", "-s", "[password]"};
        private static final int encryptArgIndex = 2;

        public static String[] generateAddCmd(String filePath) {
            addCmd[addCmdArgIndex] = filePath;
            return addCmd;
        }

        public static String[] generateEncryptCmd(String password) {
            encryptCmd[encryptArgIndex] = password;
            return encryptCmd;
        }


    }
}
