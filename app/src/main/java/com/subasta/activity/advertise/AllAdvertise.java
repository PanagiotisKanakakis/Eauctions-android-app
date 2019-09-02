package com.subasta.activity.advertise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.FilterActivity;
import com.subasta.activity.SearchActivity;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.AdvertiseAdapter;
import com.subasta.databinding.ActivityAllAdvertiseBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AdvertiseAllDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//import com.facebook.share.internal.ShareConstants;

public class AllAdvertise extends AppCompatActivity {
    private static final String TAG = "com.subasta.activity.advertise.AllAdvertise";
    AdvertiseAdapter advertiseAdapter;
    private AdvertiseAllDTO advertiseAllDTO;
    ArrayList<AdvertiseAllDTO> advertiseDTOArrayList;
    /* access modifiers changed from: private */
    public ActivityAllAdvertiseBinding binding;

    /* renamed from: id */
    private String f1298id;
    private RecyclerView.LayoutManager layoutManager;
    Context mContext;

    /* access modifiers changed from: protected */
    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivityAllAdvertiseBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_all_advertise);
        setUIAction();
        this.binding.iAHN.ivMenu.setVisibility(8);
        this.binding.iAHN.ivBack.setVisibility(0);
        this.binding.iAHN.tvindrapuri.setVisibility(0);
        this.binding.iAHN.spinner1.setVisibility(0);
        this.binding.iAHN.ivBack.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                Intent intent = new Intent(AllAdvertise.this.mContext, Dashboard.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("index", 0);
                AllAdvertise.this.startActivity(intent);
            }
        });
        this.binding.iAHN.ivFilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AllAdvertise.this.startActivity(new Intent(AllAdvertise.this.mContext, FilterActivity.class));
            }
        });
        this.binding.iAHN.ivSearch1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AllAdvertise.this.startActivity(new Intent(AllAdvertise.this.mContext, SearchActivity.class));
            }
        });
    }

    private void setUIAction() {
        this.advertiseDTOArrayList = new ArrayList<>();
        this.layoutManager = new GridLayoutManager(this.mContext, 2, 1, false);
        this.binding.recycleview1.setHasFixedSize(true);
        this.binding.recycleview1.setLayoutManager(this.layoutManager);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getAllAdvertise();
    }

    private void getAllAdvertise() {
        new HttpsRequest(Const.GET_ALL_ADVERTISE, this.mContext).stringGet(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        AllAdvertise.this.binding.recycleview1.setVisibility(0);
                        AllAdvertise.this.advertiseDTOArrayList = new ArrayList<>();
                        Type type = new TypeToken<List<AdvertiseAllDTO>>() {
                        }.getType();
//                        AllAdvertise.this.advertiseDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), type);
                        AllAdvertise.this.advertiseAdapter = new AdvertiseAdapter(AllAdvertise.this, AllAdvertise.this.advertiseDTOArrayList);
                        AllAdvertise.this.binding.recycleview1.setAdapter(AllAdvertise.this.advertiseAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(AllAdvertise.this.mContext, str);
                }
            }
        });
    }
}
