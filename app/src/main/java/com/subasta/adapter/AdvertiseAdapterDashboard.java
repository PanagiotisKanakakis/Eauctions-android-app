package com.subasta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.databinding.AdapterAdvertiseBinding;
import com.subasta.model.AdvertiseDTO;

import java.util.ArrayList;

public class AdvertiseAdapterDashboard extends RecyclerView.Adapter<AdvertiseAdapterDashboard.MyViewHolder> {
    private ArrayList<AdvertiseDTO> advertiseDTOArrayList;
    private AdapterAdvertiseBinding binding;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterAdvertiseBinding binding;

        public MyViewHolder(AdapterAdvertiseBinding adapterAdvertiseBinding) {
            super(adapterAdvertiseBinding.getRoot());
            this.binding = adapterAdvertiseBinding;
        }
    }

    public AdvertiseAdapterDashboard(Context context, ArrayList<AdvertiseDTO> arrayList) {
        this.mContext = context;
        this.advertiseDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterAdvertiseBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_advertise, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AdvertiseDTO) this.advertiseDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.ivProduct);
        myViewHolder.binding.tvProductname.setText(((AdvertiseDTO) this.advertiseDTOArrayList.get(i)).getTitle());
        myViewHolder.binding.tvPrice.setText(((AdvertiseDTO) this.advertiseDTOArrayList.get(i)).getPrice());
    }

    public int getItemCount() {
        return this.advertiseDTOArrayList.size();
    }

}
