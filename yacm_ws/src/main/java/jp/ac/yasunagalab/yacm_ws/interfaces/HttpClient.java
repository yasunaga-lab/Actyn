package jp.ac.yasunagalab.yacm_ws.interfaces;

import com.squareup.okhttp.*;

import java.io.IOException;

public class HttpClient {

    public static Response postJson(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType MIMEType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(MIMEType, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return client.newCall(request).execute();
    }

}
