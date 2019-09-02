package com.subasta.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.subasta.C2037R;
import com.xw.repo.BubbleSeekBar;

import javax.annotation.Nullable;

public class DemoFragment1 extends Fragment {
    boolean flag;
    float refValue;
    EditText topupValueET;

    public static DemoFragment1 newInstance() {
        return new DemoFragment1();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C2037R.layout.fragment_demo_1, viewGroup, false);
        BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) inflate.findViewById(C2037R.C2039id.demo_1_seek_bar);
        bubbleSeekBar.setProgress(20.0f);
        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {

            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if (progressFloat != DemoFragment1.this.refValue && DemoFragment1.this.flag) {
                    EditText editText = DemoFragment1.this.topupValueET;
                    StringBuilder sb = new StringBuilder();
                    sb.append(progressFloat);
                    sb.append("");
                    editText.setText(sb.toString());
                }
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });
        return inflate;
    }
}
