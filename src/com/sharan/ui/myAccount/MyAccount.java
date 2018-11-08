/*
 * Created by JFormDesigner on Sat Nov 03 19:19:24 IST 2018
 */

package com.sharan.ui.myAccount;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.myAccount.renderers.GenerateRenderer;
import com.sharan.ui.myAccount.renderers.HeaderRenderer;
import com.sharan.ui.myAccount.renderers.LabelRenderer;
import com.sharan.ui.pdfSaveLocationPopUp.PDFSaveFileChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;


public class MyAccount {

    private String selectedBookingId;
    private DataBaseController dataBaseController;
    private ArrayList<String> list;
    private String pathPre;
    private String userName;
    private String hotelName;
    private String bookingId;
    private String bookingStatus;
    private String checkInDate;
    private String checkOutDate;
    private String standardRoom;
    private String deluxeRoom;
    private String suiteRoom;
    private String totalCost;
    private String address;
    private String bookingDate;

    public MyAccount(String userName,DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;
        this.userName=userName;


        initComponents();

        dataBaseController.initialiseDatabase();
        ArrayList<ColumnsInMyBooking> tableList=dataBaseController.getMyAccountTableRows();
        dataBaseController.closeDatabaseConnection();

        MyTableModel myTableModel=new MyTableModel(tableList);
        activeBookings.setModel(myTableModel);
        activeBookings.getTableHeader().setDefaultRenderer(new HeaderRenderer());

        for(int i=0;i<activeBookings.getColumnCount()-2;i++) {
            activeBookings.setDefaultRenderer(activeBookings.getColumnClass(i),new LabelRenderer());
        }
        activeBookings.getColumnModel().getColumn(activeBookings.getColumnCount()-1).setCellRenderer(new GenerateRenderer());

        myAccountField.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        myAccountField.setVisible(true);
        activeBookings.setCellSelectionEnabled(true);
        ListSelectionModel listSelectionModel=activeBookings.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this::cellSelectedInTable);

    }

    private void LogoutFieldActionPerformed(ActionEvent e) {
        myAccountField.dispose();
        HomePage homePage=new HomePage(dataBaseController);

    }

    private void cellSelectedInTable(ListSelectionEvent e) {
        int row=activeBookings.getSelectedRow();
        int column=activeBookings.getSelectedColumn();
        if(column==9) {

            selectedBookingId=(String) activeBookings.getValueAt(row,1);
            if(!selectedBookingId.isEmpty()) {
            dataBaseController.initialiseDatabase();
            list= dataBaseController.getPDFdetails(selectedBookingId);
            dataBaseController.closeDatabaseConnection();
            PDFSaveFileChooser fileChooser=new PDFSaveFileChooser(list);
            }

        }

    }


//    private TableCellRenderer getRenderer() {
//        return new DefaultTableCellRenderer(){
//            @Override
//            public Component getTableCellRendererComponent(JTable table,
//                                                           Object value, boolean isSelected, boolean hasFocus,
//                                                           int row, int column) {
//                Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
//
//
//
////                if("doc".equals(value)){
////                    tableCellRendererComponent.setBackground(Color.YELLOW);
////                } else  if("xlsx".equals(value)){
////                    tableCellRendererComponent.setBackground(Color.GREEN);
////                } else {
////                    tableCellRendererComponent.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
////                }
////                return tableCellRendererComponent;
//            }
//        };
//    }

    private void activeBookingsPropertyChange(PropertyChangeEvent e) {

    }



    private void homePageActionPerformed(ActionEvent e) {
        myAccountField.dispose();
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName,dataBaseController);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        myAccountField = new JFrame();
        menuBar = new JMenuBar();
        homePage = new JMenuItem();
        separator1 = new JSeparator();
        menu2 = new JMenu();
        LogoutField = new JMenuItem();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane2 = new JScrollPane();
        activeBookings = new JTable();
        GeneratePDF1 = new JButton();
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== myAccountField ========
        {
            Container myAccountFieldContentPane = myAccountField.getContentPane();

            //======== menuBar ========
            {
                menuBar.setPreferredSize(new Dimension(83, 50));
                menuBar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
                menuBar.setBackground(Color.darkGray);
                menuBar.setForeground(new Color(238, 238, 238));

                //---- homePage ----
                homePage.setText("Home Page");
                homePage.setBackground(Color.darkGray);
                homePage.setMaximumSize(new Dimension(115, 32767));
                homePage.setForeground(new Color(238, 238, 238));
                homePage.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/Home24.gif")));
                homePage.addActionListener(e -> homePageActionPerformed(e));
                menuBar.add(homePage);

                //---- separator1 ----
                separator1.setMaximumSize(new Dimension(1300, 500));
                separator1.setPreferredSize(new Dimension(0, 250));
                separator1.setMinimumSize(new Dimension(1, 50));
                menuBar.add(separator1);

                //======== menu2 ========
                {
                    menu2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                    //---- LogoutField ----
                    LogoutField.setText("Log Out");
                    LogoutField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    LogoutField.addActionListener(e -> LogoutFieldActionPerformed(e));
                    menu2.add(LogoutField);
                }
                menuBar.add(menu2);
            }
            myAccountField.setJMenuBar(menuBar);

            //---- label1 ----
            label1.setText("My Account");
            label1.setBackground(new Color(255, 204, 0));
            label1.setOpaque(true);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Dialog", Font.BOLD, 38));

            //======== scrollPane1 ========
            {

                //======== tabbedPane1 ========
                {

                    //======== panel1 ========
                    {

                        // JFormDesigner evaluation mark
                        panel1.setBorder(new javax.swing.border.CompoundBorder(
                            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                        //======== scrollPane2 ========
                        {

                            //---- activeBookings ----
                            activeBookings.setModel(new DefaultTableModel(
                                new Object[][] {
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                },
                                new String[] {
                                    "Hotel Name", "Booking Id", "Booking Status", "CheckIn Date", "CheckOut Date", "Number of Standard Rooms", "Number of DeluxeRooms", "Number Of SuiteRooms", "Total Price Paid", "Generate PDF"
                                }
                            ));
                            {
                                TableColumnModel cm = activeBookings.getColumnModel();
                                cm.getColumn(0).setPreferredWidth(140);
                                cm.getColumn(1).setPreferredWidth(120);
                                cm.getColumn(2).setPreferredWidth(140);
                                cm.getColumn(3).setPreferredWidth(115);
                                cm.getColumn(4).setPreferredWidth(130);
                                cm.getColumn(5).setPreferredWidth(230);
                                cm.getColumn(6).setPreferredWidth(210);
                                cm.getColumn(7).setPreferredWidth(200);
                                cm.getColumn(8).setPreferredWidth(130);
                                cm.getColumn(9).setPreferredWidth(115);
                            }
                            activeBookings.setRowHeight(78);
                            activeBookings.setCellSelectionEnabled(true);
                            activeBookings.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                            activeBookings.addPropertyChangeListener(e -> activeBookingsPropertyChange(e));
                            scrollPane2.setViewportView(activeBookings);
                        }

                        //---- GeneratePDF1 ----
                        GeneratePDF1.setText("Generate PDF");
                        GeneratePDF1.setBackground(new Color(153, 0, 0));
                        GeneratePDF1.setForeground(new Color(238, 238, 238));
                        GeneratePDF1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

                        //======== scrollPane3 ========
                        {

                            //---- textPane1 ----
                            textPane1.setBackground(new Color(238, 238, 238));
                            textPane1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 16));
                            textPane1.setText("**To Generate PDF of a booking please select booking-Id of that booking and  then click Generate PDF button below.");
                            textPane1.setForeground(Color.blue);
                            scrollPane3.setViewportView(textPane1);
                        }

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(819, 819, 819)
                                    .addComponent(GeneratePDF1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                    .addGap(276, 276, 276))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 1875, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(99, Short.MAX_VALUE))
                        );
                        panel1Layout.setVerticalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(GeneratePDF1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                    .addGap(59, 59, 59))
                        );
                    }
                    tabbedPane1.addTab("My Bookings", panel1);
                }
                scrollPane1.setViewportView(tabbedPane1);
            }

            GroupLayout myAccountFieldContentPaneLayout = new GroupLayout(myAccountFieldContentPane);
            myAccountFieldContentPane.setLayout(myAccountFieldContentPaneLayout);
            myAccountFieldContentPaneLayout.setHorizontalGroup(
                myAccountFieldContentPaneLayout.createParallelGroup()
                    .addGroup(myAccountFieldContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(myAccountFieldContentPaneLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1903, Short.MAX_VALUE))
                        .addContainerGap())
            );
            myAccountFieldContentPaneLayout.setVerticalGroup(
                myAccountFieldContentPaneLayout.createParallelGroup()
                    .addGroup(myAccountFieldContentPaneLayout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                        .addContainerGap())
            );
            myAccountField.pack();
            myAccountField.setLocationRelativeTo(myAccountField.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame myAccountField;
    private JMenuBar menuBar;
    private JMenuItem homePage;
    private JSeparator separator1;
    private JMenu menu2;
    private JMenuItem LogoutField;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane2;
    private JTable activeBookings;
    private JButton GeneratePDF1;
    private JScrollPane scrollPane3;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
