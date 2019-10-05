package in.ac.nitsikkim.udgam19;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuestFragment extends Fragment {

    ArrayList<GuestItem> guestList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_guest, container, false);

        RecyclerView mRecyclerView;
        GuestAdapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        guestList = new ArrayList<>();

        guestListFunc();

        mRecyclerView = view.findViewById(R.id.guest_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new GuestAdapter(guestList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private void guestListFunc() {
        guestList.add(new GuestItem(R.drawable.view_flipper1,R.string.prateek));
    }

}
