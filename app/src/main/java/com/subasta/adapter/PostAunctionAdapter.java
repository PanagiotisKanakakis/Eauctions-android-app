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
import com.subasta.activity.aution.PostAuction;
import com.subasta.activity.aution.PostSubAunction;
import com.subasta.databinding.ItemPostAunctionBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.CategoryDTO;
import com.subasta.utils.Colors;
import com.subasta.utils.CustomTextViewBold;

import java.util.ArrayList;
import java.util.Random;

public class PostAunctionAdapter extends RecyclerView.Adapter<PostAunctionAdapter.MyViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<CategoryDTO> CategoryDTOArrayList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    private PostAuction postAuction;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemPostAunctionBinding binding;

        public MyViewHolder(@NonNull ItemPostAunctionBinding itemPostAunctionBinding) {
            super(itemPostAunctionBinding.getRoot());
            this.binding = itemPostAunctionBinding;
        }
    }

    public PostAunctionAdapter(Context context, ArrayList<CategoryDTO> arrayList) {
        this.mContext = context;
        this.CategoryDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((ItemPostAunctionBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.item_post_aunction, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((CategoryDTO) this.CategoryDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.civCat);
        myViewHolder.binding.osTexts.setText(((CategoryDTO) this.CategoryDTOArrayList.get(i)).getCat_title());
        int nextInt = new Random().nextInt(21);
        GradientDrawable gradientDrawable = (GradientDrawable) myViewHolder.binding.llcat.getBackground();
        StringBuilder sb = new StringBuilder();
        String str = "#";
        sb.append(str);
        sb.append(Colors.mColors[nextInt]);
        gradientDrawable.setColor(Color.parseColor(sb.toString()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.osTexts;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(Colors.mColors[nextInt]);
        customTextViewBold.setTextColor(Color.parseColor(sb2.toString()));
        myViewHolder.binding.llAuction.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PostAunctionAdapter.this.mContext, PostSubAunction.class);
                intent.putExtra("cat_id", ((CategoryDTO) PostAunctionAdapter.this.CategoryDTOArrayList.get(i)).getCat_id());
                intent.putExtra(Const.CAT_TITLE, ((CategoryDTO) PostAunctionAdapter.this.CategoryDTOArrayList.get(i)).getCat_title());
                PostAunctionAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.CategoryDTOArrayList.size();
    }
}
