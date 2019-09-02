package com.subasta.utils;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;

import com.subasta.model.CommonDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ArrayAdapterWithContainsFilter<S> extends ArrayAdapter {
    private ArrayList<CommonDTO> arraylist;
    private List<CommonDTO> items = null;

    public ArrayAdapterWithContainsFilter(Activity activity, int i, ArrayList<CommonDTO> arrayList) {
        super(activity, i, arrayList);
        this.items = arrayList;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(arrayList);
    }

    @NonNull
    public Filter getFilter() {
        return super.getFilter();
    }

    public void getContainsFilter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.items.clear();
        if (lowerCase.length() == 0) {
            this.items.addAll(this.arraylist);
        } else {
            Iterator it = this.arraylist.iterator();
            while (it.hasNext()) {
                CommonDTO commonDTO = (CommonDTO) it.next();
                if (commonDTO.getCatName().toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.items.add(commonDTO);
                }
            }
        }
        notifyDataSetChanged();
    }
}
