package com.sharan.ui;

import java.awt.*;

public class ImageCanvas extends Canvas {

    private String path=null;

    public ImageCanvas(String path) {
        this.path=path;
    }

    public void paint(Graphics graphics) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image image=t.getImage(path);
        graphics.drawImage(image,10,50,this);
    }
}
