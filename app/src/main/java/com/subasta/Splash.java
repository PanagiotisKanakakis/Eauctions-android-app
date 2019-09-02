package com.subasta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.subasta.activity.authentication.Sign_in;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.interfaces.Const;
import com.subasta.preferences.SharedPrefrence;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    private Handler handler = new Handler();
    /* access modifiers changed from: private */
    public SharedPrefrence prefrence;
    Runnable runnable = new Runnable() {
        @SuppressLint("WrongConstant")
        public void run() {
            if (Splash.this.prefrence.getBooleanValue(Const.IS_REGISTERED)) {
                Intent intent = new Intent(Splash.this.sContext, Dashboard.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("index", 0);
                Splash.this.startActivity(intent);
                Splash.this.finish();
                Splash.this.overridePendingTransition(C2037R.anim.anim_slide_in_left, C2037R.anim.anim_slide_out_left);
                return;
            }
            Splash.this.startActivity(new Intent(Splash.this.sContext, Sign_in.class));
            Splash.this.finish();
            Splash.this.overridePendingTransition(C2037R.anim.anim_slide_in_left, C2037R.anim.anim_slide_out_left);
        }
    };
    /* access modifiers changed from: private */
    public Context sContext;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2037R.layout.activity_splash);
        this.sContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.sContext);
        this.handler.postDelayed(this.runnable, (long) SPLASH_TIME_OUT);
    }
}
