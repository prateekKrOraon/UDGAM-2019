package in.ac.nitsikkim.udgam19;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import in.ac.nitsikkim.udgam19.adapter.GalleryGridAdapter;
import in.ac.nitsikkim.udgam19.prototype.GalleryGridPrototyipe;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private View view;
    SliderLayout sliderLayout;
    RecyclerView recyclerView;


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_gallery, container, false);

        sliderLayout = (SliderLayout) view.findViewById(R.id.sliderlayout);
        recyclerView = (RecyclerView)view.findViewById(R.id.gridimages_recyclerview);
        startSliderFromInternet(urls_slider().toArray(new String[urls_slider().size()]),
                title_slider().toArray(new String[title_slider().size()]));

        try{
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(gridLayoutManager);
            GalleryGridAdapter galleryGridAdapter = new GalleryGridAdapter(getContext(), image_urls_gridview() );
            recyclerView.setAdapter(galleryGridAdapter);

        }catch (Exception e){
            e.printStackTrace();
        }

        return view;

    }

    public void startSliderFromInternet(String[] url, String[] title) {

        LinkedHashMap<String, String> url_maps = new LinkedHashMap<>();
        url_maps.clear();
        for (int i = 0; i < url.length; i++) {
            url_maps.put(title[i], url[i]);
        }
        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onResume() {
        super.onResume();
        sliderLayout.startAutoCycle();
    }

    public ArrayList<String> urls_slider() {
        ArrayList<String> url_list = new ArrayList<>(0);
        url_list.clear();
        url_list.add("http://lorempixel.com/400/200/sports/1");
        url_list.add("http://lorempixel.com/400/200/sports/1");
        return url_list;
    }

    public ArrayList<String> title_slider(){
        ArrayList<String> title_list = new ArrayList<>();
        title_list.clear();
        title_list.add("title 1");
        title_list.add("title 2");
        return title_list;
    }

    public ArrayList<GalleryGridPrototyipe> image_urls_gridview(){
        ArrayList<GalleryGridPrototyipe> url_gridview = new ArrayList<>();
        url_gridview.clear();
        url_gridview.add(new GalleryGridPrototyipe("http://lorempixel.com/400/200/"));
        url_gridview.add(new GalleryGridPrototyipe("http://lorempixel.com/400/200/"));
        url_gridview.add(new GalleryGridPrototyipe("http://lorempixel.com/400/200/"));
        url_gridview.add(new GalleryGridPrototyipe("http://lorempixel.com/400/200/"));
        url_gridview.add(new GalleryGridPrototyipe("http://lorempixel.com/400/200/"));
        url_gridview.add(new GalleryGridPrototyipe("http://lorempixel.com/400/200/"));

        return url_gridview;
    }

}
