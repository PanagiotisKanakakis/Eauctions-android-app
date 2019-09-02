package com.subasta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.databinding.ChatBubbleLeft1Binding;
import com.subasta.databinding.ChatBubbleRightBinding;
import com.subasta.model.ChatMessageDTO;
import com.subasta.model.UserDTO;
import com.subasta.utils.ProjectUtils;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_INCOMING = 1;
    private final int TYPE_OUTGOING = 2;
    private ArrayList<ChatMessageDTO> chatMessageDTOArrayList;
    String image;
    private LayoutInflater layoutInflater;
    private Context mContext;
    private UserDTO userDTO;

    public class MyViewHolderIn extends RecyclerView.ViewHolder {
        public ChatBubbleLeft1Binding binding;

        public MyViewHolderIn(ChatBubbleLeft1Binding chatBubbleLeft1Binding) {
            super(chatBubbleLeft1Binding.getRoot());
            this.binding = chatBubbleLeft1Binding;
        }
    }

    public class MyViewHolderOut extends RecyclerView.ViewHolder {
        public ChatBubbleRightBinding binding;

        public MyViewHolderOut(ChatBubbleRightBinding chatBubbleRightBinding) {
            super(chatBubbleRightBinding.getRoot());
            this.binding = chatBubbleRightBinding;
        }
    }

    public MessageAdapter(Context context, ArrayList<ChatMessageDTO> arrayList, UserDTO userDTO2, String str) {
        this.mContext = context;
        this.chatMessageDTOArrayList = arrayList;
        this.userDTO = userDTO2;
        this.image = str;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        if (i == 1) {
            return new MyViewHolderIn((ChatBubbleLeft1Binding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.chat_bubble_left1, viewGroup, false));
        }
        if (i != 2) {
            return null;
        }
        return new MyViewHolderOut((ChatBubbleRightBinding) DataBindingUtil.inflate(this.layoutInflater, C2037R.layout.chat_bubble_right, viewGroup, false));
    }


    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolderIn) {
            MyViewHolderIn myViewHolderIn = (MyViewHolderIn) viewHolder;
            myViewHolderIn.binding.txtMsg.setText(((ChatMessageDTO) this.chatMessageDTOArrayList.get(i)).getMessage());
//            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(this.image).centerCrop()).placeholder((int) C2037R.C2038drawable.ic_user)).into((ImageView) myViewHolderIn.binding.ivCat);
            myViewHolderIn.binding.txtTime.setText(ProjectUtils.convertTimestampDateToTime(Long.parseLong(((ChatMessageDTO) this.chatMessageDTOArrayList.get(i)).getDate())));
        } else if (viewHolder instanceof MyViewHolderOut) {
            MyViewHolderOut myViewHolderOut = (MyViewHolderOut) viewHolder;
            myViewHolderOut.binding.txtMsg.setText(((ChatMessageDTO) this.chatMessageDTOArrayList.get(i)).getMessage());
//            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(this.userDTO.getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.ic_user)).into((ImageView) myViewHolderOut.binding.ivCat);
            myViewHolderOut.binding.tvTime.setText(ProjectUtils.convertTimestampDateToTime(Long.parseLong(((ChatMessageDTO) this.chatMessageDTOArrayList.get(i)).getDate())));
        }
    }

    public int getItemCount() {
        return this.chatMessageDTOArrayList.size();
    }

    public int getItemViewType(int i) {
        super.getItemViewType(i);
        return !((ChatMessageDTO) this.chatMessageDTOArrayList.get(i)).getSender_user_pub_id().equals(this.userDTO.getUser_pub_id()) ? 1 : 2;
    }
}
