package com.subasta.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.categories.CategoryList;
import com.subasta.adapter.SupportAdapter;
import com.subasta.databinding.ActivitySupportAcitivityBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.SupportDTO;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupportAcitivity extends AppCompatActivity implements OnClickListener {
    private String TAG = CategoryList.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivitySupportAcitivityBinding binding;
    /* access modifiers changed from: private */
    public Dialog dialogbox_add_bid;
    private String editDesc;
    CustomEditText editDescription;
    private String editMessage;
    CustomEditText editTitle;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public SupportAdapter supportAdapter;
    /* access modifiers changed from: private */
    public ArrayList<SupportDTO> supportDTOArrayList;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivitySupportAcitivityBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_support_acitivity);
        this.mContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        this.binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                SupportAcitivity.this.setData();
            }
        });
//        this.binding.myFAB.setOnClickListener(this);
        this.binding.chatSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                try {
                    SupportAcitivity.this.supportAdapter.filter(str);
                } catch (Exception unused) {
                }
                return false;
            }
        });
        setData();
    }

    /* access modifiers changed from: private */
    public void setData() {
        new HttpsRequest(Const.GET_ALL_SUPPORT, (Map<String, String>) this.params, this.mContext).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                SupportAcitivity.this.binding.swipeRefreshLayout.setRefreshing(false);
                if (z) {
                    try {
                        SupportAcitivity.this.supportDTOArrayList = new ArrayList();
                        Type type = new TypeToken<List<SupportDTO>>() {
                        }.getType();
                        SupportAcitivity.this.binding.tvNo.setVisibility(8);
//                        SupportAcitivity.this.supportDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), type);
                        SupportAcitivity.this.layoutManager = new LinearLayoutManager(SupportAcitivity.this.mContext, 1, false);
                        SupportAcitivity.this.binding.recycleview1.setLayoutManager(SupportAcitivity.this.layoutManager);
                        SupportAcitivity.this.supportAdapter = new SupportAdapter(SupportAcitivity.this.mContext, SupportAcitivity.this.supportDTOArrayList);
                        SupportAcitivity.this.binding.recycleview1.setAdapter(SupportAcitivity.this.supportAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    SupportAcitivity.this.binding.tvNo.setVisibility(0);
                    SupportAcitivity.this.binding.chatSearch.setVisibility(8);
                }
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C2037R.C2039id.icBack) {
            onBackPressed();
        } else if (id == C2037R.C2039id.myFAB) {
            dialogbox_support_msg();
        }
    }

    private void dialogbox_support_msg() {
        this.dialogbox_add_bid = new Dialog(this.mContext);
        this.dialogbox_add_bid.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialogbox_add_bid.requestWindowFeature(1);
        this.dialogbox_add_bid.setContentView(C2037R.layout.dialog_support_msg);
        this.editTitle = (CustomEditText) this.dialogbox_add_bid.findViewById(C2037R.C2039id.editTitle);
        this.editDescription = (CustomEditText) this.dialogbox_add_bid.findViewById(C2037R.C2039id.editDescription);
        ImageView imageView = (ImageView) this.dialogbox_add_bid.findViewById(C2037R.C2039id.ivClose);
        Button button = (Button) this.dialogbox_add_bid.findViewById(C2037R.C2039id.btnSubmit);
        this.dialogbox_add_bid.show();
        this.dialogbox_add_bid.setCancelable(true);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SupportAcitivity.this.params.put(Const.GET_SUP_TITLE, SupportAcitivity.this.editTitle.getText().toString());
                SupportAcitivity.this.params.put(Const.GET_SUP_DESC, SupportAcitivity.this.editDescription.getText().toString());
                SupportAcitivity.this.params.put(Const.USER_PUB_ID, SupportAcitivity.this.userDTO.getUser_pub_id());
                SupportAcitivity.this.checkEditField();
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SupportAcitivity.this.dialogbox_add_bid.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    @SuppressLint("WrongConstant")
    public void checkEditField() {
        String str = "";
        if (this.editTitle.getText().toString().equalsIgnoreCase(str)) {
            Toast.makeText(this.mContext, "Please enter your message title.", 0).show();
        } else if (this.editDescription.getText().toString().equalsIgnoreCase(str)) {
            Toast.makeText(this.mContext, "Please enter the description", 0).show();
        } else if (NetworkManager.isConnectToInternet(this.mContext)) {
            addSupportMsg();
        } else {
            ProjectUtils.InternetAlertDialog(this.mContext);
        }
    }

    private void addSupportMsg() {
        new HttpsRequest(Const.ADD_SUPPRT, (Map<String, String>) this.params, this.mContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    SupportAcitivity.this.setData();
                    SupportAcitivity.this.dialogbox_add_bid.dismiss();
                    ProjectUtils.showToast(SupportAcitivity.this.mContext, str);
                }
            }
        });
    }
}
