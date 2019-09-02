package com.subasta.activity.authentication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.cocosw.bottomsheet.BottomSheet.Builder;
import com.google.android.material.snackbar.Snackbar;
import com.subasta.C2037R;
import com.subasta.databinding.ActivitySignUpBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ImageCompression;
import com.subasta.utils.ImageCompression.AsyncResponse;
import com.subasta.utils.MainFragment;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SuppressLint("WrongConstant")
public class Sign_Up extends AppCompatActivity implements OnClickListener {
    public static final String MyPREFERENCES = "MyPrefs";
    int CROP_CAMERA_IMAGE = 3;
    int CROP_GALLERY_IMAGE = 4;
    int PICK_FROM_CAMERA = 1;
    int PICK_FROM_GALLERY = 2;
    private String TAG = Sign_Up.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivitySignUpBinding binding;

    /* renamed from: bm */
    Bitmap f1300bm;
    Builder builder;
    File file;
    private SharedPreferences firebase;
    ImageCompression imageCompression;
    String imageName;
    private boolean isHide = false;
    /* access modifiers changed from: private */
    public HashMap<String, File> paramsFile = new HashMap<>();
    String pathOfImage;
    Uri picUri;
    /* access modifiers changed from: private */
    public SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public Context sContext;
    SharedPreferences sharedPreferences;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivitySignUpBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_sign__up);
        this.sContext = this;
        this.sharedPreferences = getSharedPreferences("MyPrefs", 0);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("getInstanceId :====>");
        sb.append(this.sharedPreferences.getString(Const.DEVICE_TOKEN, ""));
        Log.w(str, sb.toString());
        this.prefrence = SharedPrefrence.getInstance(this.sContext);
        setUiAction();
    }

    private void setUiAction() {
        this.binding.btnSignUp.setOnClickListener(this);
        this.binding.ivBack.setOnClickListener(this);
        this.binding.cardViewProfile.setOnClickListener(this);
        this.binding.ivPass.setOnClickListener(this);
        this.builder = new Builder(this).sheet(C2037R.C2041menu.menu_cards);
        this.builder.title((CharSequence) "Please select image");
        this.builder.listener((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = "android.permission.WRITE_EXTERNAL_STORAGE";
                String str2 = "android.permission.CAMERA";
                if (i == C2037R.C2039id.camera_cards) {
                    Sign_Up sign_Up = Sign_Up.this;
                    if (ProjectUtils.hasPermissionInManifest(sign_Up, sign_Up.PICK_FROM_CAMERA, str2)) {
                        Sign_Up sign_Up2 = Sign_Up.this;
                        if (ProjectUtils.hasPermissionInManifest(sign_Up2, sign_Up2.PICK_FROM_GALLERY, str)) {
                            try {
                                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                File access$000 = Sign_Up.this.getOutputMediaFile(1);
                                if (!access$000.exists()) {
                                    try {
                                        ProjectUtils.pauseProgressDialog();
                                        access$000.createNewFile();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (VERSION.SDK_INT >= 24) {
                                    Sign_Up sign_Up3 = Sign_Up.this;
                                    Context applicationContext = Sign_Up.this.getApplicationContext();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(Sign_Up.this.getApplicationContext().getPackageName());
                                    sb.append(".fileprovider");
                                    sign_Up3.picUri = FileProvider.getUriForFile(applicationContext, sb.toString(), access$000);
                                } else {
                                    Sign_Up.this.picUri = Uri.fromFile(access$000);
                                }
                                Sign_Up.this.prefrence.setValue(Const.IMAGE_URI_CAMERA, Sign_Up.this.picUri.toString());
                                intent.putExtra("output", Sign_Up.this.picUri);
                                Sign_Up.this.startActivityForResult(intent, Sign_Up.this.PICK_FROM_CAMERA);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } else if (i == C2037R.C2039id.cancel_cards) {
//                    Sign_Up.this.builder.setOnDismissListener(new OnDismissListener() {
//                        public void onDismiss(DialogInterface dialogInterface) {
//                            dialogInterface.dismiss();
//                        }
//                    });
                } else if (i == C2037R.C2039id.gallery_cards) {
                    Sign_Up sign_Up4 = Sign_Up.this;
                    if (ProjectUtils.hasPermissionInManifest(sign_Up4, sign_Up4.PICK_FROM_CAMERA, str2)) {
                        Sign_Up sign_Up5 = Sign_Up.this;
                        if (ProjectUtils.hasPermissionInManifest(sign_Up5, sign_Up5.PICK_FROM_GALLERY, str)) {
                            File access$0002 = Sign_Up.this.getOutputMediaFile(1);
                            if (!access$0002.exists()) {
                                try {
                                    access$0002.createNewFile();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            Sign_Up.this.picUri = Uri.fromFile(access$0002);
                            Intent intent2 = new Intent();
                            intent2.setType("image/*");
                            intent2.setAction("android.intent.action.GET_CONTENT");
                            Sign_Up.this.startActivityForResult(Intent.createChooser(intent2, "Please select image."), Sign_Up.this.PICK_FROM_GALLERY);
                        }
                    }
                }
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = "resultUri";
        if (i == this.CROP_CAMERA_IMAGE && intent != null) {
            this.picUri = Uri.parse(intent.getExtras().getString(str));
            try {
                this.pathOfImage = this.picUri.getPath();
                this.imageCompression = new ImageCompression(this.sContext);
                this.imageCompression.execute(new String[]{this.pathOfImage});
                this.imageCompression.setOnTaskFinishedEvent(new AsyncResponse() {
                    public void processFinish(String str) {
                        String str2 = Const.IMAGE;
                        RequestManager with = Glide.with(Sign_Up.this.sContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append("file://");
                        sb.append(str);
//                        ((RequestBuilder) with.load(sb.toString()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) Sign_Up.this.binding.ivProfilePic);
                        try {
                            Sign_Up.this.file = new File(str);
                            Log.e(str2, str);
                            Sign_Up.this.paramsFile.put(str2, Sign_Up.this.file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i == this.CROP_GALLERY_IMAGE && intent != null) {
            this.picUri = Uri.parse(intent.getExtras().getString(str));
            try {
                this.f1300bm = Media.getBitmap(this.sContext.getContentResolver(), this.picUri);
                this.pathOfImage = this.picUri.getPath();
                this.imageCompression = new ImageCompression(this.sContext);
                this.imageCompression.execute(new String[]{this.pathOfImage});
                this.imageCompression.setOnTaskFinishedEvent(new AsyncResponse() {
                    public void processFinish(String str) {
                        RequestManager with = Glide.with(Sign_Up.this.sContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append("file://");
                        sb.append(str);
//                        ((RequestBuilder) with.load(sb.toString()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) Sign_Up.this.binding.ivProfilePic);
                        String str2 = Const.IMAGE;
                        Log.e(str2, str);
                        try {
                            Sign_Up.this.file = new File(str);
                            Sign_Up.this.paramsFile.put(str2, Sign_Up.this.file);
                            Log.e(str2, str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (i == this.PICK_FROM_CAMERA && i2 == -1) {
            Uri uri = this.picUri;
            String str2 = Const.IMAGE_URI_CAMERA;
            if (uri != null) {
                this.picUri = Uri.parse(this.prefrence.getValue(str2));
                startCropping(this.picUri, this.CROP_CAMERA_IMAGE);
            } else {
                this.picUri = Uri.parse(this.prefrence.getValue(str2));
                startCropping(this.picUri, this.CROP_CAMERA_IMAGE);
            }
        }
        if (i == this.PICK_FROM_GALLERY && i2 == -1) {
            try {
                Uri data = intent.getData();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(data);
                Log.e("front tempUri", sb.toString());
                if (data != null) {
                    startCropping(data, this.CROP_GALLERY_IMAGE);
                }
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void startCropping(Uri uri, int i) {
        Intent intent = new Intent(this.sContext, MainFragment.class);
        intent.putExtra("imageUri", uri.toString());
        intent.putExtra("requestCode", i);
        startActivityForResult(intent, i);
    }

    /* access modifiers changed from: private */
    public File getOutputMediaFile(int i) {
        String file2 = Environment.getExternalStorageDirectory().toString();
        String str = Const.APP_NAME;
        File file3 = new File(file2, str);
        if (!file3.exists() && !file3.mkdirs()) {
            return null;
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        if (i != 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file3.getPath());
        sb.append(File.separator);
        sb.append(str);
        sb.append(format);
        String str2 = ".png";
        sb.append(str2);
        File file4 = new File(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(format);
        sb2.append(str2);
        this.imageName = sb2.toString();
        return file4;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.btnSignUp /*2131361928*/:
                clickForSubmit();
                return;
            case C2037R.C2039id.cardViewProfile /*2131361961*/:
                this.builder.show();
                return;
            case C2037R.C2039id.ivBack /*2131362135*/:
                finish();
                return;
            case C2037R.C2039id.ivPass /*2131362155*/:
                if (this.isHide) {
                    this.binding.ivPass.setImageResource(C2037R.C2038drawable.eye);
                    this.binding.etPassword.setTransformationMethod(null);
                    this.binding.etPassword.setSelection(this.binding.etPassword.getText().length());
                    this.isHide = false;
                    return;
                }
                this.binding.ivPass.setImageResource(C2037R.C2038drawable.passwordhide);
                this.binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.binding.etPassword.setSelection(this.binding.etPassword.getText().length());
                this.isHide = true;
                return;
            default:
                return;
        }
    }

    private void signup() {
        ProjectUtils.showProgressDialog(this.sContext, false, getResources().getString(C2037R.string.please_wait));
        new HttpsRequest(Const.SIGN_UP, getParamsSignUp(), this.paramsFile, this.sContext).imagePost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ProjectUtils.showToast(Sign_Up.this.sContext, str);
                    Sign_Up.this.finish();
                    return;
                }
                ProjectUtils.showToast(Sign_Up.this.sContext, str);
            }
        });
    }

    public HashMap<String, String> getParamsSignUp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("email", ProjectUtils.getEditTextValue(this.binding.etEmail));
        hashMap.put(Const.MOBILE_NO, ProjectUtils.getEditTextValue(this.binding.etMobile));
        hashMap.put("name", ProjectUtils.getEditTextValue(this.binding.etName));
        hashMap.put(Const.PASSWORD, ProjectUtils.getEditTextValue(this.binding.etPassword));
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        String str = "";
        String str2 = Const.DEVICE_TOKEN;
        hashMap.put(str2, sharedPreferences2.getString(str2, str));
        hashMap.put(Const.DEVICE_TYPE, "ANDROID");
        StringBuilder sb = new StringBuilder();
//        sb.append(this.binding.cCodePicker.getSelectedCountryCode());
        sb.append(str);
        hashMap.put(Const.COUNTRY_CODE, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.TAG);
        sb2.append("---Params --->");
        ProjectUtils.showLog(sb2.toString(), hashMap.toString());
        return hashMap;
    }

    private void clickForSubmit() {
        if (this.file == null) {
            showSickbar(getResources().getString(C2037R.string.please_upload));
        } else if (!validation(this.binding.etName, getResources().getString(C2037R.string.val_name)) || !validation(this.binding.etEmail, getResources().getString(C2037R.string.val_email))) {
        } else {
            if (!ProjectUtils.isEmailValid(this.binding.etEmail.getText().toString().trim())) {
                showSickbar(getResources().getString(C2037R.string.valid_email_id));
            } else if (!ProjectUtils.isPhoneNumberValid(this.binding.etMobile.getText().toString().trim())) {
                showSickbar(getResources().getString(C2037R.string.val_mobile));
            } else if (!ProjectUtils.isPasswordValid(this.binding.etPassword.getText().toString().trim())) {
                showSickbar(getResources().getString(C2037R.string.val_password));
            } else if (NetworkManager.isConnectToInternet(this.sContext)) {
                signup();
            } else {
                ProjectUtils.InternetAlertDialog(this.sContext);
            }
        }
    }

    private void showSickbar(String str) {
        Snackbar make = Snackbar.make((View) this.binding.rlSnackbar, (CharSequence) str, 0);
        make.getView().setBackgroundColor(getResources().getColor(C2037R.color.colorPrimary));
        make.show();
    }

    private boolean validation(EditText editText, String str) {
        if (ProjectUtils.isEditTextFilled(editText)) {
            return true;
        }
        Snackbar make = Snackbar.make((View) this.binding.rlSnackbar, (CharSequence) str, 0);
        make.getView().setBackgroundColor(getResources().getColor(C2037R.color.colorPrimary));
        make.show();
        return false;
    }
}
