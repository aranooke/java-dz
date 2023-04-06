package Fourthlab;

import javax.swing.*;

public class Fourth {
    public static void main() {
        JApplet applet = new MovingCircle();
        applet.init();
        JFrame frame = new JFrame("LAB4 Vasko Applet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(applet);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}