package in.ac.nitsikkim.udgam19;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.DeveloperViewHolder>{

    private ArrayList<DeveloperItem> mDevelopersList;

    public static class DeveloperViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView name;
        public TextView designation;
        public CardView cardView;
        CircleImageView developerImage;
        ImageButton mail;
        ImageButton phone;
        ImageButton linkedIn;
        ImageButton gitHub;
        ImageButton fb;

        public DeveloperViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.developers_image);
            name = itemView.findViewById(R.id.developers_name);
            designation = itemView.findViewById(R.id.developers_designation);
            cardView = itemView.findViewById(R.id.developers);

             developerImage = itemView.findViewById(R.id.developer_description_image);
             mail = itemView.findViewById(R.id.developer_description_mail);
             phone = itemView.findViewById(R.id.developer_description_call);
             linkedIn = itemView.findViewById(R.id.developer_description_linkedin);
             gitHub = itemView.findViewById(R.id.developer_description_git_hub);
             fb = itemView.findViewById(R.id.developer_description_fb);

        }

    }

    public DeveloperAdapter(ArrayList<DeveloperItem> developerList){
        this.mDevelopersList = developerList;
    }

    @NonNull
    @Override
    public DeveloperAdapter.DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.developers_layout,viewGroup,false);
        return new DeveloperViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final DeveloperAdapter.DeveloperViewHolder developerViewHolder, int i) {

        DeveloperItem currentItem = mDevelopersList.get(2);

        developerViewHolder.imageView.setImageResource(currentItem.getProfileImage());
        developerViewHolder.name.setText(currentItem.getName());
        developerViewHolder.designation.setText(currentItem.getDesignation());

        developerViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(developerViewHolder.getAdapterPosition()){

                    case 0:


                }
                DevelopersActivity.toggleBottomSheet(developerViewHolder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDevelopersList.size();
    }


}
