package com.subasta.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.activity.categories.CategoryList;
import com.subasta.adapter.FilterAdapter;
import com.subasta.databinding.ActivityFilterBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.CategoryDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;
import com.xw.repo.BubbleSeekBar;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterActivity extends AppCompatActivity implements OnSeekBarChangeListener {
    String MaxPrice;
    String MinPrice;
    int PLACE_PICKER_REQUEST = 6;
    private String TAG = CategoryList.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivityFilterBinding binding;
    String catName;
    private CategoryDTO categoryDTO;
    /* access modifiers changed from: private */
    public ArrayList<CategoryDTO> categoryDTOArrayList;
    String distance = "0";//AppEventsConstants.EVENT_PARAM_VALUE_NO;
    /* access modifiers changed from: private */
    public FilterAdapter filterAdapter;

    /* renamed from: id */
    String f1296id = "";
    private double lattitude;
    RecyclerView.LayoutManager layoutManager;
    private double longitude;
    /* access modifiers changed from: private */
    public Context mContext;
    TextView mProgressText;
    private String mTag;
    TextView mTrackingText;

    /* renamed from: p */
    float f1297p = 1.0f;
    private HashMap<String, String> params = new HashMap<>();
    String progress;
    private SharedPrefrence sharedPrefrence;
    private UserDTO userDTO;

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityFilterBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_filter);
        this.sharedPrefrence = SharedPrefrence.getInstance(this.mContext);
        this.mContext = this;
        this.f1296id = getIntent().getStringExtra("cat_id");
        this.binding.bsbFilter.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                FilterActivity.this.distance = String.valueOf(progress);

            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });
        this.binding.Applyfilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FilterActivity.this.setparamter();
            }
        });
        this.binding.clearfilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FilterActivity.this.binding.MaxPrice.getText().clear();
                FilterActivity.this.binding.MinPrice.getText().clear();
                FilterActivity filterActivity = FilterActivity.this;
//                filterActivity.distance = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                filterActivity.binding.bsbFilter.setProgress(0.0f);
                FilterActivity.this.binding.recycleview1.setAdapter(FilterActivity.this.filterAdapter);
            }
        });
        this.binding.ivBackFilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FilterActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setparamter() {
        Intent intent = new Intent(this.mContext, CategoryBasedAdsAuction.class);
        if (!this.binding.MaxPrice.getText().toString().isEmpty() && !this.binding.MinPrice.getText().toString().isEmpty()) {
            intent.putExtra(Const.MAX_ID, this.binding.MaxPrice.getText().toString());
            intent.putExtra(Const.MIN_ID, this.binding.MinPrice.getText().toString());
        }
        intent.putExtra("cat_id", this.f1296id);
        intent.putExtra(Const.CAT_TITLE, this.catName);
        intent.putExtra(Const.DISTANCE_ID, this.distance);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public void setUIAction() {
        this.layoutManager = new GridLayoutManager(this, 5);
        this.binding.recycleview1.setHasFixedSize(true);
        this.binding.recycleview1.setLayoutManager(this.layoutManager);
        this.filterAdapter = new FilterAdapter(this, this.categoryDTOArrayList);
        this.binding.recycleview1.setAdapter(this.filterAdapter);
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
                        FilterActivity.this.binding.recycleview1.setVisibility(0);
                        FilterActivity.this.categoryDTOArrayList = new ArrayList();
//                        FilterActivity.this.categoryDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<CategoryDTO>>() {
//                        }.getType());
                        FilterActivity.this.setUIAction();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(FilterActivity.this.mContext, str);
                }
            }
        });
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.mTrackingText.setText(getString(C2037R.string.seekbar_tracking_on));
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.mTrackingText.setText(getString(C2037R.string.seekbar_tracking_off));
    }

    public void getGetId(String str) {
        this.f1296id = str;
    }

    public void getName(String str) {
        this.catName = str;
        this.binding.tvtitle3.setText(this.catName);
    }
}
