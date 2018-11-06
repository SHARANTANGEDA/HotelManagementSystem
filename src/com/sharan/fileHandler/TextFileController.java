package com.sharan.fileHandler;

import com.sharan.encryptionAlgorithms.AES128Encyrption;

import java.io.*;
import java.net.URL;


public class TextFileController {

    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;



    public TextFileController() {
    }

    public void writeToFile(String textToStore) {
        try {
            if(!textToStore.isEmpty()){
                String encryptedUserName=AES128Encyrption.encrypt(textToStore);
                URL url=getClass().getResource("userName.txt");
                fileWriter=new FileWriter(url.getPath());
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(encryptedUserName);
                bufferedWriter.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() {
        try {
            URL url=getClass().getResource("userName.txt");
            fileReader=new FileReader(url.getPath());
            bufferedReader=new BufferedReader(fileReader);
            String encryptedUserName=bufferedReader.readLine();
            String userName=AES128Encyrption.decrypt(encryptedUserName);
            bufferedReader.close();
            return userName;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
