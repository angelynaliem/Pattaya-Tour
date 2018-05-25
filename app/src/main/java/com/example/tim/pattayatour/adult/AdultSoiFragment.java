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
public class AdultSoiFragment extends Fragment {


    public AdultSoiFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Sois
        final ArrayList<AdultList> sois = new ArrayList<>();
        sois.add(new AdultList(getContext().getString(R.string.soi_walking_street), getContext().getString(R.string.sexes_two),
                getContext().getString(R.string.walking_street_description), R.drawable.adult_walking_main, R.drawable.adult_walking_two,
                R.drawable.adult_walking_four, R.drawable.adult_walking_five, getContext().getString(R.string.walking_street_web)));
        sois.add(new AdultList(getContext().getString(R.string.soi_six), getContext().getString(R.string.sexes_one),
                getContext().getString(R.string.soi_six_description), R.drawable.adult_soi_six_one, R.drawable.adult_soi_six_two,
                R.drawable.adult_soi_six_three, R.drawable.adult_soi_six_six, getContext().getString(R.string.soi_six_web)));
        sois.add(new AdultList(getContext().getString(R.string.soi_seven), getContext().getString(R.string.sexes_one),
                getContext().getString(R.string.other_sois), R.drawable.adult_soi_seven_one, R.drawable.adult_soi_seven_two,
                R.drawable.adult_soi_seven_three, R.drawable.adult_soi_seven_four, getContext().getString(R.string.soi_seven_web)));
        sois.add(new AdultList(getContext().getString(R.string.soi_eight), getContext().getString(R.string.sexes_one),
                getContext().getString(R.string.other_sois), R.drawable.adult_soi_eight_one, R.drawable.adult_soi_eight_two,
                R.drawable.adult_soi_eight_three, R.drawable.adult_soi_eight_four, getContext().getString(R.string.soi_eight_web)));
        sois.add(new AdultList(getContext().getString(R.string.soi_bukhao), getContext().getString(R.string.sexes_one),
                getContext().getString(R.string.other_sois), R.drawable.adult_soi_buakhao_one, R.drawable.adult_soi_buakhao_two,
                R.drawable.adult_soi_buakhao_four, R.drawable.adult_soi_buakhao_five, getContext().getString(R.string.soi_bhukhao_web)));

        // Create an {@link AdultAdapter}, whose is a list of {@link AdultList}s. the
        // adapter knows how to create list items for each item in the list.
        AdultAdapter adapter = new AdultAdapter(getActivity(), sois, R.color.airportFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdultList detail = sois.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });


        return rootView;
    }

}
