
import java.awt.Color;
import java.awt.Graphics;

public class Ann extends Monster {

    public Ann(int sx, int sy, int s) {
        super(sx, sy, s);
    }

    public void drawMonster(Graphics g) { //draw ann
        g.setColor(Color.YELLOW);
        int npts = 6;
        int x = super.getX();
        int y = super.getY();
        int x1 = x;
        int y1 = y;

        //x coordinates
        int x15 = x + 15;
        int x30 = x + 30;
        int x0 = x + 0;
        int x10 = x + 10;
        int x20 = x + 20;

        //y coordinates
        int y0 = y + 0;
        int y15 = y + 15;
        int y30 = y + 30;
        int y20 = y + 20;
        int y10 = y + 10;

        int dir = super.getDir();
        if (dir == 1) {//mouth to the left
            int xpts[] = {x15, x30, x15, x0, x15, x0}; //order of coordinates does not matter
            int ypts[] = {y0, y15, y30, y20, y15, y10};
            g.fillPolygon(xpts, ypts, npts);
        } else if (dir == 3) {//mouth to the right
            int xpts[] = {x15, x30, x15, x30, x15, x0};
            int ypts[] = {y0, y10, y15, y20, y30, y15};
            g.fillPolygon(xpts, ypts, npts);
        } else if (dir == 2) {//mouth face upwards
            int xpts[] = {x10, x15, x20, x30, x15, x0};
            int ypts[] = {y0, y15, y0, y15, y30, y15};
            g.fillPolygon(xpts, ypts, npts);
        } else if (dir == 4) {//mouth face downwards
            int xpts[] = {x15, x30, x20, x15, x10, x0};
            int ypts[] = {y0, y15, y30, y15, y30, y15};
            g.fillPolygon(xpts, ypts, npts);
        }

    }

    public boolean collideBorder() { //lose and stop game if collide border
        boolean collide = false;
        int x = super.getX(); //extract x and y from superclass
        int y = super.getY();
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            collide = true;
        }
        return collide;
    }

    public boolean collideGhost(Ghost g) { //lose and stop game if collide with ghost
        boolean collide = false;
        int ax = super.getX();
        int ay = super.getY();
        int gx = g.getX();
        int gy = g.getY();
        int sz = 30;
        if ((gx >= (ax - sz)) & (gx <= (ax + sz)) & (gy >= (ay - sz)) & (gy <= (ay + sz))) {
            //check within area of 30
            collide = true;
        }
        return collide;
    }
}
