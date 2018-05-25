package com.example.tim.pattayatour.lodging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.tim.pattayatour.R;
import com.example.tim.pattayatour.airport.AirportList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LodgingHotelsFragment extends Fragment {


    public LodgingHotelsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Lodging
        final ArrayList<LodgingList> hotel = new ArrayList<>();
        hotel.add(new LodgingList(R.drawable.hotel_hilton, getContext().getString(R.string.hilton_web)));
        hotel.add(new LodgingList(R.drawable.hotel_hard_rock, getContext().getString(R.string.hard_rock_web)));
        hotel.add(new LodgingList(R.drawable.hotel_flipper_house, getContext().getString(R.string.flipper_web)));
        hotel.add(new LodgingList(R.drawable.hotel_nautical, getContext().getString(R.string.nautical_web)));
        hotel.add(new LodgingList(R.drawable.hotel_queen_vic, getContext().getString(R.string.queen_vic_web)));

        // Create an {@link LodgingAdapter}, whose is a list of {@link LodgingList}s. the
        // adapter knows how to create list items for each item in the list.
        LodgingAdapter adapter = new LodgingAdapter(getActivity(), hotel, R.color.busFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LodgingList detail = hotel.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
