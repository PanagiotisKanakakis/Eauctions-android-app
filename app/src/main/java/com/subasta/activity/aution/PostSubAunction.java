package com.subasta.activity.aution;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.adapter.SubCategoryAdapter;
import com.subasta.databinding.ActivityPostSubAunctionBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.SubBrandsDTO;
import com.subasta.model.SubCategoryDTO;
import com.subasta.model.SubModelDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostSubAunction extends AppCompatActivity {
    private String TAG = PostSubAunction.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivityPostSubAunctionBinding binding;
    private String brandId;
    private String catgoryName;
    private String catid;
    private boolean isSpinnerInitial = false;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    private String modelid;
    private HashMap<String, String> param;
    private ArrayAdapter<SubBrandsDTO> subBrandsDTOArrayAdapter;
    private ArrayList<SubBrandsDTO> subBrandsDTOArrayList;
    /* access modifiers changed from: private */
    public SubCategoryAdapter subCategoryAdapter;
    private SubCategoryDTO subCategoryDTO;
    private ArrayAdapter<SubCategoryDTO> subCategoryDTOArrayAdapter;
    /* access modifiers changed from: private */
    public ArrayList<SubCategoryDTO> subCategoryDTOArrayList;
    private String subCatid;
    private ArrayAdapter<SubModelDTO> subModelDTOArrayAdapter;
    private ArrayList<SubModelDTO> subModelDTOArrayList;

    public PostSubAunction() {
        String str = "";
        this.catid = str;
        this.subCatid = str;
        this.brandId = str;
        this.modelid = str;
        this.param = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivityPostSubAunctionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_post_sub_aunction);
        String str = "cat_id";
        this.catid = getIntent().getStringExtra(str);
        this.catgoryName = getIntent().getStringExtra(Const.CAT_TITLE);
        this.binding.tvCategoryName.setText(this.catgoryName);
        this.param.put(str, this.catid);
        this.binding.icBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PostSubAunction.this.onBackPressed();
            }
        });
        setSubcategory();
    }

    private void setSubcategory() {
        new HttpsRequest(Const.GET_All_SUB_CATEGORY, (Map<String, String>) this.param, this.mContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        PostSubAunction.this.subCategoryDTOArrayList = new ArrayList();
//                        PostSubAunction.this.subCategoryDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<SubCategoryDTO>>() {
//                        }.getType());
                        PostSubAunction.this.layoutManager = new LinearLayoutManager(PostSubAunction.this.mContext, 1, false);
                        PostSubAunction.this.binding.rvSubCategory.setLayoutManager(PostSubAunction.this.layoutManager);
                        PostSubAunction.this.subCategoryAdapter = new SubCategoryAdapter(PostSubAunction.this.mContext, PostSubAunction.this.subCategoryDTOArrayList);
                        PostSubAunction.this.binding.rvSubCategory.setAdapter(PostSubAunction.this.subCategoryAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(PostSubAunction.this.mContext, str);
                }
            }
        });
    }
}
