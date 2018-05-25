package com.example.tim.pattayatour.adult;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.tim.pattayatour.R;

public class AdultPageAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    /**
     * Create a new {@link AdultPageAdapter} object
     *
     * @param context is the content of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes
     */
    public AdultPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // Return total number of pages

    @Override
    public int getCount() {
        return 4;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AdultInformationFragment();
        } else if (position == 1) {
            return new AdultSoiFragment();
        } else if (position == 2) {
            return new AdultPenthouseFragment();
        } else if (position == 3) {
            return new AdultLgbtFragment();
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
            return mContext.getString(R.string.soi);
        } else if (position == 2) {
            return mContext.getString(R.string.penthouse);
        } else if (position == 3) {
            return mContext.getString(R.string.lgbt);
        } else {
            return null;
        }
    }
}
