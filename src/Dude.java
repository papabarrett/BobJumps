
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jbarrett
 */
public class Dude extends Rectangle {

    boolean up, down, left, right, recentJump;
    int yVelocity;

    public Dude() {
        super(200, 200, 15, 30);
        up = down = left = right = recentJump = false;
        yVelocity = 1;
    }

    public Rectangle getFoot() {
        return new Rectangle(x, y + height - 1, width, 1);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setColor(Color.red);
        g.fillRect(getFoot().x, getFoot().y, getFoot().width, getFoot().height);
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }

    public void moveUp() {
        y--;
    }

    public void move(ArrayList<Block> blocks) {
        yVelocity++;
        if (yVelocity > 5) {
            yVelocity = 5;
        }
        if (right) {
            moveRight();
        }
        if (left) {
            moveLeft();
        }

        if (up && !recentJump) {
            yVelocity = -10;
            recentJump = true;
        }
        y += yVelocity;
        for (Block block : blocks) {

            while (block.getTop().intersects(getFoot())) {
//                System.out.println("Moving up cause the foot is in the wront spot");
//                System.out.println(block);
//                System.out.println(getFoot());
//                System.out.println(x+" "+y+" "+width+" "+height);
                moveUp();
                recentJump = false;
//                System.out.println(x+" "+y+" "+width+" "+height);
//                System.out.println(getFoot());
            }
        }

    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

}
