package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class YacmWsLdapApplication

fun main(args: Array<String>) {
    runApplication<YacmWsLdapApplication>(*args)
}
