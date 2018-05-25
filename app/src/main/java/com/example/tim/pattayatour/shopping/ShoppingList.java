package com.example.tim.pattayatour.shopping;

public class ShoppingList {

    // Shopping Center name
    private String mShoppingCenterName;

    // Shopping Center Location
    private String mShoppingCenterLocation;

    // shopping Center Description
    private String mShoppingCenterDescription;

    //Image resource ID for the shopping center
    private int mShoppingImageResourceId;

    // Constant value that represents no image was provided for the shopping center
    private static final int NO_IMAGE_PROVIDED = -1;

    // String value for the web addresses
    private String mWebAddress;

    /**
     * Create a new shopping object
     *
     * @param shoppingCenterName        is the name of the shopping center
     * @param shoppingCenterLocation    is where the shopping center is located
     * @param shoppingCenterDescription description of the shopping center
     * @param shoppingImageResourceId   is the resource ID for the shopping center
     * @param webAddress web site for shopping center
     */
    public ShoppingList(String shoppingCenterName, String shoppingCenterLocation, String shoppingCenterDescription,
                        int shoppingImageResourceId, String webAddress) {
        mShoppingCenterName = shoppingCenterName;
        mShoppingCenterLocation = shoppingCenterLocation;
        mShoppingCenterDescription = shoppingCenterDescription;
        mShoppingImageResourceId = shoppingImageResourceId;
        mWebAddress = webAddress;
    }

    // Get the string resource ID for the shopping center name
    public String getShoppingCenterName() {
        return mShoppingCenterName;
    }

    // Get the string resource ID for the shopping center location
    public String getShoppingCenterLocation() {
        return mShoppingCenterLocation;
    }

    // get the string resource ID for the shopping center description
    public String getShoppingCenterDescription() {
        return mShoppingCenterDescription;
    }

    // Return image resource ID for the shopping center
    public int getShoppingImageResourceId() {
        return mShoppingImageResourceId;
    }

    // Returns whether there is an image for this airport
    public boolean hasImage() {
        return mShoppingImageResourceId != NO_IMAGE_PROVIDED;
    }

    // Returns the web site for this Adult List
    public String getWebAddress() {
        return mWebAddress;
    }
}
