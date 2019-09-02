package com.subasta.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.subasta.C2037R;
import com.subasta.interfaces.OnSpinerItemClick;
import com.subasta.model.CommonDTO;

import java.util.ArrayList;

public class SpinnerDialog {
    AlertDialog alertDialog;
    boolean cancellable = false;
    String closeTitle = "Close";
    Activity context;
    String dTitle;
    ArrayList<CommonDTO> items;
    OnSpinerItemClick onSpinerItemClick;
    int pos;
    boolean showKeyboard = false;
    int style;
    boolean useContainsFilter = false;

    public SpinnerDialog(Activity activity, ArrayList<CommonDTO> arrayList, String str) {
        this.items = arrayList;
        this.context = activity;
        this.dTitle = str;
    }

    public SpinnerDialog(Activity activity, ArrayList<CommonDTO> arrayList, String str, String str2) {
        this.items = arrayList;
        this.context = activity;
        this.dTitle = str;
        this.closeTitle = str2;
    }

    public SpinnerDialog(Activity activity, ArrayList<CommonDTO> arrayList, String str, int i) {
        this.items = arrayList;
        this.context = activity;
        this.dTitle = str;
        this.style = i;
    }

    public SpinnerDialog(Activity activity, ArrayList<CommonDTO> arrayList, String str, int i, String str2) {
        this.items = arrayList;
        this.context = activity;
        this.dTitle = str;
        this.style = i;
        this.closeTitle = str2;
    }

    public void bindOnSpinerListener(OnSpinerItemClick onSpinerItemClick2) {
        this.onSpinerItemClick = onSpinerItemClick2;
    }

    public void showSpinerDialog() {
        Builder builder = new Builder(this.context);
        View inflate = this.context.getLayoutInflater().inflate(C2037R.layout.dialog_layout, null);
        TextView textView = (TextView) inflate.findViewById(C2037R.C2039id.close);
        TextView textView2 = (TextView) inflate.findViewById(C2037R.C2039id.spinerTitle);
        textView.setText(this.closeTitle);
        textView2.setText(this.dTitle);
        ListView listView = (ListView) inflate.findViewById(C2037R.C2039id.list);
        final EditText editText = (EditText) inflate.findViewById(C2037R.C2039id.searchBox);
        if (isShowKeyboard()) {
            showKeyboard(editText);
        }
        final ArrayAdapterWithContainsFilter arrayAdapterWithContainsFilter = new ArrayAdapterWithContainsFilter(this.context, C2037R.layout.items_view, this.items);
        listView.setAdapter(arrayAdapterWithContainsFilter);
        builder.setView(inflate);
        this.alertDialog = builder.create();
        this.alertDialog.getWindow().getAttributes().windowAnimations = this.style;
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TextView textView = (TextView) view.findViewById(C2037R.C2039id.text1);
                for (int i2 = 0; i2 < SpinnerDialog.this.items.size(); i2++) {
                    if (textView.getText().toString().equalsIgnoreCase(((CommonDTO) SpinnerDialog.this.items.get(i2)).getCatName().toString())) {
                        SpinnerDialog.this.pos = i2;
                    }
                }
                SpinnerDialog.this.onSpinerItemClick.onClick(textView.getText().toString(), SpinnerDialog.this.pos);
                SpinnerDialog.this.closeSpinerDialog();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (SpinnerDialog.this.isUseContainsFilter()) {
                    arrayAdapterWithContainsFilter.getContainsFilter(editText.getText().toString());
                } else {
                    arrayAdapterWithContainsFilter.getFilter().filter(editText.getText().toString());
                }
            }
        });
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SpinnerDialog.this.closeSpinerDialog();
            }
        });
        this.alertDialog.setCancelable(isCancellable());
        this.alertDialog.setCanceledOnTouchOutside(isCancellable());
        this.alertDialog.show();
    }

    public void closeSpinerDialog() {
        hideKeyboard();
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
    }

    @SuppressLint("WrongConstant")
    private void hideKeyboard() {
        try {
            ((InputMethodManager) this.context.getSystemService("input_method")).hideSoftInputFromWindow(this.context.getCurrentFocus().getWindowToken(), 2);
        } catch (Exception unused) {
        }
    }

    private void showKeyboard(final EditText editText) {
        editText.requestFocus();
        editText.postDelayed(new Runnable() {
            @SuppressLint("WrongConstant")
            public void run() {
                ((InputMethodManager) SpinnerDialog.this.context.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    private boolean isCancellable() {
        return this.cancellable;
    }

    public void setCancellable(boolean z) {
        this.cancellable = z;
    }

    private boolean isShowKeyboard() {
        return this.showKeyboard;
    }

    /* access modifiers changed from: private */
    public boolean isUseContainsFilter() {
        return this.useContainsFilter;
    }

    public void setShowKeyboard(boolean z) {
        this.showKeyboard = z;
    }

    public void setUseContainsFilter(boolean z) {
        this.useContainsFilter = z;
    }
}
