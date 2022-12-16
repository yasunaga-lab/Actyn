package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.config

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "ldap")
@Component
@Data
class LdapConfig {
    val ldifPath: String
        get() {
            return ldifPath
        }
}