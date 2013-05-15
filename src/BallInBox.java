// File:   animation/bb/BouncingBall.java
// Description: This Graphics panel simulates a ball bouncing in a box.
//         Animation is done by changing instance variables
//         in the timer's actionListener, then calling repaint().
//         * Flicker can be reduced by drawing into a BufferedImage, 
//           and/or using a clip region.
//         * The edge of the oval could be antialiased (using Graphics2).
// Author: Fred Swartz
// Date:   February 2005

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

/////////////////////////////////////////////////////////////// BouncingBall
public class BallInBox extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6604060299572397495L;

	//============================================== fields
    //... Instance variables representing the ball.
    private Ball ball = new Ball(0, 0, 2, 3);
    
    //... Instance variables for the animiation
    private int interval  = 25;  // Milliseconds between updates.
    private Timer timer;           // Timer fires to anmimate one step.

    //========================================================== constructor
    /** Set panel size and creates timer. */
    public BallInBox() {
        setPreferredSize(new Dimension(200, 80));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timer = new Timer(interval, new TimerAction());
    }
    
    //========================================================= setAnimation
    /** Turn animation on or off.
     *@param turnOnOff Specifies state of animation.
     */
    public void setAnimation(boolean turnOnOff) {
        if (turnOnOff) {
            timer.start();  // start animation by starting the timer.
        } else {
            timer.stop();   // stop timer
        }
    }

    //======================================================= paintComponent
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Paint background, border
        ball.draw(g);           // Draw the ball.
    }
    
    //////////////////////////////////// inner listener class ActionListener
    class TimerAction implements ActionListener {
        //================================================== actionPerformed
        /** ActionListener of the timer.  Each time this is called,
         *  the ball's position is updated, creating the appearance of
         *  movement.
         *@param e This ActionEvent parameter is unused.
         */
        public void actionPerformed(ActionEvent e) {
            ball.setBounds(getWidth(), getHeight());
            ball.move();  // Move the ball.
            repaint();      // Repaint indirectly calls paintComponent.
        }
    }
}//endclass