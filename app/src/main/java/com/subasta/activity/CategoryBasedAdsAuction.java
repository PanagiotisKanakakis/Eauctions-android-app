package com.subasta.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.activity.aution.AutionAll;
import com.subasta.activity.aution.PostAuction;
import com.subasta.adapter.AdvertiseAdapterDashboard;
import com.subasta.adapter.AutionAllAdapter;
import com.subasta.adapter.FilterAunctionsAdapter;
import com.subasta.databinding.ActivityCategoryBasedAdsAuctionBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AdvertiseDTO;
import com.subasta.model.AutionAllDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import com.facebook.appevents.AppEventsConstants;
//import com.facebook.share.internal.ShareConstants;

public class CategoryBasedAdsAuction extends AppCompatActivity implements OnClickListener {
    private String TAG = CategoryBasedAdsAuction.class.getCanonicalName();
    private AdvertiseAdapterDashboard advertiseAdapterDashboard;
    private ArrayList<AdvertiseDTO> advertiseDTOList;
    /* access modifiers changed from: private */
    public AutionAllAdapter autionAllAdapter;
    /* access modifiers changed from: private */
    public ActivityCategoryBasedAdsAuctionBinding binding;
    private String catName;
    private String catid;
    private ImageView filer;
    private FilterAunctionsAdapter filterAunctionsAdapter;
    /* access modifiers changed from: private */
    public ArrayList<AutionAllDTO> filterDTOArrayList;
    private ImageView ivback;
    private ImageView ivmenu;
    String lattitude;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerView.LayoutManager linearLayoutManager2;
    String longitude;
    /* access modifiers changed from: private */
    public Context mContext;
    private String maxPrice;
    private String minPrice;
    private View navHeader;
    private String progress;
    private ImageView search;
    private SharedPrefrence sharedPrefrence;
    private TextView title;
    private UserDTO userDTO;

    public CategoryBasedAdsAuction() {
        String str = "";
        this.lattitude = str;
        this.longitude = str;
    }

    /* access modifiers changed from: protected */
    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityCategoryBasedAdsAuctionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_category_based_ads_auction);
        this.mContext = this;
        this.sharedPrefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        this.catid = getIntent().getStringExtra("cat_id");
        this.maxPrice = getIntent().getStringExtra(Const.MAX_ID);
        this.minPrice = getIntent().getStringExtra(Const.MIN_ID);
        this.progress = getIntent().getStringExtra(Const.DISTANCE_ID);
        this.catName = getIntent().getStringExtra(Const.CAT_TITLE);
//        this.binding.fabPostAuctionCat.setOnClickListener(this);
        this.binding.tvViewMore.setOnClickListener(this);
        this.navHeader = findViewById(C2037R.C2039id.iAHN);
        this.ivmenu = (ImageView) this.navHeader.findViewById(C2037R.C2039id.ivMenu);
        this.search = (ImageView) this.navHeader.findViewById(C2037R.C2039id.ivSearch1);
        this.filer = (ImageView) this.navHeader.findViewById(C2037R.C2039id.ivFilter);
        this.ivback = (ImageView) this.navHeader.findViewById(C2037R.C2039id.ivBack);
        this.title = (TextView) this.navHeader.findViewById(C2037R.C2039id.tvtitlemain);
        this.ivmenu.setVisibility(8);
        this.ivback.setVisibility(0);
        this.search.setVisibility(8);
        this.filer.setVisibility(8);
        this.ivback.setOnClickListener(this);
        this.title.setVisibility(0);
        this.title.setText(this.catName);
        this.binding.chatSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                try {
                    CategoryBasedAdsAuction.this.autionAllAdapter.filter(str);
                } catch (Exception unused) {
                }
                return false;
            }
        });
        this.search.setOnClickListener(this);
        this.filer.setOnClickListener(this);
        getAllFilterAunction();
    }

    private void getAllFilterAunction() {
        new HttpsRequest("getAllAuctions", (Map<String, String>) getfilterdetail(), this.mContext).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    try {
                        CategoryBasedAdsAuction.this.filterDTOArrayList = new ArrayList();
//                        CategoryBasedAdsAuction.this.filterDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<AutionAllDTO>>() {
//                        }.getType());
                        CategoryBasedAdsAuction.this.linearLayoutManager = new GridLayoutManager(CategoryBasedAdsAuction.this.mContext, 2, 1, false);
                        CategoryBasedAdsAuction.this.binding.rvAuction.setLayoutManager(CategoryBasedAdsAuction.this.linearLayoutManager);
                        CategoryBasedAdsAuction.this.autionAllAdapter = new AutionAllAdapter(CategoryBasedAdsAuction.this.mContext, CategoryBasedAdsAuction.this.filterDTOArrayList);
                        CategoryBasedAdsAuction.this.binding.rvAuction.setAdapter(CategoryBasedAdsAuction.this.autionAllAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    CategoryBasedAdsAuction.this.binding.tvNo.setVisibility(0);
                    CategoryBasedAdsAuction.this.binding.rlAllAuc.setVisibility(8);
//                    CategoryBasedAdsAuction.this.binding.fabPostAuctionCat.setVisibility(8);
                    CategoryBasedAdsAuction.this.binding.chatSearch.setVisibility(8);
                }
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.fab_PostAuctionCat /*2131362077*/:
                startActivity(new Intent(this.mContext, PostAuction.class));
                overridePendingTransition(C2037R.anim.anim_slide_in_left, C2037R.anim.anim_slide_out_left);
                return;
            case C2037R.C2039id.ivBack /*2131362135*/:
                finish();
                return;
            case C2037R.C2039id.ivFilter /*2131362147*/:
                startActivity(new Intent(this, FilterActivity.class));
                return;
            case C2037R.C2039id.ivSearch1 /*2131362161*/:
                startActivity(new Intent(this, SearchActivity.class));
                return;
            case C2037R.C2039id.tvViewMore /*2131362521*/:
                startActivity(new Intent(this, AutionAll.class));
                return;
            default:
                return;
        }
    }

    private HashMap<String, String> getfilterdetail() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        hashMap.put("cat_id", this.catid);
        String str = this.maxPrice;
        if (!(str == null || this.minPrice == null)) {
            hashMap.put(Const.MAX_ID, str);
            hashMap.put(Const.MIN_ID, this.minPrice);
        }
        String str2 = this.progress;
//        if (str2 != null && !str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//            hashMap.put(Const.DISTANCE_ID, this.progress);
//            String str3 = "longitude";
//            hashMap.put(str3, this.sharedPrefrence.getValue(str3));
//            String str4 = "latitude";
//            hashMap.put(str4, this.sharedPrefrence.getValue(str4));
//        }
        Log.e("getfilterdetail", hashMap.toString());
        return hashMap;
    }
}
