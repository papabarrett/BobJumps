
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbarrett
 */
public class Block extends Rectangle{

    public Block(int i, int i1) {
        super(i, i1, 25, 25);
    }
    
    public void draw(Graphics g){
        g.setColor(new Color( 0, 128, 128));
        g.drawRect(x, y, width, height);
    }
    
    public Rectangle getTop(){
        return new Rectangle(x,y,width,8);
    }
    public void moveUp() {
        y--;
    }
    
}
