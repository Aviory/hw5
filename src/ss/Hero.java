package ss;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hero extends JPanel implements KeyListener {
    public final int START_RUN_Y = -315;
    private BufferedImage image;
    public final int START_X = -40;
    public final int START_Y = -25;
    public final int START_JAMP_Y = -155;
    private int currentX = START_X;
    private int currentY = START_Y;
    private HeroAnimated   heroAnimated;

    Hero(UI ui){
        ui.addKeyListener(this);
        try {
            image = ImageIO.read(new File("sprites.png")); // Замініть на свій шлях
        } catch (IOException e) {
            e.printStackTrace();
        }
        heroAnimated = new HeroAnimated(this);
        heroAnimated.start();
    }


    public int getBackX() {
        return currentX;
    }
    public void setBackX(int x) {
        this.currentX = x;
    }

    public int getBackY() {
        return currentY;
    }

    public void setBackY(int y) {
        this.currentY = y;
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, currentX, currentY, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 83:
                //System.out.println("s");
                heroAnimated.runAnim();
                break;
            case 87:
                //System.out.println("w");

                heroAnimated.jump();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
class HeroAnimated extends Thread{
    private Hero hero;
    private boolean isJump;
    private boolean isRun;

    public HeroAnimated(Hero hero) {
        this.hero = hero;
    }

    public void jump(){
        isJump = true;
    }

    @Override
    public void run() {
        while (true){
            isJump();
            isRun();
            baseSlides();
            hero.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void isRun() {
        if (isRun){
            isRun = false;
            hero.setBackX(hero.START_X);
            hero.setBackY(hero.START_RUN_Y);
        }
    }

    private void isJump() {
        if (isJump){
            isJump = false;
            hero.setBackX(hero.START_X);
            hero.setBackY(hero.START_JAMP_Y);
        }
    }

    private void baseSlides() {
        hero.setBackX(hero.getBackX()-142);
        if (hero.getBackX()<-128*5){
            hero.setBackX(hero.START_X);
            hero.setBackY(hero.START_Y);
        }
    }

    public void runAnim() {
        isRun = true;
    }
}
