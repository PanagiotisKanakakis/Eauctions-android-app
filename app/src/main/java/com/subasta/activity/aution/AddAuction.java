package com.subasta.activity.aution;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cocosw.bottomsheet.BottomSheet.Builder;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.darsh.multipleimageselect.models.Image;
import com.google.android.material.snackbar.Snackbar;
import com.subasta.C2037R;
import com.subasta.adapter.ImageAdapter;
import com.subasta.databinding.ActivityDetailsAutionBinding;
import com.subasta.event.SingleUploadBroadcastReceiver;
import com.subasta.event.SingleUploadBroadcastReceiver.Delegate;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.interfaces.OnSpinerItemClick;
import com.subasta.model.AddAuctionDTO;
import com.subasta.model.AuncitonImageDTO;
import com.subasta.model.CommonDTO;
import com.subasta.model.ImageDTO;
import com.subasta.model.MyAutionDTO;
import com.subasta.model.SubBrandsDTO;
import com.subasta.model.SubModelDTO;
import com.subasta.model.UserDTO;
import com.subasta.myauctionfregment.MyAuctions;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.ImageCompression;
import com.subasta.utils.ImageCompression.AsyncResponse;
import com.subasta.utils.MainFragment;
import com.subasta.utils.ProjectUtils;
import com.subasta.utils.SpinnerDialog;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//import com.facebook.appevents.AppEventsConstants;
//import com.facebook.share.internal.ShareConstants;
//import com.schibstedspain.leku.LocationPickerActivity;

@SuppressLint("WrongConstant")
public class AddAuction extends AppCompatActivity implements OnClickListener, Delegate {
    int CROP_CAMERA_IMAGE = 3;
    int CROP_GALLERY_IMAGE = 4;
    int PICK_FROM_CAMERA = 1;
    int PICK_FROM_GALLERY = 2;
    int PICK_IMAGE_MULTIPLE = 5;
    int PLACE_PICKER_REQUEST = 101;
    private String TAG = AddAuction.class.getCanonicalName();
    AddAuctionDTO addAuctionDTO;
    private ArrayList<AddAuctionDTO> addAuctionDTOArrayList;
    private ImageAdapter addImageAdapter;
    /* access modifiers changed from: private */
    public ActivityDetailsAutionBinding binding;

    /* renamed from: bm */
    Bitmap f1302bm;
    String brandName;
    String brandid;
    Builder builder;
    String catid;
    ArrayList<CommonDTO> commonList = new ArrayList<>();
    ArrayList<CommonDTO> commonListModel = new ArrayList<>();
    DatePickerDialog datePickerDialogADp;
    DatePickerDialog datePickerDialogEnd;
    File file;
    public ArrayList<File> files;
    int flag;
    String image;
    ImageCompression imageCompression;
    private ArrayList<ImageDTO> imageDTOArrayList;
    String imageName;
    ArrayList<Image> images;
    private double lattitude;
    private RecyclerView.LayoutManager layoutManager;
    private double longitude;
    /* access modifiers changed from: private */
    public Context mContext;
    private String modelName;
    String modelid;
    MyAuctions myAuctions = new MyAuctions();
    MyAutionDTO myAutionDTO;
    final Calendar myCalendar = Calendar.getInstance();
    final Calendar myCalendarAdop = Calendar.getInstance();
    final Calendar myCalendarEnd = Calendar.getInstance();
    /* access modifiers changed from: private */
    public Map<String, ArrayList<File>> paramsFile = new HashMap();
    String pathOfImage;
    Uri picUri;
    SharedPrefrence prefrence;
    SharedPrefrence sharedPrefrence;
    SpinnerDialog spinnerDialog;
    SpinnerDialog spinnerDialogModel;
    boolean statusBrand = false;
    /* access modifiers changed from: private */
    public ArrayList<SubBrandsDTO> subBrandsDTOArrayList;
    /* access modifiers changed from: private */
    public ArrayList<SubModelDTO> subModelDTOArrayList;
    String subcatid;
    private final SingleUploadBroadcastReceiver uploadReceiver = new SingleUploadBroadcastReceiver();
    UserDTO userDTO;
    String user_pub_id;

    public void onProgress(int i) {
    }

    public void onProgress(long j, long j2) {
    }

    public AddAuction() {
        String str = "";
        this.brandid = str;
        this.brandName = str;
        this.catid = str;
        this.modelid = str;
        this.subcatid = str;
        this.user_pub_id = str;
        this.flag = 0;
        this.files = new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProjectUtils.changeStatusBarColorNew(this, C2037R.color.topColor);
        this.binding = (ActivityDetailsAutionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_details_aution);
        this.mContext = this;
        this.sharedPrefrence = SharedPrefrence.getInstance(this);
        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        this.user_pub_id = this.userDTO.getUser_pub_id();
        setData();
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        Intent intent = getIntent();
        String str = Const.FLAG;
        if (intent.hasExtra(str)) {
            this.flag = getIntent().getIntExtra(str, 0);
            if (this.flag == 1) {
                this.myAutionDTO = (MyAutionDTO) getIntent().getSerializableExtra(Const.MY_AUCTIONDTO);
                this.subcatid = this.myAutionDTO.getSub_cat_id();
                this.catid = this.myAutionDTO.getCat_id();
                this.binding.llImages.setVisibility(8);
                setData();
            }
        } else {
            this.subcatid = getIntent().getStringExtra(Const.GET_SUB_CAT_ID);
            this.catid = getIntent().getStringExtra("cat_id");
        }
        this.binding.btnpost.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (AddAuction.this.files.size() > 0) {
                    AddAuction.this.paramsFile.put(Const.IMAGE, AddAuction.this.files);
                }
                if (AddAuction.this.flag == 1) {
                    AddAuction.this.CheckEditFiled();
                } else {
                    AddAuction.this.checkAllFields();
                }
            }
        });
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AddAuction.this.onBackPressed();
            }
        });
        setSubbrand();
        setUiAction();
    }

    private void setData() {
        try {
            CustomEditText customEditText = this.binding.etBrandName;
            StringBuilder sb = new StringBuilder();
            sb.append(this.myAutionDTO.getBrand_name());
            sb.append("/");
            sb.append(this.myAutionDTO.getModel_name());
            customEditText.setText(sb.toString());
            this.binding.etTitle.setText(ProjectUtils.capWordFirstLetter(this.myAutionDTO.getTitle()));
            this.binding.etDescription.setText(this.myAutionDTO.getDescription());
            this.binding.etEndDate.setText(this.myAutionDTO.getE_date());
            this.binding.etSDate.setText(this.myAutionDTO.getS_date());
            this.binding.etAdress.setText(this.myAutionDTO.getAddress());
            this.binding.etPrice.setText(this.myAutionDTO.getPrice());
            this.binding.etOwner.setText(this.myAutionDTO.getNo_of_owner());
//            if (this.myAutionDTO.getInsured().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//                this.binding.rbNo.setChecked(true);
//            } else {
//                this.binding.rbYes.setChecked(true);
//            }
            ((RequestBuilder) Glide.with(this.mContext).load(((AuncitonImageDTO) this.myAutionDTO.getImage_cust().get(0)).getImage()).placeholder((int) C2037R.C2038drawable.dummy)).into(this.binding.ivAddImages);
        } catch (Exception unused) {
        }
    }

    public static boolean CheckDates(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (!simpleDateFormat.parse(str).before(simpleDateFormat.parse(str2)) && !simpleDateFormat.parse(str).equals(simpleDateFormat.parse(str2))) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void CheckEditFiled() {
        String str = "";
        if (ProjectUtils.getEditTextValue(this.binding.etDescription).equalsIgnoreCase(str)) {
            showSickbar("Please Enter Description");
        } else if (ProjectUtils.getEditTextValue(this.binding.etAdress).equalsIgnoreCase(str)) {
            showSickbar("Please Enter Adress");
        } else if (ProjectUtils.getEditTextValue(this.binding.etPrice).equalsIgnoreCase(str)) {
            showSickbar("Please Enter Price");
        } else if (ProjectUtils.getEditTextValue(this.binding.etSDate).equalsIgnoreCase(str)) {
            showSickbar("Please Select Start Date");
        } else if (ProjectUtils.getEditTextValue(this.binding.etEndDate).equalsIgnoreCase(str)) {
            showSickbar("Please Select End Date");
        } else if (ProjectUtils.getEditTextValue(this.binding.etSDate).equals(ProjectUtils.getEditTextValue(this.binding.etEndDate))) {
            showSickbar("Please Select Start & End Date");
        } else if (ProjectUtils.getEditTextValue(this.binding.etTitle).equalsIgnoreCase(str)) {
            showSickbar("Please Enter the title");
        } else if (NetworkManager.isConnectToInternet(this.mContext)) {
            editAuntion();
        } else {
            ProjectUtils.InternetAlertDialog(this.mContext);
        }
    }

    /* access modifiers changed from: private */
    public void checkAllFields() {
        String str = "";
        if (ProjectUtils.getEditTextValue(this.binding.etDescription).equalsIgnoreCase(str)) {
            showSickbar("Please Enter Description");
        } else if (ProjectUtils.getEditTextValue(this.binding.etAdress).equalsIgnoreCase(str)) {
            showSickbar("Please Enter Adress");
        } else if (ProjectUtils.getEditTextValue(this.binding.etPrice).equalsIgnoreCase(str)) {
            showSickbar("Please Enter Price");
        } else if (ProjectUtils.getEditTextValue(this.binding.etSDate).equalsIgnoreCase(str)) {
            showSickbar("Please Select Start Date");
        } else if (ProjectUtils.getEditTextValue(this.binding.etEndDate).equalsIgnoreCase(str)) {
            showSickbar("Please Select End Date");
        } else if (ProjectUtils.getEditTextValue(this.binding.etSDate).equals(ProjectUtils.getEditTextValue(this.binding.etEndDate))) {
            showSickbar("Please Select Start & End Date");
        } else if (ProjectUtils.getEditTextValue(this.binding.etTitle).equalsIgnoreCase(str)) {
            showSickbar("Please Enter the title");
        } else if (NetworkManager.isConnectToInternet(this.mContext)) {
            getAddAunctionDetail();
        } else {
            ProjectUtils.InternetAlertDialog(this.mContext);
        }
    }

    public void showSickbar(String str) {
        Snackbar make = Snackbar.make((View) this.binding.rlSnackbar, (CharSequence) str, 0);
        make.getView().setBackgroundColor(getResources().getColor(C2037R.color.colorPrimary));
        make.show();
    }

    private void updateLabel() {
        this.binding.etSDate.setText(new SimpleDateFormat("MM/dd/yy", Locale.US).format(this.myCalendar.getTime()));
    }

    private void setUiAction() {
        this.binding.ivAddImages.setOnClickListener(this);
        this.binding.etBrandName.setOnClickListener(this);
        this.binding.addMoreimages.setOnClickListener(this);
        this.binding.etAdress.setOnClickListener(this);
        this.binding.etSDate.setOnClickListener(this);
        this.binding.etEndDate.setOnClickListener(this);
        this.builder = new Builder(this).sheet(C2037R.C2041menu.menu_cards);
        this.builder.title((CharSequence) "Please select image");
        this.builder.listener((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = "android.permission.WRITE_EXTERNAL_STORAGE";
                String str2 = "android.permission.CAMERA";
                if (i == C2037R.C2039id.camera_cards) {
                    AddAuction addAuction = AddAuction.this;
                    if (ProjectUtils.hasPermissionInManifest(addAuction, addAuction.PICK_FROM_CAMERA, str2)) {
                        AddAuction addAuction2 = AddAuction.this;
                        if (ProjectUtils.hasPermissionInManifest(addAuction2, addAuction2.PICK_FROM_GALLERY, str)) {
                            try {
                                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                File access$300 = AddAuction.this.getOutputMediaFile(1);
                                if (!access$300.exists()) {
                                    try {
                                        ProjectUtils.pauseProgressDialog();
                                        access$300.createNewFile();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (VERSION.SDK_INT >= 24) {
                                    AddAuction addAuction3 = AddAuction.this;
                                    Context applicationContext = AddAuction.this.getApplicationContext();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(AddAuction.this.getApplicationContext().getPackageName());
                                    sb.append(".fileprovider");
                                    addAuction3.picUri = FileProvider.getUriForFile(applicationContext, sb.toString(), access$300);
                                } else {
                                    AddAuction.this.picUri = Uri.fromFile(access$300);
                                }
                                AddAuction.this.prefrence.setValue(Const.IMAGE_URI_CAMERA, AddAuction.this.picUri.toString());
                                intent.putExtra("output", AddAuction.this.picUri);
                                AddAuction.this.startActivityForResult(intent, AddAuction.this.PICK_FROM_CAMERA);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } else if (i == C2037R.C2039id.cancel_cards) {
//                    AddAuction.this.builder.setOnDismissListener(new OnDismissListener() {
//                        public void onDismiss(DialogInterface dialogInterface) {
//                            dialogInterface.dismiss();
//                        }
//                    });
                } else if (i == C2037R.C2039id.gallery_cards) {
                    AddAuction addAuction4 = AddAuction.this;
                    if (ProjectUtils.hasPermissionInManifest(addAuction4, addAuction4.PICK_FROM_CAMERA, str2)) {
                        AddAuction addAuction5 = AddAuction.this;
                        if (ProjectUtils.hasPermissionInManifest(addAuction5, addAuction5.PICK_FROM_GALLERY, str)) {
                            File access$3002 = AddAuction.this.getOutputMediaFile(1);
                            if (!access$3002.exists()) {
                                try {
                                    access$3002.createNewFile();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            AddAuction.this.picUri = Uri.fromFile(access$3002);
                            Intent intent2 = new Intent();
                            intent2.setType("image/*");
                            intent2.setAction("android.intent.action.GET_CONTENT");
                            AddAuction.this.startActivityForResult(Intent.createChooser(intent2, "Please select image."), AddAuction.this.PICK_FROM_GALLERY);
                        }
                    }
                }
            }
        });
    }

    private void getAddAunctionDetail() {
        ProjectUtils.showProgressDialog(this.mContext, false, getResources().getString(C2037R.string.please_wait));
        HashMap detail = getDetail();
        Map<String, ArrayList<File>> map = this.paramsFile;
        Context context = this.mContext;
        HttpsRequest httpsRequest = new HttpsRequest(Const.ADD_AUCTION, detail, map, context, context);
//        httpsRequest.multiImagePost(this.TAG, new Helper() {
//            public void backResponse(boolean z, String str, JSONObject jSONObject) {
//                ProjectUtils.pauseProgressDialog();
//                if (z) {
//                    try {
//                        ProjectUtils.showToast(AddAuction.this.mContext, str);
//                        Intent intent = new Intent(AddAuction.this.mContext, Dashboard.class);
//                        intent.addFlags(32768);
//                        intent.addFlags(268435456);
//                        intent.addFlags(67108864);
//                        intent.putExtra("index", 0);
//                        AddAuction.this.startActivity(intent);
//                        AddAuction.this.finish();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    ProjectUtils.showToast(AddAuction.this.mContext, str);
//                }
//            }
//        });
    }

    public void onError(Exception exc) {
        ProjectUtils.pauseProgressDialog();
    }

    public void onCompleted(int i, byte[] bArr) {
        ProjectUtils.pauseProgressDialog();
        try {
            String str = new String(bArr, Key.STRING_CHARSET_NAME);
            Log.e("-->res", str);
            JSONObject jSONObject = new JSONObject(str);
            ProjectUtils.showToast(this.mContext, jSONObject.getString("message"));
//            if (jSONObject.getString("status").equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
//                finish();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCancelled() {
        ProjectUtils.pauseProgressDialog();
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
                        RequestManager with = Glide.with(AddAuction.this.mContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append("file://");
                        sb.append(str);
                        ((RequestBuilder) with.load(sb.toString()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)).into(AddAuction.this.binding.ivAddImages);
                        try {
                            AddAuction.this.file = new File(str);
                            Log.e(Const.IMAGE, str);
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
                this.f1302bm = Media.getBitmap(this.mContext.getContentResolver(), this.picUri);
                this.pathOfImage = this.picUri.getPath();
                this.imageCompression = new ImageCompression(this.mContext);
                this.imageCompression.execute(new String[]{this.pathOfImage});
                this.imageCompression.setOnTaskFinishedEvent(new AsyncResponse() {
                    public void processFinish(String str) {
                        RequestManager with = Glide.with(AddAuction.this.mContext);
                        StringBuilder sb = new StringBuilder();
                        sb.append("file://");
                        sb.append(str);
                        ((RequestBuilder) with.load(sb.toString()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)).into(AddAuction.this.binding.ivAddImages);
                        String str2 = Const.IMAGE;
                        Log.e(str2, str);
                        try {
                            AddAuction.this.file = new File(str);
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
//        if (i == 2000 && i2 == -1 && intent != null) {
//            this.images = new ArrayList<>();
//            this.images = intent.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);
//            this.files = new ArrayList<>();
//            for (int i3 = 0; i3 < this.images.size(); i3++) {
//                this.imageCompression = new ImageCompression(this.mContext);
//                this.imageCompression.execute(new String[]{String.valueOf(((Image) this.images.get(i3)).path)});
//                this.imageCompression.setOnTaskFinishedEvent(new AsyncResponse() {
//                    public void processFinish(String str) {
//                        AddAuction.this.files.add(new File(str));
//                    }
//                });
//            }
//            if (this.images.size() < 5) {
//                this.binding.addMoreimages.setVisibility(0);
//            } else {
//                this.binding.addMoreimages.setVisibility(8);
//            }
//            this.binding.rvImage.setVisibility(0);
//            this.binding.llImages.setVisibility(8);
//            this.layoutManager = new LinearLayoutManager(this.mContext, 0, false);
//            this.binding.rvImage.setLayoutManager(this.layoutManager);
//            this.addImageAdapter = new ImageAdapter(this, this.images);
//            this.binding.rvImage.setAdapter(this.addImageAdapter);
//        }
    }

//    public void imageRemove(int i) {
//        if (this.images.size() < 5) {
//            this.binding.addMoreimages.setVisibility(0);
//        } else {
//            this.binding.addMoreimages.setVisibility(8);
//        }
//    }

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
            this.binding.etAdress.setText(address.getAddressLine(0));
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

    private HashMap<String, String> getDetail() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title", ProjectUtils.getEditTextValue(this.binding.etTitle));
        hashMap.put("description", ProjectUtils.getEditTextValue(this.binding.etDescription));
        hashMap.put(Const.S_Date, ProjectUtils.getEditTextValue(this.binding.etSDate));
        hashMap.put("address", ProjectUtils.getEditTextValue(this.binding.etAdress));
        hashMap.put(Const.E_DATE, ProjectUtils.getEditTextValue(this.binding.etEndDate));
//        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
//        hashMap.put(Const.NO_OF_OWNER, str);
        hashMap.put("price", ProjectUtils.getEditTextValue(this.binding.etPrice));
        boolean isChecked = this.binding.rbYes.isChecked();
        String str2 = Const.INSURED;
//        if (isChecked) {
//            hashMap.put(str2, str);
//        } else if (this.binding.rbNo.isChecked()) {
//            hashMap.put(str2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
//        } else {
//            Toast.makeText(this.mContext, "please check any radio button", 0).show();
//        }
        hashMap.put("cat_id", this.catid);
        hashMap.put(Const.GET_SUB_CAT_ID, this.subcatid);
        hashMap.put(Const.MODEL_ID, this.modelid);
        hashMap.put(Const.GET_BRAND_ID, this.brandid);
        StringBuilder sb = new StringBuilder();
        sb.append(this.lattitude);
        String str3 = "";
        sb.append(str3);
        hashMap.put("latitude", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.longitude);
        sb2.append(str3);
        hashMap.put("longitude", sb2.toString());
        hashMap.put(Const.USER_PUB_ID, this.user_pub_id);
        return hashMap;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C2037R.C2039id.addMoreimages /*2131361889*/:
                multipleImages();
                return;
            case C2037R.C2039id.etAdress /*2131362054*/:
//                showlocation();
                return;
            case C2037R.C2039id.etBrandName /*2131362056*/:
                if (this.commonList.size() > 0) {
                    this.spinnerDialog.showSpinerDialog();
                    return;
                }
                return;
            case C2037R.C2039id.et_S_date /*2131362070*/:
                openDatePickerStart();
                return;
            case C2037R.C2039id.et_end_date /*2131362071*/:
                if (!this.binding.etSDate.getText().toString().equals("")) {
                    openDatePickerEnd();
                    return;
                } else {
                    Toast.makeText(this.mContext, "Please select start date.", 0).show();
                    return;
                }
            case C2037R.C2039id.ivAddImages /*2131362134*/:
                multipleImages();
                return;
            default:
                return;
        }
    }

    private void multipleImages() {
        Intent intent = new Intent(this, AlbumSelectActivity.class);
//        intent.putExtra(Constants.INTENT_EXTRA_LIMIT, 5);
        startActivityForResult(intent, 2000);
    }

    private void editAuntion() {
        HashMap editDetail = getEditDetail();
        Map<String, ArrayList<File>> map = this.paramsFile;
        Context context = this.mContext;
        HttpsRequest httpsRequest = new HttpsRequest(Const.UPDATE_AUNCTION, editDetail, map, context, context);
//        httpsRequest.multiImagePost(this.TAG, new Helper() {
//            public void backResponse(boolean z, String str, JSONObject jSONObject) {
//                ProjectUtils.pauseProgressDialog();
//                if (z) {
//                    try {
//                        ProjectUtils.showToast(AddAuction.this.mContext, str);
//                        AddAuction.this.finish();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    ProjectUtils.showToast(AddAuction.this.mContext, str);
//                }
//            }
//        });
    }

    private HashMap<String, String> getEditDetail() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title", ProjectUtils.getEditTextValue(this.binding.etTitle));
        hashMap.put(Const.Pro_pub_id, this.myAutionDTO.getPro_pub_id());
        hashMap.put("description", ProjectUtils.getEditTextValue(this.binding.etDescription));
        hashMap.put(Const.S_Date, ProjectUtils.getEditTextValue(this.binding.etSDate));
        hashMap.put("address", ProjectUtils.getEditTextValue(this.binding.etAdress));
        hashMap.put(Const.E_DATE, ProjectUtils.getEditTextValue(this.binding.etEndDate));
//        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
//        hashMap.put(Const.NO_OF_OWNER, str);
        hashMap.put("price", ProjectUtils.getEditTextValue(this.binding.etPrice));
        boolean isChecked = this.binding.rbYes.isChecked();
        String str2 = Const.INSURED;
        if (isChecked) {
//            hashMap.put(str2, str);
        } else if (this.binding.rbNo.isChecked()) {
//            hashMap.put(str2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            Toast.makeText(this.mContext, "please check any radio button", 0).show();
        }
        hashMap.put("cat_id", this.catid);
        hashMap.put(Const.GET_SUB_CAT_ID, this.subcatid);
        hashMap.put(Const.MODEL_ID, this.modelid);
        hashMap.put(Const.GET_BRAND_ID, this.brandid);
        StringBuilder sb = new StringBuilder();
        sb.append(this.lattitude);
        String str3 = "";
        sb.append(str3);
        hashMap.put("latitude", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.longitude);
        sb2.append(str3);
        hashMap.put("longitude", sb2.toString());
        hashMap.put(Const.USER_PUB_ID, this.user_pub_id);
        return hashMap;
    }

    private void setSubbrand() {
        new HttpsRequest(Const.GET_All_BRANDS, (Map<String, String>) getSubCat(), this.mContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                AddAuction.this.commonList = new ArrayList<>();
                AddAuction.this.subBrandsDTOArrayList = new ArrayList();
                if (z) {
                    try {
//                        AddAuction.this.subBrandsDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<SubBrandsDTO>>() {
//                        }.getType());
                        for (int i = 0; i < AddAuction.this.subBrandsDTOArrayList.size(); i++) {
                            AddAuction.this.commonList.add(new CommonDTO(((SubBrandsDTO) AddAuction.this.subBrandsDTOArrayList.get(i)).getBrand_id(), ((SubBrandsDTO) AddAuction.this.subBrandsDTOArrayList.get(i)).getBrand_name()));
                        }
                        AddAuction.this.spinnerDialog = new SpinnerDialog((Activity) AddAuction.this, AddAuction.this.commonList, "Select or Search", "Close");
                        AddAuction.this.spinnerDialog.setCancellable(true);
                        AddAuction.this.spinnerDialog.setShowKeyboard(false);
                        AddAuction.this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
                            public void onClick(String str, int i) {
                                AddAuction.this.brandid = ((CommonDTO) AddAuction.this.commonList.get(i)).getId();
                                AddAuction.this.brandName = ((CommonDTO) AddAuction.this.commonList.get(i)).getCatName();
                                AddAuction.this.setSubModel();
                            }
                        });
                        AddAuction.this.binding.tvbrandname.setVisibility(0);
                        AddAuction.this.binding.line1.setVisibility(0);
                        AddAuction.this.statusBrand = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    AddAuction.this.binding.tvbrandname.setVisibility(8);
                    AddAuction.this.binding.line1.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setSubModel() {
        ProjectUtils.showProgressDialog(this.mContext, false, "Please Wait...");
        new HttpsRequest(Const.GET_All_MODEL, (Map<String, String>) getBrands(), this.mContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                AddAuction.this.commonListModel = new ArrayList<>();
                AddAuction.this.subModelDTOArrayList = new ArrayList();
                if (z) {
                    try {
//                        AddAuction.this.subModelDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<SubModelDTO>>() {
//                        }.getType());
                        for (int i = 0; i < AddAuction.this.subModelDTOArrayList.size(); i++) {
                            AddAuction.this.commonListModel.add(new CommonDTO(((SubModelDTO) AddAuction.this.subModelDTOArrayList.get(i)).getModel_id(), ((SubModelDTO) AddAuction.this.subModelDTOArrayList.get(i)).getModel_name()));
                        }
                        AddAuction.this.spinnerDialogModel = new SpinnerDialog((Activity) AddAuction.this, AddAuction.this.commonListModel, "Select or Search", "Close");
                        AddAuction.this.spinnerDialogModel.setCancellable(true);
                        AddAuction.this.spinnerDialogModel.setShowKeyboard(false);
                        AddAuction.this.spinnerDialogModel.bindOnSpinerListener(new OnSpinerItemClick() {
                            public void onClick(String str, int i) {
                                AddAuction.this.modelid = ((CommonDTO) AddAuction.this.commonListModel.get(i)).getId();
                                CustomEditText customEditText = AddAuction.this.binding.etBrandName;
                                StringBuilder sb = new StringBuilder();
                                sb.append(AddAuction.this.brandName);
                                sb.append("/");
                                sb.append(str);
                                customEditText.setText(sb.toString());
                            }
                        });
                        if (AddAuction.this.commonListModel.size() > 0) {
                            AddAuction.this.spinnerDialogModel.showSpinerDialog();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    AddAuction.this.binding.etBrandName.setText(AddAuction.this.brandName);
                }
            }
        });
    }

    private HashMap<String, String> getSubCat() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Const.GET_SUB_CAT_ID, this.subcatid);
        return hashMap;
    }

    private HashMap<String, String> getBrands() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Const.GET_BRAND_ID, this.brandid);
        return hashMap;
    }

    public void openDatePickerStart() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AddAuction.this.myCalendarAdop.set(1, i);
                AddAuction.this.myCalendarAdop.set(2, i2);
                AddAuction.this.myCalendarAdop.set(5, i3);
                AddAuction.this.binding.etSDate.setText(new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(AddAuction.this.myCalendarAdop.getTime()));
            }
        }, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
        this.datePickerDialogADp = datePickerDialog;
        this.datePickerDialogADp.setTitle("Select Date");
        this.datePickerDialogADp.getDatePicker().setMinDate(System.currentTimeMillis());
        this.datePickerDialogADp.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis() + 1296000000);
        this.datePickerDialogADp.show();
    }

    public void openDatePickerEnd() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.mContext, new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AddAuction.this.myCalendarEnd.set(1, i);
                AddAuction.this.myCalendarEnd.set(2, i2);
                AddAuction.this.myCalendarEnd.set(5, i3);
                AddAuction.this.binding.etEndDate.setText(new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(AddAuction.this.myCalendarEnd.getTime()));
            }
        }, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
        this.datePickerDialogEnd = datePickerDialog;
        this.datePickerDialogEnd.setTitle("Select Date");
        this.datePickerDialogEnd.getDatePicker().setMinDate(this.myCalendarAdop.getTimeInMillis());
        this.datePickerDialogEnd.getDatePicker().setMaxDate(this.myCalendarAdop.getTimeInMillis() + 604800000);
        this.datePickerDialogEnd.show();
    }
}
