package in.ac.nitsikkim.udgam19;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventDescriptionActivity extends AppCompatActivity {

    private ImageView titleImage;
    private TextView titleText;
    private TextView name1;
    private TextView name1Phone;
    private TextView name1Email;
    private TextView name2;
    private TextView name2Phone;
    private TextView name2Email;
    private TextView time;
    private TextView place;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        titleImage = (ImageView) findViewById(R.id.des_event_image);
        titleText = (TextView) findViewById(R.id.des_event_title);
        name1 = findViewById(R.id.des_name1);
        name2 = findViewById(R.id.des_name2);
        name1Email = findViewById(R.id.des_name1_email);
        name2Email = findViewById(R.id.des_name2_email);
        name1Phone = findViewById(R.id.des_name1_phone);
        name2Phone = findViewById(R.id.des_name2_phone);
        time = findViewById(R.id.des_time);
        place = findViewById(R.id.des_place);
        description = findViewById(R.id.des_rules);

        Toolbar toolbar = findViewById(R.id.event_description_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent extras = getIntent();
        ArrayList<Integer> arrayList = extras.getIntegerArrayListExtra("array_list");

        titleImage.setImageResource(arrayList.get(0));
        titleText.setText(arrayList.get(1));
        name1.setText(arrayList.get(2));
        name1Email.setText(arrayList.get(3));
        name1Phone.setText(arrayList.get(4));
        name2.setText(arrayList.get(5));
        name2Email.setText(arrayList.get(6));
        name2Phone.setText(arrayList.get(7));
        time.setText(arrayList.get(8));
        place.setText(arrayList.get(9));
        description.setText(arrayList.get(10));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
