package com.subasta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.databinding.AdapterSupprtBinding;
import com.subasta.model.SupportDTO;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.MyViewHolder> {
    private AdapterSupprtBinding binding;
    private LayoutInflater layoutInflater;
    private Context mContext;
    private ArrayList<SupportDTO> objects;
    private ArrayList<SupportDTO> supportDTOArrayList = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterSupprtBinding binding;

        public MyViewHolder(@NonNull AdapterSupprtBinding adapterSupprtBinding) {
            super(adapterSupprtBinding.getRoot());
            this.binding = adapterSupprtBinding;
        }
    }

    public SupportAdapter(Context context, ArrayList<SupportDTO> arrayList) {
        this.mContext = context;
        this.objects = arrayList;
        this.supportDTOArrayList.addAll(arrayList);
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterSupprtBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_supprt, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.title.setText(ProjectUtils.capWordFirstLetter(((SupportDTO) this.objects.get(i)).getTitle()));
        myViewHolder.binding.tvDescription.setText(((SupportDTO) this.objects.get(i)).getDescription());
        myViewHolder.binding.tvTime.setText(ProjectUtils.changeDateFormate(((SupportDTO) this.objects.get(i)).getCreated_at()));
//        if (((SupportDTO) this.objects.get(i)).getStatus().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//            myViewHolder.binding.tvStatus.setText("Pending");
//        } else {
            myViewHolder.binding.tvStatus.setText("Approved");
//        }
    }

    public int getItemCount() {
        return this.objects.size();
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.objects.clear();
        if (lowerCase.length() == 0) {
            this.objects.addAll(this.supportDTOArrayList);
        } else {
            Iterator it = this.supportDTOArrayList.iterator();
            while (it.hasNext()) {
                SupportDTO supportDTO = (SupportDTO) it.next();
                if (supportDTO.getTitle().toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.objects.add(supportDTO);
                }
            }
        }
        notifyDataSetChanged();
    }
}
