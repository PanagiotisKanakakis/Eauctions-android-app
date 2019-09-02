package com.subasta.activity.aution;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.adapter.AdapterAllRating;
import com.subasta.databinding.ActivityGetAllRatingBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.GetRatingDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import com.facebook.appevents.AppEventsConstants;
//import com.facebook.share.internal.ShareConstants;

public class GetAllRating extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "com.subasta.activity.aution.GetAllRating";
    /* access modifiers changed from: private */
    public AdapterAllRating adapterAllRating;
    /* access modifiers changed from: private */
    public ActivityGetAllRatingBinding binding;
    /* access modifiers changed from: private */
    public ArrayList<GetRatingDTO> getRatingDTOArrayList;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    private HashMap<String, String> params = new HashMap<>();
    private String pro_pub_id;
    private String userId;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivityGetAllRatingBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_get_all_rating);
        Intent intent = getIntent();
        String str = Const.USER_PUB_ID;
        this.userId = intent.getStringExtra(str);
        Intent intent2 = getIntent();
        String str2 = Const.Pro_pub_id;
        this.pro_pub_id = intent2.getStringExtra(str2);
        this.params.put(str, this.userId);
        this.params.put(str2, this.pro_pub_id);
        this.binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                GetAllRating.this.getAllRating();
            }
        });
        getAllRating();
        this.binding.icRatBack.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void getAllRating() {
        new HttpsRequest(Const.GET_ALL_RATING, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                GetAllRating.this.binding.simpleSwipeRefreshLayout.setRefreshing(false);
                if (z) {
                    try {
                        GetAllRating.this.binding.rvAllRating.setVisibility(0);
                        GetAllRating.this.getRatingDTOArrayList = new ArrayList();
//                        GetAllRating.this.getRatingDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<GetRatingDTO>>() {
//                        }.getType());
                        GetAllRating.this.layoutManager = new LinearLayoutManager(GetAllRating.this.mContext, 1, false);
                        GetAllRating.this.binding.rvAllRating.setLayoutManager(GetAllRating.this.layoutManager);
//                        GetAllRating.this.adapterAllRating = new AdapterAllRating(GetAllRating.this.mContext, GetAllRating.this.getRatingDTOArrayList, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        GetAllRating.this.binding.rvAllRating.setAdapter(GetAllRating.this.adapterAllRating);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    GetAllRating.this.binding.rvAllRating.setVisibility(8);
                    GetAllRating.this.binding.nodata.setVisibility(0);
                    GetAllRating.this.binding.simpleSwipeRefreshLayout.setVisibility(8);
                    GetAllRating.this.binding.simpleSwipeRefreshLayout.setRefreshing(false);
                    ProjectUtils.showToast(GetAllRating.this.mContext, str);
                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == C2037R.C2039id.icRatBack) {
            finish();
        }
    }
}
