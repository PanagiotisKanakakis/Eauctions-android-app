package com.subasta.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.darsh.multipleimageselect.models.Image;
import com.subasta.C2037R;
import com.subasta.activity.aution.AddAuction;
import com.subasta.databinding.AdapterAddImageBinding;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    private AdapterAddImageBinding binding;
    /* access modifiers changed from: private */
    public ArrayList<Image> imageDTOArrayList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public AddAuction mContext;
    int pos = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public AdapterAddImageBinding binding;

        public MyViewHolder(@NonNull AdapterAddImageBinding adapterAddImageBinding) {
            super(adapterAddImageBinding.getRoot());
            this.binding = adapterAddImageBinding;
        }
    }

    public ImageAdapter(AddAuction addAuction, ArrayList<Image> arrayList) {
        this.mContext = addAuction;
        this.imageDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterAddImageBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_add_image, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this.mContext).load(((Image) this.imageDTOArrayList.get(i)).path).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.addImages);
        myViewHolder.binding.cancel.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ImageAdapter imageAdapter = ImageAdapter.this;
                imageAdapter.pos = i;
                imageAdapter.deleteDailog(imageAdapter.pos);
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteDailog(final int i) {
//        Builder builder = new Builder(this.mContext);
//        Builder cancelable = builder.setMessage((CharSequence) "Are you sure you want to cancel this image ? ").setTitle((int) C2037R.string.dialog_title).setCancelable(false);
////        C22123 r2 = new DialogInterface.OnClickListener() {
////            public void onClick(DialogInterface dialogInterface, int i) {
////                ImageAdapter.this.imageDTOArrayList.remove(i);
////                ImageAdapter.this.mContext.imageRemove(i);
////                ImageAdapter.this.mContext.files.remove(i);
////                ImageAdapter.this.notifyDataSetChanged();
////            }
////        };
////        cancelable.setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) r2).setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
////            public void onClick(DialogInterface dialogInterface, int i) {
////                dialogInterface.cancel();
////            }
////        });
//        AlertDialog create = builder.create();
//        create.setTitle("Delete auction.");
//        create.setIcon((int) C2037R.C2038drawable.ic_deleteauction);
//        create.show();
    }

    public int getItemCount() {
        return this.imageDTOArrayList.size();
    }
}
