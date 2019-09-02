package com.subasta.event;

import net.gotev.uploadservice.UploadServiceBroadcastReceiver;

public class SingleUploadBroadcastReceiver extends UploadServiceBroadcastReceiver {
    private Delegate mDelegate;
    private String mUploadID;

    public interface Delegate {
        void onCancelled();

        void onCompleted(int i, byte[] bArr);

        void onError(Exception exc);

        void onProgress(int i);

        void onProgress(long j, long j2);
    }

    public void setUploadID(String str) {
        this.mUploadID = str;
    }

    public void setDelegate(Delegate delegate) {
        this.mDelegate = delegate;
    }

    public void onProgress(String str, int i) {
        if (str.equals(this.mUploadID)) {
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                delegate.onProgress(i);
            }
        }
    }

    public void onProgress(String str, long j, long j2) {
        if (str.equals(this.mUploadID)) {
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                delegate.onProgress(j, j2);
            }
        }
    }

    public void onError(String str, Exception exc) {
        if (str.equals(this.mUploadID)) {
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                delegate.onError(exc);
            }
        }
    }

    public void onCompleted(String str, int i, byte[] bArr) {
        if (str.equals(this.mUploadID)) {
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                delegate.onCompleted(i, bArr);
            }
        }
    }

    public void onCancelled(String str) {
        if (str.equals(this.mUploadID)) {
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                delegate.onCancelled();
            }
        }
    }
}
