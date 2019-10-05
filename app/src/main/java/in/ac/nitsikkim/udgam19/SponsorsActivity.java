package in.ac.nitsikkim.udgam19;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SponsorsActivity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.maruti_suzuki_logo, R.drawable.allied, R.drawable.bitinfo, R.drawable.bombay, R.drawable.chulyang, R.drawable.logotop, R.drawable.microline, R.drawable.nhpc, R.drawable.ntpc, R.drawable.prabhas, R.drawable.ravongla, R.drawable.sarat, R.drawable.sikkim, R.drawable.sonai, R.drawable.total, R.drawable.wiley, R.drawable.zumthang};

    String[] NAMES = {"Maruti Suzuki", "Allied Publishers", "Bit Infomedia", "Bombay Safe", "Hotel Chu Lyang", "WAI WAI", "microline INDIA", "NHPC Limited", "NTPC Limited", "Parshvnath Lab Solutions", "Hotel Ravongla Star", "SARAT Book House", "Sikkim Express", "Sonal", "TOTAL IT Solutions", "Wiley", "Hotel Zumthang" };

    String[] DESCRIPTIONS = {"Previous Sponsor", "Previous Sponsor", "Media Sponsor", "Merchandise Sponsor", "Previous Sponsor", "Previous Sponsor", "Previous Sponsor", "Previous Sponsor", "Merchandise Sponsor", "Previous Sponsor", "Previous Sponsor", "Friend Sponsor", "Previous Sponsor", "Media Sponsor", "Media Sponsor", "Previous Sponsor", "Previous Sponsor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        Toolbar toolbar = findViewById(R.id.sponsors_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sponsors");

        ListView listView = (ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.list_master_sponsors, null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);

            return view;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
