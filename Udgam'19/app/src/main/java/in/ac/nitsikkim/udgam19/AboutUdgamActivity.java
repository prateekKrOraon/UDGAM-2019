package in.ac.nitsikkim.udgam19;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AboutUdgamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_udgam);

        Toolbar toolbar = findViewById(R.id.about_udgam_toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        //getSupportActionBar().hide();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
