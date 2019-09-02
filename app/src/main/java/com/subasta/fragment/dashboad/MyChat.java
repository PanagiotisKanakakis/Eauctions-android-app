package com.subasta.fragment.dashboad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.MyChatsAdapter;
import com.subasta.databinding.FragmentMyChatBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.MyChatsDTO;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class MyChat extends Fragment implements OnClickListener {
    /* access modifiers changed from: private */
    public FragmentMyChatBinding binding;
    private Dashboard dashboard;
    IntentFilter intentFilter = new IntentFilter();
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MyChat.this.getAllchat();
        }
    };
    private Context mContext;
    /* access modifiers changed from: private */
    public MyChatsAdapter myChatsAdapter;
    private ArrayList<MyChatsDTO> myChatsDTOArrayList;
    /* access modifiers changed from: private */
    public ArrayList<MyChatsDTO> object;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence preferences;
    TextView textView;
    /* access modifiers changed from: private */
    public UserDTO userDTO;
    private View view;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.dashboard = (Dashboard) context;
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.binding = (FragmentMyChatBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fragment_my_chat, viewGroup, false);
        this.view = this.binding.getRoot();
        this.preferences = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.preferences.getParentUser(Const.USER_DTO);
        this.params.put(Const.SENDER_ID, this.userDTO.getUser_pub_id());
        this.intentFilter.addAction(Const.ALL_CHAT);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.mBroadcastReceiver, this.intentFilter);
        this.binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                MyChat.this.getAllchat();
            }
        });
        this.binding.chatSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                try {
                    MyChat.this.myChatsAdapter.filter(str);
                } catch (Exception unused) {
                }
                return false;
            }
        });
        return this.view;
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.binding.recycle1.setAdapter(this.myChatsAdapter);
    }

    public void onDetach() {
        super.onDetach();
        this.dashboard = null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        getAllchat();
    }

    /* access modifiers changed from: private */
    public void getAllchat() {
        new HttpsRequest(Const.GET_CHAT_HISTORY, (Map<String, String>) this.params, (Context) getActivity()).stringPost(ProjectUtils.TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                MyChat.this.binding.swipeRefreshLayout.setRefreshing(false);
                if (z) {
                    try {
                        MyChat.this.object = new ArrayList();
//                        MyChat.this.object = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<MyChatsDTO>>() {
//                        }.getType());
                        MyChat.this.layoutManager = new LinearLayoutManager(MyChat.this.getActivity(), 1, false);
                        MyChat.this.binding.recycle1.setLayoutManager(MyChat.this.layoutManager);
                        MyChat.this.binding.recycle1.setHasFixedSize(true);
                        MyChat.this.myChatsAdapter = new MyChatsAdapter(MyChat.this.getActivity(), MyChat.this.object, MyChat.this.userDTO);
                        MyChat.this.binding.recycle1.setAdapter(MyChat.this.myChatsAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    MyChat.this.binding.swipeRefreshLayout.setRefreshing(false);
                    MyChat.this.binding.chatSearch.setVisibility(8);
                    MyChat.this.binding.tvNo.setVisibility(0);
                }
            }
        });
    }

    public void onClick(View view2) {
        view2.getId();
    }
}
