package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.interfaces.models;

import com.google.gson.Gson;
import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.domain.models.LdapUser;

import java.util.List;

public class RegisterCSResult extends Result {
    LdapUser ldapUser;

    public RegisterCSResult() {
        resultType = "register_cs";
    }

    public String toJson() {
        Gson json = new Gson();
        return json.toJson(this);
    }

    public void setResult(boolean isSuccess, List<String> result, LdapUser ldapUser) {
        super.isSuccess = isSuccess;
        super.message = isSuccess ? result.toString() : "Failed register cs account";
        this.ldapUser = ldapUser;
    }
}
