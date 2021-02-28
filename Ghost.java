
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ghost extends Monster {

    private Random rdm = new Random();

    public Ghost(int sx, int sy, int s) {
        super(sx, sy, s);
    }

    public void drawMonster(Graphics g) { //draw ghosts
        int x = super.getX();
        int y = super.getY();
        int npts = 11;
        int xpts[] = {x, x + 5, x + 25, x + 30, x + 30, x + 25, x + 20, x + 15, x + 10, x + 5, x}; //order of coordinates does not matter
        int ypts[] = {y + 5, y, y, y + 5, y + 30, y + 25, y + 30, y + 25, y + 30, y + 25, y + 30};
        g.fillPolygon(xpts, ypts, npts);
    }

    public void handleBorderCollision() { //hit border then move opposite direction
        int x = super.getX();
        int y = super.getY();
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            reverseDirection();
        }
        updatePosition();
    }

    public void hunting(Ann a) {//pass player to know where is player
        int aX = a.getX();
        int aY = a.getY();
        int gX = super.getX();
        int gY = super.getY();
        int dir = rdm.nextInt(6);
        //2 numbers for hunting, 4 numbers for random movement
        if (dir == 0) {
            moveLeft();
        } else if (dir == 1) {
            moveUp();
        } else if (dir == 2) {
            moveRight();
        } else if (dir == 3) {
            moveDown();
        } else if (dir == 4) {
            if (gX < aX) {
                super.moveRight();
            } else {
                super.moveLeft();
            }
        } else if (dir == 5) {
            if (gY < aY) {
                super.moveDown();
            } else {
                super.moveUp();
            }
        }
    }
}
