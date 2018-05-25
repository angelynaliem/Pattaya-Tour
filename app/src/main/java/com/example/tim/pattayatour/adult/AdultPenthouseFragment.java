package com.example.tim.pattayatour.adult;


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
public class AdultPenthouseFragment extends Fragment {


    public AdultPenthouseFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Airports
        final ArrayList<AdultList> penthouse = new ArrayList<>();
        penthouse.add(new AdultList(getContext().getString(R.string.spacer), getContext().getString(R.string.penthouse_hotel),
                getContext().getString(R.string.penthouse_description), R.drawable.adult_penthouse_main,
                R.drawable.adult_penthouse_one, R.drawable.adult_penthouse_four, R.drawable.adult_penthouse_five,
                getContext().getString(R.string.penthouse_web)));

        // Create an {@link AdultAdpter}, whose is a list of {@link AdultList}s. the
        // adapter knows how to create list items for each item in the list.
        AdultAdapter adapter = new AdultAdapter(getActivity(), penthouse, R.color.airportFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdultList detail = penthouse.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
