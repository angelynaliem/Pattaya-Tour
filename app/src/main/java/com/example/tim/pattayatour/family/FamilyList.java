package com.example.tim.pattayatour.family;

public class FamilyList {

    // Family Activity
    private String mFamilyActivityName;

    // Activity Location
    private String mFamilyActivityLocation;

    // Activity Description
    private String mFamilyActivityDescription;

    //Image resource ID for the family activity
    private int mFamilyActivityImageResourceId;

    // Constant value that represents no image was provided for the activity
    private static final int NO_IMAGE_PROVIDED = -1;

    // String value for the web addresses
    private String mWebAddress;

    /**
     * Create a new family activity object
     *
     * @param familyActivityName            is the name of the activity
     * @param familyActivityLocation        is where the activity is located
     * @param familyActivityDescription     description of the activity
     * @param familyActivityImageResourceId is the resource ID for the activity
     * @param webAddress is the web site
     */
    public FamilyList(String familyActivityName, String familyActivityLocation, String familyActivityDescription,
                      int familyActivityImageResourceId, String webAddress) {
        mFamilyActivityName = familyActivityName;
        mFamilyActivityLocation = familyActivityLocation;
        mFamilyActivityDescription = familyActivityDescription;
        mFamilyActivityImageResourceId = familyActivityImageResourceId;
        mWebAddress = webAddress;
    }

    // Get the string resource ID for the activity name
    public String getFamilyActivityName() {
        return mFamilyActivityName;
    }

    // Get the string resource ID for the activity location
    public String getFamilyActivityLocation() {
        return mFamilyActivityLocation;
    }

    // get the string resource ID for the activity description
    public String getFamilyActivityDescription() {
        return mFamilyActivityDescription;
    }

    // Return image resource ID for the activity
    public int getFamilyActivityImageResourceId() {
        return mFamilyActivityImageResourceId;
    }

    // Returns whether there is an image for this activity
    public boolean hasImage() {
        return mFamilyActivityImageResourceId != NO_IMAGE_PROVIDED;
    }

    // Returns the web site for this Adult List
    public String getWebAddress() {
        return mWebAddress;
    }
}
