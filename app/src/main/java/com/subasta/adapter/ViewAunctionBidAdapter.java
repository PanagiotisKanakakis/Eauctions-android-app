package com.subasta.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.databinding.AdapterViewauntionBidBinding;
import com.subasta.model.BidsDTO;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;

public class ViewAunctionBidAdapter extends RecyclerView.Adapter<ViewAunctionBidAdapter.MyViewHolder> {
    AdapterViewauntionBidBinding bidBinding;
    private ArrayList<BidsDTO> bidsDTOArrayList;
    LayoutInflater layoutInflater;
    Context mContext;
    private int pos = -1;
    private String tag;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterViewauntionBidBinding bidBinding;

        public MyViewHolder(@NonNull AdapterViewauntionBidBinding adapterViewauntionBidBinding) {
            super(adapterViewauntionBidBinding.getRoot());
            this.bidBinding = adapterViewauntionBidBinding;
        }
    }

    public ViewAunctionBidAdapter(ArrayList<BidsDTO> arrayList, Context context, String str) {
        this.bidsDTOArrayList = arrayList;
        this.mContext = context;
        this.tag = str;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.bidBinding = (AdapterViewauntionBidBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_viewauntion_bid, viewGroup, false);
        return new MyViewHolder(this.bidBinding);
    }

    @SuppressLint("WrongConstant")
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bidBinding.tvname.setText(ProjectUtils.capWordFirstLetter(((BidsDTO) this.bidsDTOArrayList.get(i)).getName()));
        CustomTextViewBold customTextViewBold = myViewHolder.bidBinding.tvprice;
        StringBuilder sb = new StringBuilder();
        sb.append(((BidsDTO) this.bidsDTOArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((BidsDTO) this.bidsDTOArrayList.get(i)).getPrice());
        customTextViewBold.setText(sb.toString());
        myViewHolder.bidBinding.tvdate.setText(ProjectUtils.changeDateFormate(((BidsDTO) this.bidsDTOArrayList.get(i)).getCreated_at()));
//        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((BidsDTO) this.bidsDTOArrayList.get(i)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) myViewHolder.bidBinding.ivProfilePic);
//        if (((BidsDTO) this.bidsDTOArrayList.get(i)).getIswin().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
//            this.bidBinding.wintag.setVisibility(0);
//        } else {
            this.bidBinding.wintag.setVisibility(8);
//        }
    }

    public int getItemCount() {
        if (this.tag.equals("5")) {
            return Math.min(this.bidsDTOArrayList.size(), 5);
        }
        return this.bidsDTOArrayList.size();
    }
}
