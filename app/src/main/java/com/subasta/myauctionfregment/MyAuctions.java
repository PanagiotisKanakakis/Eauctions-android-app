package com.subasta.myauctionfregment;

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

import com.subasta.C2037R;
import com.subasta.adapter.MyAuctionAdapter;
import com.subasta.databinding.FregmentMyAunctionAunctionsBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.MyAutionDTO;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAuctions extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = MyAuctions.class.getCanonicalName();
    /* access modifiers changed from: private */
    public FregmentMyAunctionAunctionsBinding binding;
    private GridLayoutManager layoutManager;
    private MyAuctionAdapter myAuctionAdapter;
    /* access modifiers changed from: private */
    public ArrayList<MyAutionDTO> myAutionDTOArrayList;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FregmentMyAunctionAunctionsBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fregment_my_aunction_aunctions, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        setUiAction();
        return this.binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    private void setUiAction() {
        this.layoutManager = new GridLayoutManager((Context) getActivity(), 2, 1, false);
        this.binding.rvMyAuction.setLayoutManager(this.layoutManager);
        this.binding.swipeRefreshMyauction.setOnRefreshListener(this);
        this.binding.swipeRefreshMyauction.post(new Runnable() {
            public void run() {
                Log.e("Runnable", "FIRST");
                if (NetworkManager.isConnectToInternet(MyAuctions.this.getActivity())) {
                    MyAuctions.this.binding.swipeRefreshMyauction.setRefreshing(true);
                    MyAuctions.this.getMyAuction();
                    return;
                }
                ProjectUtils.InternetAlertDialog(MyAuctions.this.getActivity());
            }
        });
    }

    /* access modifiers changed from: private */
    public void getMyAuction() {
        new HttpsRequest(Const.GET_MY_AUNCTION, (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                MyAuctions.this.binding.swipeRefreshMyauction.setRefreshing(false);
                if (z) {
                    MyAuctions.this.myAutionDTOArrayList = new ArrayList();
//                        MyAuctions.this.myAutionDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<MyAutionDTO>>() {
//                        }.getType());
                    MyAuctions.this.showData();
                } else {
                    MyAuctions.this.binding.tvNo.setVisibility(0);
                }
            }
        });
    }

    public void showData() {
        this.myAuctionAdapter = new MyAuctionAdapter(getActivity(), this.myAutionDTOArrayList);
        this.binding.rvMyAuction.setAdapter(this.myAuctionAdapter);
    }

    public void onResume() {
        super.onResume();
        getMyAuction();
    }

    public void onRefresh() {
        getMyAuction();
    }
}
