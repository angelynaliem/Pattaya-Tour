package com.example.tim.pattayatour.lodging;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.example.tim.pattayatour.R;
import java.util.ArrayList;

public class LodgingAdapter extends ArrayAdapter<LodgingList> {

    // Resource ID for the background color for the Shopping "group".
    private int mColorResourceId;

    /**
     * Create a new {@link LodgingAdapter} object
     *
     * @param context         is the current context (i.e. "Activity") that the adapter is being created in
     * @param lodging         is the list of {@link LodgingList}s to be displayed
     * @param colorResourceId is the resource ID for background color
     */
    public LodgingAdapter(Context context, ArrayList<LodgingList> lodging, int colorResourceId) {
        super(context, 0, lodging);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being used, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.lodging_list_item, parent, false);
        }

        // Get the {@link LodgingList} object located at this position in the list
        LodgingList currentHotel = getItem(position);

        // Find the ImageView in the Lodging_list_item.xml layout with the Id image
        ImageView imageView = listItemView.findViewById(R.id.lodging_list_image_view);
        // Check if an image is provided for this hotel or not
        if (currentHotel.hasImage()) {
            // If an image is available, display the image on the resource ID
            imageView.setImageResource(currentHotel.getLodgingImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.lodging_text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
