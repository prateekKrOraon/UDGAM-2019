package in.ac.nitsikkim.udgam19.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.ac.nitsikkim.udgam19.R;
import in.ac.nitsikkim.udgam19.prototype.GalleryGridPrototyipe;

public class GalleryGridAdapter extends RecyclerView.Adapter<GalleryGridAdapter.MyViewHolder> {
    Context context;
    public ArrayList<GalleryGridPrototyipe> galleryGridPrototyipes;

    public GalleryGridAdapter(Context context, ArrayList<GalleryGridPrototyipe> galleryGridPrototyipes){
        this.context = context;
        this.galleryGridPrototyipes = galleryGridPrototyipes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.inside_gallery_card_view, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Glide.with(context).load(Uri.parse(galleryGridPrototyipes.get(i).getImage_url()))
                .thumbnail(.4f)
                .into(myViewHolder.imageView);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show download and view option

            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryGridPrototyipes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.gallery_card_image);
        }
    }
}
