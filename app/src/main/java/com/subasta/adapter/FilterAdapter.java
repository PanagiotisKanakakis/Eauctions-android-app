package com.subasta.adapter;

import android.content.Context;
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
import com.subasta.activity.FilterActivity;
import com.subasta.databinding.AdapterCategoryListBinding;
import com.subasta.databinding.AdapterItemFilterBinding;
import com.subasta.model.CategoryDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.Colors;
import com.subasta.utils.CustomTextViewBold;

import java.util.ArrayList;
import java.util.Random;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MyViewHolder> {
    ArrayList<CategoryDTO> CategoryDTOArrayList;
    AdapterCategoryListBinding binding;
    FilterActivity filterActivity;

    /* renamed from: i */
    int f1306i = 1;
    LayoutInflater layoutInflater;
    Context mContext;
    int pos = -1;
    SharedPrefrence sharedPrefrence;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemFilterBinding binding;

        public MyViewHolder(@NonNull AdapterItemFilterBinding adapterItemFilterBinding) {
            super(adapterItemFilterBinding.getRoot());
            this.binding = adapterItemFilterBinding;
        }
    }

    public FilterAdapter(FilterActivity filterActivity2, ArrayList<CategoryDTO> arrayList) {
        this.filterActivity = filterActivity2;
        this.mContext = filterActivity2.getApplicationContext();
        this.CategoryDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterItemFilterBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_filter, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((CategoryDTO) this.CategoryDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.circle)).into(myViewHolder.binding.civCat);
        myViewHolder.binding.tvCatN.setText(((CategoryDTO) this.CategoryDTOArrayList.get(i)).getCat_title());
        if (this.pos == i) {
            myViewHolder.binding.llCategory.setBackgroundResource(C2037R.C2038drawable.bg_circle_gray);
        } else {
            myViewHolder.binding.llCategory.setBackgroundResource(C2037R.C2038drawable.bg_circle_trans);
        }
        if (this.f1306i == 1) {
            this.filterActivity.getGetId(((CategoryDTO) this.CategoryDTOArrayList.get(0)).getCat_id());
            this.filterActivity.getName(((CategoryDTO) this.CategoryDTOArrayList.get(0)).getCat_title());
            myViewHolder.binding.llCategory.setBackgroundResource(C2037R.C2038drawable.bg_circle_gray);
            int i2 = this.f1306i;
            this.f1306i = i2 + i2;
        } else {
            myViewHolder.binding.llcat.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    FilterAdapter.this.notifyDataSetChanged();
                    FilterAdapter.this.filterActivity.getGetId(((CategoryDTO) FilterAdapter.this.CategoryDTOArrayList.get(i)).getCat_id());
                    FilterAdapter.this.filterActivity.getName(((CategoryDTO) FilterAdapter.this.CategoryDTOArrayList.get(i)).getCat_title());
                    FilterAdapter filterAdapter = FilterAdapter.this;
                    filterAdapter.pos = i;
                    filterAdapter.notifyDataSetChanged();
                }
            });
        }
        int nextInt = new Random().nextInt(21);
        GradientDrawable gradientDrawable = (GradientDrawable) myViewHolder.binding.llcat.getBackground();
        StringBuilder sb = new StringBuilder();
        String str = "#";
        sb.append(str);
        sb.append(Colors.mColors[nextInt]);
        gradientDrawable.setColor(Color.parseColor(sb.toString()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvCatN;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(Colors.mColors[nextInt]);
        customTextViewBold.setTextColor(Color.parseColor(sb2.toString()));
    }

    public int getItemCount() {
        return this.CategoryDTOArrayList.size();
    }
}
