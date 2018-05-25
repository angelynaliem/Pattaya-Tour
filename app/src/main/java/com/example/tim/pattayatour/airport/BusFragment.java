package com.example.tim.pattayatour.airport;


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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends Fragment {


    public BusFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Airports
        final ArrayList<AirportList> airports = new ArrayList<>();
        airports.add(new AirportList(getContext().getString(R.string.bell_travel), getContext().getString(R.string.suvarnabhumi),
                getContext().getString(R.string.web_bell_travel), R.drawable.bus_bell_sign));
        airports.add(new AirportList(getContext().getString(R.string.bus_ekamai), getContext().getString(R.string.bangkok),
                getContext().getString(R.string.web_ekamai), R.drawable.bus_bkk));

        // Create an {@link AirportAdpter}, whose is a list of {@link AirportList}s. the
        // adapter knows how to create list items for each item in the list.
        AirportAdapter adapter = new AirportAdapter(getActivity(), airports, R.color.busFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AirportList detail = airports.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getAirportWebSite()));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
