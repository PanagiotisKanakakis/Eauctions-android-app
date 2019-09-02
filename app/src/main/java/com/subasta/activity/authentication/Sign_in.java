package com.subasta.activity.authentication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.snackbar.Snackbar;
import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.databinding.ActivitySignInBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.KeyHashGenerator;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//import com.facebook.FacebookSdk;
//import com.facebook.GraphResponse;
//import com.facebook.share.internal.ShareConstants;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.InstanceIdResult;

public class Sign_in extends AppCompatActivity implements OnClickListener {
    public static final String MyPREFERENCES = "MyPrefs";
    ImageView ImgClose;
    /* access modifiers changed from: private */
    public String TAG = Sign_in.class.getCanonicalName();
    private ActivitySignInBinding binding;
    /* access modifiers changed from: private */
    public Dialog dialogbox_forgetpassword;
    private String email;
//    private FacebookHelper fbConnectHelper;
//    private GoogleSignInHelper googleSignInHelper;
    private boolean isFbLogin = false;
    private boolean isHide = false;
    /* access modifiers changed from: private */
    public HashMap<String, String> paramsForgot = new HashMap<>();
    /* access modifiers changed from: private */
    public SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public Context sContext;
    SharedPreferences sharedPreferences;
    /* access modifiers changed from: private */
    public UserDTO userDTO;
    private String userName;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
//        FacebookSdk.sdkInitialize(getApplicationContext());
        this.binding = (ActivitySignInBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_sign_in);
        this.sContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.sContext);
        KeyHashGenerator.generateKey(this);
//        this.fbConnectHelper = new FacebookHelper((Activity) this, (OnFbSignInListener) this);
//        this.googleSignInHelper = new GoogleSignInHelper(this, this);
//        this.googleSignInHelper.connect();
        setUiAction();
        this.sharedPreferences = getSharedPreferences("MyPrefs", 0);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("getInstanceId :====>");
        sb.append(this.sharedPreferences.getString(Const.DEVICE_TOKEN, ""));
        Log.w(str, sb.toString());
    }

    private void setUiAction() {
        this.binding.btnSignIn.setOnClickListener(this);
        this.binding.btnFacebook.setOnClickListener(this);
        this.binding.btnGmail.setOnClickListener(this);
        this.binding.tvCreateAccount.setOnClickListener(this);
        this.binding.tvFrogotPass.setOnClickListener(this);
        this.binding.btnFacebook.setOnClickListener(this);
        this.binding.btnGmail.setOnClickListener(this);
        this.binding.ivPass.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.btnFacebook /*2131361922*/:
                fbLogin();
                return;
            case C2037R.C2039id.btnGmail /*2131361924*/:
                gmailLogin();
                return;
            case C2037R.C2039id.btnSignIn /*2131361927*/:
                ClickForSubmit();
                return;
            case C2037R.C2039id.ivPass /*2131362155*/:
                if (this.isHide) {
                    this.binding.ivPass.setImageResource(C2037R.C2038drawable.eye);
                    this.binding.etPassword.setTransformationMethod(null);
                    this.binding.etPassword.setSelection(this.binding.etPassword.getText().length());
                    this.isHide = false;
                    return;
                }
                this.binding.ivPass.setImageResource(C2037R.C2038drawable.passwordhide);
                this.binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.binding.etPassword.setSelection(this.binding.etPassword.getText().length());
                this.isHide = true;
                return;
            case C2037R.C2039id.tvCreateAccount /*2131362492*/:
                startActivity(new Intent(this.sContext, Sign_Up.class));
                return;
            case C2037R.C2039id.tvFrogotPass /*2131362498*/:
                dialogForgotPassword();
                return;
            default:
                return;
        }
    }

    private void gmailLogin() {
        ProjectUtils.showProgressDialog(this.sContext, false, "Please wait...");
//        this.googleSignInHelper.signIn();
        this.isFbLogin = false;
    }

    private void fbLogin() {
        ProjectUtils.showProgressDialog(this.sContext, false, "Please wait...");
//        this.fbConnectHelper.connect();
        this.isFbLogin = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
//        this.googleSignInHelper.onStart();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
//        this.googleSignInHelper.onActivityResult(i, i2, intent);
//        this.fbConnectHelper.onActivityResult(i, i2, intent);
    }

    private void signUpRequest() {
        ProjectUtils.showProgressDialog(this.sContext, false, "Please wait...");
        new HttpsRequest("login", new JSONObject(getParams()), this.sContext).stringPostJson(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    //                        Sign_in.this.userDTO = (UserDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), UserDTO.class);
                    Sign_in.this.prefrence.setParentUser(Sign_in.this.userDTO, Const.USER_DTO);
                    Sign_in.this.prefrence.setBooleanValue(Const.IS_REGISTERED, true);
                    Intent intent = new Intent(Sign_in.this.sContext, Dashboard.class);
                    intent.addFlags(32768);
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    intent.putExtra("index", 0);
                    Sign_in.this.startActivity(intent);
                    Sign_in.this.finish();
                } else {
                    ProjectUtils.showToast(Sign_in.this.sContext, str);
                }
            }
        });
    }

    public void dialogForgotPassword() {
        this.dialogbox_forgetpassword = new Dialog(this.sContext);
        this.dialogbox_forgetpassword.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialogbox_forgetpassword.requestWindowFeature(1);
        this.dialogbox_forgetpassword.setContentView(C2037R.layout.activity_dialogbox_forgetpassword);
        final EditText editText = (EditText) this.dialogbox_forgetpassword.findViewById(C2037R.C2039id.etEmail);
        Button button = (Button) this.dialogbox_forgetpassword.findViewById(C2037R.C2039id.btnSubmit);
        ImageView imageView = (ImageView) this.dialogbox_forgetpassword.findViewById(C2037R.C2039id.ivClose);
        this.dialogbox_forgetpassword.show();
        this.dialogbox_forgetpassword.setCancelable(false);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Sign_in.this.paramsForgot.put("email", ProjectUtils.getEditTextValue(editText));
                if (!ProjectUtils.isEmailValid(editText.getText().toString().trim())) {
                    Sign_in sign_in = Sign_in.this;
                    sign_in.showSickbar(sign_in.getResources().getString(C2037R.string.verifyemail));
                } else if (NetworkManager.isConnectToInternet(Sign_in.this.sContext)) {
                    Sign_in.this.forgotPassword();
                } else {
                    ProjectUtils.InternetAlertDialog(Sign_in.this.sContext);
                }
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Sign_in.this.dialogbox_forgetpassword.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void forgotPassword() {
        ProjectUtils.showProgressDialog(this.sContext, false, getResources().getString(C2037R.string.please_wait));
        new HttpsRequest(Const.FORGOT_PASSWORD, (Map<String, String>) this.paramsForgot, this.sContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ProjectUtils.showToast(Sign_in.this.sContext, str);
                    Sign_in.this.dialogbox_forgetpassword.dismiss();
                    return;
                }
                ProjectUtils.showToast(Sign_in.this.sContext, str);
            }
        });
    }

    private HashMap<String, String> getParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        String str = Const.DEVICE_TOKEN;
        hashMap.put(str, sharedPreferences2.getString(str, ""));
        hashMap.put("email", ProjectUtils.getEditTextValue(this.binding.etEmail));
        hashMap.put(Const.PASSWORD, ProjectUtils.getEditTextValue(this.binding.etPassword));
        return hashMap;
    }

    public void ClickForSubmit() {
        if (!ProjectUtils.isEmailValid(this.binding.etEmail.getText().toString().trim())) {
            showSickbar(getResources().getString(C2037R.string.verifyemail));
        } else if (!ProjectUtils.isPasswordValid(this.binding.etPassword.getText().toString().trim())) {
            showSickbar(getResources().getString(C2037R.string.verifypass));
        } else if (NetworkManager.isConnectToInternet(this.sContext)) {
            signUpRequest();
        } else {
            ProjectUtils.InternetAlertDialog(this.sContext);
        }
    }

    public void showSickbar(String str) {
        Snackbar make = Snackbar.make((View) this.binding.rlSnackbar, (CharSequence) str, 0);
        make.getView().setBackgroundColor(getResources().getColor(C2037R.color.colorPrimary));
        make.show();
    }



    public void OnGSignInSuccess(GoogleSignInAccount googleSignInAccount) {
        if (googleSignInAccount != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(googleSignInAccount.getGivenName());
            sb.append(googleSignInAccount.getFamilyName());
            this.userName = sb.toString();
            this.email = googleSignInAccount.getEmail();
        }
    }

    public void OnGSignInError(String str) {
        Log.e(this.TAG, str);
    }
}
