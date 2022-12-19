package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.Ldap
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.LdapUser
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.persistence.Files
import org.junit.jupiter.api.Test

class FileTests {
    @Test
    fun filePathTest() {
        val addTestPath = Files.generateLdifFilePath(Ldap.Manipulation.Add, "/Users/honda/Downloads/")
        println(addTestPath)
        val deleteTestPath = Files.generateLdifFilePath(Ldap.Manipulation.Delete, "/Users/honda/Downloads/")
        println(deleteTestPath)
        val modifyTestPath = Files.generateLdifFilePath(Ldap.Manipulation.Modify, "/Users/honda/Downloads/")
        println(modifyTestPath)
    }

    @Test
    fun createFileTest() {
        val testUser = LdapUser("test", "test TEST", "test_password")
        Files.createLdifFile(Ldap.Manipulation.Add, testUser, "/Users/honda/Downloads/")
    }
}