package com.sharan;


import com.sharan.ui.home.homePage.HomePage;

public class Main {

    public static int loginSuccess;
    public static int signUpSuccess;
    public static int starUpdate;
    public static int checkInCheckOutCheck;
    public static int viewToindividual;
    public static int loginToContinnueCheck;
    public static String carryBookingId="notLoaded";
    public static int callFromWaitingList=0;
    public static int callForWaitListToMyBooking=0;
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();
        HomePage homePage=new HomePage(dataBaseController);


        dataBaseController.closeDatabaseConnection();




    }

}