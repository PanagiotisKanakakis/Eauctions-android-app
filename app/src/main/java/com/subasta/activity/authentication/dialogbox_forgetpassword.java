package com.subasta.activity.authentication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.subasta.C2037R;
import com.subasta.databinding.ActivityDialogboxForgetpasswordBinding;

public class dialogbox_forgetpassword extends AppCompatActivity {
    private String TAG = dialogbox_forgetpassword.class.getCanonicalName();
    private ActivityDialogboxForgetpasswordBinding binding;
    /* access modifiers changed from: private */
    public Context sContext;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityDialogboxForgetpasswordBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_dialogbox_forgetpassword);
        this.sContext = this;
        setUiAction();
    }

    private void setUiAction() {
        this.binding.btnSubmit.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(dialogbox_forgetpassword.this.sContext, "Check Email", 0).show();
            }
        });
        this.binding.ivClose.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
    }
}
