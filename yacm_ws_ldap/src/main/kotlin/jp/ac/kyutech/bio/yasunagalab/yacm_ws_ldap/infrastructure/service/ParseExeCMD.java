package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure.service;

import java.util.ArrayList;
import java.util.List;

public class ParseExeCMD {

    public static List<Integer> parseUIDNumber(List<String> result) {
        List<Integer> uidList = new ArrayList<Integer>();
        for (String s : result) {
            uidList.add(Integer.valueOf(s.replace("uidNumber: ", "")));
        }
        return uidList;
    }
}
