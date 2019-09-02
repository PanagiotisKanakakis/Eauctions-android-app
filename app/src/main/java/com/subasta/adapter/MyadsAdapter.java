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
import com.subasta.activity.advertise.ViewAdvertise;
import com.subasta.databinding.AdapterItemMyAdsBinding;
import com.subasta.model.MyAdsDTO;

import java.util.ArrayList;

public class MyadsAdapter extends RecyclerView.Adapter<MyadsAdapter.MyViewHolder> {
    private ArrayList<MyAdsDTO> advertiseListDTOArrayList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemMyAdsBinding binding;

        public MyViewHolder(@NonNull AdapterItemMyAdsBinding adapterItemMyAdsBinding) {
            super(adapterItemMyAdsBinding.getRoot());
            this.binding = adapterItemMyAdsBinding;
        }
    }

    public MyadsAdapter(Context context, ArrayList<MyAdsDTO> arrayList) {
        this.mContext = context;
        this.advertiseListDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterItemMyAdsBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_my_ads, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.tvtitle.setText(((MyAdsDTO) this.advertiseListDTOArrayList.get(i)).getProductname());
        myViewHolder.binding.tvDescription.setText(((MyAdsDTO) this.advertiseListDTOArrayList.get(i)).getProductduration());
        myViewHolder.binding.tvPrice.setText(((MyAdsDTO) this.advertiseListDTOArrayList.get(i)).getProductprice());
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(Integer.valueOf(((MyAdsDTO) this.advertiseListDTOArrayList.get(i)).getProductimage())).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.iv1);
        myViewHolder.binding.iv1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MyadsAdapter.this.mContext.startActivity(new Intent(MyadsAdapter.this.mContext, ViewAdvertise.class));
            }
        });
    }

    public int getItemCount() {
        return this.advertiseListDTOArrayList.size();
    }
}
