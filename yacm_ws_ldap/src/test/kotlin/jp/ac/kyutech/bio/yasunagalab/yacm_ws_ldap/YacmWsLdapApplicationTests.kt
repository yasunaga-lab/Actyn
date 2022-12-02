package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.interfaces.models.RegisterCSResult
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class YacmWsLdapApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun jsonTest() {
        val registerCSResult = RegisterCSResult()
        registerCSResult.setResult(false, null, null)
        val result = registerCSResult.toJson()
        print(result)
    }

}
