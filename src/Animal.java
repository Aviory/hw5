import javax.swing.*;
import java.awt.*;

public abstract class Animal extends JPanel {
    private String name = "Animal";

    public Animal(String name) {
        this.name = name;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintAnimal(g);
    }

    public abstract void paintAnimal(Graphics g);

}