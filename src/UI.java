import javax.swing.*;

public class UI extends JFrame {
    UI(){
        super("Calculator");
        this.setSize(800, 900);

        this.setVisible(true);
    }

    public void setAnimal(Animal animal) {
        add(animal);
    }
}
