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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.aution.ViewAuction;
import com.subasta.databinding.AdapterItemMyBidsBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AuncitonImageDTO;
import com.subasta.model.MyBidDTO;
import com.subasta.model.UserDTO;
import com.subasta.myauctionfregment.MyAds;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyBidAdapter extends RecyclerView.Adapter<MyBidAdapter.MyViewHolder> {
    private static final String TAG = "com.subasta.adapter.MyBidAdapter";
    private AdapterItemMyBidsBinding binding;
    /* access modifiers changed from: private */
    public ArrayList<MyBidDTO> getAllBidDTOArrayList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    MyAds myAds;
    /* access modifiers changed from: private */
    public HashMap<String, String> params = new HashMap<>();
    /* access modifiers changed from: private */
    public HashMap<String, String> paramsAddBid = new HashMap<>();
    /* access modifiers changed from: private */
    public int pos = -1;
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemMyBidsBinding binding;

        public MyViewHolder(@NonNull AdapterItemMyBidsBinding adapterItemMyBidsBinding) {
            super(adapterItemMyBidsBinding.getRoot());
            this.binding = adapterItemMyBidsBinding;
        }
    }

    public MyBidAdapter(Context context, ArrayList<MyBidDTO> arrayList, MyAds myAds2) {
        this.mContext = context;
        this.getAllBidDTOArrayList = arrayList;
        this.myAds = myAds2;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterItemMyBidsBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_my_bids, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.binding.tvProductname.setText(ProjectUtils.capWordFirstLetter(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getTitle()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvAuctionPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getCurrency_code());
        String str = " ";
        sb.append(str);
        sb.append(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getAuction_price());
        customTextViewBold.setText(sb.toString());
        myViewHolder.binding.tvMinBidTxt.setText(ProjectUtils.changeDateFormate(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getCreated_at()));
        CustomTextViewBold customTextViewBold2 = myViewHolder.binding.tvPrice;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getCurrency_code());
        sb2.append(str);
        sb2.append(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getPrice());
        customTextViewBold2.setText(sb2.toString());
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AuncitonImageDTO) ((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getImage_cust().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.image);
        } catch (Exception unused) {
        }
        myViewHolder.binding.btnEdit.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MyBidAdapter.this.dialogbox_add_bid(i);
            }
        });
        myViewHolder.binding.btnDelete.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MyBidAdapter.this.pos = i;
                MyBidAdapter.this.params.put(Const.BID_PUB_ID, ((MyBidDTO) MyBidAdapter.this.getAllBidDTOArrayList.get(i)).getBid_pub_id());
                MyBidAdapter.this.deleteDailog();
            }
        });
        myViewHolder.binding.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyBidAdapter.this.mContext, ViewAuction.class);
                intent.putExtra(Const.Pro_pub_id, ((MyBidDTO) MyBidAdapter.this.getAllBidDTOArrayList.get(i)).getPro_pub_id());
                MyBidAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteDailog() {
//        Builder builder = new Builder(this.mContext);
//        String str = "No";
//        builder.setMessage((CharSequence) "Do you want to delete this bid?").setTitle((int) C2037R.string.dialog_title).setCancelable(false).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                MyBidAdapter.this.deleteBidAunctions();
//            }
//        }).setNegativeButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog create = builder.create();
//        create.setTitle("Delete bid.");
//        create.setIcon((int) C2037R.C2038drawable.ic_deleteauction);
//        create.show();
    }

    /* access modifiers changed from: private */
    public void deleteBidAunctions() {
        new HttpsRequest(Const.DELETE_BID, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    MyBidAdapter.this.getAllBidDTOArrayList.remove(MyBidAdapter.this.pos);
                    MyBidAdapter.this.notifyDataSetChanged();
                    Toast.makeText(MyBidAdapter.this.mContext, str, 0).show();
                }
            }
        });
    }

    public int getItemCount() {
        return this.getAllBidDTOArrayList.size();
    }

    /* access modifiers changed from: private */
    public void dialogbox_add_bid(final int i) {
        final Dialog dialog = new Dialog(this.mContext);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.requestWindowFeature(1);
        dialog.setContentView(C2037R.layout.activity_add_bid);
        final CustomEditText customEditText = (CustomEditText) dialog.findViewById(C2037R.C2039id.etBidPrice);
        Button button = (Button) dialog.findViewById(C2037R.C2039id.btnAddBid);
        CustomTextViewBold customTextViewBold = (CustomTextViewBold) dialog.findViewById(C2037R.C2039id.tvBidProductname);
        CustomTextViewBold customTextViewBold2 = (CustomTextViewBold) dialog.findViewById(C2037R.C2039id.tvBidProductprice);
        ImageView imageView = (ImageView) dialog.findViewById(C2037R.C2039id.ivClose);
        dialog.show();
        dialog.setCancelable(true);
        button.setText(this.mContext.getResources().getString(C2037R.string.update_bid));
        StringBuilder sb = new StringBuilder();
        sb.append(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getAuction_price());
        customTextViewBold2.setText(sb.toString());
        customTextViewBold.setText(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getTitle());
        customEditText.setText(((MyBidDTO) this.getAllBidDTOArrayList.get(i)).getPrice());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
//                if (!customEditText.getText().toString().trim().startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//                    MyBidAdapter.this.paramsAddBid = new HashMap();
//                    MyBidAdapter.this.paramsAddBid.put("price", customEditText.getText().toString().trim());
//                    MyBidAdapter.this.paramsAddBid.put(Const.USER_PUB_ID, MyBidAdapter.this.userDTO.getUser_pub_id());
//                    MyBidAdapter.this.paramsAddBid.put(Const.Pro_pub_id, ((MyBidDTO) MyBidAdapter.this.getAllBidDTOArrayList.get(i)).getPro_pub_id());
//                    MyBidAdapter.this.paramsAddBid.put(Const.BID_PUB_ID, ((MyBidDTO) MyBidAdapter.this.getAllBidDTOArrayList.get(i)).getBid_pub_id());
//                    MyBidAdapter.this.setData();
//                    dialog.dismiss();
//                    return;
//                }
                ProjectUtils.showToast(MyBidAdapter.this.mContext, MyBidAdapter.this.mContext.getResources().getString(C2037R.string.valid_bid));
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setData() {
        new HttpsRequest(Const.UPDATE_BID, (Map<String, String>) this.paramsAddBid, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    Toast.makeText(MyBidAdapter.this.mContext, "successs", 0).show();
                    MyBidAdapter.this.myAds.getMyBid();
                    return;
                }
                ProjectUtils.showToast(MyBidAdapter.this.mContext, str);
            }
        });
    }
}
