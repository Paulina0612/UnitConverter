package unitconverter;

import javax.swing.JFrame;

public class Frame extends JFrame {
    private int WIDTH=600;
    private int HEIGHT=400;

    public Frame(){
        Panel panel = new Panel();
        this.setSize(WIDTH, HEIGHT);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Unit Converter");
        this.setVisible(true);
    }
}
