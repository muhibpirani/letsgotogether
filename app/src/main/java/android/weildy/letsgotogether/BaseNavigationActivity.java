package android.weildy.letsgotogether;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.weildy.letsgotogether.activity.CartActivity;
import android.weildy.letsgotogether.activity.NotificationActivity;
import android.weildy.letsgotogether.activity.RegisterActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Muhib.Pirani on 20/02/17.
 */
@SuppressWarnings("RestrictedApi")
public abstract class BaseNavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    FrameLayout lay_container;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView toolbarTitle;
    LinearLayout containerWithToolbar;
    private View activityBaseView;
    private MenuInflater inflater;
    private float lastScale = 1.0f;
    private boolean haveToSetContentView;
    private ActionBarDrawerToggle mDrawerToggle;
    Context context;

    protected void haveToSetContentView(boolean haveToSetContentView) {
        this.haveToSetContentView = haveToSetContentView;
    }

    protected abstract int getLayoutResourceId();

    protected abstract boolean useNavDrawer();

    protected abstract int getMenuLayout();

    protected abstract int getHeaderLayout();

    protected abstract void initialization(Bundle savedInstancestate);

    protected abstract String toolBarTitle();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        if (!haveToSetContentView)
            setContentView(getLayoutResourceId());

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                float moveFactor = navigationView.getWidth() * slideOffset;
                float min = 0.8f;
                float max = 1.0f;
                float scaleFactor = (max - ((max - min) * slideOffset));
                containerWithToolbar.setTranslationX(moveFactor);
                containerWithToolbar.setScaleX(scaleFactor);
                containerWithToolbar.setScaleY(scaleFactor);
                mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
            }


            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }

        });

        initialization(savedInstanceState);
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mDrawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        lay_container = (FrameLayout) mDrawerLayout.findViewById(R.id.lay_container);
        mDrawerLayout = (DrawerLayout) mDrawerLayout.findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) mDrawerLayout.findViewById(R.id.toolBar);
        containerWithToolbar = (LinearLayout) mDrawerLayout.findViewById(R.id.container_withToolbar);

        toolbarTitle = (TextView) mDrawerLayout.findViewById(R.id.toolBar_title);
        // listen for navigation events
        navigationView = (NavigationView) mDrawerLayout.findViewById(R.id.navigation);

        if (getHeaderLayout() == 0) {
            View header = getLayoutInflater().inflate(R.layout.drawer_header, null);
            ImageView profileIcon = (ImageView) header.findViewById(R.id.img_profile);
            TextView userName = (TextView) header.findViewById(R.id.txt_user_name);
            userName.setText("Username");
            navigationView.addHeaderView(header);
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            header.getLayoutParams().width = RelativeLayout.LayoutParams.MATCH_PARENT;
            //header.getLayoutParams().height=RelativeLayout.LayoutParams.WRAP_CONTENT;
            header.getLayoutParams().height = (int) (dm.density * 200);
        } else {
            View header1 = getLayoutInflater().inflate(getHeaderLayout(), null);
            navigationView.addHeaderView(header1);
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            header1.getLayoutParams().width = RelativeLayout.LayoutParams.MATCH_PARENT;
            header1.getLayoutParams().height = (int) (dm.density * 200);
        }

        navigationView.setItemIconTintList(null); //to remove tint from navigation view icon
        //getLayoutInflater().inflate(layoutResID, lay_container, true);
        activityBaseView = getLayoutInflater().inflate(layoutResID, null);
        lay_container.addView(activityBaseView);
        super.setContentView(mDrawerLayout);


        if (useToolbar()) {
            setToolBar(toolbar,/*, toolbarTitle, (String)getTitle()*/toolBarTitle());
        } else {
        }

        navigationView.setNavigationItemSelectedListener(this);

        if (!useNavDrawer()) {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
        if (getMenuLayout() != 0) {
            navigationView.getMenu().clear();
            navigationView.inflateMenu(getMenuLayout());
        } else {
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.menu);
        }

    }


    protected void setToolBar(Toolbar toolbar/*, TextView toolbarTitle, String title*/, String title) {
        this.toolbar = toolbar;
        toolbarTitle.setText(title);
        toolbar.setTitle("");
        /*toolbarTitle.setText(title);*/
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (getSupportParentActivityIntent() != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);

            } else {
                actionBar.setDisplayShowHomeEnabled(true);


            }
        }
        setUpNavigationDrawer();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (item.getItemId()) {

                    case R.id.logout:
                        //clearAllPreferences();
                        break;
                    case R.id.cart:
                        Intent intent1 = new Intent(context, CartActivity.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.notification:
                        Intent intent2 = new Intent(context, NotificationActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.register:
                        Intent intent3 = new Intent(context, RegisterActivity.class);
                        context.startActivity(intent3);
                        break;
                }
            }
        }, 500);
        return false;
    }


    /**
     * method used to display toolbar
     * override method and pass false to hide toolbar
     *
     * @return
     */

    protected boolean useToolbar() {
        return true;
    }

    private void setUpNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(this);
        // select the correct nav menu item
        //navigationView.getMenu().findItem(mNavItemId).setChecked(true);
        // set up the hamburger icon to open and close the drawer
        mDrawerToggle = new ActionBarDrawerToggle(BaseNavigationActivity.this, mDrawerLayout, toolbar, R.string.open,
                R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true); // to display back icon instead of hamburger icon
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void disableDrawerToggle() {
        mDrawerToggle.setDrawerIndicatorEnabled(false);

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT))
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        else
            super.onBackPressed();
    }
}
