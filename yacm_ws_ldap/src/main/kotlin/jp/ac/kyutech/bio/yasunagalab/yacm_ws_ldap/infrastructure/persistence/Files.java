package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.persistence;

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.Ldap;
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.LdapUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Persistence class by files
public class Files {

    // generate ldif file path by using time.
    public static String generateLdifFilePath(Ldap.Manipulation manipulation) {
        final String baseLdifFilePath = "/Users/honda/Downloads/";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm-ss");
        String fileName = dtf.format(now) + "_" + manipulation.name() + ".ldif";
        return baseLdifFilePath + fileName;
    }

    // Create Ldif file for register Ldap user
    public static String createLdifFile(Ldap.Manipulation manipulation, LdapUser user) throws IOException {
        String filePath = generateLdifFilePath(manipulation);

        File file = new File(filePath);

        boolean success = file.createNewFile();
        if (!success) {
            throw new IOException("FILE CREATE ERROR");
        }
        FileWriter fw = new FileWriter(file);
        String field = createLdifField(user);
        fw.write(field);
        fw.flush();
        fw.close();
        return filePath;
    }

    protected static String createLdifField(LdapUser user) {
        String field;
        String dn = "dn: cn=" + user.getUserName() + "," + Ldap.getDomainName();
        String cn = "cn: " + user.getUserName();
        String gidNumber = "gidNumber: " + Ldap.gidNumber;
        String userHomeDirectory = "homedirectory: " + Ldap.homeDirectory + user.getUid();
        String loginShell = "loginshell: " + Ldap.loginShell;
        String uid = "uid: " + user.getUid();
        String uidNumber = "uidnumber: " + user.getUidNumber();
        String password = "userpasswprd: " + user.getPassword();

        field = dn + "\n" + cn + "\n" + gidNumber + "\n"
                + userHomeDirectory + "\n"
                + loginShell + "\n"
                + Ldap.getObjectClass() + "\n"
                + uid + "\n" + uidNumber + "\n" + password;

        return field;
    }
}
