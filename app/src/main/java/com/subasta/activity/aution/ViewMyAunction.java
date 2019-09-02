package com.subasta.activity.aution;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.adapter.AdapterAllRating;
import com.subasta.adapter.ViewAunctionBidAdapter;
import com.subasta.databinding.ActivityViewMyAunctionBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.GalleryDTO;
import com.subasta.model.GetRatingDTO;
import com.subasta.model.MyAutionDTO;
import com.subasta.model.UserDTO;
import com.subasta.model.ViewAllAuctionDTO;
import com.subasta.myauctionfregment.MyAuctions;
import com.subasta.network.NetworkManager;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewMyAunction extends AppCompatActivity {
    private static final String TAG = ViewAuction.class.getCanonicalName();
    /* access modifiers changed from: private */
    public AdapterAllRating adapterAllRating;
    /* access modifiers changed from: private */
    public ActivityViewMyAunctionBinding binding;
    /* access modifiers changed from: private */
    public String flag = "2";
    /* access modifiers changed from: private */
    public ArrayList<GetRatingDTO> getRatingDTOArrayList;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    Context mContext;
    private MyAuctions myAuctions = new MyAuctions();
    MyAutionDTO myAutionDTO;
    HashMap<String, String> params = new HashMap<>();
    private HashMap<String, String> paramsAllrating;
    private SharedPrefrence prefrence;
    String productPubId;
    private String status;
    /* access modifiers changed from: private */
    public UserDTO userDTO;
    /* access modifiers changed from: private */
    public ViewAllAuctionDTO viewAllAuctionDTO;
    private ViewAunctionBidAdapter viewAunctionBidAdapter;

    public ViewMyAunction() {
        String str = "";
        this.status = str;
        this.productPubId = str;
        this.paramsAllrating = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.myAuctions.getActivity();
        this.binding = (ActivityViewMyAunctionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_view_my_aunction);
        this.mContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        this.myAutionDTO = (MyAutionDTO) getIntent().getSerializableExtra(Const.MY_AUCTIONDTO);
        this.productPubId = this.myAutionDTO.getPro_pub_id();
        HashMap<String, String> hashMap = this.params;
        String user_pub_id = this.userDTO.getUser_pub_id();
        String str = Const.USER_PUB_ID;
        hashMap.put(str, user_pub_id);
        HashMap<String, String> hashMap2 = this.params;
        String str2 = this.productPubId;
        String str3 = Const.Pro_pub_id;
        hashMap2.put(str3, str2);
        this.paramsAllrating.put(str, this.userDTO.getUser_pub_id());
        this.paramsAllrating.put(str3, this.productPubId);
//        if (this.myAutionDTO.getStatus().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
//            this.binding.deactivate.setVisibility(0);
//        } else {
//            this.binding.deactivate.setVisibility(8);
//        }
        this.binding.btnEdit.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewMyAunction.this.mContext, AddAuction.class);
                Intent intent2 = ViewMyAunction.this.getIntent();
                String str = Const.MY_AUCTIONDTO;
                intent.putExtra(str, intent2.getSerializableExtra(str));
                intent.putExtra(Const.FLAG, 1);
                ViewMyAunction.this.mContext.startActivity(intent);
            }
        });
        this.binding.llViewImage.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ViewMyAunction.this.viewAllAuctionDTO.getGallery().size() >= 0) {
                    Intent intent = new Intent(ViewMyAunction.this.mContext, GalleryActivity.class);
                    intent.putExtra(Const.DTO, ViewMyAunction.this.viewAllAuctionDTO.getGallery());
                    intent.putExtra(Const.Pro_pub_id, ViewMyAunction.this.viewAllAuctionDTO.getPro_pub_id());
                    intent.putExtra(Const.USER_PUB_ID, ViewMyAunction.this.viewAllAuctionDTO.getUser_pub_id());
                    intent.putExtra(Const.FLAG, ViewMyAunction.this.flag);
                    ViewMyAunction.this.startActivity(intent);
                    return;
                }
                ProjectUtils.showToast(ViewMyAunction.this.mContext, "No gallery first upload image then you can update more.");
            }
        });
        this.binding.llClick.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ViewMyAunction.this.viewAllAuctionDTO.getGallery().size() >= 0) {
                    Intent intent = new Intent(ViewMyAunction.this.mContext, GalleryActivity.class);
                    String user_pub_id = ViewMyAunction.this.viewAllAuctionDTO.getUser_pub_id();
                    String str = Const.USER_PUB_ID;
                    intent.putExtra(str, user_pub_id);
                    intent.putExtra(str, ViewMyAunction.this.viewAllAuctionDTO.getPro_pub_id());
                    intent.putExtra(Const.DTO, ViewMyAunction.this.viewAllAuctionDTO.getGallery());
                    intent.putExtra(Const.FLAG, ViewMyAunction.this.flag);
                    ViewMyAunction.this.startActivity(intent);
                    return;
                }
                ProjectUtils.showToast(ViewMyAunction.this.mContext, "No gallery first upload image then you can update more.");
            }
        });
        this.binding.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewMyAunction.this.onBackPressed();
            }
        });
        this.binding.btnDelete.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewMyAunction.this.deleteDailog();
            }
        });
        this.binding.tvViewRating.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewMyAunction.this, GetAllRating.class);
                intent.putExtra(Const.USER_PUB_ID, ViewMyAunction.this.userDTO.getUser_pub_id());
                intent.putExtra(Const.Pro_pub_id, ViewMyAunction.this.viewAllAuctionDTO.getPro_pub_id());
                ViewMyAunction.this.startActivity(intent);
            }
        });
//        this.binding.ivMap.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                StringBuilder sb = new StringBuilder();
//                sb.append("geo:0,0?q=");
//                sb.append(ViewMyAunction.this.viewAllAuctionDTO.getLatitude());
//                sb.append(",");
//                sb.append(ViewMyAunction.this.viewAllAuctionDTO.getLongitude());
//                ViewMyAunction.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
//            }
//        });
        this.binding.tvViewRating.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewMyAunction.this, GetAllRating.class);
                intent.putExtra(Const.USER_PUB_ID, ViewMyAunction.this.userDTO.getUser_pub_id());
                intent.putExtra(Const.Pro_pub_id, ViewMyAunction.this.viewAllAuctionDTO.getPro_pub_id());
                ViewMyAunction.this.startActivity(intent);
            }
        });
        this.binding.tvViewAllBid.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ViewMyAunction.this, ViewBidAuntion.class);
                intent.putExtra(Const.Pro_pub_id, ViewMyAunction.this.viewAllAuctionDTO.getPro_pub_id());
                ViewMyAunction.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteAunctions() {
        new HttpsRequest(Const.DELETE_AUNTION, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                if (z) {
                    ViewMyAunction.this.finish();
                    Toast.makeText(ViewMyAunction.this.mContext, str, 0).show();
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
//                ViewMyAunction.this.deleteAunctions();
//            }
//        }).setNegativeButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog create = builder.create();
//        create.setTitle(Const.APP_NAME);
//        create.setIcon((int) C2037R.C2038drawable.ic_deleteauction);
//        create.show();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (NetworkManager.isConnectToInternet(this.mContext)) {
            getSingleAuction();
            getAllRating();
            return;
        }
        ProjectUtils.showToast(this.mContext, getString(C2037R.string.internet_connection));
    }

    private void getSingleAuction() {
        new HttpsRequest(Const.GET_SINGLE_AUNCTION, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
//                        ViewMyAunction.this.viewAllAuctionDTO = (ViewAllAuctionDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), ViewAllAuctionDTO.class);
                        ViewMyAunction.this.showData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @SuppressLint("WrongConstant")
    public void showData() {
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((GalleryDTO) this.viewAllAuctionDTO.getGallery().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(this.binding.ivGallery);
        } catch (Exception unused) {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load("").centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(this.binding.ivGallery);
        }
//        this.binding.deactivate.setImageResource(C2037R.C2038drawable.deactivate);
        this.binding.tvMediaCount.setText(this.viewAllAuctionDTO.getGallery_count());
//        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(this.viewAllAuctionDTO.getUsers().getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into((ImageView) this.binding.ivProfile);
        this.binding.tvName.setText(ProjectUtils.capWordFirstLetter(this.viewAllAuctionDTO.getUsers().getName()));
        this.binding.tvDate.setText(ProjectUtils.changeDateFormate(this.viewAllAuctionDTO.getCreated_at()));
        CustomTextViewBold customTextViewBold = this.binding.tvPrice;
        StringBuilder sb = new StringBuilder();
        sb.append(this.viewAllAuctionDTO.getCurrency_code());
        sb.append(" ");
        sb.append(this.viewAllAuctionDTO.getPrice());
        customTextViewBold.setText(sb.toString());
        this.binding.tvShortDescription.setText(this.viewAllAuctionDTO.getTitle());
        this.binding.tvAddress.setText(this.viewAllAuctionDTO.getAddress());
        this.binding.tvDescription.setText(this.viewAllAuctionDTO.getDescription());
        this.binding.tvAddress.setText(this.viewAllAuctionDTO.getAddress());
        this.binding.catname.setText(this.viewAllAuctionDTO.getCat_title());
        this.binding.simpleRatingBar1.setRating(Float.parseFloat(this.viewAllAuctionDTO.getAllrating()));
        if (this.viewAllAuctionDTO.getBids().size() > 0) {
            this.layoutManager = new LinearLayoutManager(this.mContext, 1, false);
            this.binding.rvBids.setLayoutManager(this.layoutManager);
//            this.viewAunctionBidAdapter = new ViewAunctionBidAdapter(this.viewAllAuctionDTO.getBids(), this.mContext, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            this.binding.rvBids.setAdapter(this.viewAunctionBidAdapter);
            return;
        }
        this.binding.linear.setVisibility(8);
    }

    private void getAllRating() {
        new HttpsRequest(Const.GET_ALL_RATING, (Map<String, String>) this.paramsAllrating, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        ViewMyAunction.this.binding.linRating.setVisibility(0);
                        ViewMyAunction.this.getRatingDTOArrayList = new ArrayList();
//                        ViewMyAunction.this.getRatingDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<GetRatingDTO>>() {
//                        }.getType());
                        ViewMyAunction.this.layoutManager = new LinearLayoutManager(ViewMyAunction.this.mContext, 1, false);
                        ViewMyAunction.this.binding.rvAllRating.setLayoutManager(ViewMyAunction.this.layoutManager);
//                        ViewMyAunction.this.adapterAllRating = new AdapterAllRating(ViewMyAunction.this.mContext, ViewMyAunction.this.getRatingDTOArrayList, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        ViewMyAunction.this.binding.rvAllRating.setAdapter(ViewMyAunction.this.adapterAllRating);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ViewMyAunction.this.binding.linRating.setVisibility(8);
                }
            }
        });
    }
}
