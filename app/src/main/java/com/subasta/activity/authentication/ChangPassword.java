package com.subasta.activity.authentication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.subasta.C2037R;
import com.subasta.databinding.ActivityChangPasswordBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangPassword extends AppCompatActivity implements OnClickListener {
    private String TAG = ChangPassword.class.getCanonicalName();
    private ActivityChangPasswordBinding binding;
    private boolean isHide = false;
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public Context sContext;
    private UserDTO userDTO;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProjectUtils.changeStatusBarColorNew(this, C2037R.color.btn_bg);
        this.binding = (ActivityChangPasswordBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_chang_password);
        this.sContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.sContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        setUiAction();
    }

    private void setUiAction() {
        this.binding.changSave.setOnClickListener(this);
        this.binding.ivConfirmPass.setOnClickListener(this);
        this.binding.ivNewPass.setOnClickListener(this);
        this.binding.ivOldPass.setOnClickListener(this);
        this.binding.ivBack.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.chang_save /*2131361972*/:
                if (NetworkManager.isConnectToInternet(this.sContext)) {
                    submitForm();
                    return;
                } else {
                    ProjectUtils.InternetAlertDialog(this.sContext);
                    return;
                }
            case C2037R.C2039id.ivBack /*2131362135*/:
                onBackPressed();
                return;
            case C2037R.C2039id.ivConfirmPass /*2131362141*/:
                if (this.isHide) {
                    this.binding.ivConfirmPass.setImageResource(C2037R.C2038drawable.eye);
                    this.binding.etConfirmPass.setTransformationMethod(null);
                    this.binding.etConfirmPass.setSelection(this.binding.etConfirmPass.getText().length());
                    this.isHide = false;
                    return;
                }
                this.binding.ivConfirmPass.setImageResource(C2037R.C2038drawable.passwordhide);
                this.binding.etConfirmPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.binding.etConfirmPass.setSelection(this.binding.etConfirmPass.getText().length());
                this.isHide = true;
                return;
            case C2037R.C2039id.ivNewPass /*2131362153*/:
                if (this.isHide) {
                    this.binding.ivNewPass.setImageResource(C2037R.C2038drawable.eye);
                    this.binding.etNewPass.setTransformationMethod(null);
                    this.binding.etNewPass.setSelection(this.binding.etNewPass.getText().length());
                    this.isHide = false;
                    return;
                }
                this.binding.ivNewPass.setImageResource(C2037R.C2038drawable.passwordhide);
                this.binding.etNewPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.binding.etNewPass.setSelection(this.binding.etNewPass.getText().length());
                this.isHide = true;
                return;
            case C2037R.C2039id.ivOldPass /*2131362154*/:
                if (this.isHide) {
                    this.binding.ivOldPass.setImageResource(C2037R.C2038drawable.eye);
                    this.binding.etOldPass.setTransformationMethod(null);
                    this.binding.etOldPass.setSelection(this.binding.etOldPass.getText().length());
                    this.isHide = false;
                    return;
                }
                this.binding.ivOldPass.setImageResource(C2037R.C2038drawable.passwordhide);
                this.binding.etOldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.binding.etOldPass.setSelection(this.binding.etOldPass.getText().length());
                this.isHide = true;
                return;
            default:
                return;
        }
    }

    private void submitForm() {
        if (validateCurrentPin() && validateNewPin() && validateNewPin()) {
            checkpass();
        }
    }

    public boolean validateCurrentPin() {
        if (this.binding.etOldPass.getText().toString().trim().equalsIgnoreCase("")) {
            this.binding.etOldPass.setError(getString(C2037R.string.enter_pass));
            this.binding.etOldPass.requestFocus();
            return false;
        } else if (!ProjectUtils.isPasswordValid(this.binding.etOldPass.getText().toString().trim())) {
            this.binding.etOldPass.setError(getString(C2037R.string.password_required_validation));
            this.binding.etOldPass.requestFocus();
            return false;
        } else {
            this.binding.etOldPass.setError(null);
            this.binding.etOldPass.clearFocus();
            return true;
        }
    }

    public boolean validateNewPin() {
        if (this.binding.etNewPass.getText().toString().trim().equalsIgnoreCase("")) {
            this.binding.etNewPass.setError(getString(C2037R.string.enter_new_pass));
            this.binding.etNewPass.requestFocus();
            return false;
        } else if (!ProjectUtils.isPasswordValid(this.binding.etNewPass.getText().toString().trim())) {
            this.binding.etNewPass.setError(getString(C2037R.string.new_pwd_required_validation));
            this.binding.etNewPass.requestFocus();
            return false;
        } else {
            this.binding.etNewPass.setError(null);
            this.binding.etNewPass.clearFocus();
            return true;
        }
    }

    public void checkpass() {
        String str = "";
        if (this.binding.etNewPass.getText().toString().trim().equals(str)) {
            this.binding.etNewPass.setError(getString(C2037R.string.new_pwd_required_validation));
        } else if (this.binding.etConfirmPass.getText().toString().trim().equals(str)) {
            this.binding.etConfirmPass.setError(getString(C2037R.string.confirm_pwd_required_validation1));
        } else if (!this.binding.etNewPass.getText().toString().trim().equals(this.binding.etConfirmPass.getText().toString().trim())) {
            this.binding.etConfirmPass.setError(getString(C2037R.string.confirm_pwd_validation1));
        } else {
            this.binding.etConfirmPass.setError(null);
            this.binding.etConfirmPass.clearFocus();
            changePassword();
        }
    }

    private void changePassword() {
        ProjectUtils.showProgressDialog(this.sContext, false, getResources().getString(C2037R.string.please_wait));
        new HttpsRequest(Const.C_PASSWORD, (Map<String, String>) getParamsChangePass(), this.sContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ProjectUtils.showToast(ChangPassword.this.sContext, str);
                    ChangPassword.this.startActivity(new Intent(ChangPassword.this.sContext, Sign_in.class));
                    ChangPassword.this.finishAffinity();
                    return;
                }
                ProjectUtils.showToast(ChangPassword.this.sContext, str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> getParamsChangePass() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        hashMap.put(Const.OLD_PASSWORD, ProjectUtils.getEditTextValue(this.binding.etOldPass));
        hashMap.put(Const.NEW_PASSWORD, ProjectUtils.getEditTextValue(this.binding.etNewPass));
        hashMap.put(Const.C_PASSWORD, ProjectUtils.getEditTextValue(this.binding.etConfirmPass));
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("---Params --->");
        ProjectUtils.showLog(sb.toString(), hashMap.toString());
        return hashMap;
    }
}
