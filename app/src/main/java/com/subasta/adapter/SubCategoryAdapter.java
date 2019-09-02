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

import com.subasta.C2037R;
import com.subasta.activity.aution.AddAuction;
import com.subasta.databinding.AdapterSubCategoryBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.SubCategoryDTO;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {
    private AdapterSubCategoryBinding binding;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<SubCategoryDTO> subCategoryDTOArrayList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterSubCategoryBinding binding;

        public ViewHolder(@NonNull AdapterSubCategoryBinding adapterSubCategoryBinding) {
            super(adapterSubCategoryBinding.getRoot());
            this.binding = adapterSubCategoryBinding;
        }
    }

    public SubCategoryAdapter(Context context, ArrayList<SubCategoryDTO> arrayList) {
        this.mContext = context;
        this.subCategoryDTOArrayList = arrayList;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterSubCategoryBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_sub_category, viewGroup, false);
        return new ViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.binding.tvtitle.setText(((SubCategoryDTO) this.subCategoryDTOArrayList.get(i)).getSub_cat_title());
        viewHolder.binding.relSubCat.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryAdapter.this.mContext, AddAuction.class);
                intent.putExtra(Const.GET_SUB_CAT_ID, ((SubCategoryDTO) SubCategoryAdapter.this.subCategoryDTOArrayList.get(i)).getSub_cat_id());
                intent.putExtra("cat_id", ((SubCategoryDTO) SubCategoryAdapter.this.subCategoryDTOArrayList.get(i)).getCat_id());
                SubCategoryAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.subCategoryDTOArrayList.size();
    }
}
