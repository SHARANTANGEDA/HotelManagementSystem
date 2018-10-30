package com.sharan;


import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;

public class Main {
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();


//        HomePage homePage=new HomePage(dataBaseController);
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(dataBaseController);
        dataBaseController.closeDatabaseConnection();
    }

}