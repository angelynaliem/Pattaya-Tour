package com.example.tim.pattayatour.family;

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
public class FamilyActivityFragment extends Fragment {


    public FamilyActivityFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Activities
        final ArrayList<FamilyList> activity = new ArrayList<>();
        activity.add(new FamilyList(getContext().getString(R.string.cartoon_activity), getContext().getString(R.string.cartoon_location),
                getContext().getString(R.string.cartoon_description), R.drawable.family_cartoon,
                getContext().getString(R.string.cartoon_web)));
        activity.add(new FamilyList(getContext().getString(R.string.elephant_activity), getContext().getString(R.string.elephant_location),
                getContext().getString(R.string.elephant_description), R.drawable.family_elephant_village,
                getContext().getString(R.string.elephant_web)));
        activity.add(new FamilyList(getContext().getString(R.string.gocart_activity), getContext().getString(R.string.gocart_location),
                getContext().getString(R.string.gocart_description), R.drawable.family_gocart, getContext().getString(R.string.gocart_web)));
        activity.add(new FamilyList(getContext().getString(R.string.harbor_activity), getContext().getString(R.string.harbor_location),
                getContext().getString(R.string.harbor_family_description), R.drawable.family_harbor, getContext().getString(R.string.harbor_web)));
        activity.add(new FamilyList(getContext().getString(R.string.khao_kheow_activity), getContext().getString(R.string.khao_kheow_location),
                getContext().getString(R.string.khao_kheow_description), R.drawable.family_khao_kheow,
                getContext().getString(R.string.khao_kheow_web)));
        activity.add(new FamilyList(getContext().getString(R.string.nong_nooch_activity), getContext().getString(R.string.nong_nooch_location),
                getContext().getString(R.string.nong_nooch_description), R.drawable.family_nong_nooch, getContext().getString(R.string.non_nooch_web)));
        activity.add(new FamilyList(getContext().getString(R.string.parasail_activity), getContext().getString(R.string.parasail_location),
                getContext().getString(R.string.parasail_description), R.drawable.family_parasail, getContext().getString(R.string.parasailing_web)));
        activity.add(new FamilyList(getContext().getString(R.string.ramanyana_activity), getContext().getString(R.string.ramanyana_location),
                getContext().getString(R.string.ramanyana_description), R.drawable.family_ramayana, getContext().getString(R.string.ramanyana_web)));
        activity.add(new FamilyList(getContext().getString(R.string.sanctuary_activity), getContext().getString(R.string.sanctuary_location),
                getContext().getString(R.string.sanctuary_description), R.drawable.family_sanctuary, getContext().getString(R.string.sanctuary_web)));
        activity.add(new FamilyList(getContext().getString(R.string.tiger_activity), getContext().getString(R.string.tiger_location),
                getContext().getString(R.string.tiger_description), R.drawable.family_tiger, getContext().getString(R.string.tiger_zoo_web)));

        // Create an {@link FamilyAdapter}, whose is a list of {@link FamilyList}s. the
        // adapter knows how to create list items for each item in the list.
        FamilyAdapter adapter = new FamilyAdapter(getActivity(), activity, R.color.busFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FamilyList detail = activity.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
