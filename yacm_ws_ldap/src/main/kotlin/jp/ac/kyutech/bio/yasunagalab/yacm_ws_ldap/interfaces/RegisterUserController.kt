package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.interfaces

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.config.LdapConfig
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.services.usecases.RegisterCSUseCase
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.interfaces.models.RegisterCSResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RegisterUserController(private val ldapConfig: LdapConfig) {

    @PostMapping("/register_cs")
    fun registerCS(@RequestBody useCase: RegisterCSUseCase): String {
        val registerCSResult = RegisterCSResult()
        try {
            val result: List<String> = useCase.registerLdapUser(this.ldapConfig)
            registerCSResult.setResult(true, result, useCase.ldapUser)
        } catch (e: Exception) {
            print(e)
            registerCSResult.setResult(false, null, null)
        }
        return registerCSResult.toJson()
    }
}