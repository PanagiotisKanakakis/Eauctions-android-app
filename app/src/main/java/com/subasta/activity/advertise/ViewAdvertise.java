package com.subasta.activity.advertise;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.subasta.C2037R;
import com.subasta.databinding.ActivityViewAdvertiseBinding;
import com.subasta.interfaces.Const;

public class ViewAdvertise extends AppCompatActivity {
    private ActivityViewAdvertiseBinding binding;

    /* renamed from: id */
    String f1299id;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityViewAdvertiseBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_view_advertise);
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewAdvertise.this.finish();
            }
        });
        this.f1299id = getIntent().getStringExtra(Const.Pro_pub_id);
    }
}
