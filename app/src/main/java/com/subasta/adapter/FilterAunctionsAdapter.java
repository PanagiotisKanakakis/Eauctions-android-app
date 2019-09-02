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
import com.subasta.databinding.AdapterItemFilterAunctionsBinding;
import com.subasta.model.AutionAllDTO;

import java.util.ArrayList;

public class FilterAunctionsAdapter extends RecyclerView.Adapter<FilterAunctionsAdapter.MyViewHolder> {
    private AdapterItemFilterAunctionsBinding binding;
    private ArrayList<AutionAllDTO> filterDTOArrayList;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemFilterAunctionsBinding binding;

        public MyViewHolder(@NonNull AdapterItemFilterAunctionsBinding adapterItemFilterAunctionsBinding) {
            super(adapterItemFilterAunctionsBinding.getRoot());
            this.binding = adapterItemFilterAunctionsBinding;
        }
    }

    public FilterAunctionsAdapter(Context context, ArrayList<AutionAllDTO> arrayList) {
        this.mContext = context;
        this.filterDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater2 = this.layoutInflater;
        if (layoutInflater2 != null) {
            if (layoutInflater2 == null) {
                this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
            }
            AdapterItemFilterAunctionsBinding adapterItemFilterAunctionsBinding = (AdapterItemFilterAunctionsBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_filter_aunctions, viewGroup, false);
        }
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.tvProductname.setText(((AutionAllDTO) this.filterDTOArrayList.get(i)).getTitle());
        myViewHolder.binding.tvPrice.setText(((AutionAllDTO) this.filterDTOArrayList.get(i)).getPrice());
        myViewHolder.binding.tvcurrency.setText(((AutionAllDTO) this.filterDTOArrayList.get(i)).getCurrency_code());
        myViewHolder.binding.tvAddress.setText(((AutionAllDTO) this.filterDTOArrayList.get(i)).getAddress());
        myViewHolder.binding.tvLocation.setText(((AutionAllDTO) this.filterDTOArrayList.get(i)).getLatitude());
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AutionAllDTO) this.filterDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.image);
    }

    public int getItemCount() {
        return this.filterDTOArrayList.size();
    }
}
