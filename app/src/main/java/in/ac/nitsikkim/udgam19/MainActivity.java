package in.ac.nitsikkim.udgam19;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private EventFragment eventFragment;
    private HomeFragment homeFragment;
    private GalleryFragment galleryFragment;
    private NotificationFragment notificationFragment;
    private GuestFragment guestFragment;
    private Toolbar toolbar;
    private CircleImageView profile;
    private boolean rotate = false;
    private FloatingActionButton fab;

    private LinearLayout layoutInsta;
    private LinearLayout layoutFb;
    private LinearLayout layoutYoutube;
    private LinearLayout layoutWeb;
    private Animation fabOpen, fabClose, fabRotateForward, fabRotateBackward;
    private static String link;
    GoogleApiClient googleApiClient;
    public static Activity ma;


    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);
        homeFragment = new HomeFragment();
        eventFragment = new EventFragment();
        galleryFragment = new GalleryFragment();
        guestFragment = new GuestFragment();
        notificationFragment = new NotificationFragment();
        profile = findViewById(R.id.profile_button);
        ma=this;



        setSupportActionBar(toolbar);
        initDrawer();
        bottomNavigationViewListener();
        setFragment(homeFragment,"home");
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String photo = intent.getStringExtra("photo");



        final ProfileFragment profileFragment = new ProfileFragment(name,email,photo);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileFragment.show(getSupportFragmentManager(),"profile");
            }
        });

    }




    private void initDrawer() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void bottomNavigationViewListener(){

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.bottom_nav_home :
                        setFragment(homeFragment,"home");
                        return true;
                    case R.id.bottom_nav_events :
                        setFragment(eventFragment,"event");
                        return true;
                    case R.id.bottom_nav_gallery :
                        setFragment(galleryFragment,"gallery");
                        return true;
                    case R.id.bottom_nav_guests :
                        setFragment(guestFragment,"guest");
                        return true;
                    case R.id.bottom_nav_notification :
                        setFragment(notificationFragment,"notification");
                        return true;
                    default :
                        return false;

                }

            }
        });

    }

    private void setFragment(Fragment fragment, String tag){

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main,fragment,tag);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int selectedItemId = bottomNavigationView.getSelectedItemId();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if(selectedItemId != R.id.bottom_nav_home){
            bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
            setFragment(homeFragment,"home");
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout_main);
        int id = item.getItemId();

        if (id == R.id.nav_about_udgam) {

            Toast.makeText(this,"Udgam 2019",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,AboutUdgamActivity.class));


        } else if (id == R.id.nav_sponsors) {
            Toast.makeText(this, "Working", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,SponsorsActivity.class));

        } else if (id == R.id.nav_developers) {
            Intent intent = new Intent(this,DevelopersActivity.class);
            startActivity(intent);
        } else if (id == R.id.report_bug) {

            showBugDialog();

        } else if (id == R.id.nav_exit) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showBugDialog() {

        final Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bug_report_dialog);
        dialog.setCancelable(true);
        WindowManager.LayoutParams wm = new WindowManager.LayoutParams();

        ImageButton attachFile = dialog.findViewById(R.id.report_bug_attachment);
        final ImageButton report = dialog.findViewById(R.id.report_bug_send);
        report.setEnabled(false);

        try {
            wm.copyFrom(dialog.getWindow().getAttributes());
            wm.width = WindowManager.LayoutParams.MATCH_PARENT;
            wm.height = WindowManager.LayoutParams.MATCH_PARENT;

        }catch(NullPointerException e){
            System.out.println(e.toString());
            Toast.makeText(this,"Null Pointer Exception",Toast.LENGTH_LONG).show();
        }



        ((EditText) dialog.findViewById(R.id.report_bug_edit_text)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                report.setEnabled(!s.toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        attachFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Snackbar.make(v.getRootView(),R.string.feedback_sent,Snackbar.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(wm);
    }








}
