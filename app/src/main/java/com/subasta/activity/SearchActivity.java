package com.subasta.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.adapter.AutionAllAdapter;
import com.subasta.databinding.ActivitySearchBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AutionAllDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "com.subasta.activity.SearchActivity";
    private List<String> arrayList = new ArrayList();
    /* access modifiers changed from: private */
    public AutionAllAdapter autionAllAdapter;
    /* access modifiers changed from: private */
    public ArrayList<AutionAllDTO> autionAllDTOArrayList;
    /* access modifiers changed from: private */
    public ActivitySearchBinding binding;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public HashMap<String, String> params = new HashMap<>();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivitySearchBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_search);
        this.binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                try {
                    SearchActivity.this.params.put("search", str);
                    SearchActivity.this.getSearchAuctions();
                } catch (Exception unused) {
                }
                return false;
            }
        });
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SearchActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    public void getSearchAuctions() {
        new HttpsRequest(Const.GET_ALL_SEARCH, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    ProjectUtils.showToast(SearchActivity.this.mContext, str);
                    try {
                        SearchActivity.this.autionAllDTOArrayList = new ArrayList();
//                        SearchActivity.this.autionAllDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<AutionAllDTO>>() {
//                        }.getType());
                        SearchActivity.this.layoutManager = new GridLayoutManager(SearchActivity.this.mContext, 2, 1, false);
                        SearchActivity.this.binding.searchAuctionRecycle.setLayoutManager(SearchActivity.this.layoutManager);
                        SearchActivity.this.binding.searchAuctionRecycle.setHasFixedSize(true);
                        SearchActivity.this.autionAllAdapter = new AutionAllAdapter(SearchActivity.this, SearchActivity.this.autionAllDTOArrayList);
                        SearchActivity.this.binding.searchAuctionRecycle.setAdapter(SearchActivity.this.autionAllAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(SearchActivity.this.mContext, str);
                }
            }
        });
    }
}
