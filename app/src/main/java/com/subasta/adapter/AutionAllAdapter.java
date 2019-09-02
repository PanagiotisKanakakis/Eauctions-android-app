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
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class AutionAllAdapter extends RecyclerView.Adapter<AutionAllAdapter.MyViewHolder> {
    private static final String TAG = "com.subasta.adapter.AutionAllAdapter";
    private ArrayList<AutionAllDTO> autionAllDTOArrayList;
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
    public ArrayList<AutionAllDTO> object;
    /* access modifiers changed from: private */
    public HashMap<String, String> paramsAddBid = new HashMap<>();
    int pos = -1;
    private SharedPrefrence prefrence;
    String proPrice;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemAutionAllBinding binding;

        public MyViewHolder(AdapterItemAutionAllBinding adapterItemAutionAllBinding) {
            super(adapterItemAutionAllBinding.getRoot());
            this.binding = adapterItemAutionAllBinding;
        }
    }

    public AutionAllAdapter(Context context, ArrayList<AutionAllDTO> arrayList) {
        this.mContext = context;
        this.object = arrayList;
        this.autionAllDTOArrayList = new ArrayList<>();
        this.autionAllDTOArrayList.addAll(arrayList);
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterItemAutionAllBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_aution_all, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        this.pos = i;
        myViewHolder.binding.tvProductname.setText(ProjectUtils.capWordFirstLetter(((AutionAllDTO) this.object.get(i)).getTitle()));
        myViewHolder.binding.tvAddress.setText(((AutionAllDTO) this.object.get(i)).getAddress());
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(((AutionAllDTO) this.object.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((AutionAllDTO) this.object.get(i)).getPrice());
        customTextViewBold.setText(sb.toString());
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((ImageDTO) ((AutionAllDTO) this.object.get(i)).getImage_cust().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.image);
        } catch (Exception unused) {
        }
//        myViewHolder.binding.ivbid.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                AutionAllAdapter.this.dialogbox_add_bid(i);
//            }
//        });
        myViewHolder.binding.image.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AutionAllAdapter.this.mContext, ViewAuction.class);
                intent.putExtra(Const.Pro_pub_id, ((AutionAllDTO) AutionAllAdapter.this.object.get(i)).getPro_pub_id());
                intent.putExtra(Const.CAT_TITLE, ((AutionAllDTO) AutionAllAdapter.this.object.get(i)).getTitle());
                AutionAllAdapter.this.mContext.startActivity(intent);
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
        customTextViewBold2.setText(((AutionAllDTO) this.object.get(i)).getPrice());
        customTextViewBold.setText(((AutionAllDTO) this.object.get(i)).getTitle());
        this.btnAddBid.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AutionAllAdapter autionAllAdapter = AutionAllAdapter.this;
                autionAllAdapter.proPrice = autionAllAdapter.etBidPrice.getText().toString();
                AutionAllAdapter.this.paramsAddBid.put(Const.Pro_pub_id, ((AutionAllDTO) AutionAllAdapter.this.object.get(i)).getPro_pub_id());
                AutionAllAdapter.this.paramsAddBid.put(Const.USER_PUB_ID, AutionAllAdapter.this.userDTO.getUser_pub_id());
                AutionAllAdapter.this.paramsAddBid.put("price", AutionAllAdapter.this.proPrice);
                AutionAllAdapter.this.setData();
                AutionAllAdapter.this.dialogbox_add_bid.dismiss();
            }
        });
        this.ivClose.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AutionAllAdapter.this.dialogbox_add_bid.dismiss();
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
                    AutionAllAdapter.this.object.remove(AutionAllAdapter.this.pos);
                    AutionAllAdapter.this.notifyDataSetChanged();
                    Toast.makeText(AutionAllAdapter.this.mContext, "successs", 0).show();
                    return;
                }
                ProjectUtils.showToast(AutionAllAdapter.this.mContext, str);
            }
        });
    }

    public int getItemCount() {
        return this.object.size();
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.object.clear();
        if (lowerCase.length() == 0) {
            this.object.addAll(this.autionAllDTOArrayList);
        } else {
            Iterator it = this.autionAllDTOArrayList.iterator();
            while (it.hasNext()) {
                AutionAllDTO autionAllDTO = (AutionAllDTO) it.next();
                if (autionAllDTO.getTitle().toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.object.add(autionAllDTO);
                }
            }
        }
        notifyDataSetChanged();
    }
}
