package com.subasta.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.adapter.MessageAdapter;
import com.subasta.databinding.ActivityChatstalkingBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.ChatMessageDTO;
import com.subasta.model.ThreadIDDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ChatstalkingActivity extends AppCompatActivity {
    private String TAG = ChatstalkingActivity.class.getCanonicalName();
    private ArrayAdapter<ChatMessageDTO> adapter;
    /* access modifiers changed from: private */
    public ActivityChatstalkingBinding binding;
    /* access modifiers changed from: private */
    public List<ChatMessageDTO> chatMessages = new ArrayList();
    private HashMap<String, String> getThread;
    private Handler handler;
    IntentFilter intentFilter;
    private final int interval;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    BroadcastReceiver mBroadcastReceiver;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public MessageAdapter messageAdapter;
    private String msg;
    private HashMap<String, String> params;
    /* access modifiers changed from: private */
    public String receiver_image;
    private HashMap<String, String> sendParams;
    SharedPrefrence sharedPrefrence;
    /* access modifiers changed from: private */
    public ThreadIDDTO threadIDDTO;
    private String threadid;
    /* access modifiers changed from: private */
    public UserDTO userDTO;
    private String username;

    public ChatstalkingActivity() {
        String str = "";
        this.receiver_image = str;
        this.params = new HashMap<>();
        this.sendParams = new HashMap<>();
        this.getThread = new HashMap<>();
        this.threadid = str;
        this.intentFilter = new IntentFilter();
        this.interval = 1000;
        this.handler = new Handler();
        this.mBroadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                ChatstalkingActivity.this.getSingleChatHistory();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.binding = (ActivityChatstalkingBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_chatstalking);
        this.sharedPrefrence = SharedPrefrence.getInstance(this);
        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        this.username = getIntent().getStringExtra(Const.RECEIVER_NAME);
        this.receiver_image = getIntent().getStringExtra(Const.RECEIVER_IMAGE);
        HashMap<String, String> hashMap = this.getThread;
        String user_pub_id = this.userDTO.getUser_pub_id();
        String str = Const.SENDER_ID;
        hashMap.put(str, user_pub_id);
        HashMap<String, String> hashMap2 = this.getThread;
        Intent intent = getIntent();
        String str2 = Const.RECEIVER_ID;
        hashMap2.put(str2, intent.getStringExtra(str2));
        this.sendParams.put(str, this.userDTO.getUser_pub_id());
        this.sendParams.put(str2, getIntent().getStringExtra(str2));
        this.intentFilter.addAction(Const.BROADCAST);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mBroadcastReceiver, this.intentFilter);
        findUI();
        timer();
    }

    public void timer() {
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                ChatstalkingActivity.this.getSingleChatHistory();
                handler2.postDelayed(this, 5000);
            }
        }, 5000);
    }

    private void setTimer() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                ChatstalkingActivity.this.chatMessages.clear();
                ChatstalkingActivity.this.getSingleChatHistory();
            }
        }, 5, 5000);
    }

    private void getThreadId() {
        new HttpsRequest(Const.THREAD_ID, (Map<String, String>) this.getThread, this.mContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
//                        ChatstalkingActivity.this.threadIDDTO = (ThreadIDDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), ThreadIDDTO.class);
                        ChatstalkingActivity.this.getSingleChatHistory();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void findUI() {
        this.binding.tvname.setText(this.username);
//        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(this.receiver_image).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) this.binding.ivalia);
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ChatstalkingActivity.this.onBackPressed();
            }
        });
        this.binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                ChatstalkingActivity.this.getSingleChatHistory();
            }
        });
        this.binding.tvname.setText(this.username);
        this.binding.btnChatSend.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                if (ChatstalkingActivity.this.binding.msgType.getText().length() > 0) {
                    ChatstalkingActivity.this.sendMessage();
                } else {
                    Toast.makeText(ChatstalkingActivity.this.mContext, "Please type your message", 0).show();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getThreadId();
    }

    /* access modifiers changed from: private */
    public void getSingleChatHistory() {
        this.params.put(Const.SENDER_ID, this.userDTO.getUser_pub_id());
        HashMap<String, String> hashMap = this.params;
        Intent intent = getIntent();
        String str = Const.RECEIVER_ID;
        hashMap.put(str, intent.getStringExtra(str));
        this.params.put(Const.THREAD, this.threadIDDTO.getThread_id());
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" param --->");
        sb.append(this.params.toString());
        ProjectUtils.showLog(str2, sb.toString());
        new HttpsRequest(Const.GET_SINGLE_CHAT_HISTORY, (Map<String, String>) this.params, this.mContext).stringPost(this.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ChatstalkingActivity.this.binding.swipeRefreshLayout.setRefreshing(false);
                if (z) {
                    try {
                        ChatstalkingActivity.this.chatMessages = new ArrayList();
//                        ChatstalkingActivity.this.chatMessages = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<ChatMessageDTO>>() {
//                        }.getType());
                        ChatstalkingActivity.this.layoutManager = new LinearLayoutManager(ChatstalkingActivity.this.mContext, 1, false);
                        ChatstalkingActivity.this.binding.recycleChat.setLayoutManager(ChatstalkingActivity.this.layoutManager);
                        ChatstalkingActivity.this.messageAdapter = new MessageAdapter(ChatstalkingActivity.this.mContext, (ArrayList) ChatstalkingActivity.this.chatMessages, ChatstalkingActivity.this.userDTO, ChatstalkingActivity.this.receiver_image);
                        ChatstalkingActivity.this.binding.recycleChat.setAdapter(ChatstalkingActivity.this.messageAdapter);
                        ChatstalkingActivity.this.binding.recycleChat.scrollToPosition(ChatstalkingActivity.this.chatMessages.size() - 1);
                        ChatstalkingActivity.this.binding.recycleChat.smoothScrollToPosition(ChatstalkingActivity.this.chatMessages.size() - 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendMessage() {
        this.sendParams.put("message", this.binding.msgType.getText().toString());
        this.sendParams.put(Const.THREAD, this.threadIDDTO.getThread_id());
        this.binding.swipeRefreshLayout.setRefreshing(false);
        new HttpsRequest(Const.SEND_MESSAGE, (Map<String, String>) this.sendParams, this.mContext).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ChatstalkingActivity.this.getSingleChatHistory();
                    ChatstalkingActivity.this.binding.msgType.setText("");
                }
            }
        });
    }
}
