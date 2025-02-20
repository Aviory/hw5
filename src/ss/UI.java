package ss;

import javax.swing.*;
import java.awt.*;


public class UI extends JFrame {

    public UI(){
        setSize(1300, 1100);
        setLayout(null);
        setBackground(new Color(0, 0, 0));
        JPanel label = new Hero(this);
        label.setBounds(150, 150, 128, 128);

        add(label);
        setVisible(true);
    }




}


