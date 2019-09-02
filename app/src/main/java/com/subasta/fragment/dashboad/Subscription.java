package com.subasta.fragment.dashboad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.SubscriptionPackageAdapter;
import com.subasta.databinding.ActivitySubscriptionPackageBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.CurrentSubDTO;
import com.subasta.model.SubscriptionPackageDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class Subscription extends Fragment implements OnClickListener {
    private String TAG = Subscription.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivitySubscriptionPackageBinding binding;
    private Button btnupgrade;
    /* access modifiers changed from: private */
    public CurrentSubDTO currentSubDTO;
    private Dashboard dashboard;
    /* access modifiers changed from: private */
    public int key;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public SubscriptionPackageAdapter subscriptionPackageAdapter;
    /* access modifiers changed from: private */
    public ArrayList<SubscriptionPackageDTO> subscriptionpackageArrayList;
    String thisDate;
    private UserDTO userDTO;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.dashboard = (Dashboard) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.binding = (ActivitySubscriptionPackageBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.activity_subscription_package, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.thisDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        getCurrentSubHistory();
        getAllsubpackage();
        return this.binding.getRoot();
    }

    private void getAllsubpackage() {
        new HttpsRequest(Const.GET_All_SUBSCRIPTION_PACKAGE, getActivity()).stringGet(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        Subscription.this.subscriptionpackageArrayList = new ArrayList();
//                        Subscription.this.subscriptionpackageArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<SubscriptionPackageDTO>>() {
//                        }.getType());
                        Subscription.this.layoutManager = new LinearLayoutManager(Subscription.this.getActivity(), 0, false);
                        Subscription.this.binding.rvplans.setLayoutManager(Subscription.this.layoutManager);
                        Subscription.this.binding.rvplans.setHasFixedSize(true);
                        Subscription.this.subscriptionPackageAdapter = new SubscriptionPackageAdapter(Subscription.this.getActivity(), Subscription.this.subscriptionpackageArrayList, Subscription.this, Subscription.this.key);
                        Subscription.this.binding.rvplans.setAdapter(Subscription.this.subscriptionPackageAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Subscription.this.binding.noPackage.setVisibility(0);
                    ProjectUtils.showToast(Subscription.this.getActivity(), str);
                }
            }
        });
    }

    public void getCurrentSubHistory() {
        new HttpsRequest("current_subscription", (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    Subscription.this.key = 123;
                    try {
                        Subscription.this.binding.linear.setVisibility(0);
//                        Subscription.this.currentSubDTO = (CurrentSubDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), CurrentSubDTO.class);
                        Subscription.this.showData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Subscription.this.key = 456;
                    Subscription.this.binding.linear.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void showData() {
        this.binding.pkgName.setText(this.currentSubDTO.getPackage_name());
        this.binding.aunctionCount.setText(this.currentSubDTO.getAuction_count());
        CustomTextViewBold customTextViewBold = this.binding.price;
        StringBuilder sb = new StringBuilder();
        sb.append(this.currentSubDTO.getCurrency_code());
        sb.append(" ");
        sb.append(this.currentSubDTO.getTotal_price());
        customTextViewBold.setText(sb.toString());
        CustomTextView customTextView = this.binding.date;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Validity -");
        sb2.append(ProjectUtils.changeDateFormate(this.currentSubDTO.getStart_date()));
        sb2.append("  to  ");
        sb2.append(ProjectUtils.changeDateFormate(this.currentSubDTO.getEnd_date()));
        customTextView.setText(sb2.toString());
        if (this.currentSubDTO.getEnd_date().matches(this.thisDate)) {
            this.binding.status.setBackground(C2037R.C2038drawable.button_red);
        } else {
            this.binding.status.setBackground(C2037R.C2038drawable.button_normal_green);
        }
        getAllsubpackage();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onDetach() {
        super.onDetach();
        this.dashboard = null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        getCurrentSubHistory();
        getAllsubpackage();
    }

    public void onClick(View view) {
        view.getId();
    }
}
