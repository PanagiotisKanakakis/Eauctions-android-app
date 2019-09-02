package com.subasta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.advertise.ViewAdvertise;
import com.subasta.databinding.AdapterAdvertiseAllBinding;
import com.subasta.model.AdvertiseAllDTO;

import java.util.ArrayList;

public class AdvertiseAdapter extends RecyclerView.Adapter<AdvertiseAdapter.MyViewHolder> {
    ArrayList<AdvertiseAllDTO> advertiseDTOArrayList;
    LayoutInflater layoutInflater;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterAdvertiseAllBinding binding;

        public MyViewHolder(AdapterAdvertiseAllBinding adapterAdvertiseAllBinding) {
            super(adapterAdvertiseAllBinding.getRoot());
            this.binding = adapterAdvertiseAllBinding;
        }
    }

    public AdvertiseAdapter(Context context, ArrayList<AdvertiseAllDTO> arrayList) {
        this.mContext = context;
        this.advertiseDTOArrayList = arrayList;
    }

//    @NonNull
//    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        if (this.layoutInflater == null) {
//            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        }
//        return new MyViewHolder((AdapterAdvertiseAllBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_advertise_all, viewGroup, false));
//    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.binding.tvProductname.setText(((AdvertiseAllDTO) this.advertiseDTOArrayList.get(i)).getTitle());
        myViewHolder.binding.tvPrice.setText(((AdvertiseAllDTO) this.advertiseDTOArrayList.get(i)).getPrice());
        myViewHolder.binding.tvTime.setText(((AdvertiseAllDTO) this.advertiseDTOArrayList.get(i)).getStatus());
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AdvertiseAllDTO) this.advertiseDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.ivProduct);
        myViewHolder.binding.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AdvertiseAdapter.this.mContext, ViewAdvertise.class);
                intent.putExtra("add_pro_id", ((AdvertiseAllDTO) AdvertiseAdapter.this.advertiseDTOArrayList.get(i)).getAdd_pro_id());
                AdvertiseAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.advertiseDTOArrayList.size();
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }
}
