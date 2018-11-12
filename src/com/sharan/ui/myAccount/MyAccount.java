/*
 * Created by JFormDesigner on Sat Nov 03 19:19:24 IST 2018
 */

package com.sharan.ui.myAccount;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.myAccount.customTableProperties.renderers.ButtonRenderer;
import com.sharan.ui.myAccount.customTableProperties.renderers.HeaderRenderer;
import com.sharan.ui.myAccount.customTableProperties.renderers.LabelRenderer;
import com.sharan.ui.myAccount.customTableProperties.tableModels.MyBookingTableModel;
import com.sharan.ui.myAccount.customTableProperties.tableModels.WaitingListTableModel;
import com.sharan.ui.pdfSaveLocationPopUp.PDFSaveFileChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.sharan.Main.callFromWaitingList;
import static com.sharan.Main.carryBookingId;


public class MyAccount {

    private String selectedBookingId;
    private DataBaseController dataBaseController;
    private ArrayList<String> list;
//    private String pathPre;
    private String userName;
//    private String hotelName;
//    private String bookingId;
//    private String bookingStatus;
//    private String checkInDate;
//    private String checkOutDate;
//    private String standardRoom;
//    private String deluxeRoom;
//    private String suiteRoom;
//    private String totalCost;
//    private String address;
//    private String bookingDate;
//    private String uniqueId;
   private ArrayList<ColumnsInMyBooking> tableList;
   private ArrayList<ColumnsInWaitingList> waitList;

    public MyAccount(String userName,DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;
        this.userName=userName;


        initComponents();

        dataBaseController.initialiseDatabase();
        tableList=dataBaseController.getMyAccountTableRows(userName);

        waitList=dataBaseController.getWaitingListTableRows(userName);
        dataBaseController.closeDatabaseConnection();

        MyBookingTableModel myBookingTableModel =new MyBookingTableModel(tableList);
        WaitingListTableModel waitingListTableModel=new WaitingListTableModel(waitList);

        activeBookings.setModel(myBookingTableModel);
        activeBookings.getTableHeader().setDefaultRenderer(new HeaderRenderer());

        for(int i=0;i<activeBookings.getColumnCount()-3;i++) {
            activeBookings.setDefaultRenderer(activeBookings.getColumnClass(0),new LabelRenderer());
        }
        activeBookings.getColumnModel().getColumn(activeBookings.getColumnCount()-2).setCellRenderer(new ButtonRenderer());
        activeBookings.getColumnModel().getColumn(activeBookings.getColumnCount()-1).setCellRenderer(new ButtonRenderer());

        waitingListTable.setModel(waitingListTableModel);
        waitingListTable.getTableHeader().setDefaultRenderer(new HeaderRenderer());

        for(int i=0;i<waitingListTable.getColumnCount()-3;i++) {
            waitingListTable.setDefaultRenderer(activeBookings.getColumnClass(0),new LabelRenderer());
        }
        waitingListTable.getColumnModel().getColumn(waitingListTable.getColumnCount()-2).setCellRenderer(new ButtonRenderer());
        waitingListTable.getColumnModel().getColumn(waitingListTable.getColumnCount()-1).setCellRenderer(new ButtonRenderer());



        myAccountField.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        myAccountField.setVisible(true);

        activeBookings.setCellSelectionEnabled(true);
        ListSelectionModel listSelectionModel=activeBookings.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(this::cellSelectedInTable);

        waitingListTable.setCellSelectionEnabled(true);
        ListSelectionModel listSelectionModelWaitList=waitingListTable.getSelectionModel();
        listSelectionModelWaitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModelWaitList.addListSelectionListener(this::cellSelectedTableWaitList);



    }



    private void LogoutFieldActionPerformed(ActionEvent e) {
        myAccountField.dispose();
        HomePage homePage=new HomePage(dataBaseController);

    }

    private void cellSelectedTableWaitList(ListSelectionEvent e) {

    }

    private void cellSelectedInTable(ListSelectionEvent e) {


    }




    private void homePageActionPerformed(ActionEvent e) {
        myAccountField.dispose();
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName,dataBaseController);
    }

    private void activeBookingsMouseClicked(MouseEvent e) {
        int row = activeBookings.getSelectedRow();
        int column = activeBookings.getSelectedColumn();
        System.out.println(column);
        if (column == 11) {

            selectedBookingId = (String) activeBookings.getValueAt(row, 1);
            if (!selectedBookingId.isEmpty()) {
                dataBaseController.initialiseDatabase();
                list = dataBaseController.getPDFdetails(selectedBookingId);
                dataBaseController.closeDatabaseConnection();
                PDFSaveFileChooser fileChooser = new PDFSaveFileChooser(list);
            }

        }

        if (column == 10) {


            dataBaseController.initialiseDatabase();
            dataBaseController.cancelBookingFromWaitList(tableList.get(row).getBookingId(), tableList.get(row).getUniqueId()
                    , tableList.get(row).getCheckIn(), tableList.get(row).getCheckOut(),
                    Integer.parseInt(tableList.get(row).getStandardRooms()), Integer.parseInt(tableList.get(row).getDeluxeRooms()),
                    Integer.parseInt(tableList.get(row).getSuiteRooms()), tableList.get(row).getBookingDate());
            dataBaseController.closeDatabaseConnection();

            myAccountField.dispose();
            MyAccount myAccount=new MyAccount(userName,dataBaseController);


        }
    }

    private void waitingListTableMouseClicked(MouseEvent e) {

        int row = waitingListTable.getSelectedRow();
        int column = waitingListTable.getSelectedColumn();
        System.out.println(column);

        if (column == 8) {
            dataBaseController.initialiseDatabase();
            dataBaseController.cancelBooking(waitList.get(row).getBookingId(), waitList.get(row).getUniqueId(), waitList.get(row).getCheckIn(), waitList.get(row).getCheckOut(),
                    Integer.parseInt(waitList.get(row).getStandardRooms()), Integer.parseInt(waitList.get(row).getDeluxeRooms()),
                    Integer.parseInt(waitList.get(row).getSuiteRooms()), waitList.get(row).getBookingDate());
            dataBaseController.closeDatabaseConnection();
            myAccountField.dispose();
            MyAccount myAccount = new MyAccount(userName, dataBaseController);

        }
        if (column == 9) {
            dataBaseController.initialiseDatabase();
            ArrayList<String> list = dataBaseController.getWholeData(waitList.get(row).getUniqueId());
            callFromWaitingList = 1;
            carryBookingId = waitList.get(row).getBookingId();
            dataBaseController.checkAvailable(userName, waitList.get(row).getUniqueId(), waitList.get(row).getCheckIn(), waitList.get(row).getCheckOut(),
                    Integer.parseInt(waitList.get(row).getStandardRooms()), Integer.parseInt(waitList.get(row).getDeluxeRooms()),
                    Integer.parseInt(waitList.get(row).getSuiteRooms()), Integer.parseInt(list.get(4)), Integer.parseInt(list.get(7)),
                    Integer.parseInt(list.get(10)));


            dataBaseController.closeDatabaseConnection();
            myAccountField.dispose();
        }
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
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();
        panel2 = new JPanel();
        scrollPane4 = new JScrollPane();
        waitingListTable = new JTable();

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
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null, null},
                                },
                                new String[] {
                                    "Hotel Name", "Booking Id", "Booking Status", "CheckIn Date", "CheckOut Date", "Number of Standard Rooms", "Number of DeluxeRooms", "Number Of SuiteRooms", "Total Price Paid", "Cancel Booking", "Generate PDF"
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
                                cm.getColumn(10).setPreferredWidth(115);
                            }
                            activeBookings.setRowHeight(78);
                            activeBookings.setCellSelectionEnabled(true);
                            activeBookings.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                            activeBookings.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    activeBookingsMouseClicked(e);
                                }
                            });
                            scrollPane2.setViewportView(activeBookings);
                        }

                        //======== scrollPane3 ========
                        {

                            //---- textPane1 ----
                            textPane1.setBackground(Color.white);
                            textPane1.setFont(new Font("Georgia", Font.BOLD, 20));
                            textPane1.setText("** If you wish to cancel the booking process please note that      \n1.If cancellation date is 3 days or more than checkIn Date No cancellation charge will be taken\n2.If cancellation date is less than 3 days 50% of booking amount will be deducted as cancellation charges\n3.If booking is cancelled after checkIn date No refund will be initiated");
                            textPane1.setForeground(Color.blue);
                            scrollPane3.setViewportView(textPane1);
                        }

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 2020, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 2014, Short.MAX_VALUE)
                                            .addContainerGap())))
                        );
                        panel1Layout.setVerticalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane1.addTab("My Bookings", panel1);

                    //======== panel2 ========
                    {

                        //======== scrollPane4 ========
                        {

                            //---- waitingListTable ----
                            waitingListTable.setRowHeight(81);
                            waitingListTable.setModel(new DefaultTableModel(
                                new Object[][] {
                                    {null, null, null, null, null, null, null, null, null, null},
                                    {null, null, null, null, null, null, null, null, null, null},
                                },
                                new String[] {
                                    null, null, null, null, null, null, null, null, null, null
                                }
                            ));
                            waitingListTable.setCellSelectionEnabled(true);
                            waitingListTable.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    waitingListTableMouseClicked(e);
                                }
                            });
                            scrollPane4.setViewportView(waitingListTable);
                        }

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 1996, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(24, Short.MAX_VALUE))
                        );
                        panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 837, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(23, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane1.addTab("Waiting List", panel2);
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
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 2018, Short.MAX_VALUE))
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
    private JScrollPane scrollPane3;
    private JTextPane textPane1;
    private JPanel panel2;
    private JScrollPane scrollPane4;
    private JTable waitingListTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
