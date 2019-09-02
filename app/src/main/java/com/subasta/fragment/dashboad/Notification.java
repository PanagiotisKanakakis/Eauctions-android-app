package com.subasta.fragment.dashboad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.C2037R;
import com.subasta.activity.dashbord.Dashboard;
import com.subasta.adapter.NotificationAdapter;
import com.subasta.databinding.FragmentNotificationBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.NotificationDTO;
import com.subasta.model.UserDTO;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notification extends Fragment implements OnClickListener {
    private String TAG = Notification.class.getCanonicalName();
    /* access modifiers changed from: private */
    public FragmentNotificationBinding binding;
    private Dashboard dashboard;
    /* access modifiers changed from: private */
    public LinearLayoutManager linearLayoutManager;
    private Context mContext;
    /* access modifiers changed from: private */
    public NotificationAdapter notificationAdapter;
    /* access modifiers changed from: private */
    public ArrayList<NotificationDTO> notificationDTOArrayList;
    private HashMap<String, String> params = new HashMap<>();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;

    public void onClick(View view) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.dashboard = (Dashboard) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FragmentNotificationBinding) DataBindingUtil.inflate(layoutInflater, C2037R.layout.fragment_notification, viewGroup, false);
        this.prefrence = SharedPrefrence.getInstance(getActivity());
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.params.put(Const.USER_PUB_ID, this.userDTO.getUser_pub_id());
        this.binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                Notification.this.getNotification();
            }
        });
        setUiAction();
        return this.binding.getRoot();
    }

    private void setUiAction() {
        if (NetworkManager.isConnectToInternet(getActivity())) {
            getNotification();
        } else {
            ProjectUtils.InternetAlertDialog(getActivity());
        }
    }

    /* access modifiers changed from: private */
    public void getNotification() {
        new HttpsRequest(Const.GET_NOTIFICATION, (Map<String, String>) this.params, (Context) getActivity()).stringPost(this.TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    Notification.this.binding.swipeRefreshLayout.setRefreshing(false);
                    try {
                        Notification.this.binding.recycleview1.setVisibility(0);
                        Notification.this.binding.relative.setVisibility(8);
                        Notification.this.notificationDTOArrayList = new ArrayList();
                        Notification.this.notificationDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray("my_notifications").toString(), new TypeToken<List<NotificationDTO>>() {
                        }.getType());
                        Notification.this.linearLayoutManager = new LinearLayoutManager(Notification.this.getActivity(), 1, false);
                        Notification.this.binding.recycleview1.setLayoutManager(Notification.this.linearLayoutManager);
                        Notification.this.notificationAdapter = new NotificationAdapter(Notification.this.getActivity(), Notification.this.notificationDTOArrayList);
                        Notification.this.binding.recycleview1.setAdapter(Notification.this.notificationAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Notification.this.binding.swipeRefreshLayout.setRefreshing(false);
                    Notification.this.binding.relative.setVisibility(0);
                    Notification.this.binding.recycleview1.setVisibility(8);
                }
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }
}
