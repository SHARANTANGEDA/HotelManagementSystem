package com.sharan;


import com.sharan.ui.HomePage;

public class Main {
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();


        HomePage homePage=new HomePage();
    }

}