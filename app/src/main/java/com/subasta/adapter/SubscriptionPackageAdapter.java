package com.subasta.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.databinding.AdapterSubscriptionStandardBinding;
import com.subasta.fragment.dashboad.Subscription;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.SubscriptionPackageDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubscriptionPackageAdapter extends RecyclerView.Adapter<SubscriptionPackageAdapter.MyViewHolder> {
    private static final String TAG = "com.subasta.adapter.SubscriptionPackageAdapter";
    private AdapterSubscriptionStandardBinding binding;
    private int key;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    private HashMap<String, String> params = new HashMap<>();
    private int pos = -1;
    private SharedPrefrence prefrence;
    Subscription subscription;
    private ArrayList<SubscriptionPackageDTO> subscriptionpackageArrayList;
    private UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterSubscriptionStandardBinding binding;

        public MyViewHolder(AdapterSubscriptionStandardBinding adapterSubscriptionStandardBinding) {
            super(adapterSubscriptionStandardBinding.getRoot());
            this.binding = adapterSubscriptionStandardBinding;
        }
    }

    public SubscriptionPackageAdapter(Context context, ArrayList<SubscriptionPackageDTO> arrayList, Subscription subscription2, int i) {
        this.mContext = context;
        this.subscriptionpackageArrayList = arrayList;
        this.subscription = subscription2;
        this.key = i;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterSubscriptionStandardBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_subscription_standard, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    @RequiresApi(api = 23)
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        this.pos = i;
        myViewHolder.binding.tvstanderd.setText(((SubscriptionPackageDTO) this.subscriptionpackageArrayList.get(i)).getPackage_name());
        CustomTextView customTextView = myViewHolder.binding.tvprice;
        StringBuilder sb = new StringBuilder();
        sb.append(((SubscriptionPackageDTO) this.subscriptionpackageArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((SubscriptionPackageDTO) this.subscriptionpackageArrayList.get(i)).getPrice());
        customTextView.setText(sb.toString());
        CustomTextView customTextView2 = myViewHolder.binding.tvtotaldays;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((SubscriptionPackageDTO) this.subscriptionpackageArrayList.get(i)).getTotal_days());
        sb2.append(" Days");
        customTextView2.setText(sb2.toString());
        myViewHolder.binding.tvaunctioncount.setText(((SubscriptionPackageDTO) this.subscriptionpackageArrayList.get(i)).getAuction_count());
        this.params.put(Const.PACKAGE_PUB_ID, ((SubscriptionPackageDTO) this.subscriptionpackageArrayList.get(i)).getPackage_pub_id());
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        if (this.key == 123) {
            myViewHolder.binding.btnupgrade.setOnClickListener(new OnClickListener() {
                @SuppressLint("WrongConstant")
                public void onClick(View view) {
                    Toast.makeText(SubscriptionPackageAdapter.this.mContext, "You have already subscribed", 0).show();
                }
            });
        } else {
            myViewHolder.binding.btnupgrade.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    SubscriptionPackageAdapter.this.deleteDailog();
                }
            });
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) myViewHolder.binding.linerplan.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();
    }

    /* access modifiers changed from: private */
    public void deleteDailog() {
//        Builder builder = new Builder(this.mContext);
//        String str = "No";
//        builder.setMessage((CharSequence) "Do you want to subscribe this package ?").setTitle((int) C2037R.string.dialog_title).setCancelable(false).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                SubscriptionPackageAdapter.this.addSubscription();
//            }
//        }).setNegativeButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog create = builder.create();
//        create.setTitle(Const.APP_NAME);
//        create.show();
    }

    /* access modifiers changed from: private */
    public void addSubscription() {
        new HttpsRequest(Const.ADD_SUBSCRIBE, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ProjectUtils.showToast(SubscriptionPackageAdapter.this.mContext, str);
                    SubscriptionPackageAdapter.this.subscription.getCurrentSubHistory();
                    return;
                }
                ProjectUtils.showToast(SubscriptionPackageAdapter.this.mContext, str);
            }
        });
    }

    public int getItemCount() {
        return this.subscriptionpackageArrayList.size();
    }
}
