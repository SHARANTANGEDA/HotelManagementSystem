package com.sharan.ui.myAccount;

import java.util.ArrayList;

public class ColumnsInWaitingList {
    private String userName;
    private String HotelName;
    private String BookingId;
    private String checkIn;
    private String checkOut;
    private String standardRooms;
    private String deluxeRooms;
    private String suiteRooms;
    private String bookingDate;

    public ColumnsInWaitingList(ArrayList<String> list) {
        this.userName = list.get(0);
        this.HotelName = list.get(1);
        this.BookingId = list.get(2);
        this.checkIn = list.get(3);
        this.checkOut = list.get(4);
        this.standardRooms = list.get(5);
        this.deluxeRooms = list.get(6);
        this.suiteRooms = list.get(7);
        this.bookingDate = list.get(8);
    }

    public String getUserName() {
        return userName;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getBookingId() {
        return BookingId;
    }


    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getStandardRooms() {
        return standardRooms;
    }

    public String getDeluxeRooms() {
        return deluxeRooms;
    }

    public String getSuiteRooms() {
        return suiteRooms;
    }

    public String getBookingDate() {
        return bookingDate;
    }

}

