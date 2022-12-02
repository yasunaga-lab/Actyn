package jp.ac.yasunagalab.yacm_ws.interfaces.models;

import com.google.gson.Gson;

abstract class Result {
    protected static String resultType;
    protected static boolean isSuccess;
    protected static String message;

    public String toJson() {
        Gson json = new Gson();
        return json.toJson(this);
    }

}

