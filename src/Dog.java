import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Dog extends Animal  {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void paintAnimal(Graphics g) {
        // Голова
        g.setColor(Color.ORANGE);
        g.fillOval(100, 100, 100, 100);

        // Вуха
        g.setColor(Color.DARK_GRAY);
        g.fillOval(80, 120, 40, 60);
        g.fillOval(180, 120, 40, 60);

        // Очі
        g.setColor(Color.WHITE);
        g.fillOval(120, 130, 20, 20);
        g.fillOval(160, 130, 20, 20);
        g.setColor(Color.BLACK);
        g.fillOval(127, 137, 7, 7);
        g.fillOval(167, 137, 7, 7);

        // Ніс
        g.fillOval(145, 160, 15, 15);

        // Рот
        g.drawArc(130, 170, 40, 20, 0, -180);
    }


}
