package com.example.tim.pattayatour.airport;

/**
 * {@link AirportList} is the for the get there list item.
 * It has the airport name, city and web address
 */

public class AirportList {

    // Airport name
    private String mAirportName;

    // Airport City
    private String mAirportCity;

    // Airport web site
    private String mAirportWebSite;

    //Image resource ID for the airport
    private int mAirportImageResourceId;

    // Constant value that represents no image was provided for the airport
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new airport object
     *
     * @param airportName            is the name of the airport
     * @param airportCity            is the city the airport is located
     * @param airportWebSite         is the web site for the airports
     * @param airportImageResourceId is the resource ID for the airport
     */
    public AirportList(String airportName, String airportCity, String airportWebSite, int airportImageResourceId) {
        mAirportName = airportName;
        mAirportCity = airportCity;
        mAirportWebSite = airportWebSite;
        mAirportImageResourceId = airportImageResourceId;
    }

    // Get the string resource ID for the airport name
    public String getAirportName() {
        return mAirportName;
    }

    // Get the string resource ID for the airport city name
    public String getAirportCity() {
        return mAirportCity;
    }

    // get the string resource ID for the airport web site
    public String getAirportWebSite() {
        return mAirportWebSite;
    }

    // Return image resource ID for the airport
    public int getAirportImageResourceId() {
        return mAirportImageResourceId;
    }

    // Returns whether there is an image for this airport
    public boolean hasImage() {
        return mAirportImageResourceId != NO_IMAGE_PROVIDED;
    }

}
