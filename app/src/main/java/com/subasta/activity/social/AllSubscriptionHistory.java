package com.subasta.activity.social;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.SubHistoryAdapter;
import com.subasta.databinding.FregmentSubscriptionHistoryBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.SubHistoryDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllSubscriptionHistory extends AppCompatActivity implements OnClickListener {
    private String TAG = AllSubscriptionHistory.class.getCanonicalName();
    /* access modifiers changed from: private */
    public FregmentSubscriptionHistoryBinding binding;
    private Dashboard dashboard;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public SubHistoryAdapter subHistoryAdapter;
    /* access modifiers changed from: private */
    public ArrayList<SubHistoryDTO> subHistoryDTOArrayList;
    private UserDTO userDTO;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (FregmentSubscriptionHistoryBinding) DataBindingUtil.setContentView(this, C2037R.layout.fregment_subscription_history);
        this.binding.icBack.setOnClickListener(this);
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        this.binding.svHistory.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                try {
                    AllSubscriptionHistory.this.subHistoryAdapter.filter(str);
                } catch (Exception unused) {
                }
                return false;
            }
        });
        getSubscriptionHistory();
    }

    private void getSubscriptionHistory() {
        new HttpsRequest(Const.GET_SUB_HISTORY, (Map<String, String>) this.params, this.mContext).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    AllSubscriptionHistory.this.binding.svHistory.setVisibility(0);
                    AllSubscriptionHistory.this.binding.tvNo.setVisibility(8);
                    try {
                        AllSubscriptionHistory.this.subHistoryDTOArrayList = new ArrayList();
//                        AllSubscriptionHistory.this.subHistoryDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<SubHistoryDTO>>() {
//                        }.getType());
                        AllSubscriptionHistory.this.layoutManager = new LinearLayoutManager(AllSubscriptionHistory.this.mContext, 1, false);
                        AllSubscriptionHistory.this.binding.rvhistory.setLayoutManager(AllSubscriptionHistory.this.layoutManager);
                        AllSubscriptionHistory.this.binding.rvhistory.setHasFixedSize(true);
                        AllSubscriptionHistory.this.subHistoryAdapter = new SubHistoryAdapter(AllSubscriptionHistory.this.mContext, AllSubscriptionHistory.this.subHistoryDTOArrayList);
                        AllSubscriptionHistory.this.binding.rvhistory.setAdapter(AllSubscriptionHistory.this.subHistoryAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    AllSubscriptionHistory.this.binding.svHistory.setVisibility(8);
                    AllSubscriptionHistory.this.binding.tvNo.setVisibility(0);
                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == C2037R.C2039id.icBack) {
            onBackPressed();
        }
    }
}
