package com.sharan;


import java.util.ArrayList;

public class Main {

    public static int loginSuccess;
    public static int signUpSuccess;
    public static int starUpdate;
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();
//        HomePage homePage=new HomePage(dataBaseController);

        ArrayList<String> list=new ArrayList<>();
        list.add("test");
        list.add("testHotel");
        list.add("test4");
        list.add("Confirmed");
        list.add("12/12/2018");
        list.add("30/12/2018");
        list.add("5");
        list.add("8");
        list.add("3");

        list.add("guttalabegumpet hydderf vlvwrlbebetbnenlw;belmlsbrbbrbrb\n"+"niorwnwbsl;kbrybtyne");
        String path="/home/sharan/Desktop/";
        PDFGenerator pdfGenerator=new PDFGenerator(list,path);

        dataBaseController.closeDatabaseConnection();




    }

}