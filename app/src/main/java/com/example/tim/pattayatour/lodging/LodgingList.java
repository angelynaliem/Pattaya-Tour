package com.example.tim.pattayatour.lodging;

public class LodgingList {

    //Image resource ID for the hotel
    private int mLodgingImageResourceId;

    // Constant value that represents no image was provided for the hotel
    private static final int NO_IMAGE_PROVIDED = -1;

    // String value for the web addresses
    private String mWebAddress;

    /**
     * Create a new hotel object
     *
     * @param lodgingImageResourceId is the resource ID for the hotel
     * @param webAddress web site for hotels
     */
    public LodgingList(int lodgingImageResourceId, String webAddress) {
        mLodgingImageResourceId = lodgingImageResourceId;
        mWebAddress = webAddress;
    }

    // Return image resource ID for the hotel
    public int getLodgingImageResourceId() {
        return mLodgingImageResourceId;
    }

    // Returns whether there is an image for this hotel
    public boolean hasImage() {
        return mLodgingImageResourceId != NO_IMAGE_PROVIDED;
    }

    // Returns the web site for this Adult List
    public String getWebAddress() {
        return mWebAddress;
    }
}
