package com.sharan.ui.myAccount;

import java.util.ArrayList;

public class ColumnsInMyBooking {
private String userName;
private String HotelName;
private String BookingId;
private String BookingStatus;
private String checkIn;
private String checkOut;
private String standardRooms;
private String deluxeRooms;
private String suiteRooms;
private String bookingDate;
private String totalPricePaid;
private String uniqueId;

public ColumnsInMyBooking(ArrayList<String> list) {
    this.userName = list.get(0);
    this.HotelName = list.get(1);
    this.BookingId = list.get(2);
    this.BookingStatus = list.get(3);
    this.checkIn = list.get(4);
    this.checkOut = list.get(5);
    this.standardRooms = list.get(6);
    this.deluxeRooms = list.get(7);
    this.suiteRooms = list.get(8);
    this.bookingDate = list.get(9);
    this.totalPricePaid = list.get(10);
    this.uniqueId = list.get(11);
    }
    public String getUniqueId()
    {
        return uniqueId;
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

    public String getBookingStatus() {
        return BookingStatus;
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

    public String getTotalPricePaid() {
        return totalPricePaid;
    }
}


