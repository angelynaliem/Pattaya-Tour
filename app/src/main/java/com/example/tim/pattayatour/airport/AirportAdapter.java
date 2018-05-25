package com.example.tim.pattayatour.airport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tim.pattayatour.R;

import java.util.ArrayList;

public class AirportAdapter extends ArrayAdapter<AirportList> {

    // Resource ID for the background color for the Airport "group".
    private int mColorResourceId;

    /**
     * Create a new {@link AirportAdapter} object
     *
     * @param context         is the current context (i.e. "Activity") that the adapter is being created in
     * @param airport         is the list of {@link AirportList}s to be displayed
     * @param colorResourceId is the resource ID for background color
     */
    public AirportAdapter(Context context, ArrayList<AirportList> airport, int colorResourceId) {
        super(context, 0, airport);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being used, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.airport_list_item, parent, false);
        }

        // Get the {@link AirportList} object located at this position in the list
        AirportList currentAirport = getItem(position);

        // Find the TextView in the airport_list_item.xml layout for airports
        TextView airportTextView = listItemView.findViewById(R.id.airport_airport_text_view);
        // Get the activity_main_airport name from the current Airport object and set this text on the TextView
        airportTextView.setText(currentAirport.getAirportName());

        // Find the TextView in the airport_list_item.xml layout for city
        TextView cityTextView = listItemView.findViewById(R.id.airport_city_text_view);
        // Get the city name from the current Airport object and set this on the TextView
        cityTextView.setText(currentAirport.getAirportCity());

        //Find the TextView in the airport_list_item.xml layout for web sites
        TextView webSiteTextView = listItemView.findViewById(R.id.airport_web_site_text_view);
        // Get the web site name from the current airport object and set this on the TextView
        webSiteTextView.setVisibility(View.GONE);

        // Find the ImageView in the airport_list_item.xml layout with the Id image
        ImageView imageView = listItemView.findViewById(R.id.airport_list_image_view);
        // Check if an image is provided for this word or not
        if (currentAirport.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView.setImageResource(currentAirport.getAirportImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.airport_text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
