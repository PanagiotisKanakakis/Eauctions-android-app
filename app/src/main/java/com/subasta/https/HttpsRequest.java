package com.subasta.https;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.jsonparser.JSONParser;
import com.subasta.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class HttpsRequest {
    /* access modifiers changed from: private */
    public Context ctx;
    private Map<String, File> fileparams;
    /* access modifiers changed from: private */
    public JSONObject jObject;
    private String match;
    private Map<String, ArrayList<File>> multiFileparams;
    /* access modifiers changed from: private */
    public Map<String, String> params;

    public HttpsRequest(String str, Map<String, String> map, Context context) {
        this.match = str;
        this.params = map;
        this.ctx = context;
    }

    public HttpsRequest(String str, Map<String, String> map, Map<String, File> map2, Context context) {
        this.match = str;
        this.params = map;
        this.fileparams = map2;
        this.ctx = context;
    }

    public HttpsRequest(String str, Map<String, String> map, Map<String, ArrayList<File>> map2, Context context, Context context2) {
        this.match = str;
        this.params = map;
        this.multiFileparams = map2;
        this.ctx = context;
    }

    public HttpsRequest(String str, Context context) {
        this.match = str;
        this.ctx = context;
    }

    public HttpsRequest(String str, JSONObject jSONObject, Context context) {
        this.match = str;
        this.jObject = jSONObject;
        this.ctx = context;
    }

    public void stringPostJson(final String str, final Helper helper) {
        AndroidNetworking.post("http://139.59.45.232:7016/api/login").addJSONObjectBody(this.jObject).setTag((Object) "test").setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() {
            public void onResponse(JSONObject jSONObject) {
                String str = null;
                StringBuilder sb = new StringBuilder();
                String str2 = " response body --->";
                sb.append(str2);
                sb.append(jSONObject.toString());
                ProjectUtils.showLog(str, sb.toString());
                String str3 = str;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(HttpsRequest.this.jObject.toString());
                ProjectUtils.showLog(str3, sb2.toString());
                JSONParser jSONParser = new JSONParser(HttpsRequest.this.ctx, jSONObject);
                if (jSONParser.RESULT) {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, null);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onError(ANError aNError) {
                ProjectUtils.pauseProgressDialog();
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" error body --->");
                sb.append(aNError.getErrorBody());
                sb.append(" error msg --->");
                sb.append(aNError.getMessage());
                ProjectUtils.showLog(str, sb.toString());
            }
        });
    }

    public void stringPost(final String str, final Helper helper) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.BASE_URL);
        sb.append(this.match);
        AndroidNetworking.post(sb.toString()).addBodyParameter(this.params).setTag((Object) "test").setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() {
            public void onResponse(JSONObject jSONObject) {
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" response body --->");
                sb.append(jSONObject.toString());
                ProjectUtils.showLog(str, sb.toString());
                String str2 = str;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" param --->");
                sb2.append(HttpsRequest.this.params.toString());
                ProjectUtils.showLog(str2, sb2.toString());
                JSONParser jSONParser = new JSONParser(HttpsRequest.this.ctx, jSONObject);
                if (jSONParser.RESULT) {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, null);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onError(ANError aNError) {
                ProjectUtils.pauseProgressDialog();
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" error body --->");
                sb.append(aNError.getErrorBody());
                sb.append(" error msg --->");
                sb.append(aNError.getMessage());
                ProjectUtils.showLog(str, sb.toString());
            }
        });
    }

    public void stringGet(final String str, final Helper helper) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.BASE_URL);
        sb.append(this.match);
        AndroidNetworking.get(sb.toString()).setTag((Object) "test").setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() {
            public void onResponse(JSONObject jSONObject) {
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" response body --->");
                sb.append(jSONObject.toString());
                ProjectUtils.showLog(str, sb.toString());
                JSONParser jSONParser = new JSONParser(HttpsRequest.this.ctx, jSONObject);
                if (jSONParser.RESULT) {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, null);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onError(ANError aNError) {
                ProjectUtils.pauseProgressDialog();
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" error body --->");
                sb.append(aNError.getErrorBody());
                sb.append(" error msg --->");
                sb.append(aNError.getMessage());
                ProjectUtils.showLog(str, sb.toString());
            }
        });
    }

    public void imagePost(final String str, final Helper helper) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.BASE_URL);
        sb.append(this.match);
        AndroidNetworking.upload(sb.toString()).addMultipartFile(this.fileparams).addMultipartParameter(this.params).setTag((Object) "uploadTest").setPriority(Priority.IMMEDIATE).build().setUploadProgressListener(new UploadProgressListener() {
            public void onProgress(long j, long j2) {
                StringBuilder sb = new StringBuilder();
                sb.append(j);
                sb.append("  !!! ");
                sb.append(j2);
                ProjectUtils.showLog("Byte", sb.toString());
            }
        }).getAsJSONObject(new JSONObjectRequestListener() {
            public void onResponse(JSONObject jSONObject) {
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" response body --->");
                sb.append(jSONObject.toString());
                ProjectUtils.showLog(str, sb.toString());
                String str2 = str;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" param --->");
                sb2.append(HttpsRequest.this.params.toString());
                ProjectUtils.showLog(str2, sb2.toString());
                JSONParser jSONParser = new JSONParser(HttpsRequest.this.ctx, jSONObject);
                if (jSONParser.RESULT) {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, null);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onError(ANError aNError) {
                ProjectUtils.pauseProgressDialog();
                String str = null;
                StringBuilder sb = new StringBuilder();
                sb.append(" error body --->");
                sb.append(aNError.getErrorBody());
                sb.append(" error msg --->");
                sb.append(aNError.getMessage());
                ProjectUtils.showLog(str, sb.toString());
            }
        });
    }

//    public void multiImagePost(final String str, final Helper helper) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Const.BASE_URL);
//        sb.append(this.match);
//        AndroidNetworking.upload(sb.toString()).addMultipartFileList(this.multiFileparams).addMultipartParameter(this.params).setTag((Object) "uploadTest").setPriority(Priority.IMMEDIATE).build().setUploadProgressListener(new UploadProgressListener() {
//            public void onProgress(long j, long j2) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(j);
//                sb.append("  !!! ");
//                sb.append(j2);
//                ProjectUtils.showLog("Byte", sb.toString());
//            }
//        }).getAsJSONObject(new JSONObjectRequestListener() {
//            public void onResponse(JSONObject jSONObject) {
//                String str = null;
//                StringBuilder sb = new StringBuilder();
//                sb.append(" response body --->");
//                sb.append(jSONObject.toString());
//                ProjectUtils.showLog(str, sb.toString());
//                String str2 = str;
//                StringBuilder sb2 = new StringBuilder();
//                sb2.append(" param --->");
//                sb2.append(HttpsRequest.this.params.toString());
//                ProjectUtils.showLog(str2, sb2.toString());
//                JSONParser jSONParser = new JSONParser(HttpsRequest.this.ctx, jSONObject);
//                if (jSONParser.RESULT) {
//                    try {
//                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, jSONObject);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    try {
//                        helper.backResponse(jSONParser.RESULT, jSONParser.MESSAGE, null);
//                    } catch (JSONException e2) {
//                        e2.printStackTrace();
//                    }
//                }
//            }
//
//            public void onError(ANError aNError) {
//                ProjectUtils.pauseProgressDialog();
//                String str = null;
//                StringBuilder sb = new StringBuilder();
//                sb.append(" error body --->");
//                sb.append(aNError.getErrorBody());
//                sb.append(" error msg --->");
//                sb.append(aNError.getMessage());
//                ProjectUtils.showLog(str, sb.toString());
//            }
//        });
//    }
}
