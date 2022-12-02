package jp.ac.kyutech.bio.yasunagalab.yacm_ws_ldap.infrastructure;

import java.io.*;
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

    public static List<String> execExternalCommandWithPassword(String[] cmd, String password) throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec(cmd);
//        process.waitFor();
        OutputStream os = process.getOutputStream();
//        System.out.println("a");
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//        bw.write(password);
//        bw.flush();
        PrintStream ps = new PrintStream(os);
        ps.println(password);
        System.out.println("b");
        process.waitFor();
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("c");
        String line;
        List<String> result = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        return result;

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(exec_process.getOutputStream()));
//        bw.write(password);
//        bw.flush();

    }
}
