package com.subasta.activity.aution;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cocosw.bottomsheet.BottomSheet.Builder;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Image;
import com.subasta.C2037R;
import com.subasta.adapter.GalleryAdapter;
import com.subasta.databinding.ActivityGalleryBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.model.GalleryDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ImageCompression;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GalleryActivity extends AppCompatActivity {
    int CROP_CAMERA_IMAGE;
    int CROP_GALLERY_IMAGE;
    int PICK_FROM_CAMERA;
    int PICK_FROM_GALLERY;
    int PICK_IMAGE_MULTIPLE;
    private String Pro_pub_id;
    private String TAG;
    private String User_pub_id;
    private ActivityGalleryBinding binding;

    /* renamed from: bm */
    Bitmap f1303bm;
    Builder builder;
    File file;
    private String flag;
    private GalleryAdapter galleryAdapter;
    private GalleryDTO galleryDTO;
    /* access modifiers changed from: private */
    public ArrayList<GalleryDTO> galleryDTOArrayList = new ArrayList<>();
    ImageCompression imageCompression;
    private String imageId;
    String imageName;
    ArrayList<Image> images;
    private RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Context mContext;
    private HashMap<String, String> params;
    private Map<String, ArrayList<File>> paramsFile;
    String pathOfImage;
    Uri picUri;
    SharedPrefrence prefrence;

    public GalleryActivity() {
        String str = "";
        this.imageId = str;
        this.flag = str;
        this.paramsFile = new HashMap();
        this.PICK_FROM_CAMERA = 1;
        this.PICK_FROM_GALLERY = 2;
        this.CROP_CAMERA_IMAGE = 3;
        this.CROP_GALLERY_IMAGE = 4;
        this.PICK_IMAGE_MULTIPLE = 5;
        this.TAG = GalleryActivity.class.getCanonicalName();
        this.params = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivityGalleryBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_gallery);
        Intent intent = getIntent();
        String str = Const.DTO;
        if (intent.hasExtra(str)) {
            this.galleryDTOArrayList = (ArrayList) getIntent().getSerializableExtra(str);
        }
        this.flag = getIntent().getStringExtra(Const.FLAG);
        if (this.flag.equals("2")) {
            this.binding.ivGalleryUpload.setVisibility(0);
        } else {
            this.binding.ivGalleryUpload.setVisibility(8);
        }
        this.Pro_pub_id = getIntent().getStringExtra(Const.Pro_pub_id);
        this.User_pub_id = getIntent().getStringExtra(Const.USER_PUB_ID);
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.this.finish();
            }
        });
        this.binding.ivGalleryUpload.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                if (GalleryActivity.this.galleryDTOArrayList.size() < 5) {
                    GalleryActivity.this.multipleImages();
                } else {
                    Toast.makeText(GalleryActivity.this.mContext, "You can not select more images.", 0).show();
                }
            }
        });
        setUiAction();
    }

    @SuppressLint("WrongConstant")
    private void setUiAction() {
        this.layoutManager = new LinearLayoutManager(this.mContext, 0, false);
        this.binding.recycleview1.setHasFixedSize(true);
        this.binding.recycleview1.setLayoutManager(this.layoutManager);
        this.galleryAdapter = new GalleryAdapter(this.mContext, this.galleryDTOArrayList, this.flag, this);
        this.binding.recycleview1.setAdapter(this.galleryAdapter);
    }

    public void uploadImage() {
        this.params.put(Const.Pro_pub_id, this.Pro_pub_id);
        this.params.put(Const.USER_PUB_ID, this.User_pub_id);
        HashMap<String, String> hashMap = this.params;
        Map<String, ArrayList<File>> map = this.paramsFile;
        Context context = this.mContext;
        HttpsRequest httpsRequest = new HttpsRequest(Const.ADD_IMAGES, hashMap, map, context, context);
//        httpsRequest.multiImagePost(this.TAG, new Helper() {
//            public void backResponse(boolean z, String str, JSONObject jSONObject) {
//                ProjectUtils.pauseProgressDialog();
//                if (z) {
//                    try {
//                        GalleryActivity.this.finish();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
    }

    /* access modifiers changed from: private */
    public void multipleImages() {
        Intent intent = new Intent(this, AlbumSelectActivity.class);
        intent.putExtra(Constants.INTENT_EXTRA_LIMIT, 5);
        startActivityForResult(intent, 2000);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2000 && i2 == -1 && intent != null) {
            this.images = intent.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);
            String str = "ImageData===>";
            Log.e(str, "AA gya");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.images.size(); i3++) {
                arrayList.add(new File(((Image) this.images.get(i3)).path));
            }
            this.paramsFile.put(Const.IMAGE, arrayList);
            Log.e(str, "List AA gyi");
            uploadImage();
        }
    }
}
