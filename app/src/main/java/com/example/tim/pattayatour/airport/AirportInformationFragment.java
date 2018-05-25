package com.example.tim.pattayatour.airport;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tim.pattayatour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AirportInformationFragment extends Fragment {


    public AirportInformationFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.airport_information, container, false);

        return rootView;
    }

}
