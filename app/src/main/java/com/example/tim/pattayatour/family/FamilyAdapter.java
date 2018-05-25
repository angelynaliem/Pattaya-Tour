package com.example.tim.pattayatour.family;

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

public class FamilyAdapter extends ArrayAdapter<FamilyList> {

    // Resource ID for the background color for the Family Activity "group".
    private int mColorResourceId;

    /**
     * Create a new {@link FamilyAdapter} object
     *
     * @param context         is the current context (i.e. "Activity") that the adapter is being created in
     * @param family          is the list of {@link FamilyList}s to be displayed
     * @param colorResourceId is the resource ID for background color
     */
    public FamilyAdapter(Context context, ArrayList<FamilyList> family, int colorResourceId) {
        super(context, 0, family);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being used, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.family_list_item, parent, false);
        }

        // Get the {@link FamilyList} object located at this position in the list
        FamilyList currentActivity = getItem(position);

        // Find the TextView in the family_list_item.xml layout for activities
        TextView activityTextView = listItemView.findViewById(R.id.family_activity_text_view);
        // Get the activity_main_family name from the current Family object and set this text on the TextView
        activityTextView.setText(currentActivity.getFamilyActivityName());

        // Find the TextView in the family_list_item.xml layout for location
        TextView locationTextView = listItemView.findViewById(R.id.family_location_text_view);
        // Get the location from the current Family object and set this on the TextView
        locationTextView.setText(currentActivity.getFamilyActivityLocation());

        //Find the TextView in the family_list_item.xml layout for description
        TextView descriptionTextView = listItemView.findViewById(R.id.family_description_text_view);
        // Get the description from the current Family object and set this on the TextView
        descriptionTextView.setText(currentActivity.getFamilyActivityDescription());

        // Find the ImageView in the Family_list_item.xml layout with the Id image
        ImageView imageView = listItemView.findViewById(R.id.family_activity_image_view);
        // Check if an image is provided for this word or not
        if (currentActivity.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView.setImageResource(currentActivity.getFamilyActivityImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.family_text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
