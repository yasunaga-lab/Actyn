package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap;

import jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.service.ParseExeCMD;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.exit;

public class LdapTest {
    @Test
    void LdapUIDNumberTest() throws IOException, InterruptedException {
        List<Integer> uidList = new ArrayList<>();

        File f = new File("src/test/java/jp/ac/yasunagalab/yacm_ws/test_data/ldapsearch_result.txt");

        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            List<String> fileContents = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.add(line);
            }
            uidList = ParseExeCMD.parseUIDNumber(fileContents);
        } else {
            System.out.println("file does not exists.");
            exit(1);
        }


        int lastIndex = uidList.size() - 1;
        int uidNumber = uidList.get(lastIndex) + 1;
        // uid is already exists
        if (uidList.contains(uidNumber)) {
            Collections.sort(uidList);
            int index = uidList.indexOf(uidNumber);

            while (true) {
                index = index + 1;
                // whether newly assign number is max uid number
                if (index == lastIndex + 1) {
                    uidNumber = uidNumber + 1;
                    break;
                }
                // Whether number space exist between uidList(i) to uidList(i+1)
                int nextUidNumber = uidList.get(index);
                if (nextUidNumber - uidNumber != 1) {
                    uidNumber = uidNumber + 1;
                    break;
                }
                uidNumber = nextUidNumber;
            }
        }

        System.out.println(uidNumber);
    }
}
