package com.sharan;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PDFGenerator {
    private String path;
    private String name;
    private String hotelName;
    private String bookingStatus;
    private String checkInDate;
    private String checkOutDate;
    private String standardRoom;
    private String deluxeRoom;
    private String suiteRoom;
    private String bookingId;
    private String address;
    private String totalCost;
    private String bookingDate;
    private String contactUs="Incase of any query ContactUs at DawnBreakers@support.com\n"+"Or call us at +91-9876543210.";
    private String ThankYouNote="Thank You For choosing us, We are always at your service \n"+"**********VISIT US AGAIN************";

    public PDFGenerator(ArrayList<String> bookingDetails, String path) {
        this.name=bookingDetails.get(0);
        this.hotelName=bookingDetails.get(1);
        this.bookingId=bookingDetails.get(2);
        this.bookingStatus=bookingDetails.get(3);
        this.checkInDate=bookingDetails.get(4);
        this.checkOutDate=bookingDetails.get(5);
        this.standardRoom=bookingDetails.get(6);
        this.deluxeRoom=bookingDetails.get(7);
        this.suiteRoom=bookingDetails.get(8);
        this.address=bookingDetails.get(9);
        this.totalCost=bookingDetails.get(10);
        this.bookingDate=bookingDetails.get(11);


        this.path=path+"/"+bookingId+".pdf";
        File file=new File(path);
        file.getParentFile().mkdirs();
        generatePDF();
    }

    public void generatePDF() {
        try {

            Document document=new Document(PageSize.A4);


            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();


             Font normal = new Font(Font.FontFamily.COURIER, 14);
            Font title = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.BOLD);
            title.setColor(BaseColor.BLUE);

            Font addressTitleFont=new Font(Font.FontFamily.COURIER,18,Font.ITALIC);
            addressTitleFont.setColor(BaseColor.BLUE);
            Font bottomFont=new Font(Font.FontFamily.COURIER,12);
            bottomFont.setColor(BaseColor.GREEN);


            PdfPTable table=new PdfPTable(1);
            PdfPCell cell=new PdfPCell();

            Paragraph titleParagraph=new Paragraph();
            Chunk titleLine=new Chunk("Booking Details",title);
            titleParagraph.add(titleLine);
            titleParagraph.add("\n\n\n\n\n");
            titleParagraph.setAlignment(Element.ALIGN_TOP);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);


            cell.addElement(titleParagraph);



            Paragraph primaryDetails=new Paragraph();
            Chunk nameField=new Chunk  ("Name:                            "+name+"\n",normal);
            Chunk hotelField=new Chunk ("Hotel Name:                      "+hotelName+"\n",normal);
            Chunk reference=new Chunk  ("Booking Id reference Number:     "+bookingId+"\n",normal);
            Chunk bookingSTAT=new Chunk("Booking Status:                  "+bookingStatus+"\n",normal);
            Chunk checkIn=new Chunk    ("CheckIn Date:                    "+checkInDate+"\n",normal);
            Chunk checkOut=new Chunk   ("CheckOut Date:                   "+checkOutDate+"\n",normal);
            Chunk stanRooms=new Chunk  ("Number of standard Rooms Booked: "+standardRoom+"\n",normal);
            Chunk delRooms=new Chunk   ("Number of Deluxe Rooms Booked:   "+deluxeRoom+"\n",normal);
            Chunk suiteRooms=new Chunk ("Number of  suite Rooms Booked:   "+suiteRoom+"\n",normal);
            Chunk pricefield=new Chunk ("Total Amount inclusive of taxes: "+totalCost+"Rs"+"\n",normal);

            primaryDetails.add(nameField);
            primaryDetails.add(hotelField);
            primaryDetails.add(reference);
            primaryDetails.add(bookingSTAT);
            primaryDetails.add(checkIn);
            primaryDetails.add(checkOut);
            primaryDetails.add(stanRooms);
            primaryDetails.add(delRooms);
            primaryDetails.add(suiteRooms);
            primaryDetails.add(pricefield);
            primaryDetails.add("\n\n\n\n\n");
            primaryDetails.setAlignment(Element.ALIGN_MIDDLE);
            primaryDetails.setAlignment(Element.ALIGN_JUSTIFIED);


            cell.addElement(primaryDetails);


            Paragraph addressPara=new Paragraph();
            Chunk chunk=new Chunk("Address of Hotel:\n",addressTitleFont);
            addressPara.add(chunk);
            Chunk addressFont=new Chunk(address,normal);
            addressPara.add(addressFont);
            addressPara.add("\n\n\n\n");
            addressPara.setAlignment(Element.ALIGN_LEFT);


            cell.addElement(addressPara);


            Paragraph bottomToast=new Paragraph();
            Chunk b1=new Chunk(ThankYouNote,bottomFont);
            Chunk b2=new Chunk(contactUs,bottomFont);
            bottomToast.add(b1);
            bottomToast.add("\n");
            bottomToast.add(b2);
            bottomToast.setAlignment(Element.ALIGN_BOTTOM);
            bottomToast.setAlignment(Element.ALIGN_CENTER);

            cell.addElement(bottomToast);

            table.addCell(cell);


            document.add(table);

            document.close();




        }catch (IOException | DocumentException e) {
e.printStackTrace();        }
    }
}
