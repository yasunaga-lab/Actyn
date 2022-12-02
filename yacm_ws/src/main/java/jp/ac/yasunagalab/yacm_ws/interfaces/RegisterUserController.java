package jp.ac.yasunagalab.yacm_ws.interfaces;


import com.squareup.okhttp.Response;
import jp.ac.yasunagalab.yacm_ws.config.LdapConfig;
import jp.ac.yasunagalab.yacm_ws.domain.services.usecases.RegisterCSUseCase;
import jp.ac.yasunagalab.yacm_ws.domain.services.usecases.RegisterMailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RegisterUserController {

    @Autowired
    private LdapConfig ldapConfig;

    @PostMapping("/register_mail")
    public String registerMail(@RequestBody RegisterMailUseCase useCase) {
        System.out.println(useCase);

        return "{message: server got mail register api}";
    }

    @PostMapping("/register_cs")
    public String registerCS(@RequestBody RegisterCSUseCase useCase) throws IOException {
        // repost to ldap server
        String url = ldapConfig.getLdapURL() + "/register_cs";
        Response response = HttpClient.postJson(url, useCase.toJson());
        return response.body().string();
    }

    @GetMapping("/config")
    public void config() {
        System.out.println(ldapConfig.getLdapURL());
    }
}
