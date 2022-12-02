package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap;

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.ExternalInterface;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ExternalInterfaceTests {
    @Test
    void execExternalCommandTest() throws IOException, InterruptedException {
        String[] cmd;
        List<String> result;
        int num;

        System.out.println("---- external command test ----");
        cmd = new String[]{"ls", "-l"};
        result = ExternalInterface.execExternalCommand(cmd);

        num = result.toArray().length;
        for (int i = 0; i < num; i++) {
            System.out.println(result.get(i));
        }
    }
}
