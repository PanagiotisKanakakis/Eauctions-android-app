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
import com.subasta.adapter.ViewAunctionBidAdapter;
import com.subasta.databinding.ActivityViewBidAuntionBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.BidsDTO;
import com.subasta.model.UserDTO;
import com.subasta.model.ViewAllAuctionDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewBidAuntion extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "com.subasta.activity.aution.ViewBidAuntion";
    /* access modifiers changed from: private */
    public ActivityViewBidAuntionBinding bidAuntionBinding;
    private ArrayList<BidsDTO> bidsDTOArrayList;

    /* renamed from: id */
    private String f1305id;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;
    /* access modifiers changed from: private */
    public ViewAllAuctionDTO viewAllAuctionDTO;
    /* access modifiers changed from: private */
    public ViewAunctionBidAdapter viewAunctionBidAdapter;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.bidAuntionBinding = (ActivityViewBidAuntionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_view_bid_auntion);
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.bidAuntionBinding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                ViewBidAuntion.this.getSingleAuction();
            }
        });
        Intent intent = getIntent();
        String str = Const.Pro_pub_id;
        this.f1305id = intent.getStringExtra(str);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        this.params.put(str, this.f1305id);
        getSingleAuction();
    }

    /* access modifiers changed from: private */
    public void getSingleAuction() {
        new HttpsRequest(Const.GET_SINGLE_AUNCTION, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                ViewBidAuntion.this.bidAuntionBinding.simpleSwipeRefreshLayout.setRefreshing(false);
                if (z) {
                    try {
//                        ViewBidAuntion.this.viewAllAuctionDTO = (ViewAllAuctionDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), ViewAllAuctionDTO.class);
                        ViewBidAuntion.this.layoutManager = new LinearLayoutManager(ViewBidAuntion.this.mContext, 1, false);
                        ViewBidAuntion.this.bidAuntionBinding.rvBids.setLayoutManager(ViewBidAuntion.this.layoutManager);
//                        ViewBidAuntion.this.viewAunctionBidAdapter = new ViewAunctionBidAdapter(ViewBidAuntion.this.viewAllAuctionDTO.getBids(), ViewBidAuntion.this.mContext, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        ViewBidAuntion.this.bidAuntionBinding.rvBids.setAdapter(ViewBidAuntion.this.viewAunctionBidAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ViewBidAuntion.this.bidAuntionBinding.nodata.setVisibility(0);
                    ViewBidAuntion.this.bidAuntionBinding.simpleSwipeRefreshLayout.setVisibility(8);
                    ViewBidAuntion.this.bidAuntionBinding.simpleSwipeRefreshLayout.setRefreshing(false);
                    ProjectUtils.showToast(ViewBidAuntion.this.mContext, str);
                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == C2037R.C2039id.icBidBack) {
            finish();
        }
    }
}
