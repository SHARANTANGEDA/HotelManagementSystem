/*
 * Created by JFormDesigner on Sat Nov 03 13:02:09 IST 2018
 */

package com.sharan.ui.home.signUpPopUp;

import com.sharan.DataBaseController;
import com.sharan.PasswordHashing;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import static com.sharan.Main.signUpSuccess;

/**
 * @author SAI SHARAN
 */
public class SignUp {
    private String name;
    private String hashedPassword;
    private String dob;
    private String aadhar;
    private String pan;
    private String phn;

    public String getName() {
        return name;
    }

    private String address;
    private String email;
    private int flag;
    private DataBaseController dataBaseController;
    private String id;
    private JButton toBeClicked;


    public SignUp(DataBaseController dataBaseController, JButton toBeClicked) {

        initComponents();

        SignUp.setVisible(true);
        this.toBeClicked=toBeClicked;
        this.dataBaseController = dataBaseController;
    }

    public JDialog getSignUp() {
        return SignUp;
    }


    public void getInformation()
    {
        name = userNameField.getText();
        PasswordHashing passwordHashing = new PasswordHashing();
        hashedPassword = passwordHashing.hashPassword(passwordField.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        xDatePicker1.setFormats(dateFormat);
        String unparsedDate=xDatePicker1.getDate().toString();

        StringBuilder sb=new StringBuilder();
        String date=unparsedDate.substring(4,7);
        String month=unparsedDate.substring(8,10);
        String year=unparsedDate.substring(24,28);

        sb.append(date);
        sb.append("/");
        sb.append(month);
        sb.append("/");
        sb.append(year);

        dob=sb.toString();
        System.out.println(dob);
        address = HNoInput.getText() + AreaInput.getText() +CityInput.getText()+StateInput.getText();
        aadhar = AadharInput.getText();
        pan = PanInput.getText();
        email = emailInput.getText();
        phn = phoneInput.getText();
        if(aadhar.equals(""))
        {
            id = pan+"p";
        }
        else if(pan.equals(""))
        {
            id = aadhar+"a";
        }
        else
        {
            id = aadhar+"a";
        }
    }


    public void Authenticate()
    {
        flag =0;
        String s= dataBaseController.checkUser(name);
        if(s.equals("s"))
        {
            JOptionPane.showMessageDialog(null,"UserName Already Exists");
            flag =1;
        }
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Name");
            flag =1;
        }
        else if(hashedPassword.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Password");
            flag =1;
        }
        else if(HNoInput.getText().equals("")||AreaInput.getText().equals("")||CityInput.getText().equals("")||StateInput.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Address");
            flag =1;
        }
        else if(pan.equals("")&&aadhar.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Aadhar or Pan Card Details");
            flag =1;
        }

        else if(phn.equals("")||phn.length()!=10||phn.matches(".*[a-zA-Z]+.*"))
        {
            JOptionPane.showMessageDialog(null,"Enter Valid PhoneNumber");
            flag =1;
        }
        else if(email.equals("")||!email.contains("@")||!email.contains(".com"))
        {
            JOptionPane.showMessageDialog(null,"Enter Valid EmailId");
            flag =1;
        }
    }


    private void signUpButtonActionPerformed(ActionEvent e) {
        getInformation();
        Authenticate();
        if(flag==0)
        {
            try {
                dataBaseController.initialiseDatabase();
                if(aadhar.equals(""))
                {
                    id = pan;
                }
                else if(pan.equals(""))
                {
                    id = aadhar;
                }
                else
                {
                    id = aadhar;
                }
                dataBaseController.addUser(name,hashedPassword,dob,address,email,id,phn);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            SignUp.dispose();
            signUpSuccess=1;
            toBeClicked.doClick();
        }

        dataBaseController.closeDatabaseConnection();

    }


    private void xDatePicker1ActionPerformed(ActionEvent e) {
        getInformation();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        SignUp = new JDialog();
        SignUpField = new JLabel();
        label1 = new JLabel();
        userName = new JLabel();
        password = new JLabel();
        dobField = new JLabel();
        addressField = new JLabel();
        userNameField = new JTextField();
        passwordField = new JPasswordField();
        xDatePicker1 = new JXDatePicker();
        HnoField = new JLabel();
        areaField = new JLabel();
        cityField = new JLabel();
        stateField = new JLabel();
        aadharField = new JLabel();
        emailField = new JLabel();
        HNoInput = new JTextField();
        AreaInput = new JTextField();
        CityInput = new JTextField();
        StateInput = new JTextField();
        AadharInput = new JTextField();
        PanInput = new JTextField();
        slashSeparator = new JLabel();
        emailInput = new JTextField();
        signUpButton = new JButton();
        phone = new JLabel();
        phoneInput = new JTextField();

        //======== SignUp ========
        {
            SignUp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container SignUpContentPane = SignUp.getContentPane();

            //---- SignUpField ----
            SignUpField.setText("Sign Up");
            SignUpField.setForeground(Color.red);
            SignUpField.setHorizontalAlignment(SwingConstants.CENTER);
            SignUpField.setFont(new Font("Times New Roman", Font.BOLD, 32));
            SignUpField.setBackground(new Color(255, 255, 51));
            SignUpField.setOpaque(true);

            //---- label1 ----
            label1.setText("Please enter the details below correctly to register with us:");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 1f));

            //---- userName ----
            userName.setText("User Name:");
            userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize() + 5f));

            //---- password ----
            password.setText("Password:");
            password.setFont(password.getFont().deriveFont(password.getFont().getSize() + 5f));

            //---- dobField ----
            dobField.setText("Date of Birth:");
            dobField.setFont(dobField.getFont().deriveFont(dobField.getFont().getSize() + 5f));

            //---- addressField ----
            addressField.setText("Residential Address:");
            addressField.setFont(addressField.getFont().deriveFont(addressField.getFont().getSize() + 5f));

            //---- userNameField ----
            userNameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            userNameField.setToolTipText("EnterUserName");

            //---- xDatePicker1 ----
            xDatePicker1.setInheritsPopupMenu(true);
            xDatePicker1.setOpaque(true);
            xDatePicker1.addActionListener(e -> xDatePicker1ActionPerformed(e));

            //---- HnoField ----
            HnoField.setText("H.No:");
            HnoField.setFont(HnoField.getFont().deriveFont(HnoField.getFont().getSize() + 5f));

            //---- areaField ----
            areaField.setText("Area/Locality:");
            areaField.setFont(areaField.getFont().deriveFont(areaField.getFont().getSize() + 5f));

            //---- cityField ----
            cityField.setText("City:");
            cityField.setFont(cityField.getFont().deriveFont(cityField.getFont().getSize() + 5f));

            //---- stateField ----
            stateField.setText("State:");
            stateField.setFont(stateField.getFont().deriveFont(stateField.getFont().getSize() + 5f));

            //---- aadharField ----
            aadharField.setText("Aadhar Card/Pan Card:");
            aadharField.setFont(aadharField.getFont().deriveFont(aadharField.getFont().getSize() + 5f));

            //---- emailField ----
            emailField.setText("Email Id:");
            emailField.setFont(emailField.getFont().deriveFont(emailField.getFont().getSize() + 5f));

            //---- HNoInput ----
            HNoInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            HNoInput.setToolTipText("EnterUserName");

            //---- AreaInput ----
            AreaInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            AreaInput.setToolTipText("EnterUserName");

            //---- CityInput ----
            CityInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            CityInput.setToolTipText("EnterUserName");

            //---- StateInput ----
            StateInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            StateInput.setToolTipText("EnterUserName");

            //---- AadharInput ----
            AadharInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            AadharInput.setToolTipText("EnterUserName");

            //---- PanInput ----
            PanInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            PanInput.setToolTipText("EnterUserName");

            //---- slashSeparator ----
            slashSeparator.setText("/");
            slashSeparator.setFont(slashSeparator.getFont().deriveFont(slashSeparator.getFont().getSize() + 11f));

            //---- emailInput ----
            emailInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            emailInput.setToolTipText("EnterUserName");

            //---- signUpButton ----
            signUpButton.setText("SIGN UP");
            signUpButton.setFont(signUpButton.getFont().deriveFont(signUpButton.getFont().getSize() + 5f));
            signUpButton.addActionListener(e -> signUpButtonActionPerformed(e));

            //---- phone ----
            phone.setText("Phone Number:");
            phone.setFont(phone.getFont().deriveFont(phone.getFont().getSize() + 5f));

            //---- phoneInput ----
            phoneInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            phoneInput.setToolTipText("EnterUserName");

            GroupLayout SignUpContentPaneLayout = new GroupLayout(SignUpContentPane);
            SignUpContentPane.setLayout(SignUpContentPaneLayout);
            SignUpContentPaneLayout.setHorizontalGroup(
                SignUpContentPaneLayout.createParallelGroup()
                    .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                        .addGroup(SignUpContentPaneLayout.createParallelGroup()
                            .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(password, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(SignUpContentPaneLayout.createParallelGroup()
                                    .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HNoInput, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AreaInput, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CityInput, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StateInput, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(userName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(SignUpField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                            .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SignUpContentPaneLayout.createParallelGroup()
                                    .addComponent(dobField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HnoField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stateField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                                                .addComponent(aadharField, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(AadharInput, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.LEADING, SignUpContentPaneLayout.createSequentialGroup()
                                                .addComponent(phone, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(slashSeparator, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PanInput, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            SignUpContentPaneLayout.setVerticalGroup(
                SignUpContentPaneLayout.createParallelGroup()
                    .addGroup(SignUpContentPaneLayout.createSequentialGroup()
                        .addComponent(SignUpField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(userName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(dobField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(xDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(HnoField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(HNoInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(areaField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(AreaInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cityField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(CityInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(stateField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(StateInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(aadharField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(AadharInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(slashSeparator)
                            .addComponent(PanInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(phone, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))
            );
            SignUp.pack();
            SignUp.setLocationRelativeTo(SignUp.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog SignUp;
    private JLabel SignUpField;
    private JLabel label1;
    private JLabel userName;
    private JLabel password;
    private JLabel dobField;
    private JLabel addressField;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JXDatePicker xDatePicker1;
    private JLabel HnoField;
    private JLabel areaField;
    private JLabel cityField;
    private JLabel stateField;
    private JLabel aadharField;
    private JLabel emailField;
    private JTextField HNoInput;
    private JTextField AreaInput;
    private JTextField CityInput;
    private JTextField StateInput;
    private JTextField AadharInput;
    private JTextField PanInput;
    private JLabel slashSeparator;
    private JTextField emailInput;
    private JButton signUpButton;
    private JLabel phone;
    private JTextField phoneInput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
