package com.subasta.utils;


import androidx.core.app.ActivityCompat;

import java.lang.ref.WeakReference;

import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class MainFragmentPermissionsDispatcher {
    /* access modifiers changed from: private */
    public static final String[] PERMISSION_CROPIMAGE = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    /* access modifiers changed from: private */
    public static final String[] PERMISSION_PICKIMAGE = {"android.permission.READ_EXTERNAL_STORAGE"};
    private static final int REQUEST_CROPIMAGE = 1;
    private static final int REQUEST_PICKIMAGE = 0;

    private static final class CropImagePermissionRequest implements PermissionRequest {
        private final WeakReference<MainFragment> weakTarget;

        public void cancel() {
        }

        private CropImagePermissionRequest(MainFragment mainFragment) {
            this.weakTarget = new WeakReference<>(mainFragment);
        }

        public void proceed() {
            MainFragment mainFragment = (MainFragment) this.weakTarget.get();
            if (mainFragment != null) {
                ActivityCompat.requestPermissions(mainFragment, MainFragmentPermissionsDispatcher.PERMISSION_CROPIMAGE, 1);
            }
        }
    }

    private static final class PickImagePermissionRequest implements PermissionRequest {
        private final WeakReference<MainFragment> weakTarget;

        public void cancel() {
        }

        private PickImagePermissionRequest(MainFragment mainFragment) {
            this.weakTarget = new WeakReference<>(mainFragment);
        }

        public void proceed() {
            MainFragment mainFragment = (MainFragment) this.weakTarget.get();
            if (mainFragment != null) {
                ActivityCompat.requestPermissions(mainFragment, MainFragmentPermissionsDispatcher.PERMISSION_PICKIMAGE, 0);
            }
        }
    }

    private MainFragmentPermissionsDispatcher() {
    }

    static void pickImageWithCheck(MainFragment mainFragment) {
        if (PermissionUtils.hasSelfPermissions(mainFragment, PERMISSION_PICKIMAGE)) {
            mainFragment.pickImage();
        } else if (PermissionUtils.shouldShowRequestPermissionRationale(mainFragment, PERMISSION_PICKIMAGE)) {
            mainFragment.showRationaleForPick(new PickImagePermissionRequest(mainFragment));
        } else {
            ActivityCompat.requestPermissions(mainFragment, PERMISSION_PICKIMAGE, 0);
        }
    }

    static void cropImageWithCheck(MainFragment mainFragment) {
        if (PermissionUtils.hasSelfPermissions(mainFragment, PERMISSION_CROPIMAGE)) {
            mainFragment.cropImage();
        } else if (PermissionUtils.shouldShowRequestPermissionRationale(mainFragment, PERMISSION_CROPIMAGE)) {
            mainFragment.showRationaleForCrop(new CropImagePermissionRequest(mainFragment));
        } else {
            ActivityCompat.requestPermissions(mainFragment, PERMISSION_CROPIMAGE, 1);
        }
    }

    static void onRequestPermissionsResult(MainFragment mainFragment, int i, int[] iArr) {
        if (i != 0) {
            if (i == 1 && ((PermissionUtils.getTargetSdkVersion(mainFragment) >= 23 || PermissionUtils.hasSelfPermissions(mainFragment, PERMISSION_CROPIMAGE)) && PermissionUtils.verifyPermissions(iArr))) {
                mainFragment.cropImage();
            }
        } else if ((PermissionUtils.getTargetSdkVersion(mainFragment) >= 23 || PermissionUtils.hasSelfPermissions(mainFragment, PERMISSION_PICKIMAGE)) && PermissionUtils.verifyPermissions(iArr)) {
            mainFragment.pickImage();
        }
    }
}
