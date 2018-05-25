package com.example.tim.pattayatour.shopping;


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
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_list, container, false);

        // This will create an ArrayList for Shopping
        final ArrayList<ShoppingList> malls = new ArrayList<>();
        malls.add(new ShoppingList(getContext().getString(R.string.avenue), getContext().getString(R.string.second_rd),
                getContext().getString(R.string.avenue_description), R.drawable.shopping_avenue,
                getContext().getString(R.string.avenue_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.big_c_extra), getContext().getString(R.string.central_rd),
                getContext().getString(R.string.big_c_extra_description), R.drawable.shopping_bigc_klang,
                getContext().getString(R.string.big_c_extra_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.central), getContext().getString(R.string.beach_rd),
                getContext().getString(R.string.central_description), R.drawable.shopping_central,
                getContext().getString(R.string.central_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.central_center), getContext().getString(R.string.second_rd),
                getContext().getString(R.string.central_center_description), R.drawable.shopping_central_center,
                getContext().getString(R.string.central_center_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.floating_market), getContext().getString(R.string.sukhumvit),
                getContext().getString(R.string.floating_description), R.drawable.shopping_floating,
                getContext().getString(R.string.floating_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.harbor_mall), getContext().getString(R.string.central_rd),
                getContext().getString(R.string.harbor_description), R.drawable.shopping_harbor,
                getContext().getString(R.string.harbor_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.mikes), getContext().getString(R.string.beach_rd),
                getContext().getString(R.string.mike_description), R.drawable.shopping_mikes,
                getContext().getString(R.string.mikes_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.night_bazaar), getContext().getString(R.string.second_rd),
                getContext().getString(R.string.night_bazaar_description), R.drawable.shopping_night_bazaar,
                getContext().getString(R.string.night_bazaar_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.night_market), getContext().getString(R.string.thepprasit_rd),
                getContext().getString(R.string.night_market_description), R.drawable.shopping_night_market,
                getContext().getString(R.string.night_market_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.outlet_mall), getContext().getString(R.string.outlet_rd),
                getContext().getString(R.string.outlet_description), R.drawable.shopping_outlet,
                getContext().getString(R.string.outlet_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.royal_garden), getContext().getString(R.string.beach_rd),
                getContext().getString(R.string.royal_description), R.drawable.shopping_royal,
                getContext().getString(R.string.royal_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.terminal), getContext().getString(R.string.pattaya_north),
                getContext().getString(R.string.terminal_description), R.drawable.shopping_terminal,
                getContext().getString(R.string.terminal_web)));
        malls.add(new ShoppingList(getContext().getString(R.string.tukcom), getContext().getString(R.string.pattaya_south),
                getContext().getString(R.string.tukcom_description), R.drawable.shopping_tukcom,
                getContext().getString(R.string.tukcom_web)));

        // Create an {@link ShoppingAdapter}, whose is a list of {@link ShoppingList}s. the
        // adapter knows how to create list items for each item in the list.
        ShoppingAdapter adapter = new ShoppingAdapter(getActivity(), malls, R.color.airportFragment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShoppingList detail = malls.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
