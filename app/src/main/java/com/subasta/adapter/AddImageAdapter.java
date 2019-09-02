package com.subasta.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.darsh.multipleimageselect.models.Image;
import com.subasta.C2037R;
import com.subasta.activity.aution.AddAuction;
import com.subasta.databinding.AdapterAddImageBinding;

import java.util.ArrayList;

public class AddImageAdapter extends RecyclerView.Adapter<AdapterAllRating.MyViewHolder> {
    private AdapterAddImageBinding binding;
    private ArrayList<Image> imageDTOArrayList;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public AddAuction mContext;
    int pos = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterAddImageBinding binding;

        public MyViewHolder(@NonNull AdapterAddImageBinding adapterAddImageBinding) {
            super(adapterAddImageBinding.getRoot());
            this.binding = adapterAddImageBinding;
        }
    }

    public AddImageAdapter(AddAuction addAuction, ArrayList<Image> arrayList) {
        this.mContext = addAuction;
        this.imageDTOArrayList = arrayList;
    }

//    @NonNull
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        if (this.layoutInflater == null) {
//            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        }
//        this.binding = (AdapterAddImageBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_add_image, viewGroup, false);
//        return new MyViewHolder(this.binding);
//    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this.mContext).load(((Image) this.imageDTOArrayList.get(i)).path).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.addImages);
        this.binding.cancel.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AddImageAdapter addImageAdapter = AddImageAdapter.this;
                int i = 0;
                addImageAdapter.pos = i;
                addImageAdapter.deleteDailog(i);
            }
        });
    }

    public int getItemCount() {
        return this.imageDTOArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllRating.MyViewHolder myViewHolder, int i) {

    }

    @NonNull
    @Override
    public AdapterAllRating.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    /* access modifiers changed from: private */
    public void deleteDailog(final int i) {
//        Builder builder = new Builder(this.mContext);
//        Builder cancelable = builder.setMessage((CharSequence) "Do you want to delete this Aunction?").setTitle((int) C2037R.string.dialog_title).setCancelable(false);
//        C21913 r2 = new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                AddImageAdapter.this.mContext.imageRemove(i);
//            }
//        };
//        cancelable.setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) r2).setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//            }
//        });
//        AlertDialog create = builder.create();
//        create.setTitle("Delete auction.");
//        create.setIcon((int) C2037R.C2038drawable.ic_deleteauction);
//        create.show();
    }
}
