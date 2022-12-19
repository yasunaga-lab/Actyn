package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "ldap")
@ConstructorBinding
data class LdapConfig(
    val ldifPath: String
)