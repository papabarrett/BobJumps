
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

public class BobJumpsMain implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    Dude bob;
    ArrayList<Block> blocks;

    public static void main(String[] args) throws Exception {
        new BobJumpsMain();
    }

    public BobJumpsMain() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        bob = new Dude();
        blocks = new ArrayList<Block>();

        for (int y = 0; y < 500; y += 100) {
            for (int x = 0; x < 500; x += 25) {
                if (Math.random() > .25) {
                    blocks.add(new Block(x, y));
                }
            }
        }

        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        if (blocks.get(blocks.size() - 1).y < 401) {
            for (int x = 0; x < 500; x += 25) {
                if (Math.random() > .10) {
                    blocks.add(new Block(x, 500));
                }
            }
        }
        for (Block block : blocks) {
            block.moveUp();
            block.moveUp();
        }

        bob.move(blocks);
        if(bob.getFoot().y>500){
            JOptionPane.showMessageDialog(frame, "You Escaped!!");
            System.exit(0);
        }

        //end your code for timer tick code
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bob.setDown(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bob.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            bob.setRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            bob.setLeft(true);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bob.setDown(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bob.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            bob.setRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            bob.setLeft(false);
        }
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 500);
            bob.draw(g);
            for (Block block : blocks) {
                block.draw(g);
            }

        }
    }
}
