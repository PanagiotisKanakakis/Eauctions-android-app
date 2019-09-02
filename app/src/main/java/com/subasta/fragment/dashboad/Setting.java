package com.subasta.fragment.dashboad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.BuildConfig;
import com.subasta.C2037R;
import com.subasta.activity.SupportAcitivity;
import com.subasta.activity.authentication.ChangPassword;
import com.subasta.activity.authentication.UpdateProfile;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.databinding.FragmentSettingBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.ProjectUtils;

import net.gotev.uploadservice.ContentType;

public class Setting extends Fragment {
    private FragmentSettingBinding binding;
    private Dashboard dashboard;
    private ImageView ivProfilpic;
    SharedPrefrence sharedPrefrence;
    private TextView tvUserName;
    private UserDTO userDTO;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.dashboard = (Dashboard) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FragmentSettingBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fragment_setting, viewGroup, false);
        this.sharedPrefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        this.binding.llID.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Setting.this.startActivity(new Intent(Setting.this.getActivity(), UpdateProfile.class));
            }
        });
        this.binding.tvchangepass.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Setting.this.startActivity(new Intent(Setting.this.getActivity(), ChangPassword.class));
            }
        });
        this.binding.tvinvited.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Setting.this.shareTextUrl();
            }
        });
        this.binding.tvsupport.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Setting.this.startActivity(new Intent(Setting.this.getActivity(), SupportAcitivity.class));
            }
        });
        return this.binding.getRoot();
    }

    /* access modifiers changed from: private */
    @SuppressLint("WrongConstant")
    public void shareTextUrl() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ContentType.TEXT_PLAIN);
        intent.addFlags(524288);
        intent.putExtra("android.intent.extra.SUBJECT", "Title Of The Post");
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(C2037R.string.invite));
        sb.append("\n https://play.google.com/store/apps/details?id=");
        sb.append(BuildConfig.APPLICATION_ID);
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        startActivity(Intent.createChooser(intent, "Share link!"));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onDetach() {
        super.onDetach();
        this.dashboard = null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) this).load(this.userDTO.getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) this.binding.imagedp);
        this.binding.tvname.setText(this.userDTO.getName());
        CustomTextView customTextView = this.binding.tvdate;
        StringBuilder sb = new StringBuilder();
        sb.append("Joined on ");
        sb.append(ProjectUtils.changeDateFormate(this.userDTO.getCreated_at()));
        customTextView.setText(sb.toString());
    }
}
