package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.services.usecases

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.config.LdapConfig
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.Ldap
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.LdapUser
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.ExternalInterface
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.persistence.Files
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.service.ParseExeCMD
import java.io.IOException


class RegisterCSUseCase {

    private lateinit var lastName: String
    private lateinit var firstName: String
    private lateinit var accountName: String
    private lateinit var password: String

    lateinit var ldapUser: LdapUser

    fun getLastName(): String {
        return lastName
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    fun getFirstName(): String {
        return firstName
    }

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun getAccountName(): String {
        return accountName
    }

    fun setAccountName(accountName: String) {
        this.accountName = accountName
    }

    fun getPassword(): String {
        return password
    }

    private fun setPassword(password: String) {
        this.password = password
    }

    /**
     * Register user on ldap server
     */
    fun registerLdapUser(ldapConfig: LdapConfig): List<String> {
        createLdapUser()
        val filePath = Files.createLdifFile(Ldap.Manipulation.Add, this.ldapUser, ldapConfig.ldifPath)
        return ExternalInterface.execExternalCommand(Ldap.Commands.generateAddCmd(filePath));
    }


    // create LdapUser model
    private fun createLdapUser() {
        val userName = "$firstName $lastName"
        this.ldapUser = LdapUser(accountName, userName, password)
        this.ldapUser.uidNumber = this.getUidNumber()
        setPassword(password)
    }

    /**
     * Get uid number at machine (ldap server)
     * Determination uidNumber is that increment last assign uidNumber,
     * if new uidNumber is already used, assign minimum number upper than last assign uidNumber.
     *
     * @return New assign uidNumber
     */
    @Throws(IOException::class, InterruptedException::class)
    fun getUidNumber(): Int {
        val search_cmd = arrayOf(
            "ldapsearch",
            "-x",
            "-LL",
            "-b",
            "\"dc=yasunaga-lab,dc=bio,dc=kyutech,dc=ac,dc=jp\"",
            "uidNumber",
            "|",
            "grep",
            "uid"
        )
        val result = ExternalInterface.execExternalCommand(search_cmd)
        val uidList = ParseExeCMD.parseUIDNumber(result)
        var uid = uidList[uidList.size - 1] + 1

        // uid is already exists
        if (uidList.contains(uid)) {
            uidList.sort()
            var index = uidList.indexOf(uid)
            while (true) {
                index += 1
                // Whether number space exist between uidList(i) to uidList(i+1)
                val nextUid = uidList[index + 1]
                if (uid - nextUid != 1) {
                    uid += 1
                    break
                }
                uid = nextUid
            }
        }
        return uid
    }

}