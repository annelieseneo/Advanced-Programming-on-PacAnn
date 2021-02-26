
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer aTimer;
    private int gameStatus = 0;     // 0 = waiting for start game
                                    // 1 = game running
                                    // 2 = game over
                                    // 3 = pause
    private Ann ann;
    private Ghost gho1, gho2, gho3; //3 ghosts
    private int score = 0;

    public GamePanel() {
        aTimer = new Timer(50, this); // 50 ms 0.05 sec or 20x per second
        reset();
        addKeyListener(this);
    }

    public void reset() { //restart game, reset position
        ann = new Ann(300, 500, 5);
        gho1 = new Ghost(300, 100, 5);
        gho2 = new Ghost(200, 100, 5);
        gho3 = new Ghost(400, 100, 5);
        score = 0;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gs) {
        gameStatus = gs;
    }

    public void startTimer() { //timer
        if (gameStatus == 0) {
            aTimer.start();
            gameStatus = 1;
        }
        if (gameStatus == 3) {
            aTimer.start();
            gameStatus = 1;
        }
    }

    public void paint(Graphics g) {

        if (gameStatus == 1) {
            score++;
            if (ann.collideBorder()) {
                gameStatus = 2;
            }
            if (ann.collideGhost(gho1)) {
                gameStatus = 2;
            }
            if (ann.collideGhost(gho2)) {
                gameStatus = 2;
            }
            if (ann.collideGhost(gho3)) {
                gameStatus = 2;
            }
            if (gameStatus != 2 & gameStatus != 3) {
                gho1.hunting(ann);
                gho2.hunting(ann);
                gho3.hunting(ann);
                ann.updatePosition();
                gho1.updatePosition();
                gho2.updatePosition();
                gho3.updatePosition();
                gho1.handleBorderCollision();
                gho2.handleBorderCollision();
                gho3.handleBorderCollision();
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.BLUE);
        g.fillRect(0, 600, 600, 30);
        ann.drawMonster(g);
        g.setColor(Color.CYAN); //blue ghost
        gho1.drawMonster(g);
        g.setColor(Color.RED); //red ghost
        gho2.drawMonster(g);
        g.setColor(Color.PINK); //pink ghost
        gho3.drawMonster(g);
        if (gameStatus == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("PRESS START TO BEGIN...", 220, 300);
        }
        if (gameStatus == 2) { //game over
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("G A M E  O V E R", 250, 300);
        }
        if (gameStatus == 3) { //pause
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("P A U S E D", 250, 300);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("S C O R E : " + score, 10, 620); //show score
    }

    public void actionPerformed(ActionEvent e) { //timer
        if (e.getSource() == aTimer) {
            repaint(0, 0, 600, 630);
            requestFocus();
        }
    }

    public void moveLeft() {
        ann.moveLeft();
    }

    public void moveRight() {
        ann.moveRight();
    }

    public void moveUp() {
        ann.moveUp();
    }

    public void moveDown() {
        ann.moveDown();
    }

    public void keyPressed(KeyEvent e) { //key movements
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            ann.moveLeft();
        } else if (keyCode == 38) {
            ann.moveUp();
        } else if (keyCode == 39) {
            ann.moveRight();
        } else if (keyCode == 40) {
            ann.moveDown();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
