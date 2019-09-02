package com.subasta.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.isseiaoki.simplecropview.CropImageView;
import com.isseiaoki.simplecropview.CropImageView.CropMode;
import com.isseiaoki.simplecropview.CropImageView.RotateDegrees;
import com.isseiaoki.simplecropview.callback.CropCallback;
import com.isseiaoki.simplecropview.callback.LoadCallback;
import com.isseiaoki.simplecropview.callback.SaveCallback;
import com.isseiaoki.simplecropview.util.Utils;
import com.subasta.C2037R;

import java.io.File;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainFragment extends FragmentActivity {
    private static final String PROGRESS_DIALOG = "ProgressDialog";
    private static final int REQUEST_PICK_IMAGE = 10011;
    private static final int REQUEST_SAF_PICK_IMAGE = 10012;
    private final OnClickListener btnListener = new OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case C2037R.C2039id.button16_9 /*2131361936*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.RATIO_16_9);
                    return;
                case C2037R.C2039id.button1_1 /*2131361937*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.SQUARE);
                    return;
                case C2037R.C2039id.button3_4 /*2131361938*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.RATIO_3_4);
                    return;
                case C2037R.C2039id.button4_3 /*2131361939*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.RATIO_4_3);
                    return;
                case C2037R.C2039id.button9_16 /*2131361940*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.RATIO_9_16);
                    return;
                case C2037R.C2039id.buttonCircle /*2131361941*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.CIRCLE);
                    return;
                case C2037R.C2039id.buttonCustom /*2131361942*/:
                    MainFragment.this.mCropView.setCustomRatio(7, 5);
                    return;
                case C2037R.C2039id.buttonDone /*2131361943*/:
                    MainFragmentPermissionsDispatcher.cropImageWithCheck(MainFragment.this);
                    return;
                case C2037R.C2039id.buttonFitImage /*2131361944*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.FIT_IMAGE);
                    return;
                case C2037R.C2039id.buttonFree /*2131361945*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.FREE);
                    return;
                case C2037R.C2039id.buttonPickImage /*2131361947*/:
                    MainFragmentPermissionsDispatcher.pickImageWithCheck(MainFragment.this);
                    return;
                case C2037R.C2039id.buttonRotateLeft /*2131361948*/:
                    MainFragment.this.mCropView.rotateImage(RotateDegrees.ROTATE_M90D);
                    return;
                case C2037R.C2039id.buttonRotateRight /*2131361949*/:
                    MainFragment.this.mCropView.rotateImage(RotateDegrees.ROTATE_90D);
                    return;
                case C2037R.C2039id.buttonShowCircleButCropAsSquare /*2131361950*/:
                    MainFragment.this.mCropView.setCropMode(CropMode.CIRCLE_SQUARE);
                    return;
                default:
                    return;
            }
        }
    };
    private final CropCallback mCropCallback = new CropCallback() {
        @Override
        public void onError(Throwable e) {

        }


        public void onSuccess(Bitmap bitmap) {
        }
    };
    /* access modifiers changed from: private */
    public CropImageView mCropView;
    private final LoadCallback mLoadCallback = new LoadCallback() {
        @Override
        public void onError(Throwable e) {

        }

        public void onSuccess() {
            MainFragment.this.dismissProgress();
            Log.e("", "success");
        }

        public void onError() {
            MainFragment.this.dismissProgress();
            Log.e("", "error");
        }
    };
    private LinearLayout mRootLayout;
    private final SaveCallback mSaveCallback = new SaveCallback() {
        @Override
        public void onError(Throwable e) {
            MainFragment.this.dismissProgress();
        }

        public void onSuccess(Uri uri) {
            MainFragment.this.dismissProgress();
            Intent intent = MainFragment.this.getIntent();
            intent.putExtra("resultUri", uri.toString());
            MainFragment mainFragment = MainFragment.this;
            mainFragment.setResult(mainFragment.requestCode, intent);
            MainFragment.this.finish();
        }

        public void onError() {
            MainFragment.this.dismissProgress();
        }
    };
    Uri myUri;
    int requestCode;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2037R.layout.fragment_main);
        this.myUri = Uri.parse(getIntent().getExtras().getString("imageUri"));
        this.requestCode = getIntent().getExtras().getInt("requestCode");
        bindViews();
        FontUtils.setFont((ViewGroup) this.mRootLayout);
        this.mCropView.startLoad(this.myUri, this.mLoadCallback);
        this.mCropView.setCropMode(CropMode.SQUARE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == REQUEST_PICK_IMAGE && i2 == -1) {
            showProgress();
            intent.getData().toString();
            this.mCropView.startLoad(intent.getData(), this.mLoadCallback);
        } else if (i == REQUEST_SAF_PICK_IMAGE && i2 == -1) {
            showProgress();
            Utils.ensureUriPermission(this, intent).toString();
            this.mCropView.startLoad(Utils.ensureUriPermission(this, intent), this.mLoadCallback);
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        MainFragmentPermissionsDispatcher.onRequestPermissionsResult(this, i, iArr);
    }

    private void bindViews() {
        this.mCropView = (CropImageView) findViewById(C2037R.C2039id.cropImageView);
        findViewById(C2037R.C2039id.buttonDone).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonFitImage).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.button1_1).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.button3_4).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.button4_3).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.button9_16).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.button16_9).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonFree).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonPickImage).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonRotateLeft).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonRotateRight).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonCustom).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonCircle).setOnClickListener(this.btnListener);
        findViewById(C2037R.C2039id.buttonShowCircleButCropAsSquare).setOnClickListener(this.btnListener);
        this.mRootLayout = (LinearLayout) findViewById(C2037R.C2039id.layout_root);
    }

    @NeedsPermission({"android.permission.READ_EXTERNAL_STORAGE"})
    public void pickImage() {
        String str = "image/*";
        if (VERSION.SDK_INT < 19) {
            startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType(str), REQUEST_PICK_IMAGE);
            return;
        }
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        startActivityForResult(intent, REQUEST_SAF_PICK_IMAGE);
    }

    @NeedsPermission({"android.permission.WRITE_EXTERNAL_STORAGE"})
    public void cropImage() {
        showProgress();
        Log.e("cropImage", "called");
        this.mCropView.startCrop(createSaveUri(), this.mCropCallback, this.mSaveCallback);
    }

    @OnShowRationale({"android.permission.READ_EXTERNAL_STORAGE"})
    public void showRationaleForPick(PermissionRequest permissionRequest) {
        showRationaleDialog(C2037R.string.permission_pick_rationale, permissionRequest);
    }

    @OnShowRationale({"android.permission.WRITE_EXTERNAL_STORAGE"})
    public void showRationaleForCrop(PermissionRequest permissionRequest) {
        showRationaleDialog(C2037R.string.permission_crop_rationale, permissionRequest);
    }

    public void showProgress() {
        getSupportFragmentManager().beginTransaction().add((Fragment) ProgressDialogFragment.getInstance(), PROGRESS_DIALOG).commitAllowingStateLoss();
    }

    public void dismissProgress() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            ProgressDialogFragment progressDialogFragment = (ProgressDialogFragment) supportFragmentManager.findFragmentByTag(PROGRESS_DIALOG);
            if (progressDialogFragment != null) {
                getSupportFragmentManager().beginTransaction().remove(progressDialogFragment).commitAllowingStateLoss();
            }
        }
    }

    public Uri createSaveUri() {
        return Uri.fromFile(new File(getCacheDir(), "cropped"));
    }

    private void showRationaleDialog(@StringRes int i, final PermissionRequest permissionRequest) {
//        new Builder(this).setPositiveButton((int) C2037R.string.button_allow, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(@NonNull DialogInterface dialogInterface, int i) {
//                permissionRequest.proceed();
//            }
//        }).setNegativeButton((int) C2037R.string.button_deny, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(@NonNull DialogInterface dialogInterface, int i) {
//                permissionRequest.cancel();
//            }
//        }).setCancelable(false).setMessage(i).show();
    }
}
