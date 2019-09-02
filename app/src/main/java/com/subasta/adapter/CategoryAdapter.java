package com.subasta.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import com.subasta.activity.CategoryBasedAdsAuction;
import com.subasta.databinding.AdapterCategoryBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.CategoryDTO;
import com.subasta.utils.Colors;
import com.subasta.utils.CustomTextViewBold;

import java.util.ArrayList;
import java.util.Random;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<CategoryDTO> categoryDTOList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterCategoryBinding binding;

        public MyViewHolder(AdapterCategoryBinding adapterCategoryBinding) {
            super(adapterCategoryBinding.getRoot());
            this.binding = adapterCategoryBinding;
        }
    }

    public CategoryAdapter(Context context, ArrayList<CategoryDTO> arrayList) {
        this.mContext = context;
        this.categoryDTOList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterCategoryBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_category, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((CategoryDTO) this.categoryDTOList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.circle)).into(myViewHolder.binding.civCat);
        myViewHolder.binding.tvCat.setText(((CategoryDTO) this.categoryDTOList.get(i)).getCat_title());
        myViewHolder.binding.civCat.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(CategoryAdapter.this.mContext, CategoryBasedAdsAuction.class);
                intent.putExtra("cat_id", ((CategoryDTO) CategoryAdapter.this.categoryDTOList.get(i)).getCat_id());
                intent.putExtra(Const.CAT_TITLE, ((CategoryDTO) CategoryAdapter.this.categoryDTOList.get(i)).getCat_title());
                CategoryAdapter.this.mContext.startActivity(intent);
            }
        });
        int nextInt = new Random().nextInt(21);
        GradientDrawable gradientDrawable = (GradientDrawable) myViewHolder.binding.llcat.getBackground();
        StringBuilder sb = new StringBuilder();
        String str = "#";
        sb.append(str);
        sb.append(Colors.mColors[nextInt]);
        gradientDrawable.setColor(Color.parseColor(sb.toString()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvCat;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(Colors.mColors[nextInt]);
        customTextViewBold.setTextColor(Color.parseColor(sb2.toString()));
    }

    public int getItemCount() {
        return this.categoryDTOList.size();
    }
}
