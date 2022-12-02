package jp.ac.yasunagalab.yacm_ws.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExternalInterface {
    public static List<String> execExternalCommand(String[] cmd) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        List<String> result = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        return result;
    }
}
