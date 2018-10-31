package com.sharan;


import com.sharan.ui.home.homePage.HomePage;

public class Main {

    public static int loginSuccess;
    public static int signUpSuccess;
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();


        HomePage homePage=new HomePage(dataBaseController);
//        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(dataBaseController);
//        HotelHomePage page=new HotelHomePage("h1",dataBaseController);
//        HotelHomePageBeforeLogin hotelHomePageBeforeLogin=new HotelHomePageBeforeLogin("h1",dataBaseController);
        dataBaseController.closeDatabaseConnection();




    }

}