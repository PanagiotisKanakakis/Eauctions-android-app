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
import com.subasta.activity.aution.ViewAuction;
import com.subasta.databinding.AdapterMyfavBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.AuncitonImageDTO;
import com.subasta.model.MyFavDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyFavAdapter extends RecyclerView.Adapter<MyFavAdapter.MyViewHolder> {
    private static final String TAG = "com.subasta.adapter.MyFavAdapter";
    AdapterMyfavBinding binding;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<MyFavDTO> myFavDTOArrayList;
    /* access modifiers changed from: private */
    public HashMap<String, String> paramsUnfavrouite = new HashMap<>();
    /* access modifiers changed from: private */
    public int pos = -1;
    private SharedPrefrence prefrence;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterMyfavBinding binding;

        public MyViewHolder(@NonNull AdapterMyfavBinding adapterMyfavBinding) {
            super(adapterMyfavBinding.getRoot());
            this.binding = adapterMyfavBinding;
        }
    }

    public MyFavAdapter(Context context, ArrayList<MyFavDTO> arrayList) {
        this.mContext = context;
        this.myFavDTOArrayList = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterMyfavBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_myfav, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.binding.tvtitle.setText(ProjectUtils.capWordFirstLetter(((MyFavDTO) this.myFavDTOArrayList.get(i)).getTitle()));
        CustomTextViewBold customTextViewBold = myViewHolder.binding.tvPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(((MyFavDTO) this.myFavDTOArrayList.get(i)).getCurrency_code());
        sb.append(" ");
        sb.append(((MyFavDTO) this.myFavDTOArrayList.get(i)).getPrice());
        customTextViewBold.setText(sb.toString());
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((AuncitonImageDTO) ((MyFavDTO) this.myFavDTOArrayList.get(i)).getImage_cust().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(myViewHolder.binding.iv1);
        } catch (Exception unused) {
        }
        myViewHolder.binding.tvDate.setText(ProjectUtils.changeDateFormate(((MyFavDTO) this.myFavDTOArrayList.get(i)).getCreated_at()));
        myViewHolder.binding.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyFavAdapter.this.mContext, ViewAuction.class);
                intent.putExtra(Const.Pro_pub_id, ((MyFavDTO) MyFavAdapter.this.myFavDTOArrayList.get(i)).getPro_pub_id());
                MyFavAdapter.this.mContext.startActivity(intent);
            }
        });
        myViewHolder.binding.btnRemove.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MyFavAdapter.this.pos = i;
                MyFavAdapter.this.paramsUnfavrouite.put(Const.USER_PUB_ID, MyFavAdapter.this.userDTO.getUser_pub_id());
                MyFavAdapter.this.paramsUnfavrouite.put(Const.Pro_pub_id, ((MyFavDTO) MyFavAdapter.this.myFavDTOArrayList.get(i)).getPro_pub_id());
                MyFavAdapter.this.deleteDailog();
            }
        });
    }

    /* access modifiers changed from: private */
    public void unfavoruite() {
        new HttpsRequest(Const.GET_MYUNFAV, (Map<String, String>) this.paramsUnfavrouite, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    MyFavAdapter.this.myFavDTOArrayList.remove(MyFavAdapter.this.pos);
                    MyFavAdapter.this.notifyDataSetChanged();
                    Toast.makeText(MyFavAdapter.this.mContext, str, 0).show();
                    return;
                }
                ProjectUtils.showToast(MyFavAdapter.this.mContext, str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteDailog() {
//        Builder builder = new Builder(this.mContext);
//        String str = "No";
//        builder.setMessage((CharSequence) "Do you want to unfavoruite this aunction").setTitle((int) C2037R.string.dialog_title).setCancelable(false).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                MyFavAdapter.this.unfavoruite();
//            }
//        }).setNegativeButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog create = builder.create();
//        create.setTitle("Delete favrouite auction.");
//        create.setIcon((int) C2037R.C2038drawable.ic_deleteauction);
//        create.show();
    }

    public int getItemCount() {
        return this.myFavDTOArrayList.size();
    }
}
