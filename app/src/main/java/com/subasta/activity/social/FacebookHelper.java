//package com.subasta.activity.social;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import androidx.fragment.app.Fragment;
//
//import com.facebook.AccessToken;
//import com.facebook.CallbackManager;
//import com.facebook.CallbackManager.Factory;
//import com.facebook.FacebookAuthorizationException;
//import com.facebook.FacebookCallback;
//import com.facebook.FacebookException;
//import com.facebook.GraphRequest;
//import com.facebook.GraphRequest.GraphJSONObjectCallback;
//import com.facebook.GraphResponse;
//import com.facebook.login.LoginManager;
//import com.facebook.login.LoginResult;
//import com.facebook.share.model.ShareLinkContent;
//import com.facebook.share.model.ShareLinkContent.Builder;
//import com.facebook.share.widget.ShareDialog;
//
//import org.json.JSONObject;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//public class FacebookHelper {
//    private Activity activity;
//    private CallbackManager callbackManager;
//    /* access modifiers changed from: private */
//    public OnFbSignInListener fbSignInListener;
//    private Fragment fragment;
//    private LoginManager loginManager;
//
//    /* renamed from: permissions reason: collision with root package name */
//    private Collection<String> f1806permissions = Arrays.asList(new String[]{"public_profile ", "email", "user_birthday", "user_location"});
//    private ShareDialog shareDialog;
//
//    public interface OnFbSignInListener {
//        void OnFbSignInComplete(GraphResponse graphResponse, String str);
//    }
//
//    public FacebookHelper(Activity activity2, OnFbSignInListener onFbSignInListener) {
//        this.activity = activity2;
//        this.fbSignInListener = onFbSignInListener;
//    }
//
//    public FacebookHelper(Fragment fragment2, OnFbSignInListener onFbSignInListener) {
//        this.fragment = fragment2;
//        this.fbSignInListener = onFbSignInListener;
//    }
//
//    public FacebookHelper(Activity activity2) {
//        this.shareDialog = new ShareDialog(activity2);
//    }
//
//    public FacebookHelper(Fragment fragment2) {
//        this.shareDialog = new ShareDialog(fragment2);
//    }
//
//    public void connect() {
//        this.callbackManager = Factory.create();
//        this.loginManager = LoginManager.getInstance();
//        Activity activity2 = this.activity;
//        if (activity2 != null) {
//            this.loginManager.logInWithReadPermissions(activity2, this.f1806permissions);
//        } else {
//            this.loginManager.logInWithReadPermissions(this.fragment, this.f1806permissions);
//        }
//        this.loginManager.registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() {
//            public void onSuccess(LoginResult loginResult) {
//                if (loginResult != null) {
//                    FacebookHelper.this.callGraphAPI(loginResult.getAccessToken());
//                }
//            }
//
//            public void onCancel() {
//                FacebookHelper.this.fbSignInListener.OnFbSignInComplete(null, "User cancelled.");
//            }
//
//            public void onError(FacebookException facebookException) {
//                if ((facebookException instanceof FacebookAuthorizationException) && AccessToken.getCurrentAccessToken() != null) {
//                    LoginManager.getInstance().logOut();
//                }
//                FacebookHelper.this.fbSignInListener.OnFbSignInComplete(null, facebookException.getMessage());
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void callGraphAPI(AccessToken accessToken) {
//        GraphRequest newMeRequest = GraphRequest.newMeRequest(accessToken, new GraphJSONObjectCallback() {
//            public void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
//                FacebookHelper.this.fbSignInListener.OnFbSignInComplete(graphResponse, null);
//            }
//        });
//        Bundle bundle = new Bundle();
//        bundle.putString("fields", "id,birthday,email,first_name,gender,last_name,link,location,name");
//        newMeRequest.setParameters(bundle);
//        newMeRequest.executeAsync();
//    }
//
//    public void onActivityResult(int i, int i2, Intent intent) {
//        CallbackManager callbackManager2 = this.callbackManager;
//        if (callbackManager2 != null) {
//            callbackManager2.onActivityResult(i, i2, intent);
//        }
//    }
//
//    public void shareOnFBWall(String str, String str2, String str3) {
//        if (ShareDialog.canShow(ShareLinkContent.class)) {
//            this.shareDialog.show(((Builder) new Builder().setContentTitle(str).setContentDescription(str2).setContentUrl(Uri.parse(str3))).build());
//        }
//    }
//}
