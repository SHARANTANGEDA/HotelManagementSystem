package com.sharan;


import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;

public class Main {

    public static int loginSuccess;
    public static int signUpSuccess;
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();
        HomePageAfterLogin homePageAfterLogin= new HomePageAfterLogin(dataBaseController);
   //     HomePage homePage=new HomePage(dataBaseController);
        dataBaseController.closeDatabaseConnection();




    }

}