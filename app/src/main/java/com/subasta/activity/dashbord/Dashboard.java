package com.subasta.activity.dashbord;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.cocosw.bottomsheet.BottomSheet.Builder;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.subasta.BuildConfig;
import com.subasta.C2037R;
import com.subasta.activity.FilterActivity;
import com.subasta.activity.SearchActivity;
import com.subasta.activity.authentication.Sign_in;
import com.subasta.activity.authentication.UpdateProfile;
import com.subasta.activity.social.AllSubscriptionHistory;
import com.subasta.adapter.MyChatsAdapter;
import com.subasta.fragment.dashboad.Ads;
import com.subasta.fragment.dashboad.Browse;
import com.subasta.fragment.dashboad.MyAutions;
import com.subasta.fragment.dashboad.MyChat;
import com.subasta.fragment.dashboad.Notification;
import com.subasta.fragment.dashboad.Setting;
import com.subasta.fragment.dashboad.Subscription;
import com.subasta.interfaces.Const;
import com.subasta.model.UserDTO;
import com.subasta.preferences.SharedPrefrence;
import com.subasta.utils.CustomTypeFaceSpan;
import com.subasta.utils.ProjectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Dashboard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static String CURRENT_TAG = "browse";
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;
    private static final String KEY_LOCATION = "location";
    private static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting-location-updates";
    private static final int REQUEST_CHECK_SETTINGS = 1;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    /* access modifiers changed from: private */
    public static final String TAG = "Dashboard";
    private static final String TAG_BROWSE = "browse";
    private static final String TAG_CHATS = "chats";
    private static final String TAG_LOGOUT = "logout";
    private static final String TAG_MYADS = "myads";
    private static final String TAG_MYAUCTION = "myauction";
    private static final String TAG_NOTIFICATION = "notification";
    private static final String TAG_SETTING = "SETTING";
    private static final String TAG_SUBCRIPTION = "subcription";
    private static final String TAG_SUBSCRIPTION = "subscription";
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    public static int navItemIndex;
    private View actionheaderbar;
    private Layout app_bar;
    Builder builder;
    AlertDialog.Builder builder1;
    Button closeButton;
    private DrawerLayout drawer;
    private View heder;
    private ImageView history;
    private ImageView ivBack;
    private ImageView ivDasBack1;
    private ImageView ivDash;
    private ImageView ivFilter;
    private ImageView ivHistory;
    private ImageView ivMenu;
    private ImageView ivProfilpic;
    private ImageView ivSearch;
    /* access modifiers changed from: private */
    public Location mCurrentLocation;
    /* access modifiers changed from: private */
//    public FusedLocationProviderClient mFusedLocationClient;
    private Handler mHandler;
    /* access modifiers changed from: private */
//    public LocationCallback mLocationCallback;
    /* access modifiers changed from: private */
//    public LocationRequest mLocationRequest;
//    private LocationSettingsRequest mLocationSettingsRequest;
    /* access modifiers changed from: private */
    public Boolean mRequestingLocationUpdates;
//    private SettingsClient mSettingsClient;
    private MyChatsAdapter myChatsAdapter;
    private View navHeader;
    private NavigationView navigationView;
    private HashMap<String, File> paramsFile = new HashMap<>();
    SharedPrefrence sharedPrefrence;
    private boolean shouldLoadHomeFragOnBackPress = true;
    private TextView subscribe;
    private SearchView svHistory;
    private TextView tvtitilemain;
    private TextView tvtitle;
    private TextView tvusername;
    private TextView unsubscribe;
    private UserDTO userDTO;
    private TextView userName;

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2037R.layout.activity_dashboard);
        this.sharedPrefrence = SharedPrefrence.getInstance(this);
//        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        this.mHandler = new Handler();
        this.drawer = (DrawerLayout) findViewById(C2037R.C2039id.drawer_layout);
        this.navigationView = (NavigationView) findViewById(C2037R.C2039id.nav_view);
        this.navHeader = this.navigationView.getHeaderView(0);
        this.ivMenu = (ImageView) findViewById(C2037R.C2039id.ivMenu);
        this.ivFilter = (ImageView) findViewById(C2037R.C2039id.ivFilter);
        this.ivSearch = (ImageView) findViewById(C2037R.C2039id.ivSearch1);
        this.ivDash = (ImageView) findViewById(C2037R.C2039id.ivDasBack1);
        this.tvusername = (TextView) this.navHeader.findViewById(C2037R.C2039id.usrename);
        this.ivDasBack1 = (ImageView) this.navHeader.findViewById(C2037R.C2039id.ivDasBack1);
        this.actionheaderbar = findViewById(C2037R.C2039id.appbar);
        this.heder = this.actionheaderbar.findViewById(C2037R.C2039id.action_bar);
        this.tvtitilemain = (TextView) findViewById(C2037R.C2039id.tvtitlemain);
        this.ivProfilpic = (ImageView) this.navHeader.findViewById(C2037R.C2039id.imageView);
        this.subscribe = (TextView) this.navHeader.findViewById(C2037R.C2039id.subscribe);
        this.unsubscribe = (TextView) this.navHeader.findViewById(C2037R.C2039id.unsubscribe);
        this.userName = (TextView) this.navHeader.findViewById(C2037R.C2039id.usrename);
        this.ivBack = (ImageView) findViewById(C2037R.C2039id.ivBack);
        this.ivHistory = (ImageView) findViewById(C2037R.C2039id.ivHistory);
        this.builder1 = new AlertDialog.Builder(this);
        new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{-1, SupportMenu.CATEGORY_MASK});
        setUpNavigationView();
        if (getIntent() != null) {
            navItemIndex = getIntent().getIntExtra("index", 0);
            getHeaderName();
            loadHomeFragment();
        }
        this.ivDasBack1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.onBackPressed();
            }
        });
        this.ivMenu.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.drawerOpen();
            }
        });
        this.ivFilter.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.startActivity(new Intent(Dashboard.this, FilterActivity.class));
            }
        });
        this.ivSearch.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.startActivity(new Intent(Dashboard.this, SearchActivity.class));
            }
        });
        this.ivHistory.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.startActivity(new Intent(Dashboard.this, AllSubscriptionHistory.class));
            }
        });
        this.ivProfilpic.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.startActivity(new Intent(Dashboard.this, UpdateProfile.class));
            }
        });
        this.ivBack.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Dashboard.this.onBackPressed();
            }
        });
        this.mRequestingLocationUpdates = Boolean.valueOf(false);
        updateValuesFromBundle(bundle);
        Menu menu = this.navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SubMenu subMenu = item.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int i2 = 0; i2 < subMenu.size(); i2++) {
                    applyFontToMenuItem(subMenu.getItem(i2));
                }
            }
            applyFontToMenuItem(item);
        }
    }

    public void getHeaderName() {
        int i = navItemIndex;
        if (i == 0) {
            CURRENT_TAG = TAG_BROWSE;
        } else if (i == 1) {
            CURRENT_TAG = TAG_CHATS;
        } else if (i == 2) {
            CURRENT_TAG = TAG_MYADS;
        } else if (i == 3) {
            CURRENT_TAG = TAG_MYAUCTION;
        } else if (i == 4) {
            CURRENT_TAG = TAG_NOTIFICATION;
        } else if (i == 5) {
            CURRENT_TAG = TAG_SUBSCRIPTION;
        } else if (i == 6) {
            CURRENT_TAG = TAG_SETTING;
        }
    }

    public void drawerOpen() {
        if (this.drawer.isDrawerOpen((int) GravityCompat.START)) {
            this.drawer.closeDrawer((int) GravityCompat.START);
        } else {
            this.drawer.openDrawer((int) GravityCompat.START);
        }
    }

    /* access modifiers changed from: private */
    public void loadHomeFragment() {
        selectNavMenu();
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            this.drawer.closeDrawers();
            return;
        }
        this.mHandler.post(new Runnable() {
            @SuppressLint("ResourceType")
            public void run() {
                Fragment access$000 = Dashboard.this.getHomeFragment();
                FragmentTransaction beginTransaction = Dashboard.this.getSupportFragmentManager().beginTransaction();
                beginTransaction.setCustomAnimations(17432576, 17432577);
                beginTransaction.replace(C2037R.C2039id.frame, access$000, Dashboard.CURRENT_TAG);
                beginTransaction.commitAllowingStateLoss();
            }
        });
        this.drawer.closeDrawers();
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: private */
    @SuppressLint("WrongConstant")
    public Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                this.ivBack.setVisibility(8);
                this.ivSearch.setVisibility(0);
                this.ivFilter.setVisibility(0);
                this.ivMenu.setVisibility(0);
                this.ivHistory.setVisibility(8);
                this.tvtitilemain.setVisibility(0);
                this.tvtitilemain.setText("Browse");
                return new Browse();
            case 1:
                this.ivSearch.setVisibility(8);
                this.ivFilter.setVisibility(8);
                this.tvtitilemain.setVisibility(0);
                this.ivHistory.setVisibility(8);
                this.tvtitilemain.setText("Chat");
                return new MyChat();
            case 2:
                this.ivSearch.setVisibility(8);
                this.ivFilter.setVisibility(8);
                this.ivHistory.setVisibility(8);
                this.tvtitilemain.setText("My ads");
                return new Ads();
            case 3:
                this.tvtitilemain.setText("My aunctions");
                this.ivSearch.setVisibility(8);
                this.ivFilter.setVisibility(8);
                this.ivHistory.setVisibility(8);
                this.tvtitilemain.setVisibility(0);
                this.tvtitilemain.setText("Aunctions");
                return new MyAutions();
            case 4:
                this.ivSearch.setVisibility(8);
                this.ivFilter.setVisibility(8);
                this.tvtitilemain.setVisibility(0);
                this.ivHistory.setVisibility(8);
                this.tvtitilemain.setText("Notification");
                return new Notification();
            case 5:
                this.ivSearch.setVisibility(8);
                this.ivFilter.setVisibility(8);
                this.ivBack.setVisibility(0);
                this.ivMenu.setVisibility(8);
                this.tvtitilemain.setVisibility(0);
                this.ivHistory.setVisibility(0);
                this.tvtitilemain.setText("Subscription");
                return new Subscription();
            case 6:
                this.ivSearch.setVisibility(8);
                this.ivFilter.setVisibility(8);
                this.ivMenu.setVisibility(8);
                this.ivBack.setVisibility(0);
                this.ivHistory.setVisibility(8);
                this.tvtitilemain.setVisibility(0);
                this.tvtitilemain.setText("Settings");
                return new Setting();
            default:
                return new Browse();
        }
    }

    private void selectNavMenu() {
        this.navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        this.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId != C2037R.C2039id.ivDasBack1) {
                    switch (itemId) {
                        case C2037R.C2039id.nav_browse /*2131362240*/:
                            Dashboard.navItemIndex = 0;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_BROWSE;
                            break;
                        case C2037R.C2039id.nav_chats /*2131362241*/:
                            Dashboard.navItemIndex = 1;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_CHATS;
                            break;
                        case C2037R.C2039id.nav_logout /*2131362242*/:
                            Dashboard.this.logout();
                            break;
                        case C2037R.C2039id.nav_myads /*2131362243*/:
                            Dashboard.navItemIndex = 2;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_MYADS;
                            break;
                        case C2037R.C2039id.nav_myauction /*2131362244*/:
                            Dashboard.navItemIndex = 3;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_MYAUCTION;
                            break;
                        case C2037R.C2039id.nav_notification /*2131362245*/:
                            Dashboard.navItemIndex = 4;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_NOTIFICATION;
                            break;
                        case C2037R.C2039id.nav_setting /*2131362246*/:
                            Dashboard.navItemIndex = 6;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_SETTING;
                            break;
                        case C2037R.C2039id.nav_subcription /*2131362247*/:
                            Dashboard.navItemIndex = 5;
                            Dashboard.CURRENT_TAG = Dashboard.TAG_SUBSCRIPTION;
                            break;
                    }
                } else {
                    Dashboard.this.onBackPressed();
                }
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                Dashboard.this.loadHomeFragment();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void logout() {
        this.builder1.setMessage((int) C2037R.string.dialog_message).setTitle((int) C2037R.string.dialog_title);
        String str = "No";
        this.builder1.setMessage((CharSequence) "Do you want to close this application ?").setCancelable(false).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(DialogInterface dialogInterface, int i) {
                Dashboard.this.sharedPrefrence.clearAllPreferences();
                Intent intent = new Intent(Dashboard.this, Sign_in.class);
                intent.addFlags(32768);
                intent.addFlags(67108864);
                intent.addFlags(268435456);
                Dashboard.this.startActivity(intent);
            }
        }).setNegativeButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog create = this.builder1.create();
        create.setTitle(Const.APP_NAME);
        create.setIcon((int) C2037R.C2038drawable.ic_logout1);
        create.show();
    }

    public void onBackPressed() {
        if (this.drawer.isDrawerOpen((int) GravityCompat.START)) {
            this.drawer.closeDrawers();
        } else if (!this.shouldLoadHomeFragOnBackPress || navItemIndex == 0) {
            super.onBackPressed();
        } else {
            navItemIndex = 0;
            CURRENT_TAG = TAG_BROWSE;
            loadHomeFragment();
        }
    }

    private void applyFontToMenuItem(MenuItem menuItem) {
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "Montserrat-SemiBold.otf");
        SpannableString spannableString = new SpannableString(menuItem.getTitle());
        spannableString.setSpan(new CustomTypeFaceSpan("", createFromAsset), 0, spannableString.length(), 18);
        menuItem.setTitle(spannableString);
    }

    private void updateValuesFromBundle(Bundle bundle) {
        if (bundle != null) {
            Set keySet = bundle.keySet();
            String str = KEY_REQUESTING_LOCATION_UPDATES;
            if (keySet.contains(str)) {
                this.mRequestingLocationUpdates = Boolean.valueOf(bundle.getBoolean(str));
            }
            String str2 = "location";
            if (bundle.keySet().contains(str2)) {
                this.mCurrentLocation = (Location) bundle.getParcelable(str2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                Log.i(TAG, "User agreed to make required location settings changes.");
            } else if (i2 == 0) {
                Log.i(TAG, "User chose not to make required location settings changes.");
                this.mRequestingLocationUpdates = Boolean.valueOf(false);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.mRequestingLocationUpdates = Boolean.valueOf(true);

//        this.userDTO = this.sharedPrefrence.getParentUser(Const.USER_DTO);
        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(this.userDTO.getImage()).centerCrop()).placeholder((int) C2037R.C2038drawable.noimage)).into(this.ivProfilpic);
        this.userName.setText(ProjectUtils.capWordFirstLetter(this.userDTO.getName()));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_REQUESTING_LOCATION_UPDATES, this.mRequestingLocationUpdates.booleanValue());
        bundle.putParcelable("location", this.mCurrentLocation);
        super.onSaveInstanceState(bundle);
    }

    @SuppressLint("ResourceType")
    private void showSnackbar(int i, int i2, OnClickListener onClickListener) {
        Snackbar.make(findViewById(16908290), (CharSequence) getString(i), -2).setAction((CharSequence) getString(i2), onClickListener).show();
    }

    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private void requestPermissions() {
        String str = "android.permission.ACCESS_FINE_LOCATION";
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
            Log.i(TAG, "Displaying permission rationale to provide additional context.");
            showSnackbar(C2037R.string.permission_rationale, 17039370, new OnClickListener() {
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(Dashboard.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 34);
                }
            });
            return;
        }
        Log.i(TAG, "Requesting permission");
        ActivityCompat.requestPermissions(this, new String[]{str}, 34);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Log.i(TAG, "onRequestPermissionResult");
        if (i != 34) {
            return;
        }
        if (iArr.length <= 0) {
            Log.i(TAG, "User interaction was cancelled.");
        } else if (iArr[0] != 0) {
            showSnackbar(C2037R.string.permission_denied_explanation, C2037R.string.settings, new OnClickListener() {
                @SuppressLint("WrongConstant")
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
                    intent.setFlags(268435456);
                    Dashboard.this.startActivity(intent);
                }
            });
        } else if (this.mRequestingLocationUpdates.booleanValue()) {
            Log.i(TAG, "Permission granted, updates requested, starting location updates");
        }
    }
}
