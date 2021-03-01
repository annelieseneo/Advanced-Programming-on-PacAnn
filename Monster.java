
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Monster {

    private int x;
    private int dx = 0;
    private int y;
    private int dy = 0;
    private int speed;
    private int dir = 2;

    public Monster(int sx, int sy, int s) {
        x = sx;
        y = sy;
        speed = s;
    }

    public int getDir() { //direction
        return dir;
    }

    public int getX() { //x coordinate
        return x;
    }

    public int getY() { //y coordinate
        return y;
    }

    public void reverseDirection() { //hit border then move in opposite direction
        dx = -dx;
        dy = -dy;
    }

    public void updatePosition() {
        x = x + dx;
        y = y + dy;
    }

    public void moveLeft() { //move to the left
        dx = -speed;
        dy = 0;
        dir = 1;
    }

    public void moveRight() { //move to the right
        dx = speed;
        dy = 0;
        dir = 3;
    }

    public void moveUp() { //move upwards
        dx = 0;
        dy = -speed;
        dir = 2;
    }

    public void moveDown() { //move downwards
        dx = 0;
        dy = speed;
        dir = 4;
    }
}
