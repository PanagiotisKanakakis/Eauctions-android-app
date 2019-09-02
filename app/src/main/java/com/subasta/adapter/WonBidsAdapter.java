package com.subasta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.aution.ViewAuction;
import com.subasta.databinding.AdapterWonBidsBinding;
import com.subasta.fragment.dashboad.MyWonBid;
import com.subasta.interfaces.Const;
import com.subasta.model.AuncitonImageDTO;
import com.subasta.model.WonBidDTO;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;

public class WonBidsAdapter extends RecyclerView.Adapter<WonBidsAdapter.MyViewHolder> {
    private AdapterWonBidsBinding binding;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    private MyWonBid myWonBid;
    /* access modifiers changed from: private */
    public ArrayList<WonBidDTO> wonBidDTOArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public AdapterWonBidsBinding binding;

        public MyViewHolder(@NonNull AdapterWonBidsBinding adapterWonBidsBinding) {
            super(adapterWonBidsBinding.getRoot());
            this.binding = adapterWonBidsBinding;
        }
    }

    public WonBidsAdapter(Context context, ArrayList<WonBidDTO> arrayList, MyWonBid myWonBid2) {
        this.mContext = context;
        this.wonBidDTOArrayList = arrayList;
        this.myWonBid = myWonBid2;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterWonBidsBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_won_bids, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.binding.tvtitle.setText(ProjectUtils.capWordFirstLetter(((WonBidDTO) this.wonBidDTOArrayList.get(i)).getTitle()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvPrice;
        StringBuilder sb = new StringBuilder();
        sb.append("Your placed bid-");
        sb.append(((WonBidDTO) this.wonBidDTOArrayList.get(i)).getCurrency_code());
        String str = " ";
        sb.append(str);
        sb.append(((WonBidDTO) this.wonBidDTOArrayList.get(i)).getPrice());
        customTextViewBold.setText(sb.toString());
        CustomTextViewBold customTextViewBold2 = myViewHolder.binding.tvProPrice;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((WonBidDTO) this.wonBidDTOArrayList.get(i)).getCurrency_code());
        sb2.append(str);
        sb2.append(((WonBidDTO) this.wonBidDTOArrayList.get(i)).getPro_price());
        customTextViewBold2.setText(sb2.toString());
        CustomTextView customTextView = myViewHolder.binding.tvDate;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Your placed bid date - ");
        sb3.append(ProjectUtils.changeDateFormate(((WonBidDTO) this.wonBidDTOArrayList.get(i)).getCreated_at()));
        customTextView.setText(sb3.toString());
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AuncitonImageDTO) ((WonBidDTO) this.wonBidDTOArrayList.get(i)).getImage_cust().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.iv1);
        } catch (Exception unused) {
        }
        myViewHolder.binding.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(WonBidsAdapter.this.mContext, ViewAuction.class);
                intent.putExtra(Const.Pro_pub_id, ((WonBidDTO) WonBidsAdapter.this.wonBidDTOArrayList.get(i)).getPro_pub_id());
                intent.putExtra(Const.WON_INDEX, 1);
                WonBidsAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.wonBidDTOArrayList.size();
    }
}
