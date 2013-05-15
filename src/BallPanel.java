import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BallPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6591380787666896975L;
	BallInBox ballInBox;   // The bouncing ball panel
    
    /** Creates a panel with the controls and bouncing ball display. */
    BallPanel() {
        //... Create components
    	ballInBox = new BallInBox();        
        JButton startButton = new JButton("Start");        
        JButton stopButton  = new JButton("Stop");
        
        //... Add Listeners
        startButton.addActionListener(new StartAction());
        stopButton.addActionListener(new StopAction());
        
        //... Layout inner panel with two buttons horizontally
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        
        //... Layout outer panel with button panel above bouncing ball
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(ballInBox, BorderLayout.CENTER);
    }
    
    class StartAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	ballInBox.setAnimation(true);
        }
    }
    
    class StopAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	ballInBox.setAnimation(false);
        }
    }
}