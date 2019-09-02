package com.subasta.fragment.dashboad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.MyadsAdapter;
import com.subasta.databinding.FregmentMyAdsBinding;
import com.subasta.model.MyAdsDTO;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class Ads extends Fragment implements OnClickListener {
    private ArrayList<MyAdsDTO> advertiseListDTOArrayList;
    private FregmentMyAdsBinding binding;
    private Dashboard dashboard;
    private GridLayoutManager manager;
    private Context mcontext;
    private MyadsAdapter myadsAdapter;
    private View view;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.dashboard = (Dashboard) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.myadsAdapter = new MyadsAdapter(getActivity(), this.advertiseListDTOArrayList);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.binding = (FregmentMyAdsBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fregment_my_ads, viewGroup, false);
        this.view = this.binding.getRoot();
        setUIAction(this.view);
        return this.view;
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.binding.recycleview1.setAdapter(this.myadsAdapter);
    }

    public void onDetach() {
        super.onDetach();
        this.dashboard = null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void setUIAction(View view2) {
        this.binding.tvSelling.setOnClickListener(this);
        this.binding.tvFavourites.setOnClickListener(this);
        this.binding.tvSold.setOnClickListener(this);
        this.manager = new GridLayoutManager((Context) getActivity(), 2, 1, false);
        this.binding.recycleview1.setLayoutManager(this.manager);
        this.myadsAdapter = new MyadsAdapter(getActivity(), this.advertiseListDTOArrayList);
        this.binding.recycleview1.setAdapter(this.myadsAdapter);
    }

    public void onClick(View view2) {
        int id = view2.getId();
        if (id == C2037R.C2039id.tvFavourites) {
            setSelected(false, false, true);
        } else if (id == C2037R.C2039id.tvSelling) {
            setSelected(true, false, false);
        } else if (id == C2037R.C2039id.tvSold) {
            setSelected(false, true, false);
        }
    }

    @SuppressLint("WrongConstant")
    private void setSelected(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.binding.tvSellingSelect.setVisibility(0);
            this.binding.tvSoldSelect.setVisibility(8);
            this.binding.tvFavouritesSelect.setVisibility(8);
        }
        if (z2) {
            this.binding.tvSellingSelect.setVisibility(8);
            this.binding.tvSoldSelect.setVisibility(0);
            this.binding.tvFavouritesSelect.setVisibility(8);
        }
        if (z3) {
            this.binding.tvSellingSelect.setVisibility(8);
            this.binding.tvSoldSelect.setVisibility(8);
            this.binding.tvFavouritesSelect.setVisibility(0);
        }
        this.binding.tvSellingSelect.setSelected(z);
        this.binding.tvSoldSelect.setSelected(z2);
        this.binding.tvFavouritesSelect.setSelected(z2);
    }
}
