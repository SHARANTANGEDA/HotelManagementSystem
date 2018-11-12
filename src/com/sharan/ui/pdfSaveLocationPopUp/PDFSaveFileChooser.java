/*
 * Created by JFormDesigner on Tue Nov 06 22:38:20 IST 2018
 */

package com.sharan.ui.pdfSaveLocationPopUp;

import com.sharan.PDFGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class PDFSaveFileChooser {
    private String pathPre;
    public PDFSaveFileChooser(ArrayList<String> list) {

        initComponents();
        if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            pathPre=fileChooser.getSelectedFile().toString();
            PDFGenerator pdfGenerator=new PDFGenerator(list,pathPre);
        }

    }

    public String getPathPre() {
        return pathPre;
    }

    private void thisActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        fileChooser = new JFileChooser();

        //---- fileChooser ----
        fileChooser.setDialogTitle("Choose Folder To Save The PDF file");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setOpaque(true);
        fileChooser.addActionListener(e -> thisActionPerformed(e));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFileChooser fileChooser;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
