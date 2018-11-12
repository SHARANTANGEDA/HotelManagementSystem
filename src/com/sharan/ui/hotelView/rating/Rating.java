/*
 * Created by JFormDesigner on Tue Oct 30 18:38:55 IST 2018
 */

package com.sharan.ui.hotelView.rating;

import com.sharan.DataBaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.SQLException;

import static com.sharan.Main.starUpdate;

/**
 * @author SAI SHARAN
 */
public class Rating extends JFrame {
    private DataBaseController dataBaseController;
    private int rate;
    private String uniqueId;

    private JButton tobeClicked;

    public JDialog getRater() {
        return rater;
    }

    public int getRate() {
        return rate;
    }


    public Rating(String id, DataBaseController dataBaseController, JButton tobeClicked) {
        this.dataBaseController=dataBaseController;
        this.uniqueId=id;
        this.tobeClicked=tobeClicked;
        if(starUpdate==1) {
            initComponents();
        }else {
            JOptionPane.showMessageDialog(null,"Thank You, Y");
        }
        rater.setVisible(true);
        rater.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        rater.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());


    }

    private void star1ItemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED) {
            star2.setSelected(false);
            star3.setSelected(false);
            star4.setSelected(false);
            star5.setSelected(false);
        }
        rate=1;
        try{
            dataBaseController.initialiseDatabase();
            dataBaseController.addRating(uniqueId,rate);
            dataBaseController.closeDatabaseConnection();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }



    }

    private void star2ItemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED) {
            star1.setSelected(false);
            star3.setSelected(false);
            star4.setSelected(false);
            star5.setSelected(false);
        }

        rate=2;
        try{
            dataBaseController.initialiseDatabase();
            dataBaseController.addRating(uniqueId,rate);
            dataBaseController.closeDatabaseConnection();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void star3ItemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED) {
            star1.setSelected(false);
            star2.setSelected(false);
            star4.setSelected(false);
            star5.setSelected(false);
        }

        rate=3;
        try{
            dataBaseController.initialiseDatabase();
            dataBaseController.addRating(uniqueId,rate);
            dataBaseController.closeDatabaseConnection();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void star4ItemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED) {
            star1.setSelected(false);
            star2.setSelected(false);
            star3.setSelected(false);
            star5.setSelected(false);
        }
        rate=4;
        try{
            dataBaseController.initialiseDatabase();
            dataBaseController.addRating(uniqueId,rate);
            dataBaseController.closeDatabaseConnection();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void star5ItemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED) {
            star1.setSelected(false);
            star2.setSelected(false);
            star3.setSelected(false);
            star4.setSelected(false);
        }

        rate=5;
        try{
            dataBaseController.initialiseDatabase();
            dataBaseController.addRating(uniqueId,rate);
            dataBaseController.closeDatabaseConnection();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void confirmActionPerformed(ActionEvent e) {
        rater.dispose();
        rater.setVisible(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        rater = new JDialog();
        star1 = new JCheckBox();
        star2 = new JCheckBox();
        star3 = new JCheckBox();
        star4 = new JCheckBox();
        Heading = new JLabel();
        star5 = new JCheckBox();
        confirm = new JButton();

        //======== rater ========
        {
            rater.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            rater.setVisible(true);
            Container raterContentPane = rater.getContentPane();

            //---- star1 ----
            star1.setText("Worst Experience");
            star1.setFont(new Font("Arial", Font.BOLD, 16));
            star1.addItemListener(e -> star1ItemStateChanged(e));

            //---- star2 ----
            star2.setText("Bad");
            star2.setFont(new Font("Arial", Font.BOLD, 16));
            star2.addItemListener(e -> star2ItemStateChanged(e));

            //---- star3 ----
            star3.setText("Good but can be improved");
            star3.setFont(new Font("Arial", Font.BOLD, 16));
            star3.addItemListener(e -> star3ItemStateChanged(e));

            //---- star4 ----
            star4.setText("Very Good");
            star4.setFont(new Font("Arial", Font.BOLD, 16));
            star4.addItemListener(e -> star4ItemStateChanged(e));

            //---- Heading ----
            Heading.setText("Rate Below");
            Heading.setForeground(new Color(254, 0, 27));
            Heading.setFont(new Font("Courier New", Font.BOLD, 33));
            Heading.setBackground(new Color(245, 255, 0));
            Heading.setHorizontalAlignment(SwingConstants.CENTER);
            Heading.setHorizontalTextPosition(SwingConstants.CENTER);
            Heading.setBorder(null);
            Heading.setOpaque(true);
            Heading.setAutoscrolls(true);
            Heading.setRequestFocusEnabled(false);

            //---- star5 ----
            star5.setText("Excellent");
            star5.setFont(new Font("Arial", Font.BOLD, 16));
            star5.addItemListener(e -> star5ItemStateChanged(e));

            //---- confirm ----
            confirm.setText("Confirm");
            confirm.setFont(new Font("Dialog", Font.BOLD, 18));
            confirm.addActionListener(e -> confirmActionPerformed(e));

            GroupLayout raterContentPaneLayout = new GroupLayout(raterContentPane);
            raterContentPane.setLayout(raterContentPaneLayout);
            raterContentPaneLayout.setHorizontalGroup(
                raterContentPaneLayout.createParallelGroup()
                    .addGroup(raterContentPaneLayout.createSequentialGroup()
                        .addGroup(raterContentPaneLayout.createParallelGroup()
                            .addGroup(raterContentPaneLayout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(Heading, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(raterContentPaneLayout.createSequentialGroup()
                                .addContainerGap(160, Short.MAX_VALUE)
                                .addComponent(star4)
                                .addGap(44, 44, 44)
                                .addComponent(star5)
                                .addGap(161, 161, 161))
                            .addGroup(GroupLayout.Alignment.TRAILING, raterContentPaneLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(star1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(star2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(star3)))
                        .addGap(39, 39, 39))
                    .addGroup(raterContentPaneLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(confirm)
                        .addContainerGap(253, Short.MAX_VALUE))
            );
            raterContentPaneLayout.setVerticalGroup(
                raterContentPaneLayout.createParallelGroup()
                    .addGroup(raterContentPaneLayout.createSequentialGroup()
                        .addComponent(Heading, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(raterContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(star3)
                            .addComponent(star2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(star1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(raterContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(star4)
                            .addComponent(star5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirm, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addContainerGap())
            );
            rater.pack();
            rater.setLocationRelativeTo(rater.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog rater;
    private JCheckBox star1;
    private JCheckBox star2;
    private JCheckBox star3;
    private JCheckBox star4;
    private JLabel Heading;
    private JCheckBox star5;
    private JButton confirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
