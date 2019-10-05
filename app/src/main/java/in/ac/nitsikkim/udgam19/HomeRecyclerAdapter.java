package in.ac.nitsikkim.udgam19;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder> {

    private ArrayList<HomeItem> homeItems;
    private CardView cardView;

    public static class HomeViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public HomeViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.home_card_image);
        }
    }

    public HomeRecyclerAdapter(ArrayList<HomeItem> homeItems){
        this.homeItems = homeItems;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_layout,viewGroup,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {
        HomeItem currentItem = homeItems.get(i);

        homeViewHolder.imageView.setImageResource(currentItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }
}
