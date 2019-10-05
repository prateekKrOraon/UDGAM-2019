package in.ac.nitsikkim.udgam19;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private ArrayList<EventItem> mEventList;

    public static class EventViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public Button exploreButton;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_event);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            exploreButton = itemView.findViewById(R.id.explore_button);
        }
    }

    public EventAdapter(ArrayList<EventItem> eventList){
        this.mEventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_layout,viewGroup,false);
        return new EventViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final EventViewHolder eventViewHolder, int i) {
        EventItem currentItem = mEventList.get(i);

        eventViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        eventViewHolder.textView1.setText(currentItem.getmText1());
        eventViewHolder.textView2.setText(currentItem.getmText2());

        eventViewHolder.exploreButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EventDescriptionActivity.class);
                switch(eventViewHolder.getAdapterPosition()){
                    case 0:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.quiz,
                                R.string.quiz,
                                R.string.quiz_name1,
                                R.string.quiz_name1_email,
                                R.string.quiz_name1_phone,
                                R.string.quiz_name2,
                                R.string.quiz_name2_email,
                                R.string.quiz_name2_phone,
                                R.string.quiz_time,
                                R.string.quiz_place,
                                R.string.quiz_description)));
                        break;
                    case 1:
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
                    case 2:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.debate,
                                R.string.tug_of_war,
                                R.string.tug_of_war_name1,
                                R.string.tug_of_war_name1_email,
                                R.string.tug_of_war_name1_phone,
                                R.string.tug_of_war_name2,
                                R.string.tug_of_war_name2_email,
                                R.string.tug_of_war_name2_phone,
                                R.string.tug_of_war_time,
                                R.string.tug_of_war_place,
                                R.string.tug_of_war_description)));
                        break;
                    case 3:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 4:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.treasure_hunt,
                                R.string.treasure_hunt_name1,
                                R.string.treasure_hunt_name1_email,
                                R.string.treasure_hunt_name1_phone,
                                R.string.treasure_hunt_name2,
                                R.string.treasure_hunt_name2_email,
                                R.string.treasure_hunt_name2_phone,
                                R.string.treasure_hunt_time,
                                R.string.treasure_hunt_place,
                                R.string.treasure_hunt_description)));
                        break;
                    case 5:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.h2hb2b,
                                R.string.h2hb2b_name1,
                                R.string.h2hb2b_name1_email,
                                R.string.h2hb2b_name1_phone,
                                R.string.h2hb2b_name2,
                                R.string.h2hb2b_name2_email,
                                R.string.h2hb2b_name2_phone,
                                R.string.h2hb2b_time,
                                R.string.h2hb2b_place,
                                R.string.h2hb2b_description)));
                        break;
                    case 6:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 7:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.balloon_fight,
                                R.string.balloon_fight_name1,
                                R.string.balloon_fight_name1_email,
                                R.string.balloon_fight_name1_phone,
                                R.string.balloon_fight_name2,
                                R.string.balloon_fight_name2_email,
                                R.string.balloon_fight_name2_phone,
                                R.string.balloon_fight_time,
                                R.string.balloon_fight_place,
                                R.string.balloon_fight_description)));
                        break;
                    case 8:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.super_over,
                                R.string.super_over_name1,
                                R.string.super_over_name1_email,
                                R.string.super_over_name1_phone,
                                R.string.super_over_name2,
                                R.string.super_over_name2_email,
                                R.string.super_over_name2_phone,
                                R.string.super_over_time,
                                R.string.super_over_place,
                                R.string.super_over_description)));
                        break;
                    case 9:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.arm_wrestling,
                                R.string.arm_wrestling_name1,
                                R.string.arm_wrestling_name1_email,
                                R.string.arm_wrestling_name1_phone,
                                R.string.arm_wrestling_name2,
                                R.string.arm_wrestling_name2_email,
                                R.string.arm_wrestling_name2_phone,
                                R.string.arm_wrestling_time,
                                R.string.arm_wrestling_place,
                                R.string.arm_wrestling_description)));
                        break;
                    case 10:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.antakshri,
                                R.string.antakshri_name1,
                                R.string.antakshri_name1_email,
                                R.string.antakshri_name1_phone,
                                R.string.antakshri_name2,
                                R.string.antakshri_name2_email,
                                R.string.antakshri_name2_phone,
                                R.string.antakshri_time,
                                R.string.antakshri_place,
                                R.string.antakshri_description)));
                        break;
                    case 11:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 12:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.twist_a_tale,
                                R.string.twist_a_tale_name1,
                                R.string.twist_a_tale_name1_email,
                                R.string.twist_a_tale_name1_phone,
                                R.string.twist_a_tale_name2,
                                R.string.twist_a_tale_name2_email,
                                R.string.twist_a_tale_name2_phone,
                                R.string.twist_a_tale_time,
                                R.string.twist_a_tale_place,
                                R.string.twist_a_tale_description)));
                        break;
                    case 13:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 14:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.switching_emotion,
                                R.string.switching_emotion_name1,
                                R.string.switching_emotion_name1_email,
                                R.string.switching_emotion_name1_phone,
                                R.string.switching_emotion_name2,
                                R.string.switching_emotion_name2_email,
                                R.string.switching_emotion_name2_phone,
                                R.string.switching_emotion_time,
                                R.string.switching_emotion_place,
                                R.string.switching_emotion_description)));
                        break;
                    case 15:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.connected,
                                R.string.connected_name1,
                                R.string.connected_name1_email,
                                R.string.connected_name1_phone,
                                R.string.connected_name2,
                                R.string.connected_name2_email,
                                R.string.connected_name2_phone,
                                R.string.connected_time,
                                R.string.connected_place,
                                R.string.connected_description)));
                        break;
                    case 16:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 17:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.dumsharaz,
                                R.string.dumsharaz_name1,
                                R.string.dumsharaz_name1_email,
                                R.string.dumsharaz_name1_phone,
                                R.string.dumsharaz_name2,
                                R.string.dumsharaz_name2_email,
                                R.string.dumsharaz_name2_phone,
                                R.string.dumsharaz_time,
                                R.string.dumsharaz_place,
                                R.string.dumsharaz_description)));
                        break;
                    case 18:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 19:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.high_voltage,
                                R.string.high_voltage_name1,
                                R.string.high_voltage_name1_email,
                                R.string.high_voltage_name1_phone,
                                R.string.high_voltage_name2,
                                R.string.high_voltage_name2_email,
                                R.string.high_voltage_name2_phone,
                                R.string.high_voltage_time,
                                R.string.high_voltage_place,
                                R.string.high_voltage_description)));
                        break;
                    case 20:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.pubg,
                                R.string.pubg_name1,
                                R.string.pubg_name1_email,
                                R.string.pubg_name1_phone,
                                R.string.pubg_name2,
                                R.string.pubg_name2_email,
                                R.string.pubg_name2_phone,
                                R.string.pubg_time,
                                R.string.pubg_place,
                                R.string.pubg_description)));
                        break;
                    case 21:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.counter_strike,
                                R.string.counter_strike_name1,
                                R.string.counter_strike_name1_email,
                                R.string.counter_strike_name1_phone,
                                R.string.counter_strike_name2,
                                R.string.counter_strike_name2_email,
                                R.string.counter_strike_name2_phone,
                                R.string.counter_strike_time,
                                R.string.counter_strike_place,
                                R.string.counter_strike_description)));
                        break;
                    case 22:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.camera_ne_bana_di_jodi,
                                R.string.camera_ne_bana_di_jodi_name1,
                                R.string.camera_ne_bana_di_jodi_name1_email,
                                R.string.camera_ne_bana_di_jodi_name1_phone,
                                R.string.camera_ne_bana_di_jodi_name2,
                                R.string.camera_ne_bana_di_jodi_name2_email,
                                R.string.camera_ne_bana_di_jodi_name2_phone,
                                R.string.camera_ne_bana_di_jodi_time,
                                R.string.camera_ne_bana_di_jodi_place,
                                R.string.camera_ne_bana_di_jodi_description)));
                        break;
                    case 23:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
                                R.string.short_film_contest,
                                R.string.short_film_contest_name1,
                                R.string.short_film_contest_name1_email,
                                R.string.short_film_contest_name1_phone,
                                R.string.short_film_contest_name2,
                                R.string.short_film_contest_name2_email,
                                R.string.short_film_contest_name2_phone,
                                R.string.short_film_contest_time,
                                R.string.short_film_contest_place,
                                R.string.short_film_contest_description)));
                        break;
                    case 24:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 25:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(Arrays.asList(
                                R.drawable.tug_of_war,
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
                    case 26:
                        intent.putIntegerArrayListExtra("array_list",new ArrayList<>(
                                Arrays.asList(
                                        R.drawable.tug_of_war,
                                        R.string.tiger_five,
                                        R.string.tiger_five_name1,
                                        R.string.tiger_five_name1_email,
                                        R.string.tiger_five_name1_phone,
                                        R.string.tiger_five_name2,
                                        R.string.tiger_five_name2_email,
                                        R.string.tiger_five_name2_phone,
                                        R.string.tiger_five_time,
                                        R.string.tiger_five_place,
                                        R.string.tiger_five_description)));
                        break;
                    default:
                        Snackbar.make(v.getRootView(),"Error Occurred",Snackbar.LENGTH_SHORT).show();
                }
                v.getContext().startActivity(intent);
            }

        });


    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

}
