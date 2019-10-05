package in.ac.nitsikkim.udgam19;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Day3 extends Fragment {

    ArrayList<EventItem> eventList;

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_event, container, false);

        RecyclerView mRecyclerView;
        EventAdapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        eventList = new ArrayList<>();

        eventListFunc();

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mAdapter = new EventAdapter(eventList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        return view;
    }

    private void eventListFunc() {

        eventList.add(new EventItem(R.drawable.debate,R.string.quiz,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.debate,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.tug_of_war,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.face_painting,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.treasure_hunt,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.h2hb2b,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.wall_painting,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.balloon_fight,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.super_over,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.arm_wrestling,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.antakshri,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.just_a_minute,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.twist_a_tale,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.dance_face_off,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.switching_emotion,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.connected,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.alfaaz,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.dumsharaz,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.open_mic,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.high_voltage,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.pubg,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.counter_strike,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.camera_ne_bana_di_jodi,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.short_film_contest,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.ramp_walk,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.nit_idol,"time"));
        eventList.add(new EventItem(R.drawable.debate,R.string.tiger_five,"time"));

    }

}
