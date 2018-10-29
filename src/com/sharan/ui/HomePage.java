package com.sharan.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class HomePage {
    private int FRAME_WIDTH=1500;
    private int FRAME_HEIGHT=1000;

    public HomePage () {
        JFrame frame=new JFrame("Online Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollBar vBar=new JScrollBar(JScrollBar.VERTICAL,0,40,0,200);
        vBar.setValueIsAdjusting(true);
        vBar.setBounds(FRAME_WIDTH-30,0,20,FRAME_HEIGHT);
        vBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {

            }
        });




        Container pane=frame.getContentPane();
        pane.setLayout(new BorderLayout(10,10));
        frame.setLayout(null);
        JLabel label=new JLabel();
        label.setText("Online Hotel Booking Portal");
        label.setForeground(Color.RED);
        label.setBackground(Color.YELLOW);
        label.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,36));
        label.setBounds(((FRAME_WIDTH/2)-250),10,500,40);

        JButton signIn=new JButton("LogIn");
        signIn.setBackground(Color.BLUE);
        signIn.addActionListener(e -> label.setText("Login"));
        signIn.setBounds(FRAME_WIDTH-250,10,100,40);
        signIn.setForeground(Color.WHITE);
        signIn.setFont(Font.getFont("TIMES NEW ROMAN"));

        JButton signUp=new JButton("Sign Up");
        signUp.setBackground(Color.BLUE);
        signUp.addActionListener(e -> label.setText("SignUp"));
        signUp.setBounds(FRAME_WIDTH-140,10,100,40);
        signUp.setForeground(Color.WHITE);
        signUp.setFont(Font.getFont("TIMES NEW ROMAN"));


        pane.add(signIn,BorderLayout.NORTH);
        pane.add(signUp,BorderLayout.NORTH);
        pane.add(label,BorderLayout.NORTH);
        pane.add(vBar,BorderLayout.EAST);

        frame.setResizable(false);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);

    }
}
