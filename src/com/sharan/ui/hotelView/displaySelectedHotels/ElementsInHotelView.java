package com.sharan.ui.hotelView.displaySelectedHotels;

public class ElementsInHotelView {
    private String uniqueId;
    private String hotelName;
    private String hotelDescription;
    private String standardRoomPrice;
    private int standardRoomCapacity;
    private String deluxeRoomPrice;
    private int deluxeRoomCapacity;
    private String suiteRoomPrice;
    private int suiteRoomCapacity;
    private String imagePath;
    private String starRating;
    private int numberOfVotes;

    public ElementsInHotelView(String uniqueId,String hotelName,String hotelDescription,String standardRoomPrice,int standardRoomCapacity
                                ,String deluxeRoomPrice,int deluxeRoomCapacity,String suiteRoomPrice,int suiteRoomCapacity,String imagePath,
                               String starRating,int numberOfVotes) {

        this.uniqueId=uniqueId;
        this.hotelName=hotelName;
        this.hotelDescription=hotelDescription;
        this.standardRoomCapacity=standardRoomCapacity;
        this.standardRoomPrice=standardRoomPrice;
        this.deluxeRoomPrice=deluxeRoomPrice;
        this.deluxeRoomCapacity=deluxeRoomCapacity;
        this.suiteRoomPrice=suiteRoomPrice;
        this.suiteRoomCapacity=suiteRoomCapacity;
        this.imagePath=imagePath;
        this.starRating=starRating;
        this.numberOfVotes=numberOfVotes;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public String getStandardRoomPrice() {
        return standardRoomPrice;
    }

    public int getStandardRoomCapacity() {
        return standardRoomCapacity;
    }

    public String getDeluxeRoomPrice() {
        return deluxeRoomPrice;
    }

    public int getDeluxeRoomCapacity() {
        return deluxeRoomCapacity;
    }

    public String getSuiteRoomPrice() {
        return suiteRoomPrice;
    }

    public int getSuiteRoomCapacity() {
        return suiteRoomCapacity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getStarRating() {
        return starRating;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }
}
