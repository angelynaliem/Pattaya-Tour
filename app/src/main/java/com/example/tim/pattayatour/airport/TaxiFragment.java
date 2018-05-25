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
public class TaxiFragment extends Fragment {


    public TaxiFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Airports
        final ArrayList<AirportList> airports = new ArrayList<>();
        airports.add(new AirportList(getContext().getString(R.string.smile_taxi), getContext().getString(R.string.all_airports),
                getContext().getString(R.string.web_smile_taxi), R.drawable.smile_taxi));
        airports.add(new AirportList(getContext().getString(R.string.bangkok_taxi), getContext().getString(R.string.bangkok),
                getContext().getString(R.string.web_bkk_taxi), R.drawable.bangkok_taxi24));

        // Create an {@link AirportAdapter}, whose is a list of {@link AirportList}s. the
        // adapter knows how to create list items for each item in the list.
        AirportAdapter adapter = new AirportAdapter(getActivity(), airports, R.color.taxiFragment);

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
