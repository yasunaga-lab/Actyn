package jp.ac.yasunagalab.yacm_ws.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "ldap-server")
@Component
@Data
public class LdapConfig {
    private String address;
    private Integer port;


    public String getLdapURL() {
        return "http://" + this.address + ":" + this.port;
    }
}
