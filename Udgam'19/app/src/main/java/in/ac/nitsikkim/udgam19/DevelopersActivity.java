package in.ac.nitsikkim.udgam19;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class DevelopersActivity extends AppCompatActivity {

    ArrayList<DeveloperItem> developers;
    static BottomSheetBehavior bottomSheetBehavior;
    private static View backDrop;
    private TextView name;
    private TextView designation;
    private TextView other;
    private TextView description;
    private ImageButton call;
    private ImageButton mail;
    private ImageButton linkedIn;
    private ImageButton gitHub;
    private ImageButton fb;
    private static boolean bottomSheetOpen;
    public ImageButton clearButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        initBottomSheet();

        RecyclerView mRecyclerView;
        DeveloperAdapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        CoordinatorLayout developerLayout = findViewById(R.id.developer_activity_layout);

        developers = new ArrayList<>();

        developersList();
        clearButton();

        mRecyclerView = findViewById(R.id.developers_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,2);
        mAdapter = new DeveloperAdapter(developers);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Snackbar.make(developerLayout,"Click on card for more",Snackbar.LENGTH_LONG).show();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    private void clearButton() {
        clearButton = findViewById(R.id.developer_description_clear);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet(-1);
            }
        });
    }

    private void initBottomSheet() {

        final View bottomSheet = findViewById(R.id.developer_description);

        name = findViewById(R.id.developer_description_name);
        designation = findViewById(R.id.developer_description_designation);
        CircleImageView desProfileImage = findViewById(R.id.developer_description_image);

        call = findViewById(R.id.developer_description_call);
        mail = findViewById(R.id.developer_description_mail);
        linkedIn = findViewById(R.id.developer_description_linkedin);
        gitHub = findViewById(R.id.developer_description_git_hub);
        fb = findViewById(R.id.developer_description_fb);
        description = findViewById(R.id.developer_description_des);
        other = findViewById(R.id.developer_description_other);

        backDrop = findViewById(R.id.back_drop);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        backDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet(-1);
            }
        });


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if(i == BottomSheetBehavior.STATE_HIDDEN){
                    backDrop.setVisibility(View.GONE);
                    backDrop.setClickable(false);
                    bottomSheetOpen = false;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    public static void toggleBottomSheet(int position){

        switch(position){

        }

        if(bottomSheetOpen){
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            backDrop.setVisibility(View.GONE);
            backDrop.setClickable(false);
            bottomSheetOpen = false;
        }else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            backDrop.setVisibility(View.VISIBLE);
            backDrop.setClickable(true);
            bottomSheetOpen = true;
        }
    }


    private void developersList() {

        developers.add(new DeveloperItem(R.string.prince,R.drawable.person_24,R.string.prince_designation));
        developers.add(new DeveloperItem(R.string.prateek,R.drawable.person_24,R.string.prateek_designation));
        developers.add(new DeveloperItem(R.string.dhrub,R.drawable.person_24,R.string.dhrub_designation));
        developers.add(new DeveloperItem(R.string.ud,R.drawable.person_24,R.string.ud_designation));
        developers.add(new DeveloperItem(R.string.vaibhav,R.drawable.person_24,R.string.vaibhav_designation));
        developers.add(new DeveloperItem(R.string.anjali,R.drawable.person_24,R.string.anjali_designation));

    }

    @Override
    public void onBackPressed() {
        if(bottomSheetOpen){
            toggleBottomSheet(-1);
        }else{
            super.onBackPressed();
        }
    }
}
