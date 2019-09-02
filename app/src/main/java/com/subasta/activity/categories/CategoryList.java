package com.subasta.activity.categories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.FilterActivity;
import com.subasta.activity.SearchActivity;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.CategoryListAdapter;
import com.subasta.databinding.ActivityCategorylistBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.CategoryDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryList extends AppCompatActivity implements OnClickListener {
    ArrayList<CategoryDTO> CategoryDTOArrayList;
    private String TAG = CategoryList.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivityCategorylistBinding binding;
    CategoryListAdapter categoryListAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Context mContext;

    public void onClick(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityCategorylistBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_categorylist);
        this.mContext = this;
        setUIAction();
    }

    @SuppressLint("WrongConstant")
    private void setUIAction() {
        this.binding.iAHN.ivMenu.setVisibility(8);
        this.binding.iAHN.ivBack.setVisibility(0);
        this.binding.iAHN.tvtitlemain.setText("Categories");
        this.binding.iAHN.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(CategoryList.this.mContext, Dashboard.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("index", 0);
                CategoryList.this.startActivity(intent);
            }
        });
        this.binding.iAHN.ivFilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CategoryList.this.startActivity(new Intent(CategoryList.this.mContext, FilterActivity.class));
            }
        });
        this.binding.iAHN.ivSearch1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CategoryList.this.startActivity(new Intent(CategoryList.this.mContext, SearchActivity.class));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        getAllCategory();
        super.onResume();
    }

    private void getAllCategory() {
        new HttpsRequest(Const.GET_ALL_CATEGORY, this.mContext).stringGet(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        CategoryList.this.binding.recycleview1.setVisibility(0);
                        CategoryList.this.CategoryDTOArrayList = new ArrayList<>();
                        Type type = new TypeToken<List<CategoryDTO>>() {
                        }.getType();
//                        CategoryList.this.CategoryDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), type);
                        CategoryList.this.showData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(CategoryList.this.mContext, str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void showData() {
        this.layoutManager = new GridLayoutManager(this, 1);
        this.binding.recycleview1.setHasFixedSize(true);
        this.binding.recycleview1.setLayoutManager(this.layoutManager);
        this.categoryListAdapter = new CategoryListAdapter(this.mContext, this.CategoryDTOArrayList);
        this.binding.recycleview1.setAdapter(this.categoryListAdapter);
    }
}
