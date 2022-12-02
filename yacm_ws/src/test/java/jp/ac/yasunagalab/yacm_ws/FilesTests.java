package jp.ac.yasunagalab.yacm_ws;

import jp.ac.yasunagalab.yacm_ws.domain.models.Ldap;
import jp.ac.yasunagalab.yacm_ws.domain.models.LdapUser;
import jp.ac.yasunagalab.yacm_ws.infrastructure.persistence.Files;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FilesTests {
    @Test
    void filePathTest() {
        String addTestPath = Files.generateLdifFilePath(Ldap.Manipulation.Add);
        System.out.println(addTestPath);

        String deleteTestPath = Files.generateLdifFilePath(Ldap.Manipulation.Delete);
        System.out.println(deleteTestPath);

        String modifyTestPath = Files.generateLdifFilePath(Ldap.Manipulation.Modify);
        System.out.println(modifyTestPath);
    }

    @Test
    void createFileTest() throws IOException, InterruptedException {
        LdapUser testUser = new LdapUser("test", "test TEST", "test_password");
        Files.createLdifFile(Ldap.Manipulation.Add, testUser);
    }
}
