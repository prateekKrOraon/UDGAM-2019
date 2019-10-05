package in.ac.nitsikkim.udgam19;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {

    private ArrayList<GuestItem> mGuestList;

    public static class GuestViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public Button button;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.guest_image);
            textView = itemView.findViewById(R.id.guest_name);
            button = itemView.findViewById(R.id.guest_btn);
        }
    }

    public GuestAdapter(ArrayList<GuestItem> guestList) {
        this.mGuestList = guestList;
    }


    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.guest_layout,viewGroup,false);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder guestViewHolder, int i) {
        GuestItem currentItem = mGuestList.get(i);

        guestViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        guestViewHolder.textView.setText(currentItem.getmName());
        guestViewHolder.textView.append("Appended");

        guestViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Working", Toast.LENGTH_LONG).show();

                v.getContext().startActivity(new Intent(v.getContext(),GuestDescriptionActivity.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mGuestList.size();
    }

}
