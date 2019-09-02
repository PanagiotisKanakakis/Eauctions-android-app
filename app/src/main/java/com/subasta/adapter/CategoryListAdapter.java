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
import com.subasta.databinding.AdapterCategoryListBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.CategoryDTO;
import com.subasta.utils.Colors;
import com.subasta.utils.CustomTextViewBold;

import java.util.ArrayList;
import java.util.Random;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ImageviewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<CategoryDTO> CategoryDTOArrayList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;

    public static class ImageviewHolder extends RecyclerView.ViewHolder {
        AdapterCategoryListBinding binding;

        public ImageviewHolder(AdapterCategoryListBinding adapterCategoryListBinding) {
            super(adapterCategoryListBinding.getRoot());
            this.binding = adapterCategoryListBinding;
        }
    }

    public CategoryListAdapter(Context context, ArrayList<CategoryDTO> arrayList) {
        this.mContext = context;
        this.CategoryDTOArrayList = arrayList;
    }

    @NonNull
    public ImageviewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ImageviewHolder((AdapterCategoryListBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_category_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull ImageviewHolder imageviewHolder, final int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((CategoryDTO) this.CategoryDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.circle)).into(imageviewHolder.binding.civCat);
        imageviewHolder.binding.tvCat.setText(((CategoryDTO) this.CategoryDTOArrayList.get(i)).getCat_title());
        int nextInt = new Random().nextInt(21);
        GradientDrawable gradientDrawable = (GradientDrawable) imageviewHolder.binding.llcat.getBackground();
        StringBuilder sb = new StringBuilder();
        String str = "#";
        sb.append(str);
        sb.append(Colors.mColors[nextInt]);
        gradientDrawable.setColor(Color.parseColor(sb.toString()));
        CustomTextViewBold customTextViewBold = imageviewHolder.binding.tvCat;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(Colors.mColors[nextInt]);
        customTextViewBold.setTextColor(Color.parseColor(sb2.toString()));
        imageviewHolder.binding.line1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(CategoryListAdapter.this.mContext, CategoryBasedAdsAuction.class);
                intent.putExtra(Const.CAT_TITLE, ((CategoryDTO) CategoryListAdapter.this.CategoryDTOArrayList.get(i)).getCat_title());
                CategoryListAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.CategoryDTOArrayList.size();
    }
}
