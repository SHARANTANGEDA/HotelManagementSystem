package com.sharan;


import com.sharan.ui.hotelView.hotelHome.HotelHomePage;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();


//        HomePage homePage=new HomePage(dataBaseController);
//        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(dataBaseController);
        HotelHomePage page=new HotelHomePage("h1",dataBaseController);




    }

}