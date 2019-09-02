package com.subasta.jsonparser;

import android.content.Context;

import com.subasta.preferences.SharedPrefrence;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

public class JSONParser {
    public static String PIC_KEY = "profilepic";
    public static String TAG_MESSAGE = "message";
    public static String TAG_SUCCESS = "status";
    public String MESSAGE;
    public boolean RESULT = false;
    public String SUCCESS;
    public Context context;
    public JSONObject jObj;
    String jsonObjResponse;
    private SharedPrefrence prefrence;

    public JSONParser(Context context2, JSONObject jSONObject) {
        String str = "";
        this.SUCCESS = str;
        this.MESSAGE = str;
        try {
            this.context = context2;
            this.jObj = jSONObject;
            this.SUCCESS = getJsonString(this.jObj, TAG_SUCCESS);
            this.MESSAGE = html2text(getJsonString(this.jObj, TAG_MESSAGE));
            this.prefrence = SharedPrefrence.getInstance(context2);
//            if (this.SUCCESS.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//                this.RESULT = false;
//            } else {
//                this.RESULT = true;
//            }
        } catch (Exception e) {
            this.jObj = null;
            e.printStackTrace();
        }
    }

    public static String html2text(String str) {
        return Jsoup.parse(str).text();
    }

    public static boolean getBoolean(String str) {
//        return str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return false;
    }

    public static JSONObject getJsonObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public static String getJsonString(JSONObject jSONObject, String str) {
        String str2 = "";
        try {
            String string = jSONObject.getString(str);
            return (string == null || string.equalsIgnoreCase("null") || string.equalsIgnoreCase(str2)) ? str2 : string;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static JSONArray getJsonArray(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }
}
