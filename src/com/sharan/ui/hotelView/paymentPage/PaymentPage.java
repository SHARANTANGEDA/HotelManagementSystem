/*
 * Created by JFormDesigner on Wed Nov 07 07:49:29 IST 2018
 */

package com.sharan.ui.hotelView.paymentPage;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.plaf.*;

/**
 * @author SAI SHARAN
 */
public class PaymentPage {
    public PaymentPage() {
        initComponents();
        paymentPage.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        paymentPage = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tabbedPane2 = new JTabbedPane();
        panel2 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        aadharField = new JTextField();
        confirmPaymenaadhar = new JButton();
        label6 = new JLabel();
        button1 = new JButton();
        panel1 = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        aadharField2 = new JTextField();
        confirmPaymenaadhar2 = new JButton();
        label9 = new JLabel();
        button3 = new JButton();
        button2 = new JButton();

        //======== paymentPage ========
        {
            paymentPage.setBackground(Color.white);
            Container paymentPageContentPane = paymentPage.getContentPane();

            //---- label1 ----
            label1.setText("Payment ");
            label1.setBackground(new Color(255, 204, 0));
            label1.setOpaque(true);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Dialog", Font.BOLD, 38));

            //---- label2 ----
            label2.setText("Safe & Secure");
            label2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/secure-payment64.png")));
            label2.setFont(new Font("Arial", Font.BOLD, 16));
            label2.setBorder(LineBorder.createBlackLineBorder());
            label2.setBackground(Color.white);
            label2.setOpaque(true);

            //---- label3 ----
            label3.setText("AES 128bit Encrypted");
            label3.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/AES50.png")));
            label3.setFont(new Font("Arial", Font.BOLD, 16));
            label3.setBorder(LineBorder.createBlackLineBorder());
            label3.setBackground(Color.white);
            label3.setOpaque(true);

            //======== tabbedPane2 ========
            {

                //======== panel2 ========
                {
                    panel2.setBackground(Color.white);

                    // JFormDesigner evaluation mark
                    panel2.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                    //---- label4 ----
                    label4.setText("Please Enter Your Aadhar Card or Pan Card details below to make Payment");
                    label4.setFont(new Font("Arial Black", Font.BOLD, 16));
                    label4.setForeground(new Color(0, 0, 197));

                    //---- label5 ----
                    label5.setText("Aadhar-Card:");
                    label5.setFont(new Font("Arial", Font.BOLD, 16));

                    //---- aadharField ----
                    aadharField.setBackground(Color.white);
                    aadharField.setToolTipText("Enter-Aadhar Number");

                    //---- confirmPaymenaadhar ----
                    confirmPaymenaadhar.setText("Confirm Payment");
                    confirmPaymenaadhar.setBackground(new Color(204, 0, 0));
                    confirmPaymenaadhar.setForeground(new Color(238, 238, 238));
                    confirmPaymenaadhar.setFont(new Font("Arial Black", Font.BOLD, 20));

                    //---- label6 ----
                    label6.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/lock-icon.png")));

                    //---- button1 ----
                    button1.setText("Cancel Payment");
                    button1.setBackground(new Color(204, 0, 0));
                    button1.setForeground(Color.white);
                    button1.setFont(new Font("Arial Black", Font.BOLD, 20));

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addContainerGap(332, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(aadharField, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label6))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(224, 224, 224)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                            .addComponent(confirmPaymenaadhar, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))))
                                .addGap(323, 323, 323))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(aadharField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addComponent(confirmPaymenaadhar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addGap(38, 38, 38))
                    );
                }
                tabbedPane2.addTab("Aadhar-Card", panel2);

                //======== panel1 ========
                {
                    panel1.setBackground(Color.white);

                    //---- label7 ----
                    label7.setText("Please Enter Your Aadhar Card or Pan Card details below to make Payment");
                    label7.setFont(new Font("Arial Black", Font.BOLD, 16));
                    label7.setForeground(new Color(0, 0, 197));

                    //---- label8 ----
                    label8.setText("Pan-Card:");
                    label8.setFont(new Font("Arial", Font.BOLD, 16));

                    //---- aadharField2 ----
                    aadharField2.setBackground(Color.white);
                    aadharField2.setToolTipText("Enter Pan-Number");

                    //---- confirmPaymenaadhar2 ----
                    confirmPaymenaadhar2.setText("Confirm Payment");
                    confirmPaymenaadhar2.setBackground(new Color(204, 0, 0));
                    confirmPaymenaadhar2.setForeground(new Color(238, 238, 238));
                    confirmPaymenaadhar2.setFont(new Font("Arial Black", Font.BOLD, 20));

                    //---- label9 ----
                    label9.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/payment/lock-icon.png")));

                    //---- button3 ----
                    button3.setText("Cancel Payment");
                    button3.setBackground(new Color(204, 0, 0));
                    button3.setForeground(Color.white);
                    button3.setFont(new Font("Arial Black", Font.BOLD, 20));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(340, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)
                                        .addGap(315, 315, 315))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(aadharField2, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(label9)
                                        .addGap(434, 434, 434))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(confirmPaymenaadhar2, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
                                        .addGap(564, 564, 564))))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(aadharField2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addComponent(confirmPaymenaadhar2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                    );
                }
                tabbedPane2.addTab("Pan-Card", panel1);
            }

            //---- button2 ----
            button2.setText("Go to HomePage");
            button2.setBackground(new Color(204, 0, 0));
            button2.setForeground(Color.white);
            button2.setFont(new Font("Arial", Font.BOLD, 16));
            button2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/Home24.gif")));

            GroupLayout paymentPageContentPaneLayout = new GroupLayout(paymentPageContentPane);
            paymentPageContentPane.setLayout(paymentPageContentPaneLayout);
            paymentPageContentPaneLayout.setHorizontalGroup(
                paymentPageContentPaneLayout.createParallelGroup()
                    .addGroup(paymentPageContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paymentPageContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(GroupLayout.Alignment.TRAILING, paymentPageContentPaneLayout.createSequentialGroup()
                                .addComponent(button2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                            .addComponent(tabbedPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 1430, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            paymentPageContentPaneLayout.setVerticalGroup(
                paymentPageContentPaneLayout.createParallelGroup()
                    .addGroup(paymentPageContentPaneLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paymentPageContentPaneLayout.createParallelGroup()
                            .addGroup(paymentPageContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedPane2)
                        .addGap(15, 15, 15))
            );
            paymentPage.pack();
            paymentPage.setLocationRelativeTo(paymentPage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame paymentPage;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTabbedPane tabbedPane2;
    private JPanel panel2;
    private JLabel label4;
    private JLabel label5;
    private JTextField aadharField;
    private JButton confirmPaymenaadhar;
    private JLabel label6;
    private JButton button1;
    private JPanel panel1;
    private JLabel label7;
    private JLabel label8;
    private JTextField aadharField2;
    private JButton confirmPaymenaadhar2;
    private JLabel label9;
    private JButton button3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
