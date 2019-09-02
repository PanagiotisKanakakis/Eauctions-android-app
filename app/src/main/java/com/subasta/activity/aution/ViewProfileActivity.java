package com.subasta.activity.aution;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.databinding.ActivityViewProfileBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ViewProfileActivity extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "com.subasta.activity.aution.ViewProfileActivity";
    private ActivityViewProfileBinding binding;
    /* access modifiers changed from: private */
    public Context mContext;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public UserDTO userDTO;
    private String userId;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityViewProfileBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_view_profile);
        Intent intent = getIntent();
        String str = Const.USER_PUB_ID;
        this.userId = intent.getStringExtra(str);
        this.mContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        setUiAction();
        this.params.put(str, this.userId);
        getViewProfileData();
    }

    private void setUiAction() {
        this.binding.profileback.setOnClickListener(this);
        this.binding.cetPhoneno.setOnClickListener(this);
    }

    private void getViewProfileData() {
        new HttpsRequest(Const.VIEW_PROFILE, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
//                        ViewProfileActivity.this.userDTO = (UserDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), UserDTO.class);
                        ViewProfileActivity.this.showData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(ViewProfileActivity.this.mContext, str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void showData() {
        this.binding.cetAddress.setText(this.userDTO.getAddress());
        this.binding.ctvName.setText(ProjectUtils.capWordFirstLetter(this.userDTO.getName()));
        this.binding.etEmail.setText(this.userDTO.getEmail());
        this.binding.cetPhoneno.setText(this.userDTO.getMobile_no());
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(this.userDTO.getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) this.binding.civProfile);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C2037R.C2039id.cetPhoneno) {
            callDialer();
        } else if (id == C2037R.C2039id.profileback) {
            onBackPressed();
        }
    }

    private void callDialer() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("tel:");
            sb.append(this.binding.cetPhoneno.getText().toString());
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse(sb.toString())));
        } catch (SecurityException unused) {
        }
    }
}
