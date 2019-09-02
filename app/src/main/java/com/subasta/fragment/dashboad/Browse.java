package com.subasta.fragment.dashboad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.subasta.C2037R;
import com.subasta.activity.aution.AutionAll;
import com.subasta.activity.aution.PostAuction;
import com.subasta.activity.categories.CategoryList;
import com.subasta.adapter.AdvertiseAdapter;
import com.subasta.adapter.BrowseAunctionAdapter;
import com.subasta.adapter.CategoryAdapter;
import com.subasta.adapter.FilterAunctionsAdapter;
import com.subasta.databinding.FragmentBrowseBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AdvertiseAllDTO;
import com.subasta.model.AutionAllDTO;
import com.subasta.model.CategoryDTO;
import com.subasta.model.FilterDTO;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Browse extends Fragment implements OnClickListener {
    private String TAG = Browse.class.getCanonicalName();
    private AdvertiseAdapter advertiseAdapterDashboard;
    private ArrayList<AdvertiseAllDTO> advertiseDTOList;
    /* access modifiers changed from: private */
    public ArrayList<AutionAllDTO> allDTOArrayList;
    /* access modifiers changed from: private */
    public BrowseAunctionAdapter autionAllAdapter;
    /* access modifiers changed from: private */
    public FragmentBrowseBinding binding;
    /* access modifiers changed from: private */
    public CategoryAdapter categoryAdapter;
    /* access modifiers changed from: private */
    public ArrayList<CategoryDTO> categoryDTOList;
    private FilterAunctionsAdapter filterAdapter;
    private ArrayList<FilterDTO> filterDTOArrayList;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager2;
    private LinearLayoutManager linearLayoutManager3;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FragmentBrowseBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fragment_browse, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        setUiAction();
        return this.binding.getRoot();
    }

    @SuppressLint("WrongConstant")
    public void setUiAction() {
        this.binding.llDisc.setOnClickListener(this);
        this.binding.btnViewAllAuc.setOnClickListener(this);
        this.binding.fabPostAuction.setOnClickListener(this);
        this.linearLayoutManager = new LinearLayoutManager(getActivity(), 0, false);
        this.linearLayoutManager2 = new GridLayoutManager((Context) getActivity(), 2, 1, false);
        this.binding.rvAuction.setHasFixedSize(true);
        this.binding.rvAuction.setLayoutManager(this.linearLayoutManager2);
        this.linearLayoutManager3 = new LinearLayoutManager(getActivity(), 0, false);
        this.binding.rvChosse.setLayoutManager(this.linearLayoutManager3);
        if (NetworkManager.isConnectToInternet(getActivity())) {
            getAuctionList();
            getCategoryList();
            return;
        }
        ProjectUtils.InternetAlertDialog(getActivity());
    }

    public void onResume() {
        super.onResume();
    }

    public void getAuctionList() {
        new HttpsRequest("getAllAuctions", (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    Browse.this.allDTOArrayList = new ArrayList();
//                        Browse.this.allDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<AutionAllDTO>>() {
//                        }.getType());
//                        Browse.this.autionAllAdapter = new BrowseAunctionAdapter(Browse.this.getActivity(), Browse.this.allDTOArrayList, AppEventsConstants.EVENT_PARAM_VALUE_YES);
//                        Browse.this.binding.rvAuction.setAdapter(Browse.this.autionAllAdapter);
                    Browse.this.binding.ftvNoAuction.setVisibility(8);
                } else {
                    ProjectUtils.showToast(Browse.this.getActivity(), str);
                    Browse.this.binding.ftvNoAuction.setVisibility(0);
                }
            }
        });
    }

    public void getCategoryList() {
        new HttpsRequest(Const.GET_ALL_CATEGORY, getActivity()).stringGet(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    Browse.this.categoryDTOList = new ArrayList();
//                        Browse.this.categoryDTOList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<CategoryDTO>>() {
//                        }.getType());
                    Browse.this.categoryAdapter = new CategoryAdapter(Browse.this.getActivity(), Browse.this.categoryDTOList);
//                        Browse.this.binding.rvChosse.setAdapter(Browse.this.categoryAdapter);
                } else {
                    ProjectUtils.showToast(Browse.this.getActivity(), str);
                }
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C2037R.C2039id.btn_ViewAllAuc) {
            startActivity(new Intent(getActivity(), AutionAll.class));
            getActivity().overridePendingTransition(C2037R.anim.anim_slide_in_left, C2037R.anim.anim_slide_out_left);
        } else if (id == C2037R.C2039id.fab_PostAuction) {
            startActivity(new Intent(getActivity(), PostAuction.class));
            getActivity().overridePendingTransition(C2037R.anim.anim_slide_in_left, C2037R.anim.anim_slide_out_left);
        } else if (id == C2037R.C2039id.llDisc) {
            startActivity(new Intent(getActivity(), CategoryList.class));
            getActivity().overridePendingTransition(C2037R.anim.anim_slide_in_left, C2037R.anim.anim_slide_out_left);
        }
    }
}
