package com.subasta;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;

import androidx.databinding.DataBinderMapper;
import androidx.databinding.ViewDataBinding;

import com.subasta.databinding.ActionbarHeaderNavBindingImpl;
import com.subasta.databinding.ActivityAddBidBindingImpl;
import com.subasta.databinding.ActivityAdvertiseImagesBindingImpl;
import com.subasta.databinding.ActivityAllAdvertiseBindingImpl;
import com.subasta.databinding.ActivityAutionAllBindingImpl;
import com.subasta.databinding.ActivityAutionImagesBindingImpl;
import com.subasta.databinding.ActivityCategoryBasedAdsAuctionBindingImpl;
import com.subasta.databinding.ActivityCategorylistBindingImpl;
import com.subasta.databinding.ActivityChangPasswordBindingImpl;
import com.subasta.databinding.ActivityChatstalkingBindingImpl;
import com.subasta.databinding.ActivityDetailsAutionBindingImpl;
import com.subasta.databinding.ActivityDialogboxForgetpasswordBindingImpl;
import com.subasta.databinding.ActivityFavoruiteBindingImpl;
import com.subasta.databinding.ActivityFilterBindingImpl;
import com.subasta.databinding.ActivityGalleryBindingImpl;
import com.subasta.databinding.ActivityGetAllRatingBindingImpl;
import com.subasta.databinding.ActivityMainBindingImpl;
import com.subasta.databinding.ActivityMyBidsBindingImpl;
import com.subasta.databinding.ActivityPlansBindingImpl;
import com.subasta.databinding.ActivityPostAuctionBindingImpl;
import com.subasta.databinding.ActivityPostSubAunctionBindingImpl;
import com.subasta.databinding.ActivityProfileBindingImpl;
import com.subasta.databinding.ActivitySearchBindingImpl;
import com.subasta.databinding.ActivitySignInBindingImpl;
import com.subasta.databinding.ActivitySignUpBindingImpl;
import com.subasta.databinding.ActivitySplashBindingImpl;
import com.subasta.databinding.ActivitySubscriptionPackageBindingImpl;
import com.subasta.databinding.ActivitySupportAcitivityBindingImpl;
import com.subasta.databinding.ActivityUpdateprofileBindingImpl;
import com.subasta.databinding.ActivityViewAdvertiseBindingImpl;
import com.subasta.databinding.ActivityViewAuctionBindingImpl;
import com.subasta.databinding.ActivityViewBidAuntionBindingImpl;
import com.subasta.databinding.ActivityViewMyAunctionBindingImpl;
import com.subasta.databinding.ActivityViewProfileBindingImpl;
import com.subasta.databinding.AdapterAddImageBindingImpl;
import com.subasta.databinding.AdapterAdvertiseAllBindingImpl;
import com.subasta.databinding.AdapterAdvertiseBindingImpl;
import com.subasta.databinding.AdapterAllRatingBindingImpl;
import com.subasta.databinding.AdapterAuctionBindingImpl;
import com.subasta.databinding.AdapterCategoryBindingImpl;
import com.subasta.databinding.AdapterCategoryListBindingImpl;
import com.subasta.databinding.AdapterChatItemListBindingImpl;
import com.subasta.databinding.AdapterGalleryImageSliderBindingImpl;
import com.subasta.databinding.AdapterHistoryBindingImpl;
import com.subasta.databinding.AdapterItemAutionAllBindingImpl;
import com.subasta.databinding.AdapterItemFilterAunctionsBindingImpl;
import com.subasta.databinding.AdapterItemFilterBindingImpl;
import com.subasta.databinding.AdapterItemMyAdsBindingImpl;
import com.subasta.databinding.AdapterItemMyAunctionBindingImpl;
import com.subasta.databinding.AdapterItemMyBidsBindingImpl;
import com.subasta.databinding.AdapterMyChatBindingImpl;
import com.subasta.databinding.AdapterMyfavBindingImpl;
import com.subasta.databinding.AdapterNotificationBindingImpl;
import com.subasta.databinding.AdapterSubCategoryBindingImpl;
import com.subasta.databinding.AdapterSubscriptionStandardBindingImpl;
import com.subasta.databinding.AdapterSupprtBindingImpl;
import com.subasta.databinding.AdapterViewauntionBidBindingImpl;
import com.subasta.databinding.AdapterWonBidsBindingImpl;
import com.subasta.databinding.ChatBubbleLeft1BindingImpl;
import com.subasta.databinding.ChatBubbleRightBindingImpl;
import com.subasta.databinding.CommentBindingImpl;
import com.subasta.databinding.FragmentBrowseBindingImpl;
import com.subasta.databinding.FragmentMyChatBindingImpl;
import com.subasta.databinding.FragmentNotificationBindingImpl;
import com.subasta.databinding.FragmentSettingBindingImpl;
import com.subasta.databinding.FragmentSubscriptionBindingImpl;
import com.subasta.databinding.FregementMyAunctionFavBindingImpl;
import com.subasta.databinding.FregmentMyAdsBindingImpl;
import com.subasta.databinding.FregmentMyAuctionBindingImpl;
import com.subasta.databinding.FregmentMyAunctionAunctionsBindingImpl;
import com.subasta.databinding.FregmentMyAunctionBidsBindingImpl;
import com.subasta.databinding.FregmentSubscriptionHistoryBindingImpl;
import com.subasta.databinding.FregmentWonBidsBindingImpl;
import com.subasta.databinding.ItemPostAunctionBindingImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint("RestrictedApi")
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(74);
    private static final int LAYOUT_ACTIONBARHEADERNAV = 1;
    private static final int LAYOUT_ACTIVITYADDBID = 2;
    private static final int LAYOUT_ACTIVITYADVERTISEIMAGES = 3;
    private static final int LAYOUT_ACTIVITYALLADVERTISE = 4;
    private static final int LAYOUT_ACTIVITYAUTIONALL = 5;
    private static final int LAYOUT_ACTIVITYAUTIONIMAGES = 6;
    private static final int LAYOUT_ACTIVITYCATEGORYBASEDADSAUCTION = 7;
    private static final int LAYOUT_ACTIVITYCATEGORYLIST = 8;
    private static final int LAYOUT_ACTIVITYCHANGPASSWORD = 9;
    private static final int LAYOUT_ACTIVITYCHATSTALKING = 10;
    private static final int LAYOUT_ACTIVITYDETAILSAUTION = 11;
    private static final int LAYOUT_ACTIVITYDIALOGBOXFORGETPASSWORD = 12;
    private static final int LAYOUT_ACTIVITYFAVORUITE = 13;
    private static final int LAYOUT_ACTIVITYFILTER = 14;
    private static final int LAYOUT_ACTIVITYGALLERY = 15;
    private static final int LAYOUT_ACTIVITYGETALLRATING = 16;
    private static final int LAYOUT_ACTIVITYMAIN = 17;
    private static final int LAYOUT_ACTIVITYMYBIDS = 18;
    private static final int LAYOUT_ACTIVITYPLANS = 19;
    private static final int LAYOUT_ACTIVITYPOSTAUCTION = 20;
    private static final int LAYOUT_ACTIVITYPOSTSUBAUNCTION = 21;
    private static final int LAYOUT_ACTIVITYPROFILE = 22;
    private static final int LAYOUT_ACTIVITYSEARCH = 23;
    private static final int LAYOUT_ACTIVITYSIGNIN = 25;
    private static final int LAYOUT_ACTIVITYSIGNUP = 24;
    private static final int LAYOUT_ACTIVITYSPLASH = 26;
    private static final int LAYOUT_ACTIVITYSUBSCRIPTIONPACKAGE = 27;
    private static final int LAYOUT_ACTIVITYSUPPORTACITIVITY = 28;
    private static final int LAYOUT_ACTIVITYUPDATEPROFILE = 29;
    private static final int LAYOUT_ACTIVITYVIEWADVERTISE = 30;
    private static final int LAYOUT_ACTIVITYVIEWAUCTION = 31;
    private static final int LAYOUT_ACTIVITYVIEWBIDAUNTION = 32;
    private static final int LAYOUT_ACTIVITYVIEWMYAUNCTION = 33;
    private static final int LAYOUT_ACTIVITYVIEWPROFILE = 34;
    private static final int LAYOUT_ADAPTERADDIMAGE = 35;
    private static final int LAYOUT_ADAPTERADVERTISE = 36;
    private static final int LAYOUT_ADAPTERADVERTISEALL = 37;
    private static final int LAYOUT_ADAPTERALLRATING = 38;
    private static final int LAYOUT_ADAPTERAUCTION = 39;
    private static final int LAYOUT_ADAPTERCATEGORY = 40;
    private static final int LAYOUT_ADAPTERCATEGORYLIST = 41;
    private static final int LAYOUT_ADAPTERCHATITEMLIST = 42;
    private static final int LAYOUT_ADAPTERGALLERYIMAGESLIDER = 43;
    private static final int LAYOUT_ADAPTERHISTORY = 44;
    private static final int LAYOUT_ADAPTERITEMAUTIONALL = 45;
    private static final int LAYOUT_ADAPTERITEMFILTER = 46;
    private static final int LAYOUT_ADAPTERITEMFILTERAUNCTIONS = 47;
    private static final int LAYOUT_ADAPTERITEMMYADS = 48;
    private static final int LAYOUT_ADAPTERITEMMYAUNCTION = 49;
    private static final int LAYOUT_ADAPTERITEMMYBIDS = 50;
    private static final int LAYOUT_ADAPTERMYCHAT = 51;
    private static final int LAYOUT_ADAPTERMYFAV = 52;
    private static final int LAYOUT_ADAPTERNOTIFICATION = 53;
    private static final int LAYOUT_ADAPTERSUBCATEGORY = 54;
    private static final int LAYOUT_ADAPTERSUBSCRIPTIONSTANDARD = 55;
    private static final int LAYOUT_ADAPTERSUPPRT = 56;
    private static final int LAYOUT_ADAPTERVIEWAUNTIONBID = 57;
    private static final int LAYOUT_ADAPTERWONBIDS = 58;
    private static final int LAYOUT_CHATBUBBLELEFT1 = 59;
    private static final int LAYOUT_CHATBUBBLERIGHT = 60;
    private static final int LAYOUT_COMMENT = 61;
    private static final int LAYOUT_FRAGMENTBROWSE = 62;
    private static final int LAYOUT_FRAGMENTMYCHAT = 63;
    private static final int LAYOUT_FRAGMENTNOTIFICATION = 64;
    private static final int LAYOUT_FRAGMENTSETTING = 65;
    private static final int LAYOUT_FRAGMENTSUBSCRIPTION = 66;
    private static final int LAYOUT_FREGEMENTMYAUNCTIONFAV = 67;
    private static final int LAYOUT_FREGMENTMYADS = 68;
    private static final int LAYOUT_FREGMENTMYAUCTION = 69;
    private static final int LAYOUT_FREGMENTMYAUNCTIONAUNCTIONS = 70;
    private static final int LAYOUT_FREGMENTMYAUNCTIONBIDS = 71;
    private static final int LAYOUT_FREGMENTSUBSCRIPTIONHISTORY = 72;
    private static final int LAYOUT_FREGMENTWONBIDS = 73;
    private static final int LAYOUT_ITEMPOSTAUNCTION = 74;

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>(2);

        private InnerBrLookup() {
        }

        static {
            sKeys.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(74);

        private InnerLayoutIdLookup() {
        }

        static {
            sKeys.put("layout/actionbar_header_nav_0", Integer.valueOf(C2037R.layout.actionbar_header_nav));
            sKeys.put("layout/activity_add_bid_0", Integer.valueOf(C2037R.layout.activity_add_bid));
            sKeys.put("layout/activity_advertise_images_0", Integer.valueOf(C2037R.layout.activity_advertise_images));
            sKeys.put("layout/activity_all_advertise_0", Integer.valueOf(C2037R.layout.activity_all_advertise));
            sKeys.put("layout/activity_aution_all_0", Integer.valueOf(C2037R.layout.activity_aution_all));
            sKeys.put("layout/activity_aution_images_0", Integer.valueOf(C2037R.layout.activity_aution_images));
            sKeys.put("layout/activity_category_based_ads_auction_0", Integer.valueOf(C2037R.layout.activity_category_based_ads_auction));
            sKeys.put("layout/activity_categorylist_0", Integer.valueOf(C2037R.layout.activity_categorylist));
            sKeys.put("layout/activity_chang_password_0", Integer.valueOf(C2037R.layout.activity_chang_password));
            sKeys.put("layout/activity_chatstalking_0", Integer.valueOf(C2037R.layout.activity_chatstalking));
            sKeys.put("layout/activity_details_aution_0", Integer.valueOf(C2037R.layout.activity_details_aution));
            sKeys.put("layout/activity_dialogbox_forgetpassword_0", Integer.valueOf(C2037R.layout.activity_dialogbox_forgetpassword));
            sKeys.put("layout/activity_favoruite_0", Integer.valueOf(C2037R.layout.activity_favoruite));
            sKeys.put("layout/activity_filter_0", Integer.valueOf(C2037R.layout.activity_filter));
            sKeys.put("layout/activity_gallery_0", Integer.valueOf(C2037R.layout.activity_gallery));
            sKeys.put("layout/activity_get_all_rating_0", Integer.valueOf(C2037R.layout.activity_get_all_rating));
            sKeys.put("layout/activity_main_0", Integer.valueOf(C2037R.layout.activity_main));
            sKeys.put("layout/activity_my_bids_0", Integer.valueOf(C2037R.layout.activity_my_bids));
            sKeys.put("layout/activity_plans_0", Integer.valueOf(C2037R.layout.activity_plans));
            sKeys.put("layout/activity_post_auction_0", Integer.valueOf(C2037R.layout.activity_post_auction));
            sKeys.put("layout/activity_post_sub_aunction_0", Integer.valueOf(C2037R.layout.activity_post_sub_aunction));
            sKeys.put("layout/activity_profile_0", Integer.valueOf(C2037R.layout.activity_profile));
            sKeys.put("layout/activity_search_0", Integer.valueOf(C2037R.layout.activity_search));
            sKeys.put("layout/activity_sign__up_0", Integer.valueOf(C2037R.layout.activity_sign__up));
            sKeys.put("layout/activity_sign_in_0", Integer.valueOf(C2037R.layout.activity_sign_in));
            sKeys.put("layout/activity_splash_0", Integer.valueOf(C2037R.layout.activity_splash));
            sKeys.put("layout/activity_subscription_package_0", Integer.valueOf(C2037R.layout.activity_subscription_package));
            sKeys.put("layout/activity_support_acitivity_0", Integer.valueOf(C2037R.layout.activity_support_acitivity));
            sKeys.put("layout/activity_updateprofile_0", Integer.valueOf(C2037R.layout.activity_updateprofile));
            sKeys.put("layout/activity_view_advertise_0", Integer.valueOf(C2037R.layout.activity_view_advertise));
            sKeys.put("layout/activity_view_auction_0", Integer.valueOf(C2037R.layout.activity_view_auction));
            sKeys.put("layout/activity_view_bid_auntion_0", Integer.valueOf(C2037R.layout.activity_view_bid_auntion));
            sKeys.put("layout/activity_view_my_aunction_0", Integer.valueOf(C2037R.layout.activity_view_my_aunction));
            sKeys.put("layout/activity_view_profile_0", Integer.valueOf(C2037R.layout.activity_view_profile));
            sKeys.put("layout/adapter_add_image_0", Integer.valueOf(C2037R.layout.adapter_add_image));
            sKeys.put("layout/adapter_advertise_0", Integer.valueOf(C2037R.layout.adapter_advertise));
            sKeys.put("layout/adapter_advertise_all_0", Integer.valueOf(C2037R.layout.adapter_advertise_all));
            sKeys.put("layout/adapter_all_rating_0", Integer.valueOf(C2037R.layout.adapter_all_rating));
            sKeys.put("layout/adapter_auction_0", Integer.valueOf(C2037R.layout.adapter_auction));
            sKeys.put("layout/adapter_category_0", Integer.valueOf(C2037R.layout.adapter_category));
            sKeys.put("layout/adapter_category_list_0", Integer.valueOf(C2037R.layout.adapter_category_list));
            sKeys.put("layout/adapter_chat_item_list_0", Integer.valueOf(C2037R.layout.adapter_chat_item_list));
            sKeys.put("layout/adapter_gallery_image_slider_0", Integer.valueOf(C2037R.layout.adapter_gallery_image_slider));
            sKeys.put("layout/adapter_history_0", Integer.valueOf(C2037R.layout.adapter_history));
            sKeys.put("layout/adapter_item_aution_all_0", Integer.valueOf(C2037R.layout.adapter_item_aution_all));
            sKeys.put("layout/adapter_item_filter_0", Integer.valueOf(C2037R.layout.adapter_item_filter));
            sKeys.put("layout/adapter_item_filter_aunctions_0", Integer.valueOf(C2037R.layout.adapter_item_filter_aunctions));
            sKeys.put("layout/adapter_item_my_ads_0", Integer.valueOf(C2037R.layout.adapter_item_my_ads));
            sKeys.put("layout/adapter_item_my_aunction_0", Integer.valueOf(C2037R.layout.adapter_item_my_aunction));
            sKeys.put("layout/adapter_item_my_bids_0", Integer.valueOf(C2037R.layout.adapter_item_my_bids));
            sKeys.put("layout/adapter_my_chat_0", Integer.valueOf(C2037R.layout.adapter_my_chat));
            sKeys.put("layout/adapter_myfav_0", Integer.valueOf(C2037R.layout.adapter_myfav));
            sKeys.put("layout/adapter_notification_0", Integer.valueOf(C2037R.layout.adapter_notification));
            sKeys.put("layout/adapter_sub_category_0", Integer.valueOf(C2037R.layout.adapter_sub_category));
            sKeys.put("layout/adapter_subscription_standard_0", Integer.valueOf(C2037R.layout.adapter_subscription_standard));
            sKeys.put("layout/adapter_supprt_0", Integer.valueOf(C2037R.layout.adapter_supprt));
            sKeys.put("layout/adapter_viewauntion_bid_0", Integer.valueOf(C2037R.layout.adapter_viewauntion_bid));
            sKeys.put("layout/adapter_won_bids_0", Integer.valueOf(C2037R.layout.adapter_won_bids));
            sKeys.put("layout/chat_bubble_left1_0", Integer.valueOf(C2037R.layout.chat_bubble_left1));
            sKeys.put("layout/chat_bubble_right_0", Integer.valueOf(C2037R.layout.chat_bubble_right));
            sKeys.put("layout/comment_0", Integer.valueOf(C2037R.layout.comment));
            sKeys.put("layout/fragment_browse_0", Integer.valueOf(C2037R.layout.fragment_browse));
            sKeys.put("layout/fragment_my_chat_0", Integer.valueOf(C2037R.layout.fragment_my_chat));
            sKeys.put("layout/fragment_notification_0", Integer.valueOf(C2037R.layout.fragment_notification));
            sKeys.put("layout/fragment_setting_0", Integer.valueOf(C2037R.layout.fragment_setting));
            sKeys.put("layout/fragment_subscription_0", Integer.valueOf(C2037R.layout.fragment_subscription));
            sKeys.put("layout/fregement_my_aunction_fav_0", Integer.valueOf(C2037R.layout.fregement_my_aunction_fav));
            sKeys.put("layout/fregment_my_ads_0", Integer.valueOf(C2037R.layout.fregment_my_ads));
            sKeys.put("layout/fregment_my_auction_0", Integer.valueOf(C2037R.layout.fregment_my_auction));
            sKeys.put("layout/fregment_my_aunction_aunctions_0", Integer.valueOf(C2037R.layout.fregment_my_aunction_aunctions));
            sKeys.put("layout/fregment_my_aunction_bids_0", Integer.valueOf(C2037R.layout.fregment_my_aunction_bids));
            sKeys.put("layout/fregment_subscription_history_0", Integer.valueOf(C2037R.layout.fregment_subscription_history));
            sKeys.put("layout/fregment_won_bids_0", Integer.valueOf(C2037R.layout.fregment_won_bids));
            sKeys.put("layout/item_post_aunction_0", Integer.valueOf(C2037R.layout.item_post_aunction));
        }
    }

    static {
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.actionbar_header_nav, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_add_bid, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_advertise_images, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_all_advertise, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_aution_all, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_aution_images, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_category_based_ads_auction, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_categorylist, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_chang_password, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_chatstalking, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_details_aution, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_dialogbox_forgetpassword, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_favoruite, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_filter, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_gallery, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_get_all_rating, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_main, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_my_bids, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_plans, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_post_auction, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_post_sub_aunction, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_profile, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_search, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_sign__up, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_sign_in, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_splash, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_subscription_package, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_support_acitivity, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_updateprofile, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_view_advertise, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_view_auction, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_view_bid_auntion, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_view_my_aunction, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.activity_view_profile, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_add_image, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_advertise, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_advertise_all, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_all_rating, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_auction, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_category, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_category_list, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_chat_item_list, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_gallery_image_slider, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_history, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_item_aution_all, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_item_filter, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_item_filter_aunctions, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_item_my_ads, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_item_my_aunction, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_item_my_bids, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_my_chat, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_myfav, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_notification, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_sub_category, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_subscription_standard, 55);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_supprt, 56);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_viewauntion_bid, 57);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.adapter_won_bids, 58);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.chat_bubble_left1, 59);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.chat_bubble_right, 60);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.comment, 61);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fragment_browse, 62);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fragment_my_chat, 63);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fragment_notification, 64);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fragment_setting, 65);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fragment_subscription, 66);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregement_my_aunction_fav, 67);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregment_my_ads, 68);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregment_my_auction, 69);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregment_my_aunction_aunctions, 70);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregment_my_aunction_bids, 71);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregment_subscription_history, 72);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.fregment_won_bids, 73);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2037R.layout.item_post_aunction, 74);
    }

    private final ViewDataBinding internalGetViewDataBinding0(androidx.databinding.DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/actionbar_header_nav_0".equals(obj)) {
                    return new ActionbarHeaderNavBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The tag for actionbar_header_nav is invalid. Received: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString());
            case 2:
                if ("layout/activity_add_bid_0".equals(obj)) {
                    return new ActivityAddBidBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The tag for activity_add_bid is invalid. Received: ");
                sb2.append(obj);
                throw new IllegalArgumentException(sb2.toString());
            case 3:
                if ("layout/activity_advertise_images_0".equals(obj)) {
                    return new ActivityAdvertiseImagesBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The tag for activity_advertise_images is invalid. Received: ");
                sb3.append(obj);
                throw new IllegalArgumentException(sb3.toString());
            case 4:
                if ("layout/activity_all_advertise_0".equals(obj)) {
                    return new ActivityAllAdvertiseBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("The tag for activity_all_advertise is invalid. Received: ");
                sb4.append(obj);
                throw new IllegalArgumentException(sb4.toString());
            case 5:
                if ("layout/activity_aution_all_0".equals(obj)) {
                    return new ActivityAutionAllBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("The tag for activity_aution_all is invalid. Received: ");
                sb5.append(obj);
                throw new IllegalArgumentException(sb5.toString());
            case 6:
                if ("layout/activity_aution_images_0".equals(obj)) {
                    return new ActivityAutionImagesBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("The tag for activity_aution_images is invalid. Received: ");
                sb6.append(obj);
                throw new IllegalArgumentException(sb6.toString());
            case 7:
                if ("layout/activity_category_based_ads_auction_0".equals(obj)) {
                    return new ActivityCategoryBasedAdsAuctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("The tag for activity_category_based_ads_auction is invalid. Received: ");
                sb7.append(obj);
                throw new IllegalArgumentException(sb7.toString());
            case 8:
                if ("layout/activity_categorylist_0".equals(obj)) {
                    return new ActivityCategorylistBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("The tag for activity_categorylist is invalid. Received: ");
                sb8.append(obj);
                throw new IllegalArgumentException(sb8.toString());
            case 9:
                if ("layout/activity_chang_password_0".equals(obj)) {
                    return new ActivityChangPasswordBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("The tag for activity_chang_password is invalid. Received: ");
                sb9.append(obj);
                throw new IllegalArgumentException(sb9.toString());
            case 10:
                if ("layout/activity_chatstalking_0".equals(obj)) {
                    return new ActivityChatstalkingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append("The tag for activity_chatstalking is invalid. Received: ");
                sb10.append(obj);
                throw new IllegalArgumentException(sb10.toString());
            case 11:
                if ("layout/activity_details_aution_0".equals(obj)) {
                    return new ActivityDetailsAutionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append("The tag for activity_details_aution is invalid. Received: ");
                sb11.append(obj);
                throw new IllegalArgumentException(sb11.toString());
            case 12:
                if ("layout/activity_dialogbox_forgetpassword_0".equals(obj)) {
                    return new ActivityDialogboxForgetpasswordBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append("The tag for activity_dialogbox_forgetpassword is invalid. Received: ");
                sb12.append(obj);
                throw new IllegalArgumentException(sb12.toString());
            case 13:
                if ("layout/activity_favoruite_0".equals(obj)) {
                    return new ActivityFavoruiteBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb13 = new StringBuilder();
                sb13.append("The tag for activity_favoruite is invalid. Received: ");
                sb13.append(obj);
                throw new IllegalArgumentException(sb13.toString());
            case 14:
                if ("layout/activity_filter_0".equals(obj)) {
                    return new ActivityFilterBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb14 = new StringBuilder();
                sb14.append("The tag for activity_filter is invalid. Received: ");
                sb14.append(obj);
                throw new IllegalArgumentException(sb14.toString());
            case 15:
                if ("layout/activity_gallery_0".equals(obj)) {
                    return new ActivityGalleryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb15 = new StringBuilder();
                sb15.append("The tag for activity_gallery is invalid. Received: ");
                sb15.append(obj);
                throw new IllegalArgumentException(sb15.toString());
            case 16:
                if ("layout/activity_get_all_rating_0".equals(obj)) {
                    return new ActivityGetAllRatingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb16 = new StringBuilder();
                sb16.append("The tag for activity_get_all_rating is invalid. Received: ");
                sb16.append(obj);
                throw new IllegalArgumentException(sb16.toString());
            case 17:
                if ("layout/activity_main_0".equals(obj)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb17 = new StringBuilder();
                sb17.append("The tag for activity_main is invalid. Received: ");
                sb17.append(obj);
                throw new IllegalArgumentException(sb17.toString());
            case 18:
                if ("layout/activity_my_bids_0".equals(obj)) {
                    return new ActivityMyBidsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb18 = new StringBuilder();
                sb18.append("The tag for activity_my_bids is invalid. Received: ");
                sb18.append(obj);
                throw new IllegalArgumentException(sb18.toString());
            case 19:
                if ("layout/activity_plans_0".equals(obj)) {
                    return new ActivityPlansBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb19 = new StringBuilder();
                sb19.append("The tag for activity_plans is invalid. Received: ");
                sb19.append(obj);
                throw new IllegalArgumentException(sb19.toString());
            case 20:
                if ("layout/activity_post_auction_0".equals(obj)) {
                    return new ActivityPostAuctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb20 = new StringBuilder();
                sb20.append("The tag for activity_post_auction is invalid. Received: ");
                sb20.append(obj);
                throw new IllegalArgumentException(sb20.toString());
            case 21:
                if ("layout/activity_post_sub_aunction_0".equals(obj)) {
                    return new ActivityPostSubAunctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb21 = new StringBuilder();
                sb21.append("The tag for activity_post_sub_aunction is invalid. Received: ");
                sb21.append(obj);
                throw new IllegalArgumentException(sb21.toString());
            case 22:
                if ("layout/activity_profile_0".equals(obj)) {
                    return new ActivityProfileBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb22 = new StringBuilder();
                sb22.append("The tag for activity_profile is invalid. Received: ");
                sb22.append(obj);
                throw new IllegalArgumentException(sb22.toString());
            case 23:
                if ("layout/activity_search_0".equals(obj)) {
                    return new ActivitySearchBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb23 = new StringBuilder();
                sb23.append("The tag for activity_search is invalid. Received: ");
                sb23.append(obj);
                throw new IllegalArgumentException(sb23.toString());
            case 24:
                if ("layout/activity_sign__up_0".equals(obj)) {
                    return new ActivitySignUpBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb24 = new StringBuilder();
                sb24.append("The tag for activity_sign__up is invalid. Received: ");
                sb24.append(obj);
                throw new IllegalArgumentException(sb24.toString());
            case 25:
                if ("layout/activity_sign_in_0".equals(obj)) {
                    return new ActivitySignInBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb25 = new StringBuilder();
                sb25.append("The tag for activity_sign_in is invalid. Received: ");
                sb25.append(obj);
                throw new IllegalArgumentException(sb25.toString());
            case 26:
                if ("layout/activity_splash_0".equals(obj)) {
                    return new ActivitySplashBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb26 = new StringBuilder();
                sb26.append("The tag for activity_splash is invalid. Received: ");
                sb26.append(obj);
                throw new IllegalArgumentException(sb26.toString());
            case 27:
                if ("layout/activity_subscription_package_0".equals(obj)) {
                    return new ActivitySubscriptionPackageBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb27 = new StringBuilder();
                sb27.append("The tag for activity_subscription_package is invalid. Received: ");
                sb27.append(obj);
                throw new IllegalArgumentException(sb27.toString());
            case 28:
                if ("layout/activity_support_acitivity_0".equals(obj)) {
                    return new ActivitySupportAcitivityBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb28 = new StringBuilder();
                sb28.append("The tag for activity_support_acitivity is invalid. Received: ");
                sb28.append(obj);
                throw new IllegalArgumentException(sb28.toString());
            case 29:
                if ("layout/activity_updateprofile_0".equals(obj)) {
                    return new ActivityUpdateprofileBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb29 = new StringBuilder();
                sb29.append("The tag for activity_updateprofile is invalid. Received: ");
                sb29.append(obj);
                throw new IllegalArgumentException(sb29.toString());
            case 30:
                if ("layout/activity_view_advertise_0".equals(obj)) {
                    return new ActivityViewAdvertiseBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb30 = new StringBuilder();
                sb30.append("The tag for activity_view_advertise is invalid. Received: ");
                sb30.append(obj);
                throw new IllegalArgumentException(sb30.toString());
            case 31:
                if ("layout/activity_view_auction_0".equals(obj)) {
                    return new ActivityViewAuctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb31 = new StringBuilder();
                sb31.append("The tag for activity_view_auction is invalid. Received: ");
                sb31.append(obj);
                throw new IllegalArgumentException(sb31.toString());
            case 32:
                if ("layout/activity_view_bid_auntion_0".equals(obj)) {
                    return new ActivityViewBidAuntionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb32 = new StringBuilder();
                sb32.append("The tag for activity_view_bid_auntion is invalid. Received: ");
                sb32.append(obj);
                throw new IllegalArgumentException(sb32.toString());
            case 33:
                if ("layout/activity_view_my_aunction_0".equals(obj)) {
                    return new ActivityViewMyAunctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb33 = new StringBuilder();
                sb33.append("The tag for activity_view_my_aunction is invalid. Received: ");
                sb33.append(obj);
                throw new IllegalArgumentException(sb33.toString());
            case 34:
                if ("layout/activity_view_profile_0".equals(obj)) {
                    return new ActivityViewProfileBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb34 = new StringBuilder();
                sb34.append("The tag for activity_view_profile is invalid. Received: ");
                sb34.append(obj);
                throw new IllegalArgumentException(sb34.toString());
            case 35:
                if ("layout/adapter_add_image_0".equals(obj)) {
                    return new AdapterAddImageBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb35 = new StringBuilder();
                sb35.append("The tag for adapter_add_image is invalid. Received: ");
                sb35.append(obj);
                throw new IllegalArgumentException(sb35.toString());
            case 36:
                if ("layout/adapter_advertise_0".equals(obj)) {
                    return new AdapterAdvertiseBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb36 = new StringBuilder();
                sb36.append("The tag for adapter_advertise is invalid. Received: ");
                sb36.append(obj);
                throw new IllegalArgumentException(sb36.toString());
            case 37:
                if ("layout/adapter_advertise_all_0".equals(obj)) {
                    return new AdapterAdvertiseAllBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb37 = new StringBuilder();
                sb37.append("The tag for adapter_advertise_all is invalid. Received: ");
                sb37.append(obj);
                throw new IllegalArgumentException(sb37.toString());
            case 38:
                if ("layout/adapter_all_rating_0".equals(obj)) {
                    return new AdapterAllRatingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb38 = new StringBuilder();
                sb38.append("The tag for adapter_all_rating is invalid. Received: ");
                sb38.append(obj);
                throw new IllegalArgumentException(sb38.toString());
            case 39:
                if ("layout/adapter_auction_0".equals(obj)) {
                    return new AdapterAuctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb39 = new StringBuilder();
                sb39.append("The tag for adapter_auction is invalid. Received: ");
                sb39.append(obj);
                throw new IllegalArgumentException(sb39.toString());
            case 40:
                if ("layout/adapter_category_0".equals(obj)) {
                    return new AdapterCategoryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb40 = new StringBuilder();
                sb40.append("The tag for adapter_category is invalid. Received: ");
                sb40.append(obj);
                throw new IllegalArgumentException(sb40.toString());
            case 41:
                if ("layout/adapter_category_list_0".equals(obj)) {
                    return new AdapterCategoryListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb41 = new StringBuilder();
                sb41.append("The tag for adapter_category_list is invalid. Received: ");
                sb41.append(obj);
                throw new IllegalArgumentException(sb41.toString());
            case 42:
                if ("layout/adapter_chat_item_list_0".equals(obj)) {
                    return new AdapterChatItemListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb42 = new StringBuilder();
                sb42.append("The tag for adapter_chat_item_list is invalid. Received: ");
                sb42.append(obj);
                throw new IllegalArgumentException(sb42.toString());
            case 43:
                if ("layout/adapter_gallery_image_slider_0".equals(obj)) {
                    return new AdapterGalleryImageSliderBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb43 = new StringBuilder();
                sb43.append("The tag for adapter_gallery_image_slider is invalid. Received: ");
                sb43.append(obj);
                throw new IllegalArgumentException(sb43.toString());
            case 44:
                if ("layout/adapter_history_0".equals(obj)) {
                    return new AdapterHistoryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb44 = new StringBuilder();
                sb44.append("The tag for adapter_history is invalid. Received: ");
                sb44.append(obj);
                throw new IllegalArgumentException(sb44.toString());
            case 45:
                if ("layout/adapter_item_aution_all_0".equals(obj)) {
                    return new AdapterItemAutionAllBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb45 = new StringBuilder();
                sb45.append("The tag for adapter_item_aution_all is invalid. Received: ");
                sb45.append(obj);
                throw new IllegalArgumentException(sb45.toString());
            case 46:
                if ("layout/adapter_item_filter_0".equals(obj)) {
                    return new AdapterItemFilterBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb46 = new StringBuilder();
                sb46.append("The tag for adapter_item_filter is invalid. Received: ");
                sb46.append(obj);
                throw new IllegalArgumentException(sb46.toString());
            case 47:
                if ("layout/adapter_item_filter_aunctions_0".equals(obj)) {
                    return new AdapterItemFilterAunctionsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb47 = new StringBuilder();
                sb47.append("The tag for adapter_item_filter_aunctions is invalid. Received: ");
                sb47.append(obj);
                throw new IllegalArgumentException(sb47.toString());
            case 48:
                if ("layout/adapter_item_my_ads_0".equals(obj)) {
                    return new AdapterItemMyAdsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb48 = new StringBuilder();
                sb48.append("The tag for adapter_item_my_ads is invalid. Received: ");
                sb48.append(obj);
                throw new IllegalArgumentException(sb48.toString());
            case 49:
                if ("layout/adapter_item_my_aunction_0".equals(obj)) {
                    return new AdapterItemMyAunctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb49 = new StringBuilder();
                sb49.append("The tag for adapter_item_my_aunction is invalid. Received: ");
                sb49.append(obj);
                throw new IllegalArgumentException(sb49.toString());
            case 50:
                if ("layout/adapter_item_my_bids_0".equals(obj)) {
                    return new AdapterItemMyBidsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb50 = new StringBuilder();
                sb50.append("The tag for adapter_item_my_bids is invalid. Received: ");
                sb50.append(obj);
                throw new IllegalArgumentException(sb50.toString());
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(androidx.databinding.DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/adapter_my_chat_0".equals(obj)) {
                    return new AdapterMyChatBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The tag for adapter_my_chat is invalid. Received: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString());
            case 52:
                if ("layout/adapter_myfav_0".equals(obj)) {
                    return new AdapterMyfavBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The tag for adapter_myfav is invalid. Received: ");
                sb2.append(obj);
                throw new IllegalArgumentException(sb2.toString());
            case 53:
                if ("layout/adapter_notification_0".equals(obj)) {
                    return new AdapterNotificationBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The tag for adapter_notification is invalid. Received: ");
                sb3.append(obj);
                throw new IllegalArgumentException(sb3.toString());
            case 54:
                if ("layout/adapter_sub_category_0".equals(obj)) {
                    return new AdapterSubCategoryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("The tag for adapter_sub_category is invalid. Received: ");
                sb4.append(obj);
                throw new IllegalArgumentException(sb4.toString());
            case 55:
                if ("layout/adapter_subscription_standard_0".equals(obj)) {
                    return new AdapterSubscriptionStandardBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("The tag for adapter_subscription_standard is invalid. Received: ");
                sb5.append(obj);
                throw new IllegalArgumentException(sb5.toString());
            case 56:
                if ("layout/adapter_supprt_0".equals(obj)) {
                    return new AdapterSupprtBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("The tag for adapter_supprt is invalid. Received: ");
                sb6.append(obj);
                throw new IllegalArgumentException(sb6.toString());
            case 57:
                if ("layout/adapter_viewauntion_bid_0".equals(obj)) {
                    return new AdapterViewauntionBidBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("The tag for adapter_viewauntion_bid is invalid. Received: ");
                sb7.append(obj);
                throw new IllegalArgumentException(sb7.toString());
            case 58:
                if ("layout/adapter_won_bids_0".equals(obj)) {
                    return new AdapterWonBidsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("The tag for adapter_won_bids is invalid. Received: ");
                sb8.append(obj);
                throw new IllegalArgumentException(sb8.toString());
            case 59:
                if ("layout/chat_bubble_left1_0".equals(obj)) {
                    return new ChatBubbleLeft1BindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("The tag for chat_bubble_left1 is invalid. Received: ");
                sb9.append(obj);
                throw new IllegalArgumentException(sb9.toString());
            case 60:
                if ("layout/chat_bubble_right_0".equals(obj)) {
                    return new ChatBubbleRightBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append("The tag for chat_bubble_right is invalid. Received: ");
                sb10.append(obj);
                throw new IllegalArgumentException(sb10.toString());
            case 61:
                if ("layout/comment_0".equals(obj)) {
                    return new CommentBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append("The tag for comment is invalid. Received: ");
                sb11.append(obj);
                throw new IllegalArgumentException(sb11.toString());
            case 62:
                if ("layout/fragment_browse_0".equals(obj)) {
                    return new FragmentBrowseBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append("The tag for fragment_browse is invalid. Received: ");
                sb12.append(obj);
                throw new IllegalArgumentException(sb12.toString());
            case 63:
                if ("layout/fragment_my_chat_0".equals(obj)) {
                    return new FragmentMyChatBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb13 = new StringBuilder();
                sb13.append("The tag for fragment_my_chat is invalid. Received: ");
                sb13.append(obj);
                throw new IllegalArgumentException(sb13.toString());
            case 64:
                if ("layout/fragment_notification_0".equals(obj)) {
                    return new FragmentNotificationBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb14 = new StringBuilder();
                sb14.append("The tag for fragment_notification is invalid. Received: ");
                sb14.append(obj);
                throw new IllegalArgumentException(sb14.toString());
            case 65:
                if ("layout/fragment_setting_0".equals(obj)) {
                    return new FragmentSettingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb15 = new StringBuilder();
                sb15.append("The tag for fragment_setting is invalid. Received: ");
                sb15.append(obj);
                throw new IllegalArgumentException(sb15.toString());
            case 66:
                if ("layout/fragment_subscription_0".equals(obj)) {
                    return new FragmentSubscriptionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb16 = new StringBuilder();
                sb16.append("The tag for fragment_subscription is invalid. Received: ");
                sb16.append(obj);
                throw new IllegalArgumentException(sb16.toString());
            case 67:
                if ("layout/fregement_my_aunction_fav_0".equals(obj)) {
                    return new FregementMyAunctionFavBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb17 = new StringBuilder();
                sb17.append("The tag for fregement_my_aunction_fav is invalid. Received: ");
                sb17.append(obj);
                throw new IllegalArgumentException(sb17.toString());
            case 68:
                if ("layout/fregment_my_ads_0".equals(obj)) {
                    return new FregmentMyAdsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb18 = new StringBuilder();
                sb18.append("The tag for fregment_my_ads is invalid. Received: ");
                sb18.append(obj);
                throw new IllegalArgumentException(sb18.toString());
            case 69:
                if ("layout/fregment_my_auction_0".equals(obj)) {
                    return new FregmentMyAuctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb19 = new StringBuilder();
                sb19.append("The tag for fregment_my_auction is invalid. Received: ");
                sb19.append(obj);
                throw new IllegalArgumentException(sb19.toString());
            case 70:
                if ("layout/fregment_my_aunction_aunctions_0".equals(obj)) {
                    return new FregmentMyAunctionAunctionsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb20 = new StringBuilder();
                sb20.append("The tag for fregment_my_aunction_aunctions is invalid. Received: ");
                sb20.append(obj);
                throw new IllegalArgumentException(sb20.toString());
            case 71:
                if ("layout/fregment_my_aunction_bids_0".equals(obj)) {
                    return new FregmentMyAunctionBidsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb21 = new StringBuilder();
                sb21.append("The tag for fregment_my_aunction_bids is invalid. Received: ");
                sb21.append(obj);
                throw new IllegalArgumentException(sb21.toString());
            case 72:
                if ("layout/fregment_subscription_history_0".equals(obj)) {
                    return new FregmentSubscriptionHistoryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb22 = new StringBuilder();
                sb22.append("The tag for fregment_subscription_history is invalid. Received: ");
                sb22.append(obj);
                throw new IllegalArgumentException(sb22.toString());
            case 73:
                if ("layout/fregment_won_bids_0".equals(obj)) {
                    return new FregmentWonBidsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb23 = new StringBuilder();
                sb23.append("The tag for fregment_won_bids is invalid. Received: ");
                sb23.append(obj);
                throw new IllegalArgumentException(sb23.toString());
            case 74:
                if ("layout/item_post_aunction_0".equals(obj)) {
                    return new ItemPostAunctionBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb24 = new StringBuilder();
                sb24.append("The tag for item_post_aunction is invalid. Received: ");
                sb24.append(obj);
                throw new IllegalArgumentException(sb24.toString());
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i3 = (i2 - 1) / 50;
                if (i3 == 0) {
                    return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
                }
                if (i3 == 1) {
                    return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
                }
            } else {
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
    }

    public ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        Integer num = (Integer) InnerLayoutIdLookup.sKeys.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }

    public String convertBrIdToString(int i) {
        return (String) InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
//        arrayList.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }
}
