package com.subasta.activity.aution;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.subasta.C2037R;
import com.subasta.activity.ChatstalkingActivity;
import com.subasta.adapter.AdapterAllRating;
import com.subasta.adapter.ViewAunctionBidAdapter;
import com.subasta.databinding.ActivityViewAuctionBinding;
import com.subasta.databinding.CommentBinding;
import com.subasta.https.HttpsRequest;
import com.subasta.interfaces.Const;
import com.subasta.interfaces.Helper;
import com.subasta.model.GalleryDTO;
import com.subasta.model.GetRatingDTO;
import com.subasta.model.UserDTO;
import com.subasta.model.ViewAllAuctionDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.ProjectUtils;
import com.willy.ratingbar.BaseRatingBar;
import com.willy.ratingbar.BaseRatingBar.OnRatingChangeListener;

import net.gotev.uploadservice.ContentType;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewAuction extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "com.subasta.activity.aution.ViewAuction";
    private static String price = "";
    /* access modifiers changed from: private */
    public AdapterAllRating adapterAllRating;
    String addComment;
    TextView bidprice;
    /* access modifiers changed from: private */
    public ActivityViewAuctionBinding binding;
    Button btnAddBid;
    Button btnComment;
    String comment;
    /* access modifiers changed from: private */
    public Dialog dialogbox_add_bid;
    /* access modifiers changed from: private */
    public Dialog dialogbox_comment;
    EditText etBidPrice;
    EditText etComment;
    private String flag = "YES";// AppEventsConstants.EVENT_PARAM_VALUE_YES;
    private ArrayList<GalleryDTO> galleryDTOArrayList;
    /* access modifiers changed from: private */
    public ArrayList<GetRatingDTO> getRatingDTOArrayList;

    /* renamed from: id */
    private String f1304id;
    ImageView ivClose;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public HashMap<String, String> paramRating = new HashMap<>();
    HashMap<String, String> params = new HashMap<>();
    /* access modifiers changed from: private */
    public HashMap<String, String> paramsAddBid = new HashMap<>();
    private HashMap<String, String> paramsAllrating = new HashMap<>();
    private HashMap<String, String> paramsUnfavrouite = new HashMap<>();
    private HashMap<String, String> paramsfavrouite = new HashMap<>();
    private SharedPrefrence prefrence;
    String proPrice;
    String ratingBar;
    TextView tvbidprice;
    TextView tvbidproductname;
    private UserDTO userDTO;
    /* access modifiers changed from: private */
    public ViewAllAuctionDTO viewAllAuctionDTO;
    private ViewAunctionBidAdapter viewAunctionBidAdapter;

    /* access modifiers changed from: protected */
    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityViewAuctionBinding) DataBindingUtil.setContentView(this, C2037R.layout.activity_view_auction);
        this.mContext = this;
        this.prefrence = SharedPrefrence.getInstance(this.mContext);
        this.userDTO = this.prefrence.getParentUser(Const.USER_DTO);
        HashMap<String, String> hashMap = this.params;
        String user_pub_id = this.userDTO.getUser_pub_id();
        String str = Const.USER_PUB_ID;
        hashMap.put(str, user_pub_id);
        if (getIntent().hasExtra(Const.WON_INDEX)) {
            this.binding.llOffer.setVisibility(8);
//            this.binding.ivwin.setVisibility(0);
        } else {
            this.binding.llOffer.setVisibility(0);
//            this.binding.ivwin.setVisibility(8);
        }
        Intent intent = getIntent();
        String str2 = Const.Pro_pub_id;
        if (intent.hasExtra(str2)) {
            this.f1304id = getIntent().getStringExtra(str2);
            this.params.put(str2, this.f1304id);
        }
        this.paramsAddBid.put(str, this.userDTO.getUser_pub_id());
        this.paramsAddBid.put(str2, this.f1304id);
        this.paramsfavrouite.put(str, this.userDTO.getUser_pub_id());
        this.paramsfavrouite.put(str2, this.f1304id);
        this.paramsUnfavrouite.put(str, this.userDTO.getUser_pub_id());
        this.paramsUnfavrouite.put(str2, this.f1304id);
        this.paramRating.put(str, this.userDTO.getUser_pub_id());
        this.paramRating.put(str2, this.f1304id);
        this.paramsAllrating.put(str, this.userDTO.getUser_pub_id());
        this.paramsAllrating.put(str2, this.f1304id);
        setUiAction();
    }

    public void setUiAction() {
        this.binding.llViewImage.setOnClickListener(this);
        this.binding.tvViewProfile.setOnClickListener(this);
        this.binding.tvViewRating.setOnClickListener(this);
        this.binding.llClick.setOnClickListener(this);
        this.binding.comment.setOnClickListener(this);
        this.binding.tvViewAllBid.setOnClickListener(this);
//        this.binding.ivMap.setOnClickListener(this);
        getSingleAuction();
        getAllRating();
    }

    /* access modifiers changed from: private */
    public void getSingleAuction() {
        new HttpsRequest(Const.GET_SINGLE_AUNCTION, (Map<String, String>) this.params, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
//                        ViewAuction.this.viewAllAuctionDTO = (ViewAllAuctionDTO) new Gson().fromJson(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), ViewAllAuctionDTO.class);
                        ViewAuction.this.showData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void getAllRating() {
        new HttpsRequest(Const.GET_ALL_RATING, (Map<String, String>) this.paramsAllrating, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    try {
                        ViewAuction.this.binding.linRating.setVisibility(0);
                        ViewAuction.this.getRatingDTOArrayList = new ArrayList();
//                        ViewAuction.this.getRatingDTOArrayList = (ArrayList) new Gson().fromJson(jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA).toString(), new TypeToken<List<GetRatingDTO>>() {
//                        }.getType());
                        ViewAuction.this.layoutManager = new LinearLayoutManager(ViewAuction.this.mContext, 1, false);
                        ViewAuction.this.binding.rvAllRating.setLayoutManager(ViewAuction.this.layoutManager);
//                        ViewAuction.this.adapterAllRating = new AdapterAllRating(ViewAuction.this.mContext, ViewAuction.this.getRatingDTOArrayList, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        ViewAuction.this.binding.rvAllRating.setAdapter(ViewAuction.this.adapterAllRating);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ViewAuction.this.binding.linRating.setVisibility(8);
                }
            }
        });
    }

    public void getSelectingRating() {
        new HttpsRequest(Const.ADD_RATING, (Map<String, String>) this.paramRating, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ViewAuction.this.getAllRating();
                    ViewAuction.this.dialogbox_comment.dismiss();
                    ProjectUtils.showToast(ViewAuction.this.mContext, str);
                    return;
                }
                Toast.makeText(ViewAuction.this.mContext, "Please give your rating and comment.", 0).show();
            }
        });
    }

    @SuppressLint("WrongConstant")
    public void showData() {
        try {
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(((GalleryDTO) this.viewAllAuctionDTO.getGallery().get(0)).getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(this.binding.ivGallery);
        } catch (Exception unused) {
        }
//        this.binding.ivwin.setImageResource(C2037R.C2038drawable.win);
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
        this.binding.catname.setText(this.viewAllAuctionDTO.getCat_title());
        this.binding.tvAddress.setText(this.viewAllAuctionDTO.getAddress());
        this.binding.tvDescription.setText(this.viewAllAuctionDTO.getDescription());
        this.binding.tvAddress.setText(this.viewAllAuctionDTO.getAddress());
        if (this.viewAllAuctionDTO.getBids().size() > 0) {
            this.binding.line1.setVisibility(0);
            this.layoutManager = new LinearLayoutManager(this.mContext, 1, false);
            this.binding.rvBids.setLayoutManager(this.layoutManager);
//            this.viewAunctionBidAdapter = new ViewAunctionBidAdapter(this.viewAllAuctionDTO.getBids(), this.mContext, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            this.binding.rvBids.setAdapter(this.viewAunctionBidAdapter);
        } else {
            this.binding.line1.setVisibility(8);
        }
        this.binding.simpleRatingBar1.setRating(Float.parseFloat(this.viewAllAuctionDTO.getAllrating()));
//        if (this.viewAllAuctionDTO.getFavourite().equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//            this.binding.ivFavScreen.setImageDrawable(getResources().getDrawable(C2037R.C2038drawable.ic_unfav));
//        } else {
//            this.binding.ivFavScreen.setImageDrawable(getResources().getDrawable(C2037R.C2038drawable.ic_filledfav));
//        }
    }

    public void onClick(View view) {
        int id = view.getId();
        String str = Const.Pro_pub_id;
        String str2 = Const.FLAG;
        String str3 = Const.DTO;
        String str4 = Const.USER_PUB_ID;
        switch (id) {
            case C2037R.C2039id.comment /*2131362000*/:
                dialogbox_comment();
                return;
            case C2037R.C2039id.ivBack1 /*2131362136*/:
                onBackPressed();
                return;
            case C2037R.C2039id.ivFavScreen /*2131362145*/:
//                if (this.viewAllAuctionDTO.getFavourite().equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//                    setfavrouite();
//                    return;
//                } else {
                    setUnFavrouite();
//                    return;
//                }
            case C2037R.C2039id.ivMap /*2131362151*/:
                StringBuilder sb = new StringBuilder();
                sb.append("geo:0,0?q=");
                sb.append(this.viewAllAuctionDTO.getLatitude());
                sb.append(",");
                sb.append(this.viewAllAuctionDTO.getLongitude());
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                return;
            case C2037R.C2039id.llChatscreen /*2131362199*/:
                Intent intent = new Intent(this.mContext, ChatstalkingActivity.class);
                intent.putExtra(Const.RECEIVER_ID, this.viewAllAuctionDTO.getUsers().getUser_pub_id());
                intent.putExtra(Const.RECEIVER_NAME, this.viewAllAuctionDTO.getUsers().getName());
                intent.putExtra(Const.RECEIVER_IMAGE, this.viewAllAuctionDTO.getUsers().getImage());
                startActivity(intent);
                return;
            case C2037R.C2039id.llClick /*2131362200*/:
                Intent intent2 = new Intent(this.mContext, GalleryActivity.class);
                intent2.putExtra(str3, this.viewAllAuctionDTO.getGallery());
                intent2.putExtra(str4, this.viewAllAuctionDTO.getUser_pub_id());
                intent2.putExtra(str2, this.flag);
                startActivity(intent2);
                return;
            case C2037R.C2039id.llOffer /*2131362205*/:
                dialogbox_add_bid();
                return;
            case C2037R.C2039id.llViewImage /*2131362208*/:
                if (this.viewAllAuctionDTO.getGallery().size() > 0) {
                    Intent intent3 = new Intent(this.mContext, GalleryActivity.class);
                    intent3.putExtra(str3, this.viewAllAuctionDTO.getGallery());
                    intent3.putExtra(str4, this.viewAllAuctionDTO.getUser_pub_id());
                    intent3.putExtra(str2, this.flag);
                    startActivity(intent3);
                    return;
                }
                ProjectUtils.showToast(this.mContext, "No Gallery Found");
                return;
            case C2037R.C2039id.tvViewAllBid /*2131362520*/:
                Intent intent4 = new Intent(this, ViewBidAuntion.class);
                intent4.putExtra(str, this.f1304id);
                startActivity(intent4);
                return;
            case C2037R.C2039id.tvViewProfile /*2131362522*/:
                Intent intent5 = new Intent(this, ViewProfileActivity.class);
                intent5.putExtra(str4, this.viewAllAuctionDTO.getUser_pub_id());
                startActivity(intent5);
                return;
            case C2037R.C2039id.tvViewRating /*2131362523*/:
                Intent intent6 = new Intent(this, GetAllRating.class);
                intent6.putExtra(str4, this.userDTO.getUser_pub_id());
                intent6.putExtra(str, this.viewAllAuctionDTO.getPro_pub_id());
                startActivity(intent6);
                return;
            default:
                return;
        }
    }

    private void setfavrouite() {
        new HttpsRequest(Const.GET_FAVROUITE, (Map<String, String>) this.paramsfavrouite, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint({"WrongConstant", "ShowToast"})
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    Toast.makeText(ViewAuction.this.mContext, str, 0).show();
                    ViewAuction.this.binding.ivFavScreen.setImageDrawable(ViewAuction.this.getResources().getDrawable(C2037R.C2038drawable.ic_filledfav));
//                    ViewAuction.this.viewAllAuctionDTO.setFavourite(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    return;
                }
                ProjectUtils.showToast(ViewAuction.this.mContext, str);
            }
        });
    }

    @SuppressLint("WrongConstant")
    private void shareTextUrl() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ContentType.TEXT_PLAIN);
        intent.addFlags(524288);
        intent.putExtra("android.intent.extra.SUBJECT", "Title Of The Post");
        intent.putExtra("android.intent.extra.TEXT", "Hello...............");
        startActivity(Intent.createChooser(intent, "Share link!"));
    }

    private void setUnFavrouite() {
        new HttpsRequest(Const.GET_MYUNFAV, (Map<String, String>) this.paramsUnfavrouite, this.mContext).stringPost(TAG, new Helper() {
            @SuppressLint("WrongConstant")
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    Toast.makeText(ViewAuction.this.mContext, str, 0).show();
                    ViewAuction.this.binding.ivFavScreen.setImageDrawable(ViewAuction.this.getResources().getDrawable(C2037R.C2038drawable.ic_unfav));
//                    ViewAuction.this.viewAllAuctionDTO.setFavourite(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    return;
                }
                ProjectUtils.showToast(ViewAuction.this.mContext, str);
            }
        });
    }

    private void dialogbox_add_bid() {
        this.dialogbox_add_bid = new Dialog(this.mContext);
        this.dialogbox_add_bid.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialogbox_add_bid.requestWindowFeature(1);
        this.dialogbox_add_bid.setContentView(C2037R.layout.activity_add_bid);
        this.etBidPrice = (EditText) this.dialogbox_add_bid.findViewById(C2037R.C2039id.etBidPrice);
        this.btnAddBid = (Button) this.dialogbox_add_bid.findViewById(C2037R.C2039id.btnAddBid);
        CustomTextViewBold customTextViewBold = (CustomTextViewBold) this.dialogbox_add_bid.findViewById(C2037R.C2039id.tvBidProductname);
        CustomTextViewBold customTextViewBold2 = (CustomTextViewBold) this.dialogbox_add_bid.findViewById(C2037R.C2039id.tvBidProductprice);
        this.ivClose = (ImageView) this.dialogbox_add_bid.findViewById(C2037R.C2039id.ivClose);
        this.dialogbox_add_bid.show();
        this.dialogbox_add_bid.setCancelable(true);
        StringBuilder sb = new StringBuilder();
        sb.append(this.viewAllAuctionDTO.getCurrency_code());
        sb.append(" ");
        sb.append(this.viewAllAuctionDTO.getPrice());
        customTextViewBold2.setText(sb.toString());
        customTextViewBold.setText(this.viewAllAuctionDTO.getTitle());
        this.btnAddBid.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewAuction viewAuction = ViewAuction.this;
                viewAuction.proPrice = viewAuction.etBidPrice.getText().toString();
//                if (!ViewAuction.this.proPrice.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
//                    ViewAuction.this.paramsAddBid.put("price", ViewAuction.this.proPrice);
//                    ViewAuction.this.setData();
//                    return;
//                }
                ProjectUtils.showToast(ViewAuction.this.mContext, ViewAuction.this.mContext.getResources().getString(C2037R.string.valid_bid));
            }
        });
        this.ivClose.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewAuction.this.dialogbox_add_bid.dismiss();
            }
        });
    }

    private void dialogbox_comment() {
        this.dialogbox_comment = new Dialog(this.mContext);
        this.dialogbox_comment.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialogbox_comment.requestWindowFeature(1);
        final CommentBinding commentBinding = (CommentBinding) DataBindingUtil.inflate(LayoutInflater.from(this.dialogbox_comment.getContext()), C2037R.layout.comment, null, false);
        this.dialogbox_comment.setContentView(commentBinding.getRoot());
        this.dialogbox_comment.show();
        this.dialogbox_comment.setCancelable(true);
        commentBinding.simpleRatingBar.setOnRatingChangeListener(new OnRatingChangeListener() {
            public void onRatingChange(BaseRatingBar baseRatingBar, float f, boolean z) {
                ViewAuction.this.paramRating.put(Const.STAR, String.valueOf(commentBinding.simpleRatingBar.getRating()));
            }
        });
        commentBinding.btnComment.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewAuction.this.paramRating.put(Const.COMMENT, commentBinding.etComment.getText().toString());
                ViewAuction.this.getSelectingRating();
            }
        });
        commentBinding.ivClose.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ViewAuction.this.dialogbox_comment.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setData() {
        new HttpsRequest(Const.ADD_BID, (Map<String, String>) this.paramsAddBid, this.mContext).stringPost(TAG, new Helper() {
            public void backResponse(boolean z, String str, JSONObject jSONObject) {
                ProjectUtils.pauseProgressDialog();
                if (z) {
                    ViewAuction.this.getSingleAuction();
                    ProjectUtils.showToast(ViewAuction.this.mContext, str);
                    ViewAuction.this.dialogbox_add_bid.dismiss();
                    return;
                }
                ProjectUtils.showToast(ViewAuction.this.mContext, str);
            }
        });
    }
}
