package permissions.dispatcher.v13;

import android.app.Fragment;

public final class V13Access {
    V13Access() {
    }

    public boolean shouldShowRequestPermissionRationale(Fragment fragment, String... strArr) {
        for (String shouldShowRequestPermissionRationale : strArr) {
//            if (FragmentCompat.shouldShowRequestPermissionRationale(fragment, shouldShowRequestPermissionRationale)) {
//                return true;
//            }
        }
        return false;
    }

    public void requestPermissions(Fragment fragment, String[] strArr, int i) {
//        FragmentCompat.requestPermissions(fragment, strArr, i);
    }
}
