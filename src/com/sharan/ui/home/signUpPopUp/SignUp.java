/*
 * Created by JFormDesigner on Mon Oct 29 21:09:04 IST 2018
 */

package com.sharan.ui.home.signUpPopUp;

import com.miginfocom.beans.*;
import com.miginfocom.beans.DateComboBean;
import com.sharan.DataBaseController;
import javax.swing.*;
import java.awt.*;


public class SignUp extends JPanel {
    DataBaseController dataBaseController;
    public SignUp(DataBaseController dataBaseController) {
        this.dataBaseController = dataBaseController;
        initComponents();

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        dialog1 = new JDialog();
        button1 = new JButton();
        PanField = new JTextField();
        slash = new JLabel();
        AadharField = new JTextField();
        emailField = new JTextField();
        stateField = new JTextField();
        localityField = new JTextField();
        houseNumberField = new JTextField();
        cityField = new JTextField();
        label13 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label10 = new JLabel();
        label9 = new JLabel();
        label8 = new JLabel();
        password = new JPasswordField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        Title = new JLabel();
        userName = new JTextField();
        dayBean = new DateComboBean();
        monthBean = new DateComboBean();
        dateSpinnerBean1 = new DateSpinnerBean();

        //======== dialog1 ========
        {
            Container dialog1ContentPane = dialog1.getContentPane();

            //---- button1 ----
            button1.setText("SIGN UP");

            //---- slash ----
            slash.setText("/");

            //---- label13 ----
            label13.setText("EMAIL ID");

            //---- label11 ----
            label11.setText("STATE");

            //---- label12 ----
            label12.setText("AADHAR/PAN CARD");

            //---- label10 ----
            label10.setText("CITY");

            //---- label9 ----
            label9.setText("AREA/LOCALITY");

            //---- label8 ----
            label8.setText("H.NO.");

            //---- label2 ----
            label2.setText("USER NAME");

            //---- label3 ----
            label3.setText("PASSWORD");

            //---- label4 ----
            label4.setText("DATE OF BIRTH");

            //---- label6 ----
            label6.setText("/");

            //---- label5 ----
            label5.setText("/");

            //---- label7 ----
            label7.setText("RESIDENTIAL ADDRESS:");

            //---- Title ----
            Title.setText("Sign Up");
            Title.setHorizontalAlignment(SwingConstants.CENTER);
            Title.setFont(Title.getFont().deriveFont(Title.getFont().getSize() + 19f));
            Title.setForeground(Color.red);

            //---- dayBean ----
            dayBean.setFont(new Font("Arial", Font.PLAIN, 16));
            dayBean.setDateFormatString("dd");
            dayBean.setCalendarField(java.util.Calendar.DAY_OF_MONTH);

            //---- monthBean ----
            monthBean.setFont(new Font("Arial", Font.PLAIN, 16));
            monthBean.setDateFormatString("MM");
            monthBean.setCalendarField(java.util.Calendar.MONTH);

            //---- dateSpinnerBean1 ----
            dateSpinnerBean1.setCalendarField(java.util.Calendar.YEAR);
            dateSpinnerBean1.setDateFormatString("yyyy");
            dateSpinnerBean1.setFont(new Font("Arial", Font.PLAIN, 16));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(Title, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(label7)
                                .addGap(0, 482, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(password, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addGap(221, 221, 221))
                                    .addGroup(GroupLayout.Alignment.LEADING, dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(GroupLayout.Alignment.LEADING, dialog1ContentPaneLayout.createSequentialGroup()
                                                .addComponent(dayBean, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(monthBean, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateSpinnerBean1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(userName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                        .addGap(223, 223, 223))))
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label9)
                                    .addComponent(label12)
                                    .addComponent(label13)
                                    .addComponent(label10)
                                    .addComponent(label11))
                                .addGap(61, 61, 61)
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(localityField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(houseNumberField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cityField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 222, Short.MAX_VALUE))
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                                .addComponent(AadharField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(slash, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PanField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(stateField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(69, Short.MAX_VALUE))))))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(Title, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(label2))
                                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(label3))
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                            .addComponent(monthBean, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(dateSpinnerBean1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                                .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))))))
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dayBean, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(label7)
                        .addGap(52, 52, 52)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(houseNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label9)
                            .addComponent(localityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(stateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label11))
                        .addGap(18, 18, 18)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(AadharField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(slash, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addComponent(label13)
                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog dialog1;
    private JButton button1;
    private JTextField PanField;
    private JLabel slash;
    private JTextField AadharField;
    private JTextField emailField;
    private JTextField stateField;
    private JTextField localityField;
    private JTextField houseNumberField;
    private JTextField cityField;
    private JLabel label13;
    private JLabel label11;
    private JLabel label12;
    private JLabel label10;
    private JLabel label9;
    private JLabel label8;
    private JPasswordField password;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label6;
    private JLabel label5;
    private JLabel label7;
    private JLabel Title;
    private JTextField userName;
    private DateComboBean dayBean;
    private DateComboBean monthBean;
    private DateSpinnerBean dateSpinnerBean1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
