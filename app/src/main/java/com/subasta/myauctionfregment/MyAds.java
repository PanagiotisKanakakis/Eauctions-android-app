package com.subasta.myauctionfregment;

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
import com.subasta.adapter.MyBidAdapter;
import com.subasta.databinding.FregmentMyAunctionBidsBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.MyBidDTO;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAds extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = MyAds.class.getCanonicalName();
    /* access modifiers changed from: private */
    public FregmentMyAunctionBidsBinding binding;
    private GridLayoutManager layoutManager;
    private MyBidAdapter myBidAdapter;
    /* access modifiers changed from: private */
    public ArrayList<MyBidDTO> myBidsDTOArrayList;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FregmentMyAunctionBidsBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fregment_my_aunction_bids, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        setUiAction();
        return this.binding.getRoot();
    }

    private void setUiAction() {
        this.layoutManager = new GridLayoutManager((Context) getActivity(), 2, 1, false);
        this.binding.rvMyBids.setLayoutManager(this.layoutManager);
        this.binding.swipeRefreshMybids.setOnRefreshListener(this);
        this.binding.swipeRefreshMybids.post(new Runnable() {
            public void run() {
                Log.e("Runnable", "FIRST");
                if (NetworkManager.isConnectToInternet(MyAds.this.getActivity())) {
                    MyAds.this.binding.swipeRefreshMybids.setRefreshing(true);
                    MyAds.this.getMyBid();
                    return;
                }
                ProjectUtils.InternetAlertDialog(MyAds.this.getActivity());
            }
        });
    }

    public void getMyBid() {
        new HttpsRequest(Const.GET_MY_BID, (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                MyAds.this.binding.swipeRefreshMybids.setRefreshing(false);
                if (z) {
                    MyAds.this.myBidsDTOArrayList = new ArrayList();
//                        MyAds.this.myBidsDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<MyBidDTO>>() {
//                        }.getType());
                    MyAds.this.showData();
                } else {
                    MyAds.this.binding.tvNo.setVisibility(0);
                }
            }
        });
    }

    public void showData() {
        this.myBidAdapter = new MyBidAdapter(getActivity(), this.myBidsDTOArrayList, this);
        this.binding.rvMyBids.setAdapter(this.myBidAdapter);
    }

    public void onRefresh() {
        getMyBid();
    }
}
