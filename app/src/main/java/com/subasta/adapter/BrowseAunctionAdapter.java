package com.subasta.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.aution.ViewAuction;
import com.subasta.databinding.AdapterItemAutionAllBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AutionAllDTO;
import com.subasta.model.ImageDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BrowseAunctionAdapter extends RecyclerView.Adapter<BrowseAunctionAdapter.MyViewHolder> {
    private static final String TAG = AutionAllAdapter.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ArrayList<AutionAllDTO> allDTOArrayList;
    TextView bidprice;
    private AdapterItemAutionAllBinding binding;
    Button btnAddBid;
    /* access modifiers changed from: private */
    public Dialog dialogbox_add_bid;
    EditText etBidPrice;
    ImageView ivClose;
    private LayoutInflater layoutInflater;
    private final int limit = 4;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public HashMap<String, String> paramsAddBid = new HashMap<>();
    int pos = -1;
    private SharedPrefrence prefrence;
    String proPrice;
    private String tag;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemAutionAllBinding binding;

        public MyViewHolder(AdapterItemAutionAllBinding adapterItemAutionAllBinding) {
            super(adapterItemAutionAllBinding.getRoot());
            this.binding = adapterItemAutionAllBinding;
        }
    }

    public BrowseAunctionAdapter(Context context, ArrayList<AutionAllDTO> arrayList, String str) {
        this.tag = str;
        this.mContext = context;
        this.allDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterItemAutionAllBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_aution_all, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        this.pos = i;
        myViewHolder.binding.tvProductname.setText(ProjectUtils.capWordFirstLetter(((AutionAllDTO) this.allDTOArrayList.get(i)).getTitle()));
        myViewHolder.binding.tvAddress.setText(((AutionAllDTO) this.allDTOArrayList.get(i)).getAddress());
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(((AutionAllDTO) this.allDTOArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((AutionAllDTO) this.allDTOArrayList.get(i)).getPrice());
        customTextViewBold.setText(sb.toString());
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((ImageDTO) ((AutionAllDTO) this.allDTOArrayList.get(i)).getImage_cust().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.image);
        } catch (Exception unused) {
        }
//        myViewHolder.binding.ivbid.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                BrowseAunctionAdapter.this.dialogbox_add_bid(i);
//            }
//        });
        myViewHolder.binding.image.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BrowseAunctionAdapter.this.mContext, ViewAuction.class);
                intent.putExtra(Const.Pro_pub_id, ((AutionAllDTO) BrowseAunctionAdapter.this.allDTOArrayList.get(i)).getPro_pub_id());
                intent.putExtra(Const.CAT_TITLE, ((AutionAllDTO) BrowseAunctionAdapter.this.allDTOArrayList.get(i)).getTitle());
                BrowseAunctionAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: private */
    public void dialogbox_add_bid(final int i) {
        this.dialogbox_add_bid = new Dialog(this.mContext);
        this.dialogbox_add_bid.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialogbox_add_bid.requestWindowFeature(1);
        this.dialogbox_add_bid.setContentView(C2037R.layout.activity_add_bid);
        this.etBidPrice = (EditText) this.dialogbox_add_bid.findViewById(C2037R.C2039id.etBidPrice);
        this.btnAddBid = (Button) this.dialogbox_add_bid.findViewById(C2037R.C2039id.btnAddBid);
        CustomTextViewBold customTextViewBold = (CustomTextViewBold) this.dialogbox_add_bid.findViewById(C2037R.C2039id.tvBidProductname);
        CustomTextViewBold customTextViewBold2 = (CustomTextViewBold) this.dialogbox_add_bid.findViewById(C2037R.C2039id.tvBidProductprice);
        this.ivClose = (ImageView) this.dialogbox_add_bid.findViewById(C2037R.C2039id.ivClose);
        this.dialogbox_add_bid.show();
        this.dialogbox_add_bid.setCancelable(true);
        StringBuilder sb = new StringBuilder();
        sb.append(((AutionAllDTO) this.allDTOArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((AutionAllDTO) this.allDTOArrayList.get(i)).getPrice());
        customTextViewBold2.setText(sb.toString());
        customTextViewBold.setText(((AutionAllDTO) this.allDTOArrayList.get(i)).getTitle());
        this.btnAddBid.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BrowseAunctionAdapter browseAunctionAdapter = BrowseAunctionAdapter.this;
                browseAunctionAdapter.proPrice = browseAunctionAdapter.etBidPrice.getText().toString();
//                if (!BrowseAunctionAdapter.this.proPrice.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//                    BrowseAunctionAdapter.this.paramsAddBid.put(Const.Pro_pub_id, ((AutionAllDTO) BrowseAunctionAdapter.this.allDTOArrayList.get(i)).getPro_pub_id());
//                    BrowseAunctionAdapter.this.paramsAddBid.put(Const.USER_PUB_ID, BrowseAunctionAdapter.this.userDTO.getUser_pub_id());
//                    BrowseAunctionAdapter.this.paramsAddBid.put("price", BrowseAunctionAdapter.this.proPrice);
//                    BrowseAunctionAdapter.this.setData();
//                    return;
//                }
                ProjectUtils.showToast(BrowseAunctionAdapter.this.mContext, BrowseAunctionAdapter.this.mContext.getResources().getString(C2037R.string.valid_bid));
            }
        });
        this.ivClose.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BrowseAunctionAdapter.this.dialogbox_add_bid.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setData() {
        new HttpsRequest(Const.ADD_BID, (Map<String, String>) this.paramsAddBid, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    BrowseAunctionAdapter.this.allDTOArrayList.remove(BrowseAunctionAdapter.this.pos);
                    BrowseAunctionAdapter.this.notifyDataSetChanged();
                    BrowseAunctionAdapter.this.dialogbox_add_bid.dismiss();
                    Toast.makeText(BrowseAunctionAdapter.this.mContext, "successs", 0).show();
                    return;
                }
                ProjectUtils.showToast(BrowseAunctionAdapter.this.mContext, str);
            }
        });
    }

    public int getItemCount() {
//        if (this.tag.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
//            return Math.min(this.allDTOArrayList.size(), 4);
//        }
        return this.allDTOArrayList.size();
    }
}
