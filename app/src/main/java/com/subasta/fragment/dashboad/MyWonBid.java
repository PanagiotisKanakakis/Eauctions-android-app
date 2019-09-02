package com.subasta.fragment.dashboad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.adapter.WonBidsAdapter;
import com.subasta.databinding.FregmentWonBidsBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.UserDTO;
import com.subasta.model.WonBidDTO;
import com.subasta.myauctionfregment.MyAds;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyWonBid extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = MyAds.class.getCanonicalName();
    /* access modifiers changed from: private */
    public FregmentWonBidsBinding binding;
    private GridLayoutManager layoutManager;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;
    /* access modifiers changed from: private */
    public ArrayList<WonBidDTO> wonBidDTOArrayList;
    private WonBidsAdapter wonBidsAdapter;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FregmentWonBidsBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fregment_won_bids, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        setUiAction();
        return this.binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    private void setUiAction() {
        this.layoutManager = new GridLayoutManager((Context) getActivity(), 2, 1, false);
        this.binding.rvWonBids.setLayoutManager(this.layoutManager);
        this.binding.swipeRefreshMybids.setOnRefreshListener(this);
        this.binding.swipeRefreshMybids.post(new Runnable() {
            public void run() {
                Log.e("Runnable", "FIRST");
                if (NetworkManager.isConnectToInternet(MyWonBid.this.getActivity())) {
                    MyWonBid.this.binding.swipeRefreshMybids.setRefreshing(true);
                    MyWonBid.this.getMyBid();
                    return;
                }
                ProjectUtils.InternetAlertDialog(MyWonBid.this.getActivity());
            }
        });
    }

    public void getMyBid() {
        new HttpsRequest(Const.WON_BID, (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                MyWonBid.this.binding.swipeRefreshMybids.setRefreshing(false);
                if (z) {
                    MyWonBid.this.wonBidDTOArrayList = new ArrayList();
//                        MyWonBid.this.wonBidDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<WonBidDTO>>() {
//                        }.getType());
                    MyWonBid.this.showData();
                } else {
                    MyWonBid.this.binding.tvNo.setVisibility(0);
                }
            }
        });
    }

    public void showData() {
        this.wonBidsAdapter = new WonBidsAdapter(getActivity(), this.wonBidDTOArrayList, this);
        this.binding.rvWonBids.setAdapter(this.wonBidsAdapter);
    }

    public void onRefresh() {
        getMyBid();
    }
}
