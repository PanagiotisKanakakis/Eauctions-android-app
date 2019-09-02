package com.subasta.activity.aution;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.adapter.PostAunctionAdapter;
import com.subasta.databinding.ActivityPostAuctionBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.interfaces.RecycleViewClickListner;
import com.subasta.model.CategoryDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;

//import com.facebook.share.internal.ShareConstants;

public class PostAuction extends AppCompatActivity {
    private static final String TAG = "com.subasta.activity.aution.PostAuction";
    CategoryDTO CategoryDTO;
    /* access modifiers changed from: private */
    public ArrayList<CategoryDTO> CategoryDTOArrayList;
    /* access modifiers changed from: private */
    public ActivityPostAuctionBinding binding;
    String category_id;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    RecycleViewClickListner listner;
    Context mContext;
    /* access modifiers changed from: private */
    public PostAunctionAdapter postAunctionAdapter;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivityPostAuctionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_post_auction);
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PostAuction.this.onBackPressed();
            }
        });
        getAllCategory();
    }

    private void getAllCategory() {
        new HttpsRequest(Const.GET_ALL_CATEGORY, this.mContext).stringGet(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        PostAuction.this.CategoryDTOArrayList = new ArrayList();
//                        PostAuction.this.CategoryDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<CategoryDTO>>() {
//                        }.getType());
                        PostAuction.this.layoutManager = new GridLayoutManager(PostAuction.this.mContext, 2, 1, false);
                        PostAuction.this.binding.customgrid.setHasFixedSize(true);
                        PostAuction.this.binding.customgrid.setLayoutManager(PostAuction.this.layoutManager);
                        PostAuction.this.postAunctionAdapter = new PostAunctionAdapter(PostAuction.this, PostAuction.this.CategoryDTOArrayList);
                        PostAuction.this.binding.customgrid.setAdapter(PostAuction.this.postAunctionAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(PostAuction.this.mContext, str);
                }
            }
        });
    }

    public void getCategoryid(int i) {
        this.CategoryDTO = (CategoryDTO) this.CategoryDTOArrayList.get(i);
        this.category_id = this.CategoryDTO.getCat_id();
        Intent intent = new Intent(this.mContext, AddAuction.class);
        intent.putExtra("cat_id", this.category_id);
        startActivity(intent);
    }
}
