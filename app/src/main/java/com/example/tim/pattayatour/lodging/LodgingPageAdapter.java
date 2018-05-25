package com.example.tim.pattayatour.lodging;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.tim.pattayatour.R;

public class LodgingPageAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    /**
     * Create a new {@link LodgingPageAdapter} object
     *
     * @param context is the content of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes
     */
    public LodgingPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // Return total number of pages

    @Override
    public int getCount() {
        return 2;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LodgingInformationFragment();
        } else if (position == 1) {
            return new LodgingHotelsFragment();
        } else {
            return null;
        }
    }

    // Make the tab header reflect the page

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.information);
        } else if (position == 1) {
            return mContext.getString(R.string.hotel_tab);
        } else {
            return null;
        }
    }
}
