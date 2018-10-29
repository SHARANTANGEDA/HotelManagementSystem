package com.sharan.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends Canvas {
    private int FRAME_WIDTH = 1500;
    private int FRAME_HEIGHT = 750;
    public String stateSelected = null;


    public HomePage() {
        JFrame frame = new JFrame("Online Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout(10, 10));
        frame.setLayout(null);
        JLabel label = new JLabel();
        label.setText("Online Hotel Booking Portal");
        label.setForeground(Color.RED);
        label.setBackground(Color.YELLOW);
        label.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 36));
        label.setBounds(((FRAME_WIDTH / 2) - 250), 10, 500, 40);


        JButton signIn = new JButton("LogIn");
        signIn.setBackground(Color.BLUE);
        signIn.addActionListener(e -> label.setText("Login"));
        signIn.setBounds(FRAME_WIDTH - 250, 10, 100, 40);
        signIn.setForeground(Color.WHITE);
        signIn.setFont(Font.getFont("TIMES NEW ROMAN"));

        JButton signUp = new JButton("Sign Up");
        signUp.setBackground(Color.BLUE);
        signUp.addActionListener(e -> label.setText("SignUp"));
        signUp.setBounds(FRAME_WIDTH - 140, 10, 100, 40);
        signUp.setForeground(Color.WHITE);
        signUp.setFont(Font.getFont("TIMES NEW ROMAN"));


        String states[] = {"Telangana", "Andhra Pradesh", "Maharastra", "Delhi"};
        JComboBox stateComboBox = new JComboBox(states);
        stateComboBox.setBounds(25, FRAME_HEIGHT - 100, 200, 50);
        stateComboBox.setFont(new Font("Arial", Font.PLAIN, 18));




        JButton stateConfirmer = new JButton("Confirm State");
        stateConfirmer.setBackground(Color.BLUE);
        stateConfirmer.setBounds(235, FRAME_HEIGHT - 100, 100, 25);
        stateConfirmer.setForeground(Color.WHITE);
        stateConfirmer.setFont(Font.getFont("TIMES NEW ROMAN"));
        stateConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateSelected = stateComboBox.getItemAt(stateComboBox.getSelectedIndex()).toString();
            }
        });
//        JComboBox city=null;
//        switch (stateSelected) {
//            case "Telangana":{
//                String cities[]={"Hyderabad", "Warangal","KarimNagar","Kammam"};
//                city=new JComboBox(cities);
//                city.setBounds(345, FRAME_HEIGHT - 100, 200, 50);
//                city.setFont(new Font("Arial", Font.PLAIN, 18));
//                break;
//            }
////            case ""
//        }



        pane.add(stateConfirmer,BorderLayout.SOUTH);
        pane.add(signIn, BorderLayout.NORTH);
        pane.add(signUp, BorderLayout.NORTH);
        pane.add(label, BorderLayout.NORTH);
        pane.add(stateComboBox, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);


    }


}
