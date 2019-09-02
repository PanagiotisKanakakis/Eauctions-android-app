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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.adapter.MyFavAdapter;
import com.subasta.databinding.FregementMyAunctionFavBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.MyFavDTO;
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

public class MyFav extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = MyFav.class.getCanonicalName();
    /* access modifiers changed from: private */
    public FregementMyAunctionFavBinding binding;
    private GridLayoutManager layoutManager;
    private MyFavAdapter myFavAdapter;
    /* access modifiers changed from: private */
    public ArrayList<MyFavDTO> myFavDTOArrayList;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FregementMyAunctionFavBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fregement_my_aunction_fav, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        setUiAction();
        return this.binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    private void setUiAction() {
        this.layoutManager = new GridLayoutManager((Context) getActivity(), 2, 1, false);
        this.binding.rvMyfav.setLayoutManager(this.layoutManager);
        this.binding.swipeRefreshMyfav.setOnRefreshListener(this);
        this.binding.swipeRefreshMyfav.post(new Runnable() {
            public void run() {
                Log.e("Runnable", "FIRST");
                if (NetworkManager.isConnectToInternet(MyFav.this.getActivity())) {
                    MyFav.this.binding.swipeRefreshMyfav.setRefreshing(true);
                    MyFav.this.getMyFavourite();
                    return;
                }
                ProjectUtils.InternetAlertDialog(MyFav.this.getActivity());
            }
        });
    }

    /* access modifiers changed from: private */
    public void getMyFavourite() {
        new HttpsRequest(Const.GET_MYFAV, (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                MyFav.this.binding.swipeRefreshMyfav.setRefreshing(false);
                if (z) {
                    MyFav.this.myFavDTOArrayList = new ArrayList();
//                        MyFav.this.myFavDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<MyFavDTO>>() {
//                        }.getType());
                    MyFav.this.showData();
                } else {
                    MyFav.this.binding.tvNo.setVisibility(0);
                }
            }
        });
    }

    public void showData() {
        this.myFavAdapter = new MyFavAdapter(getActivity(), this.myFavDTOArrayList);
        this.binding.rvMyfav.setAdapter(this.myFavAdapter);
    }

    public void onRefresh() {
        getMyFavourite();
    }
}
