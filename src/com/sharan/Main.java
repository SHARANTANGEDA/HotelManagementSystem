package com.sharan;


import com.sharan.ui.home.homePage.HomePage;

public class Main {

    public static int loginSuccess;
    public static int signUpSuccess;
    public static int starUpdate;
    public static int checkInCheckOutCheck;
    public static int viewToindividual;
    public static void main(String[] args) {

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.initialiseDatabase();
        HomePage homePage=new HomePage(dataBaseController);

//        HotelHomeAfterLogin hotelHomeAfterLogin=new HotelHomeAfterLogin();

//        MyAccount myAccount=new MyAccount();
//        ArrayList<String> list=new ArrayList<>();
//        list.add("final");
//        list.add("helo");
//        list.add("idjlvw");
//        list.add("status");
//        list.add("checkIndate");
//        list.add("checkoufa");
//        list.add("4");
//        list.add("2");
//        list.add("7");
//        list.add("Address");
//        list.add("3500");
//
//        String path="/home/sharan/Desktop";
//        PDFGenerator pdfGenerator=new PDFGenerator(list,path);
//        PDFSaveFileChooser pdfSaveFileChooser=new PDFSaveFileChooser();


//        PaymentPage paymentPage=new PaymentPage();
        dataBaseController.closeDatabaseConnection();




    }

}