package com.subasta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.databinding.AdapterHistoryBinding;
import com.subasta.model.SubHistoryDTO;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SubHistoryAdapter extends RecyclerView.Adapter<SubHistoryAdapter.MyViewHolder> {
    private AdapterHistoryBinding binding;
    private LayoutInflater layoutInflater;
    private ArrayList<SubHistoryDTO> objects;
    private Context sContext;
    private ArrayList<SubHistoryDTO> subHistoryDTOArrayList = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterHistoryBinding binding;

        public MyViewHolder(AdapterHistoryBinding adapterHistoryBinding) {
            super(adapterHistoryBinding.getRoot());
            this.binding = adapterHistoryBinding;
        }
    }

    public SubHistoryAdapter(Context context, ArrayList<SubHistoryDTO> arrayList) {
        this.sContext = context;
        this.objects = arrayList;
        this.subHistoryDTOArrayList.addAll(arrayList);
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterHistoryBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_history, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.pkgName.setText(((SubHistoryDTO) this.objects.get(i)).getPackage_name());
        CustomTextView customTextView = myViewHolder.binding.totalPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(((SubHistoryDTO) this.objects.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((SubHistoryDTO) this.objects.get(i)).getTotal_price());
        customTextView.setText(sb.toString());
        myViewHolder.binding.tax.setText(((SubHistoryDTO) this.objects.get(i)).getTax());
        CustomTextView customTextView2 = myViewHolder.binding.date;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("From - ");
        sb2.append(ProjectUtils.changeDateFormate(((SubHistoryDTO) this.objects.get(i)).getStart_date()));
        sb2.append("  to  ");
        sb2.append(ProjectUtils.changeDateFormate(((SubHistoryDTO) this.objects.get(i)).getEnd_date()));
        customTextView2.setText(sb2.toString());
        myViewHolder.binding.discount.setText(((SubHistoryDTO) this.objects.get(i)).getDiscount());
    }

    public int getItemCount() {
        return this.objects.size();
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.objects.clear();
        if (lowerCase.length() == 0) {
            this.objects.addAll(this.subHistoryDTOArrayList);
        } else {
            Iterator it = this.subHistoryDTOArrayList.iterator();
            while (it.hasNext()) {
                SubHistoryDTO subHistoryDTO = (SubHistoryDTO) it.next();
                if (subHistoryDTO.getPackage_name().toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.objects.add(subHistoryDTO);
                }
            }
        }
        notifyDataSetChanged();
    }
}
