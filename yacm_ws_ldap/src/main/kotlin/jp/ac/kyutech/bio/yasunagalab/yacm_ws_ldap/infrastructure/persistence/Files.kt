package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.persistence

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.Ldap
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.Ldap.Manipulation
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.LdapUser
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class Files {
    companion object {

        // generate ldif file path by using time.
        fun generateLdifFilePath(manipulation: Manipulation, ldifPath: String): String {
            val now = LocalDateTime.now()
            val dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm-ss")
            val fileName = dtf.format(now) + "_" + manipulation.name + ".ldif"
            return ldifPath + fileName
        }

        // Create Ldif file for register Ldap user
        fun createLdifFile(manipulation: Manipulation, user: LdapUser, ldifPath: String): String {
            val filePath = generateLdifFilePath(manipulation, ldifPath)
            val file = File(filePath)
            val success = file.createNewFile()
            if (!success) {
                throw IOException("FILE CREATE ERROR")
            }
            val fw = FileWriter(file)
            val field = createLdifField(user)
            fw.write(field)
            fw.flush()
            fw.close()
            return filePath
        }

        private fun createLdifField(user: LdapUser): String {
            val dn = "dn: cn=" + user.userName + "," + Ldap.getDomainName()
            val cn = "cn: " + user.userName
            val gidNumber = "gidNumber: " + Ldap.gidNumber
            val userHomeDirectory = "homedirectory: " + Ldap.homeDirectory + user.uid
            val loginShell = "loginshell: " + Ldap.loginShell
            val uid = "uid: " + user.uid
            val uidNumber = "uidnumber: " + user.uidNumber
            val password = "userpasswprd: " + user.password
            return "$dn\n$cn\n$gidNumber\n$userHomeDirectory\n$loginShell\n${Ldap.getObjectClass()}\n$uid\n$uidNumber\n$password"
        }
    }
}