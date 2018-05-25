package com.example.tim.pattayatour.shopping;

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

public class ShoppingAdapter extends ArrayAdapter<ShoppingList> {

    // Resource ID for the background color for the Shopping "group".
    private int mColorResourceId;

    /**
     * Create a new {@link ShoppingAdapter} object
     *
     * @param context         is the current context (i.e. "Activity") that the adapter is being created in
     * @param shopping        is the list of {@link ShoppingList}s to be displayed
     * @param colorResourceId is the resource ID for background color
     */
    public ShoppingAdapter(Context context, ArrayList<ShoppingList> shopping, int colorResourceId) {
        super(context, 0, shopping);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being used, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.shopping_list_item, parent, false);
        }

        // Get the {@link ShoppingList} object located at this position in the list
        ShoppingList currentMall = getItem(position);

        // Find the TextView in the shopping_list_item.xml layout for malls
        TextView shoppingTextView = listItemView.findViewById(R.id.shopping_center_text_view);
        // Get the activity_main_shopping name from the current Shopping object and set this text on the TextView
        shoppingTextView.setText(currentMall.getShoppingCenterName());

        // Find the TextView in the shopping_list_item.xml layout for location
        TextView locationTextView = listItemView.findViewById(R.id.shopping_location_text_view);
        // Get the location from the current Shopping object and set this on the TextView
        locationTextView.setText(currentMall.getShoppingCenterLocation());

        //Find the TextView in the shopping_list_item.xml layout for description
        TextView descriptionTextView = listItemView.findViewById(R.id.shopping_description_text_view);
        // Get the description from the current Shopping object and set this on the TextView
        descriptionTextView.setText(currentMall.getShoppingCenterDescription());

        // Find the ImageView in the Shopping_list_item.xml layout with the Id image
        ImageView imageView = listItemView.findViewById(R.id.shopping_image_view);
        // Check if an image is provided for this word or not
        if (currentMall.hasImage()) {
            // If an image is available, disply the image on the resource ID
            imageView.setImageResource(currentMall.getShoppingImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.shopping_text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
