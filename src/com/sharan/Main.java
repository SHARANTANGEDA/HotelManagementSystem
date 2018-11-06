package com.sharan;


import com.sharan.ui.home.homePage.HomePage;

public class Main {

    public static int loginSuccess;
    public static int signUpSuccess;
    public static int starUpdate;
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();
        HomePage homePage=new HomePage(dataBaseController);
        dataBaseController.closeDatabaseConnection();




    }

}