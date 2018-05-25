package com.example.tim.pattayatour.adult;

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

public class AdultAdapter extends ArrayAdapter<AdultList> {

    // Resource ID for the background color for the Adult "group".
    private int mColorResourceId;

    /**
     * Create a new {@link AdultAdapter} object
     *
     * @param context         is the current context (i.e. "Activity") that the adapter is being created in
     * @param soi             is the list of {@link AdultList}s to be displayed
     * @param colorResourceId is the resource ID for background color
     */
    public AdultAdapter(Context context, ArrayList<AdultList> soi, int colorResourceId) {
        super(context, 0, soi);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being used, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.adult_list_item, parent, false);
        }

        // Get the {@link AdultList} object located at this position in the list
        AdultList currentSoi = getItem(position);

        // Find the TextView in the adult_list_item.xml layout for sois
        TextView soiTextView = listItemView.findViewById(R.id.adult_soi_text_view);
        // Get the Soi name from the current Soi object and set this text on the TextView
        soiTextView.setText(currentSoi.getSoiName());

        // Find the TextView in the adult_list_item.xml layout for sexes
        TextView sexesTextView = listItemView.findViewById(R.id.adult_sexes_text_view);
        // Get the sexes from the current Sexes object and set this on the TextView
        sexesTextView.setText(currentSoi.getSexes());

        //Find the TextView in the adult_list_item.xml layout for description
        TextView descriptionTextView = listItemView.findViewById(R.id.adult_description_text_view);
        // Get the description from the current Description object and set this on the TextView
        descriptionTextView.setText(currentSoi.getSoiDescription());

        // Find the ImageView in the adult_list_item.xml layout with the Id image
        ImageView imageView = listItemView.findViewById(R.id.adult_list_image_view1);
        // Check if an image is provided for this soi or not
        if (currentSoi.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView.setImageResource(currentSoi.getAdultImageResourceId1());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Find the ImageView in the adult_list_item.xml layout with the Id image
        ImageView imageView2 = listItemView.findViewById(R.id.adult_list_image_view2);
        // Check if an image is provided for this word or not
        if (currentSoi.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView2.setImageResource(currentSoi.getAdultImageResourceId2());
            // Make sure the view is visible
            imageView2.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView2.setVisibility(View.GONE);
        }

        // Find the ImageView in the adult_list_item.xml layout with the Id image
        ImageView imageView3 = listItemView.findViewById(R.id.adult_list_image_view3);
        // Check if an image is provided for this word or not
        if (currentSoi.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView3.setImageResource(currentSoi.getAdultImageResourceId3());
            // Make sure the view is visible
            imageView3.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView3.setVisibility(View.GONE);
        }

        // Find the ImageView in the adult_list_item.xml layout with the Id image
        ImageView imageView4 = listItemView.findViewById(R.id.adult_list_image_view4);
        // Check if an image is provided for this word or not
        if (currentSoi.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView4.setImageResource(currentSoi.getAdultImageResourceId4());
            // Make sure the view is visible
            imageView4.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView4.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.adult_text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
