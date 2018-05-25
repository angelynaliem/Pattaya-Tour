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
import com.example.tim.pattayatour.adult.AdultList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AirportFragment extends Fragment {

    public AirportFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Airports
        final ArrayList<AirportList> airports = new ArrayList<>();
        airports.add(new AirportList(getContext().getString(R.string.suvarnabhumi), getContext().getString(R.string.bangkok),
                getContext().getString(R.string.web_airports_bkk), R.drawable.suvarnabuhmi));
        airports.add(new AirportList(getContext().getString(R.string.donmueang), getContext().getString(R.string.bangkok),
                getContext().getString(R.string.web_airports_bkk), R.drawable.don_mueang));
        airports.add(new AirportList(getContext().getString(R.string.utapao), getContext().getString(R.string.rayong),
                getContext().getString(R.string.web_utapao), R.drawable.utapao));

        // Create an {@link AirportAdpter}, whose is a list of {@link AirportList}s. the
        // adapter knows how to create list items for each item in the list.
        AirportAdapter adapter = new AirportAdapter(getActivity(), airports, R.color.airportFragment);

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
