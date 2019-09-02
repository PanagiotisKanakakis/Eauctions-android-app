package com.subasta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.activity.ChatstalkingActivity;
import com.subasta.databinding.AdapterMyChatBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.MyChatsDTO;
import com.subasta.model.UserDTO;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class MyChatsAdapter extends RecyclerView.Adapter<MyChatsAdapter.MyViewHolder> {
    private int bitmap;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    private ArrayList<MyChatsDTO> myChatsDTOArrayList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<MyChatsDTO> objects;
    /* access modifiers changed from: private */
    public UserDTO userDTO;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterMyChatBinding binding;

        public MyViewHolder(@NonNull AdapterMyChatBinding adapterMyChatBinding) {
            super(adapterMyChatBinding.getRoot());
            this.binding = adapterMyChatBinding;
        }
    }

    public MyChatsAdapter(Context context, ArrayList<MyChatsDTO> arrayList, UserDTO userDTO2) {
        this.mContext = context;
        this.objects = arrayList;
        this.userDTO = userDTO2;
        this.myChatsDTOArrayList.addAll(arrayList);
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MyViewHolder((AdapterMyChatBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_my_chat, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
//        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((MyChatsDTO) this.objects.get(i)).getUser_image()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) myViewHolder.binding.ivPro);
        myViewHolder.binding.tvTitle.setText(ProjectUtils.capWordFirstLetter(((MyChatsDTO) this.objects.get(i)).getUser_name()));
        myViewHolder.binding.tvMsg.setText(((MyChatsDTO) this.objects.get(i)).getMessage());
        myViewHolder.binding.tvDate.setText(ProjectUtils.convertTimestampDateToTime(Long.parseLong(((MyChatsDTO) this.objects.get(i)).getDate())));
        myViewHolder.binding.rvChat.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MyChatsAdapter.this.mContext, ChatstalkingActivity.class);
                boolean equalsIgnoreCase = ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getReceiver_user_pub_id().equalsIgnoreCase(MyChatsAdapter.this.userDTO.getUser_pub_id());
                String str = Const.RECEIVER_IMAGE;
                String str2 = Const.RECEIVER_NAME;
                String str3 = Const.RECEIVER_ID;
                if (equalsIgnoreCase) {
                    intent.putExtra(str3, ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getSender_user_pub_id());
                    intent.putExtra(str2, ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getUser_name());
                    intent.putExtra(str, ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getUser_image());
                } else {
                    intent.putExtra(str3, ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getReceiver_user_pub_id());
                    intent.putExtra(str2, ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getUser_name());
                    intent.putExtra(str, ((MyChatsDTO) MyChatsAdapter.this.objects.get(i)).getUser_image());
                }
                MyChatsAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.objects.size();
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.objects.clear();
        if (lowerCase.length() == 0) {
            this.objects.addAll(this.myChatsDTOArrayList);
        } else {
            Iterator it = this.myChatsDTOArrayList.iterator();
            while (it.hasNext()) {
                MyChatsDTO myChatsDTO = (MyChatsDTO) it.next();
                if (myChatsDTO.getUser_name().toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.objects.add(myChatsDTO);
                }
            }
        }
        notifyDataSetChanged();
    }
}
