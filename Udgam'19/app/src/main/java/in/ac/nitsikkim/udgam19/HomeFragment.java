package in.ac.nitsikkim.udgam19;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    CardView footloose;
    CardView nitIdol;
    CardView rampWalk, wallPainting, facePainting,openMic, debate, jam, alfaaZ;

    private ArrayList<HomeItem> homeItems;


    private FloatingActionButton fabInsta;
    private FloatingActionButton fabFb;
    private FloatingActionButton fabYoutube;
    private FloatingActionButton fabWeb;

    private CardView culturalMore;
    private CardView artMore;
    private CardView literatureMore;
    private EventFragment eventFragment;
    private BottomNavigationView bottomNavigationView;

    private SliderLayout sliderLayout;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;
        HomeRecyclerAdapter mAdapter;

        homeItems = new ArrayList<>();
        homeItemFunc();

        fabInsta = view.findViewById(R.id.fab_insta);
        fabFb = view.findViewById(R.id.fab_fb);
        fabYoutube = view.findViewById(R.id.fab_youtube);
        fabWeb = view.findViewById(R.id.fab_web);

        fabListeners();

        culturalMore = view.findViewById(R.id.cultural_more);
        artMore = view.findViewById(R.id.art_more);
        literatureMore = view.findViewById(R.id.literature_more);

        eventFragment = new EventFragment();
        bottomNavigationView = getActivity().findViewById(R.id.bottom_nav_bar);

        moreCardListener();

        /*mRecyclerView = view.findViewById(R.id.home_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(mRecyclerView);
        mAdapter = new HomeRecyclerAdapter(homeItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }
        });*/

        footloose = view.findViewById(R.id.home_footloose);
        nitIdol = view.findViewById(R.id.home_nit_idol);
        rampWalk = view.findViewById(R.id.home_ramp_walk);
        wallPainting = view.findViewById(R.id.home_wall_painting);
        facePainting = view.findViewById(R.id.home_face_painting);
        openMic = view.findViewById(R.id.home_open_mic);
        debate = view.findViewById(R.id.home_debate);
        jam = view.findViewById(R.id.home_jam);
        alfaaZ = view.findViewById(R.id.home_alfaaz);

        cardListener();

        sliderLayout = view.findViewById(R.id.home_slider_layout);
        startSlider(sliderImages().toArray(new Integer[sliderImages().size()]),
                sliderText().toArray(new String[sliderText().size()]));

        return view;
    }

    private void startSlider(Integer[] images, String[] title) {

        //LinkedHashMap<String,Integer> urlMaps = new LinkedHashMap<>();
        //urlMaps.clear();

        /*for (int i = 0; i<images.length;i++){

            urlMaps.put(title[i],images[i]);
        }*/

        for(int i = 0; i<images.length; i++){

            TextSliderView textSliderView = new TextSliderView(getContext());

            textSliderView
                    .description(title[i])
                    .image(images[i])
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",title[i]);

            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);
    }

    private ArrayList<Integer> sliderImages(){

        ArrayList<Integer> sliderImages = new ArrayList<>();
        sliderImages.clear();
        sliderImages.add(R.drawable.iron_man);
        sliderImages.add(R.drawable.superman);
        sliderImages.add(R.drawable.captain);
        sliderImages.add(R.drawable.spiderman);
        sliderImages.add(R.drawable.thor);

        return sliderImages;

    }

    private ArrayList<String> sliderText(){

        ArrayList<String> sliderText = new ArrayList<>();
        sliderText.clear();
        sliderText.add("Iron Man");
        sliderText.add("Superman");
        sliderText.add("Captain America");
        sliderText.add("Spiderman");
        sliderText.add("Thor");

        return sliderText;

    }

    private void cardListener() {

        footloose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cardStartActivity(0);
            }
        });

        nitIdol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(1);
            }
        });

        rampWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(2);
            }
        });

        wallPainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(3);
            }
        });

        facePainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(4);
            }
        });

        openMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(5);
            }
        });

        debate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(6);
            }
        });

        jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(7);
            }
        });

        alfaaZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStartActivity(8);
            }
        });

    }

    private void cardStartActivity(int i){

        Intent intent = new Intent(getContext(),EventDescriptionActivity.class);

        switch(i){
            case 0:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.dfo,
                        R.string.dance_face_off,
                        R.string.dance_face_off_name1,
                        R.string.dance_face_off_name1_email,
                        R.string.dance_face_off_name1_phone,
                        R.string.dance_face_off_name2,
                        R.string.dance_face_off_name2_email,
                        R.string.dance_face_off_name2_phone,
                        R.string.dance_face_off_time,
                        R.string.dance_face_off_place,
                        R.string.dance_face_off_description)));
                break;
            case 1:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.nit_idol,
                        R.string.nit_idol,
                        R.string.nit_idol_name1,
                        R.string.nit_idol_name1_email,
                        R.string.nit_idol_name1_phone,
                        R.string.nit_idol_name2,
                        R.string.nit_idol_name2_email,
                        R.string.nit_idol_name2_phone,
                        R.string.nit_idol_time,
                        R.string.nit_idol_place,
                        R.string.nit_idol_description)));
                break;
            case 2:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.ramp_walk,
                        R.string.ramp_walk,
                        R.string.ramp_walk_name1,
                        R.string.ramp_walk_name1_email,
                        R.string.ramp_walk_name1_phone,
                        R.string.ramp_walk_name2,
                        R.string.ramp_walk_name2_email,
                        R.string.ramp_walk_name2_phone,
                        R.string.ramp_walk_time,
                        R.string.ramp_walk_place,
                        R.string.ramp_walk_description)));
                break;
            case 3:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.wall_painting,
                        R.string.wall_painting,
                        R.string.wall_painting_name1,
                        R.string.wall_painting_name1_email,
                        R.string.wall_painting_name1_phone,
                        R.string.wall_painting_name2,
                        R.string.wall_painting_name2_email,
                        R.string.wall_painting_name2_phone,
                        R.string.wall_painting_time,
                        R.string.wall_painting_place,
                        R.string.wall_painting_description)));
                break;
            case 4:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.face_painting,
                        R.string.face_painting,
                        R.string.face_painting_name1,
                        R.string.face_painting_name1_email,
                        R.string.face_painting_name1_phone,
                        R.string.face_painting_name2,
                        R.string.face_painting_name2_email,
                        R.string.face_painting_name2_phone,
                        R.string.face_painting_time,
                        R.string.face_painting_place,
                        R.string.face_painting_description)));
                break;
            case 5:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.open_mic,
                        R.string.open_mic,
                        R.string.open_mic_name1,
                        R.string.open_mic_name1_email,
                        R.string.open_mic_name1_phone,
                        R.string.open_mic_name2,
                        R.string.open_mic_name2_email,
                        R.string.open_mic_name2_phone,
                        R.string.open_mic_time,
                        R.string.open_mic_place,
                        R.string.open_mic_description)));
                break;
            case 6:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.debate,
                        R.string.debate,
                        R.string.debate_name1,
                        R.string.debate_name1_email,
                        R.string.debate_name1_phone,
                        R.string.debate_name2,
                        R.string.debate_name2_email,
                        R.string.debate_name2_phone,
                        R.string.debate_time,
                        R.string.debate_place,
                        R.string.debate_description)));
                break;
            case 7:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.jam,
                        R.string.just_a_minute,
                        R.string.jam_name1,
                        R.string.jam_name1_email,
                        R.string.jam_name1_phone,
                        R.string.jam_name2,
                        R.string.jam_name2_email,
                        R.string.jam_name2_phone,
                        R.string.jam_time,
                        R.string.jam_place,
                        R.string.jam_description)));
                break;
            case 8:
                intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                        R.drawable.alfaaz,
                        R.string.alfaaz,
                        R.string.alfaaz_name1,
                        R.string.alfaaz_name1_email,
                        R.string.alfaaz_name1_phone,
                        R.string.alfaaz_name2,
                        R.string.alfaaz_name2_email,
                        R.string.alfaaz_name2_phone,
                        R.string.alfaaz_time,
                        R.string.alfaaz_place,
                        R.string.alfaaz_description)));
                break;
            default:
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }

        startActivity(intent);
    }

    private void moreCardListener() {

        culturalMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEventFragment();
            }
        });

        artMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEventFragment();
            }
        });

        literatureMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEventFragment();
            }
        });
    }

    public void goToEventFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main,eventFragment,"event");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_events);
    }

    private void homeItemFunc() {
        homeItems.add(new HomeItem(R.drawable.home_udgam));
        homeItems.add(new HomeItem(R.drawable.iron_man));
        homeItems.add(new HomeItem(R.drawable.spiderman));
        homeItems.add(new HomeItem(R.drawable.superman));
        homeItems.add(new HomeItem(R.drawable.captain));
        homeItems.add(new HomeItem(R.drawable.thor));
    }

    private void fabListeners() {

        fabInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String web = "http://instagram.com/udgam_nitsikkim";

                    openWeb(web);
            }
        });

        fabFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String app = "fb://facewebmodal/f?href=udgam.nitsikkim";
                String web = "http://facebook.com/udgam.nitsikkim";

                    openWeb(web);
            }
        });

        fabYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String app = "vnd.youtube:user/NITSikkimUdgam";
                String web = "https://www.youtube.com/NITSikkimUdgam";

                    openWeb(web);

            }
        });

        fabWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http:\\udgam.nitsikkim.ac.in";
                openWeb(url);
            }
        });
    }

    public void openWeb(String url){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }
}
