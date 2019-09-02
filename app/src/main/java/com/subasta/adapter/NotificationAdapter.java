package com.subasta.adapter;

import android.annotation.SuppressLint;
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
import com.subasta.activity.aution.ViewAuction;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.databinding.AdapterNotificationBinding;
import com.subasta.interfaces.Const;
import com.subasta.model.NotificationDTO;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    private AdapterNotificationBinding binding;
    private LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<NotificationDTO> notificationDTOArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterNotificationBinding binding;

        public MyViewHolder(@NonNull AdapterNotificationBinding adapterNotificationBinding) {
            super(adapterNotificationBinding.getRoot());
            this.binding = adapterNotificationBinding;
        }
    }

    public NotificationAdapter(Context context, ArrayList<NotificationDTO> arrayList) {
        this.notificationDTOArrayList = arrayList;
        this.mContext = context;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        this.binding = (AdapterNotificationBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.adapter_notification, viewGroup, false);
        return new MyViewHolder(this.binding);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.binding.title.setText(((NotificationDTO) this.notificationDTOArrayList.get(i)).getTittle());
        myViewHolder.binding.message.setText(((NotificationDTO) this.notificationDTOArrayList.get(i)).getMessage());
        myViewHolder.binding.cardView1.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                if (((NotificationDTO) NotificationAdapter.this.notificationDTOArrayList.get(i)).getType().equals(Const.WIN_BID_TYPE)) {
                    Intent intent = new Intent(NotificationAdapter.this.mContext, ViewAuction.class);
                    intent.putExtra(Const.Pro_pub_id, ((NotificationDTO) NotificationAdapter.this.notificationDTOArrayList.get(i)).getPro_pub_id());
                    NotificationAdapter.this.mContext.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(NotificationAdapter.this.mContext, Dashboard.class);
                intent2.addFlags(67108864);
                intent2.addFlags(32768);
                intent2.addFlags(268435456);
                intent2.addFlags(67108864);
                intent2.putExtra("index", ProjectUtils.indexOfNotification(((NotificationDTO) NotificationAdapter.this.notificationDTOArrayList.get(i)).getType()));
                NotificationAdapter.this.mContext.startActivity(intent2);
            }
        });
    }

    public int getItemCount() {
        return this.notificationDTOArrayList.size();
    }
}
