package com.moovers.storemanager.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moovers.storemanager.R;
import com.moovers.storemanager.fragments.MyProductFragment;
import com.moovers.storemanager.fragments.OrderListFragment;
import com.moovers.storemanager.fragments.PastOrderFragment;
import com.moovers.storemanager.fragments.ProfileFragment;
import com.moovers.storemanager.fragments.ReportsFragment;
import com.moovers.storemanager.fragments.SettingFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private RelativeLayout rlHeader;
    private DrawerLayout drawer;
    private TextView txtMyOrder, txtMyProduct, txtReports, txtProfile, txtSettings, txtLogout;
    public ImageView imgMenu, imgAddProduct, imgCalender, imgBack;
    public RelativeLayout rlNotification;
    public TextView txtTitle, txtSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initComponents() {
        rlHeader = findViewById(R.id.rlHeader);
        txtMyOrder = findViewById(R.id.txtMyOrder);
        txtMyProduct = findViewById(R.id.txtMyProduct);
        txtProfile = findViewById(R.id.txtProfile);
        txtReports = findViewById(R.id.txtReports);
        txtSettings = findViewById(R.id.txtSettings);
        txtLogout = findViewById(R.id.txtLogout);
        imgMenu = findViewById(R.id.imgMenu);
        imgAddProduct = findViewById(R.id.imgAddProduct);
        imgCalender = findViewById(R.id.imgCalender);
        imgBack = findViewById(R.id.imgBack);
        txtTitle = findViewById(R.id.txtTitle);
        txtSubTitle = findViewById(R.id.txtSubTitle);
        rlNotification = findViewById(R.id.rlNotification);
//        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        OrderListFragment orderListFragment = new OrderListFragment();
        replaceFragmenr(orderListFragment, orderListFragment.getTag(), false);
        rlHeader.setOnClickListener(view -> {
            closeDrawer();
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                int count = fragmentManager.getBackStackEntryCount();
                if (count > 1) {
                    fragmentManager.popBackStackImmediate();
                }
            }
        });
        imgMenu.setOnClickListener(view -> {
            drawer.openDrawer(Gravity.START);
        });

        txtMyOrder.setOnClickListener(view -> {
            closeDrawer();
            replaceFragmenr(orderListFragment, orderListFragment.getTag(), false);
        });
        txtMyProduct.setOnClickListener(view -> {
            closeDrawer();
            MyProductFragment myProductFragment = new MyProductFragment();
            replaceFragmenr(myProductFragment, myProductFragment.getTag(), false);
        });
        txtReports.setOnClickListener(view -> {
            closeDrawer();
            ReportsFragment reportsFragment = new ReportsFragment();
            replaceFragmenr(reportsFragment, reportsFragment.getTag(), false);
        });

        txtProfile.setOnClickListener(view -> {
            closeDrawer();
           /* ProfileFragment profileFragment = new ProfileFragment();
            replaceFragmenr(profileFragment, profileFragment.getTag(), false);*/
            PastOrderFragment pastOrderFragment = new PastOrderFragment();
            replaceFragmenr(pastOrderFragment, pastOrderFragment.getTag(), false);
        });
        txtSettings.setOnClickListener(view -> {
            closeDrawer();
            SettingFragment settingFragment = new SettingFragment();
            replaceFragmenr(settingFragment, settingFragment.getTag(), false);
        });

        txtLogout.setOnClickListener(view -> {
            closeDrawer();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); //slide_in_right
                }
            }, 200);
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
            FragmentManager fragmentManager = getSupportFragmentManager();
            int count = fragmentManager.getBackStackEntryCount();
            if (count > 1) {
                fragmentManager.popBackStackImmediate();
            } else {
                finish();
            }
        }

    }


    private void closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_order) {
            Toast.makeText(this, "nav menu", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_product) {
            MyProductFragment myProductFragment = new MyProductFragment();
            replaceFragmenr(myProductFragment, myProductFragment.getTag(), false);
        } else if (id == R.id.nav_reports) {
            Toast.makeText(this, "nav reports", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_profile) {
            Toast.makeText(this, "nav profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_setting) {
            Toast.makeText(this, "nav setting", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "nav logout", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
