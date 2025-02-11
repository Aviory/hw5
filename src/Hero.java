import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hero extends JPanel implements KeyListener {
    private BufferedImage image;
    private int x = -40;
    Hero(){
        addKeyListener(this);
        try {
            image = ImageIO.read(new File("sprites.png")); // Замініть на свій шлях
        } catch (IOException e) {
            e.printStackTrace();
        }
        HeroAnimated   heroAnimated = new HeroAnimated(this);
        heroAnimated.start();
    }


    public int getBackX() {
        return x;
    }
    public void setBackX(int x) {
        this.x = x;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, x, -25, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()){
            case 83:
                HeroAnimated  heroAnimated = new HeroAnimated(this);
                heroAnimated.start();
                break;
            case 87:
                HeroAnimated  heroAnimated1 = new HeroAnimated(this);
                heroAnimated1.start();
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
class HeroAnimated extends Thread{
    private Hero hero;
    boolean b;
    public HeroAnimated(Hero hero) {
        this.hero = hero;
    }
    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true){

            hero.setBackX(hero.getBackX()-128);
            if (hero.getBackX()<-128*5)
                hero.setBackX(-40);
            hero.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
