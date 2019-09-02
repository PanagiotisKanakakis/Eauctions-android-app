package com.subasta.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.aution.GalleryActivity;
import com.subasta.activity.aution.ViewMyAunction;
import com.subasta.databinding.AdapterGalleryImageSliderBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.GalleryDTO;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {
    private static final String TAG = GalleryActivity.class.getCanonicalName();
    private AdapterGalleryImageSliderBinding binding;
    private String flag = "";
    private GalleryActivity galleryActivity;
    /* access modifiers changed from: private */
    public ArrayList<GalleryDTO> galleryDTOArrayList;
    private LayoutInflater layoutInflater;
    private Context mContext;
    HashMap<String, String> params = new HashMap<>();
    int pos = 0;
    private ViewMyAunction viewMyAunction = new ViewMyAunction();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterGalleryImageSliderBinding binding;

        public MyViewHolder(@NonNull AdapterGalleryImageSliderBinding adapterGalleryImageSliderBinding) {
            super(adapterGalleryImageSliderBinding.getRoot());
            this.binding = adapterGalleryImageSliderBinding;
        }
    }

    public GalleryAdapter(Context context, ArrayList<GalleryDTO> arrayList, String str, GalleryActivity galleryActivity2) {
        this.mContext = context;
        this.flag = str;
        this.mContext = galleryActivity2;
        this.galleryDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterGalleryImageSliderBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_gallery_image_slider, viewGroup, false));
    }

    @SuppressLint("WrongConstant")
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        this.pos = i;
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((GalleryDTO) this.galleryDTOArrayList.get(this.pos)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) myViewHolder.binding.imageView);
//        if (this.flag.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
//            myViewHolder.binding.ivRemove.setVisibility(8);
//        } else {
            myViewHolder.binding.ivRemove.setVisibility(0);
//        }
        myViewHolder.binding.ivRemove.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                GalleryAdapter.this.params.put(Const.Pro_pub_id, ((GalleryDTO) GalleryAdapter.this.galleryDTOArrayList.get(GalleryAdapter.this.pos)).getPro_pub_id());
                GalleryAdapter.this.params.put("id", ((GalleryDTO) GalleryAdapter.this.galleryDTOArrayList.get(GalleryAdapter.this.pos)).getId());
                GalleryAdapter.this.deleteDailog();
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteDailog() {
        Builder builder = new Builder(this.mContext);
        String str = "No";
        builder.setMessage("Are you sure you want to cancel this image ? ").setTitle(C2037R.string.dialog_title).setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                GalleryAdapter.this.removeGallery();
                GalleryAdapter.this.notifyDataSetChanged();
            }
        }).setNegativeButton(str, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog create = builder.create();
        create.setTitle("Delete auction.");
        create.setIcon(C2037R.C2038drawable.ic_deleteauction);
        create.show();
    }

    public int getItemCount() {
        return this.galleryDTOArrayList.size();
    }

    /* access modifiers changed from: private */
    public void removeGallery() {
        new HttpsRequest(Const.REMOVE_IMAGE, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        GalleryAdapter.this.galleryDTOArrayList.remove(GalleryAdapter.this.pos);
                        GalleryAdapter.this.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
