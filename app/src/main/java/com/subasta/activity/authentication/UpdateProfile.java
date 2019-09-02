package com.subasta.activity.authentication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.cocosw.bottomsheet.BottomSheet.Builder;
import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.databinding.ActivityUpdateprofileBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.UpdateProfileDTO;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ImageCompression;
import com.subasta.utils.ImageCompression.AsyncResponse;
import com.subasta.utils.MainFragment;
import com.subasta.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

//import com.facebook.appevents.AppEventsConstants;
//import com.facebook.share.internal.ShareConstants;
//import com.hbb20.CountryCodePicker;
//import com.schibstedspain.leku.LocationPickerActivity;

public class UpdateProfile extends AppCompatActivity implements OnClickListener {
    int CROP_CAMERA_IMAGE = 3;
    int CROP_GALLERY_IMAGE = 4;
    int PICK_FROM_CAMERA = 1;
    int PICK_FROM_GALLERY = 2;
    int PLACE_PICKER_REQUEST = 6;
    private String TAG = UpdateProfile.class.getCanonicalName();
    /* access modifiers changed from: private */
    public ActivityUpdateprofileBinding binding;

    /* renamed from: bm */
    Bitmap f1301bm;
    Builder builder;
    private String city;
    private String country;
    File file;
    private SharedPreferences firebase;
    ImageCompression imageCompression;
    String imageName;
    private double lattitude;
    private double longitude;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public HashMap<String, File> paramsFile = new HashMap<>();
    String pathOfImage;
    Uri picUri;
    private String postCode;
    /* access modifiers changed from: private */
    public SharedPrefrence prefrence;
    private SharedPrefrence sharedPrefrence;
    private Sign_Up sign_up;
    private UpdateProfileDTO updateProfileDTO;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityUpdateprofileBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_updateprofile);
        this.mContext = this;
        this.firebase = getSharedPreferences("MyPrefs", 0);
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("---tokensss");
        ProjectUtils.showLog(sb.toString(), this.firebase.getString(Const.DEVICE_TOKEN, ""));
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.sharedPrefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        setUiAction();
        showData();
//        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(this.userDTO.getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) this.binding.civProfile);
    }

    private void setUiAction() {
        this.binding.btnsubmitdata.setOnClickListener(this);
//        this.binding.civProfile1.setOnClickListener(this);
        this.binding.cetAddress.setOnClickListener(this);
        this.builder = new Builder(this).sheet(C2037R.C2041menu.menu_cards);
        this.builder.title((CharSequence) "Please select image");
        this.builder.listener((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = "android.permission.WRITE_EXTERNAL_STORAGE";
                String str2 = "android.permission.CAMERA";
                if (i == C2037R.C2039id.camera_cards) {
                    UpdateProfile updateProfile = UpdateProfile.this;
                    if (ProjectUtils.hasPermissionInManifest(updateProfile, updateProfile.PICK_FROM_CAMERA, str2)) {
                        UpdateProfile updateProfile2 = UpdateProfile.this;
                        if (ProjectUtils.hasPermissionInManifest(updateProfile2, updateProfile2.PICK_FROM_GALLERY, str)) {
                            try {
                                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                File access$000 = UpdateProfile.this.getOutputMediaFile(1);
                                if (!access$000.exists()) {
                                    try {
                                        ProjectUtils.pauseProgressDialog();
                                        access$000.createNewFile();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (VERSION.SDK_INT >= 24) {
                                    UpdateProfile updateProfile3 = UpdateProfile.this;
                                    Context applicationContext = UpdateProfile.this.getApplicationContext();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(UpdateProfile.this.getApplicationContext().getPackageName());
                                    sb.append(".fileprovider");
                                    updateProfile3.picUri = FileProvider.getUriForFile(applicationContext, sb.toString(), access$000);
                                } else {
                                    UpdateProfile.this.picUri = Uri.fromFile(access$000);
                                }
                                UpdateProfile.this.prefrence.setValue(Const.IMAGE_URI_CAMERA, UpdateProfile.this.picUri.toString());
                                intent.putExtra("output", UpdateProfile.this.picUri);
                                UpdateProfile.this.startActivityForResult(intent, UpdateProfile.this.PICK_FROM_CAMERA);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } else if (i == C2037R.C2039id.cancel_cards) {
//                    UpdateProfile.this.builder.setOnDismissListener(new OnDismissListener() {
//                        public void onDismiss(DialogInterface dialogInterface) {
//                            dialogInterface.dismiss();
//                        }
//                    });
                } else if (i == C2037R.C2039id.gallery_cards) {
                    UpdateProfile updateProfile4 = UpdateProfile.this;
                    if (ProjectUtils.hasPermissionInManifest(updateProfile4, updateProfile4.PICK_FROM_CAMERA, str2)) {
                        UpdateProfile updateProfile5 = UpdateProfile.this;
                        if (ProjectUtils.hasPermissionInManifest(updateProfile5, updateProfile5.PICK_FROM_GALLERY, str)) {
                            File access$0002 = UpdateProfile.this.getOutputMediaFile(1);
                            if (!access$0002.exists()) {
                                try {
                                    access$0002.createNewFile();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            UpdateProfile.this.picUri = Uri.fromFile(access$0002);
                            Intent intent2 = new Intent();
                            intent2.setType("image/*");
                            intent2.setAction("android.intent.action.GET_CONTENT");
                            UpdateProfile.this.startActivityForResult(Intent.createChooser(intent2, "Please select image."), UpdateProfile.this.PICK_FROM_GALLERY);
                        }
                    }
                }
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.PLACE_PICKER_REQUEST && i2 == -1) {
            try {
                ProjectUtils.pauseProgressDialog();
                this.lattitude = intent.getDoubleExtra("latitude", 0.0d);
                this.longitude = intent.getDoubleExtra("longitude", 0.0d);
                Log.d("LONGITUDE****", String.valueOf(this.longitude));
                getAddress(this.lattitude, this.longitude);
            } catch (Exception unused) {
            }
        }
        String str = "resultUri";
        if (i == this.CROP_CAMERA_IMAGE && intent != null) {
            this.picUri = Uri.parse(intent.getExtras().getString(str));
            try {
                this.pathOfImage = this.picUri.getPath();
                this.imageCompression = new ImageCompression(this.mContext);
                this.imageCompression.execute(new String[]{this.pathOfImage});
                this.imageCompression.setOnTaskFinishedEvent(new AsyncResponse() {
                    public void processFinish(String str) {
                        String str2 = Const.IMAGE;
                        RequestManager with = Glide.with(UpdateProfile.this.mContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append("file://");
                        sb.append(str);
//                        ((RequestBuilder) with.load(sb.toString()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) UpdateProfile.this.binding.civProfile);
                        try {
                            UpdateProfile.this.file = new File(str);
                            Log.e(str2, str);
                            UpdateProfile.this.paramsFile.put(str2, UpdateProfile.this.file);
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
                this.f1301bm = Media.getBitmap(this.mContext.getContentResolver(), this.picUri);
                this.pathOfImage = this.picUri.getPath();
                this.imageCompression = new ImageCompression(this.mContext);
                this.imageCompression.execute(new String[]{this.pathOfImage});
                this.imageCompression.setOnTaskFinishedEvent(new AsyncResponse() {
                    public void processFinish(String str) {
                        RequestManager with = Glide.with(UpdateProfile.this.mContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append("file://");
                        sb.append(str);
//                        ((RequestBuilder) with.load(sb.toString()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) UpdateProfile.this.binding.civProfile);
                        String str2 = Const.IMAGE;
                        Log.e(str2, str);
                        try {
                            UpdateProfile.this.file = new File(str);
                            UpdateProfile.this.paramsFile.put(str2, UpdateProfile.this.file);
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

    public void getAddress(double d, double d2) {
        String str = "\n";
        try {
            Address address = (Address) new Geocoder(this, Locale.getDefault()).getFromLocation(d, d2, 1).get(0);
            String addressLine = address.getAddressLine(0);
            StringBuilder sb = new StringBuilder();
            sb.append(addressLine);
            sb.append(str);
            sb.append(address.getCountryName());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(str);
            sb3.append(address.getCountryCode());
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(str);
            sb5.append(address.getAdminArea());
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(str);
            sb7.append(address.getPostalCode());
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            sb9.append(str);
            sb9.append(address.getSubAdminArea());
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            sb11.append(str);
            sb11.append(address.getLocality());
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            sb13.append(str);
            sb13.append(address.getSubThoroughfare());
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append("Address");
            sb15.append(sb14);
            Log.e("IGA", sb15.toString());
            this.binding.cetAddress.setText(address.getAddressLine(0));
            this.city = String.valueOf(address.getLocality());
            this.country = String.valueOf(address.getCountryName());
            this.postCode = String.valueOf(address.getPostalCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startCropping(Uri uri, int i) {
        Intent intent = new Intent(this.mContext, MainFragment.class);
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

    private void setData() {
        ProjectUtils.showProgressDialog(this.mContext, false, getResources().getString(C2037R.string.please_wait));
        new HttpsRequest(Const.UPDATE_PROFILE, getParamsSignUp(), this.paramsFile, this.mContext).imagePost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) throws JSONException {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ProjectUtils.showToast(UpdateProfile.this.mContext, str);
                    try {
//                        UpdateProfile.this.userDTO = (UserDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), UserDTO.class);
                        UpdateProfile.this.prefrence.setParentUser(UpdateProfile.this.userDTO, Const.USER_DTO);
                        UpdateProfile.this.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(UpdateProfile.this.mContext, str);
                }
            }
        });
    }

    private void showData() {
        this.binding.ctvName.setText(ProjectUtils.capWordFirstLetter(this.userDTO.getName()));
        this.binding.cetAddress.setText(this.userDTO.getAddress());
        this.binding.cetPhoneno.setText(this.userDTO.getMobile_no());
        this.binding.etEmail.setText(this.userDTO.getEmail());
//        this.binding.cCodePicker.setCountryForPhoneCode(Integer.parseInt(this.userDTO.getCountry_code()));
//        CountryCodePicker countryCodePicker = this.binding.cCodePicker;
        StringBuilder sb = new StringBuilder();
        sb.append(this.userDTO.getCountry_code());
        sb.append(this.userDTO.getCountry());
//        countryCodePicker.setDetectCountryWithAreaCode(Boolean.parseBoolean(sb.toString()));
        this.city = this.userDTO.getCity();
        this.postCode = this.userDTO.getPostcode();
//        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(this.userDTO.getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) this.binding.civProfile);
        this.country = this.userDTO.getCountry();
        if (this.userDTO.getGender().equals("male")) {
            this.binding.male.setChecked(true);
        } else if (this.userDTO.getGender().equals("female")) {
            this.binding.female.setChecked(true);
        }
        if (!this.userDTO.getLatitude().equals("")) {
            this.lattitude = Double.parseDouble(this.userDTO.getLatitude());
            this.longitude = Double.parseDouble(this.userDTO.getLongitude());
        }
    }

    @SuppressLint("WrongConstant")
    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.btnsubmitdata /*2131361933*/:
                validation();
                return;
            case C2037R.C2039id.cetAddress /*2131361969*/:
//                showlocation();
                return;
            case C2037R.C2039id.civProfile1 /*2131361985*/:
                this.builder.show();
                return;
            case C2037R.C2039id.profileback /*2131362306*/:
                onBackPressed();
                return;
            case C2037R.C2039id.profilenotification /*2131362307*/:
                Intent intent = new Intent(this, Dashboard.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("index", 0);
                startActivity(intent);
                return;
            default:
                return;
        }
    }

    @SuppressLint("WrongConstant")
    private void validation() {
        String str = "";
        if (ProjectUtils.getEditTextValue(this.binding.etEmail).equalsIgnoreCase(str)) {
            Toast.makeText(this.mContext, "please enter the mail", 0).show();
        } else if (ProjectUtils.getEditTextValue(this.binding.cetPhoneno).equalsIgnoreCase(str)) {
            Toast.makeText(this.mContext, "please enter Mobile number ", 0).show();
        } else if (ProjectUtils.getEditTextValue(this.binding.cetAddress).equalsIgnoreCase(str)) {
            Toast.makeText(this.mContext, "please enter Address ", 0).show();
        } else if (ProjectUtils.getEditTextValue(this.binding.ctvName).equalsIgnoreCase(str)) {
            Toast.makeText(this.mContext, "please enter Name ", 0).show();
        } else if (NetworkManager.isConnectToInternet(this.mContext)) {
            setData();
        } else {
            ProjectUtils.InternetAlertDialog(this.mContext);
        }
    }

    @SuppressLint("WrongConstant")
    public HashMap<String, String> getParamsSignUp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Const.MOBILE_NO, ProjectUtils.getEditTextValue(this.binding.cetPhoneno));
        hashMap.put("name", ProjectUtils.getEditTextValue(this.binding.ctvName));
        hashMap.put("email", ProjectUtils.getEditTextValue(this.binding.etEmail));
        hashMap.put("address", ProjectUtils.getEditTextValue(this.binding.cetAddress));
        hashMap.put(Const.CITY, this.city);
        hashMap.put(Const.COUNTRY, this.country);
        StringBuilder sb = new StringBuilder();
        sb.append(this.lattitude);
        String str = "";
        sb.append(str);
        hashMap.put("latitude", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.longitude);
        sb2.append(str);
        hashMap.put("longitude", sb2.toString());
        hashMap.put(Const.POSTCODE, this.postCode);
        hashMap.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        boolean isChecked = this.binding.male.isChecked();
        String str2 = Const.GENDER;
        if (isChecked) {
            hashMap.put(str2, "male");
        } else if (this.binding.female.isChecked()) {
            hashMap.put(str2, "female");
        } else {
            Toast.makeText(this.mContext, "please check field", 0).show();
        }
        SharedPreferences sharedPreferences = this.firebase;
        String str3 = Const.DEVICE_TOKEN;
//        hashMap.put(str3, sharedPreferences.getString(str3, AppEventsConstants.EVENT_PARAM_VALUE_YES));
        hashMap.put(Const.DEVICE_TYPE, "ANDROID");
        StringBuilder sb3 = new StringBuilder();
//        sb3.append(this.binding.cCodePicker.getSelectedCountryCode());
        sb3.append(str);
        hashMap.put(Const.COUNTRY_CODE, sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.TAG);
        sb4.append("---Params --->");
        ProjectUtils.showLog(sb4.toString(), hashMap.toString());
        return hashMap;
    }
}
