package com.subasta.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.aution.AddAuction;
import com.subasta.activity.aution.ViewMyAunction;
import com.subasta.databinding.AdapterItemMyAunctionBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AuncitonImageDTO;
import com.subasta.model.MyAutionDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAuctionAdapter extends RecyclerView.Adapter<MyAuctionAdapter.MyViewHolder> {
    private static final String TAG = "com.subasta.adapter.MyAuctionAdapter";
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<MyAutionDTO> myAutionDTOArrayList;
    private HashMap<String, String> params = new HashMap<>();
    /* access modifiers changed from: private */
    public int pos = -1;
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterItemMyAunctionBinding binding;

        public MyViewHolder(@NonNull AdapterItemMyAunctionBinding adapterItemMyAunctionBinding) {
            super(adapterItemMyAunctionBinding.getRoot());
            this.binding = adapterItemMyAunctionBinding;
        }
    }

    public MyAuctionAdapter(Context context, ArrayList<MyAutionDTO> arrayList) {
        this.mContext = context;
        this.myAutionDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        AdapterItemMyAunctionBinding adapterItemMyAunctionBinding = (AdapterItemMyAunctionBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_item_my_aunction, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        return new MyViewHolder(adapterItemMyAunctionBinding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        this.params.put(Const.Pro_pub_id, ((MyAutionDTO) this.myAutionDTOArrayList.get(i)).getPro_pub_id());
        myViewHolder.binding.tvtitle.setText(ProjectUtils.capWordFirstLetter(((MyAutionDTO) this.myAutionDTOArrayList.get(i)).getTitle()));
        myViewHolder.binding.tvDate.setText(ProjectUtils.changeDateFormate(((MyAutionDTO) this.myAutionDTOArrayList.get(i)).getCreated_at()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(((MyAutionDTO) this.myAutionDTOArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((MyAutionDTO) this.myAutionDTOArrayList.get(i)).getPrice());
        customTextViewBold.setText(sb.toString());
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AuncitonImageDTO) ((MyAutionDTO) this.myAutionDTOArrayList.get(i)).getImage_cust().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.iv1);
        } catch (Exception unused) {
        }
        myViewHolder.binding.iv1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyAuctionAdapter.this.mContext, ViewMyAunction.class);
                intent.putExtra(Const.MY_AUCTIONDTO, (Serializable) MyAuctionAdapter.this.myAutionDTOArrayList.get(i));
                MyAuctionAdapter.this.mContext.startActivity(intent);
            }
        });
        myViewHolder.binding.btnEdit.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyAuctionAdapter.this.mContext, AddAuction.class);
                intent.putExtra(Const.MY_AUCTIONDTO, (Serializable) MyAuctionAdapter.this.myAutionDTOArrayList.get(i));
                intent.putExtra(Const.FLAG, 1);
                MyAuctionAdapter.this.mContext.startActivity(intent);
            }
        });
        myViewHolder.binding.btnDelete.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MyAuctionAdapter.this.pos = i;
                MyAuctionAdapter.this.deleteDailog();
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteAunctions() {
        new HttpsRequest(Const.DELETE_AUNTION, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    MyAuctionAdapter.this.myAutionDTOArrayList.remove(MyAuctionAdapter.this.pos);
                    MyAuctionAdapter.this.notifyDataSetChanged();
                    Toast.makeText(MyAuctionAdapter.this.mContext, str, 0).show();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteDailog() {
//        Builder builder = new Builder(this.mContext);
//        String str = "No";
//        builder.setMessage((CharSequence) "Do you want to delete this Aunction?").setTitle((int) C2037R.string.dialog_title).setCancelable(false).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                MyAuctionAdapter.this.deleteAunctions();
//            }
//        }).setNegativeButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog create = builder.create();
//        create.setTitle("Delete auction.");
//        create.setIcon((int) C2037R.C2038drawable.ic_deleteauction);
//        create.show();
    }

    public int getItemCount() {
        return this.myAutionDTOArrayList.size();
    }
}
