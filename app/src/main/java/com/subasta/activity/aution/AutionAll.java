package com.subasta.activity.aution;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.FilterActivity;
import com.subasta.activity.SearchActivity;
import com.subasta.adapter.AutionAllAdapter;
import com.subasta.databinding.ActivityAutionAllBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AutionAllDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.facebook.share.internal.ShareConstants;

public class AutionAll extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "com.subasta.activity.aution.AutionAll";
    ArrayList<AutionAllDTO> allDTOArrayList;
    /* access modifiers changed from: private */
    public AutionAllAdapter autionAllAdapter;
    /* access modifiers changed from: private */
    public ActivityAutionAllBinding binding;
    private GridLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public void onClick(View view) {
    }

    /* access modifiers changed from: protected */
    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityAutionAllBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_aution_all);
        this.mContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        setUiAction();
        this.binding.iAHN.ivMenu.setVisibility(8);
        this.binding.iAHN.ivBack.setVisibility(0);
        this.binding.iAHN.tvindrapuri.setVisibility(8);
        this.binding.iAHN.spinner1.setVisibility(8);
        this.binding.iAHN.tvtitlemain.setVisibility(0);
        this.binding.iAHN.tvtitlemain.setText("All Aunctions");
        this.binding.iAHN.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AutionAll.this.onBackPressed();
            }
        });
        this.binding.iAHN.ivFilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AutionAll.this.startActivity(new Intent(AutionAll.this.mContext, FilterActivity.class));
            }
        });
        this.binding.iAHN.ivSearch1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AutionAll.this.startActivity(new Intent(AutionAll.this.mContext, SearchActivity.class));
            }
        });
    }

    private void setUiAction() {
        this.binding.recycleview1.setOnClickListener(this);
        this.layoutManager = new GridLayoutManager(this.mContext, 2, 1, false);
        this.binding.recycleview1.setHasFixedSize(true);
        this.binding.recycleview1.setLayoutManager(this.layoutManager);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getAllAuction();
    }

    public void getAllAuction() {
        new HttpsRequest("getAllAuctions", (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        AutionAll.this.binding.recycleview1.setVisibility(0);
                        AutionAll.this.allDTOArrayList = new ArrayList<>();
                        Type type = new TypeToken<List<AutionAllDTO>>() {
                        }.getType();
//                        AutionAll.this.allDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), type);
                        AutionAll.this.autionAllAdapter = new AutionAllAdapter(AutionAll.this, AutionAll.this.allDTOArrayList);
                        AutionAll.this.binding.recycleview1.setAdapter(AutionAll.this.autionAllAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(AutionAll.this.mContext, str);
                    AutionAll.this.binding.recycleview1.setVisibility(8);
                }
            }
        });
    }
}
