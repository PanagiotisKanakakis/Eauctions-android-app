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
import androidx.fragment.app.FragmentManager;

import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.databinding.FregmentMyAuctionBinding;
import com.subasta.myauctionfregment.MyAds;
import com.subasta.myauctionfregment.MyAuctions;
import com.subasta.myauctionfregment.MyFav;

import javax.annotation.Nullable;

//import android.support.annotation.Nullable;

public class MyAutions extends Fragment implements OnClickListener {
    private FregmentMyAuctionBinding binding;
    private Dashboard dashboard;
    private FragmentManager fragmentManager;
    private MyAds myAds = new MyAds();
    private MyAuctions myAuctions = new MyAuctions();
    private MyFav myFav = new MyFav();
    private MyWonBid myWonBid = new MyWonBid();

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.dashboard = (Dashboard) context;
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.binding = (FregmentMyAuctionBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fregment_my_auction, viewGroup, false);
        this.fragmentManager = getChildFragmentManager();
        setUiAction();
        return this.binding.getRoot();
    }

    private void setUiAction() {
        this.fragmentManager.beginTransaction().add(C2037R.C2039id.container, this.myAuctions, "myAuctions").commit();
        this.binding.tvmyauction.setOnClickListener(this);
        this.binding.tvmybids.setOnClickListener(this);
        this.binding.tvFavourites.setOnClickListener(this);
        this.binding.tvwonbids.setOnClickListener(this);
    }

    public void onDetach() {
        super.onDetach();
        this.dashboard = null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.tvFavourites /*2131362496*/:
                setSelected(false, false, true, false);
                this.fragmentManager.beginTransaction().replace(C2037R.C2039id.container, this.myFav, "myFav").commit();
                return;
            case C2037R.C2039id.tvmyauction /*2131362536*/:
                setSelected(true, false, false, false);
                this.fragmentManager.beginTransaction().replace(C2037R.C2039id.container, this.myAuctions, "myAuctions").commit();
                return;
            case C2037R.C2039id.tvmybids /*2131362537*/:
                setSelected(false, true, false, false);
                this.fragmentManager.beginTransaction().replace(C2037R.C2039id.container, this.myAds, "myAds").commit();
                return;
            case C2037R.C2039id.tvwonbids /*2131362549*/:
                setSelected(false, false, false, true);
                this.fragmentManager.beginTransaction().replace(C2037R.C2039id.container, this.myWonBid, "myWonBid").commit();
                return;
            default:
                return;
        }
    }

    @SuppressLint("WrongConstant")
    private void setSelected(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            this.binding.tvAuctionSelect.setVisibility(0);
            this.binding.tvBidsSelect.setVisibility(8);
            this.binding.tvFavouritesSelect.setVisibility(8);
            this.binding.tvwonBidsSelect.setVisibility(8);
        }
        if (z2) {
            this.binding.tvAuctionSelect.setVisibility(8);
            this.binding.tvBidsSelect.setVisibility(0);
            this.binding.tvFavouritesSelect.setVisibility(8);
            this.binding.tvwonBidsSelect.setVisibility(8);
        }
        if (z3) {
            this.binding.tvAuctionSelect.setVisibility(8);
            this.binding.tvBidsSelect.setVisibility(8);
            this.binding.tvFavouritesSelect.setVisibility(0);
            this.binding.tvwonBidsSelect.setVisibility(8);
        }
        if (z4) {
            this.binding.tvAuctionSelect.setVisibility(8);
            this.binding.tvBidsSelect.setVisibility(8);
            this.binding.tvFavouritesSelect.setVisibility(8);
            this.binding.tvwonBidsSelect.setVisibility(0);
        }
        this.binding.tvAuctionSelect.setSelected(z);
        this.binding.tvBidsSelect.setSelected(z2);
        this.binding.tvFavouritesSelect.setSelected(z3);
        this.binding.tvwonBidsSelect.setSelected(z4);
    }
}
