package com.example.tim.pattayatour.adult;

import android.content.Intent;

public class AdultList {

    // Soi name
    private String mSoiName;

    // Sexes
    private String mSexes;

    // Soi Description
    private String mSoiDescription;

    //Image resource ID for the Adult List
    private int mAdultImageResourceId1;

    //Image resource ID for the Adult List
    private int mAdultImageResourceId2;

    //Image resource ID for the Adult List
    private int mAdultImageResourceId3;

    //Image resource ID for the Adult List
    private int mAdultImageResourceId4;

    // Constant value that represents no image was provided for the Adult List
    private static final int NO_IMAGE_PROVIDED = -1;

    // String value for the web addresses
    private String mWebAddress;

    /**
     * Create a new airport object
     *
     * @param soiName               is the name of the soi
     * @param sexes                 what sexes work on that soi
     * @param soiDescription        description of the soi
     * @param adultImageResourceId1 is the resource ID for the soi
     * @param webAddress            is the web site
     */
    public AdultList(String soiName, String sexes, String soiDescription, int adultImageResourceId1, int adultImageResourceId2,
                     int adultImageResourceId3, int adultImageResourceId4, String webAddress) {
        mSoiName = soiName;
        mSexes = sexes;
        mSoiDescription = soiDescription;
        mAdultImageResourceId1 = adultImageResourceId1;
        mAdultImageResourceId2 = adultImageResourceId2;
        mAdultImageResourceId3 = adultImageResourceId3;
        mAdultImageResourceId4 = adultImageResourceId4;
        mWebAddress = webAddress;
    }

    // Get the string resource ID for the Soi name
    public String getSoiName() {
        return mSoiName;
    }

    // Get the string resource ID for the sexes
    public String getSexes() {
        return mSexes;
    }

    // get the string resource ID for the Soi Description
    public String getSoiDescription() {
        return mSoiDescription;
    }

    // Return image resource ID for the Adult List
    public int getAdultImageResourceId1() {
        return mAdultImageResourceId1;
    }

    // Return image resource ID for the Adult List
    public int getAdultImageResourceId2() {
        return mAdultImageResourceId2;
    }

    // Return image resource ID for the Adult List
    public int getAdultImageResourceId3() {
        return mAdultImageResourceId3;
    }

    // Return image resource ID for the Adult List
    public int getAdultImageResourceId4() {
        return mAdultImageResourceId4;
    }

    // Returns whether there is an image for this Adult List
    public boolean hasImage() {
        return mAdultImageResourceId1 != NO_IMAGE_PROVIDED;
    }

    // Returns the web site for this Adult List
    public String getWebAddress() {
        return mWebAddress;
    }
}
