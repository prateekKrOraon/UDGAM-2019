package in.ac.nitsikkim.udgam19;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsideGalleryCardAdapter extends RecyclerView.Adapter<InsideGalleryCardAdapter.InsideGalleryCardViewHolder> {

    private ArrayList<InsideGalleryCardItem> cardItem;
    private CardView imageTile;

    public static class InsideGalleryCardViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageButton;

        public InsideGalleryCardViewHolder(@NonNull View itemView){
            super(itemView);
            imageButton = itemView.findViewById(R.id.gallery_card_image);
        }
    }

    public InsideGalleryCardAdapter(ArrayList<InsideGalleryCardItem> cardItem){
        this.cardItem = cardItem;
    }

    @NonNull
    @Override
    public InsideGalleryCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inside_gallery_card_view,viewGroup,false);
        InsideGalleryCardViewHolder holder = new InsideGalleryCardViewHolder(view);
        imageTile = view.findViewById(R.id.gallery_card);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final InsideGalleryCardViewHolder insideGalleryCardViewHolder, int i) {
        InsideGalleryCardItem currentItem = cardItem.get(i);

        imageTile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(insideGalleryCardViewHolder.getAdapterPosition()){

                    case 0:
                        v.getContext().startActivity(new Intent(v.getContext(),ImageViewerActivity.class).putExtra("image",R.drawable.view_flipper4));
                        break;
                    default:
                        Toast.makeText(v.getContext(),"Error",Toast.LENGTH_LONG).show();

                }
            }
        });
        insideGalleryCardViewHolder.imageButton.setImageResource(currentItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return cardItem.size();
    }
}
