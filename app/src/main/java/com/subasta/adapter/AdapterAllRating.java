package com.subasta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.databinding.AdapterAllRatingBinding;
import com.subasta.model.GetRatingDTO;
import com.subasta.model.UserDTO;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;

public class AdapterAllRating extends RecyclerView.Adapter<AdapterAllRating.MyViewHolder> {
    private AdapterAllRatingBinding binding;
    private ArrayList<GetRatingDTO> getRatingDTOArrayList;
    private LayoutInflater layoutInflater;
    private Context mContext;
    private String tag;
    private UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterAllRatingBinding binding;

        public MyViewHolder(@NonNull AdapterAllRatingBinding adapterAllRatingBinding) {
            super(adapterAllRatingBinding.getRoot());
            this.binding = adapterAllRatingBinding;
        }
    }

    public AdapterAllRating(Context context, ArrayList<GetRatingDTO> arrayList, String str) {
        this.mContext = context;
        this.getRatingDTOArrayList = arrayList;
        this.tag = str;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterAllRatingBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_all_rating, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.userName.setText(ProjectUtils.capWordFirstLetter(((GetRatingDTO) this.getRatingDTOArrayList.get(i)).getName()));
        myViewHolder.binding.tvComment.setText(((GetRatingDTO) this.getRatingDTOArrayList.get(i)).getComment());
        myViewHolder.binding.simpleRatingBar.setRating(Float.parseFloat(((GetRatingDTO) this.getRatingDTOArrayList.get(i)).getStar()));
//        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((GetRatingDTO) this.getRatingDTOArrayList.get(i)).getUser_image()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) myViewHolder.binding.civCat);
    }

    public int getItemCount() {
        if (this.tag.equals("5")) {
            return Math.min(this.getRatingDTOArrayList.size(), 5);
        }
        return this.getRatingDTOArrayList.size();
    }
}
