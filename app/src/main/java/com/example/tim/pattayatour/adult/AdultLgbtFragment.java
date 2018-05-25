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

public class AdultLgbtFragment extends Fragment {

    public AdultLgbtFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Ladyboys
        final ArrayList<AdultList> ladyboy = new ArrayList<>();
        ladyboy.add(new AdultList(getContext().getString(R.string.spacer), getContext().getString(R.string.tiffany),
                getContext().getString(R.string.tiffany_caberet), R.drawable.adult_tiff_main, R.drawable.adult_tiff_one,
                R.drawable.adult_tiff_two, R.drawable.adult_tiff_three, getContext().getString(R.string.tiffany_web)));
        ladyboy.add(new AdultList(getContext().getString(R.string.spacer), getContext().getString(R.string.ladyboys),
                getContext().getString(R.string.everywhere), R.drawable.adult_ladyboy_one, R.drawable.adult_ladyboy_two,
                R.drawable.adult_ladyboy_three, R.drawable.adult_ladyboy_six, getContext().getString(R.string.ladyboy_web)));
        ladyboy.add(new AdultList(getContext().getString(R.string.spacer), getContext().getString(R.string.boyz_town),
                getContext().getString(R.string.soi_boyz_description), R.drawable.adult_boyz_main, R.drawable.adult_boyz_two,
                R.drawable.adult_boyz_three, R.drawable.adult_boyz_four, getContext().getString(R.string.boyztown_web)));

        // Create an {@link AdultAdpter}, whose is a list of {@link AdultList}s. the
        // adapter knows how to create list items for each item in the list.
        AdultAdapter adapter = new AdultAdapter(getActivity(), ladyboy, R.color.airportFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdultList detail = ladyboy.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
