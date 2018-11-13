package com.sharan.fileHandler;

import com.sharan.encryptionAlgorithms.AES128Encyrption;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class TextFileController {

    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;



    public TextFileController() {
    }

    public void createFile() {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("userName.txt"), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String textToStore) {
        try {
            if(!textToStore.isEmpty()){
                String encryptedUserName=AES128Encyrption.encrypt(textToStore);
                URL url=getClass().getResource("userName.txt");
                File file=new File(url.getPath());
                fileWriter=new FileWriter(file);
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
