
import java.awt.*;

public class Ball {
    //... Constants
    final static int DIAMETER = 21;
    
    //... Instance variables
    private int x;           // x and y coordinates upper left
    private int y;
    
    private int velocityX;   // Pixels to move each time move() is called.
    private int velocityY;
    
    private int rightBound;  // Maximum permissible x, y values.
    private int bottomBound;
    
    public Ball(int x, int y, int velocityX, int velocityY) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }
    
    public void setBounds(int width, int height) {
        rightBound  = width  - DIAMETER;
        bottomBound = height - DIAMETER;
    }
    
    public void move() {
        //... Move the ball at the give velocity.
        x += velocityX;
        y += velocityY;        
        
        //... Bounce the ball off the walls if necessary.
        if (x < 0) {                  // If at or beyond left side
            x         = 0;            // Place against edge and
            velocityX = -velocityX; // reverse direction.
            
        } else if (x > rightBound) { // If at or beyond right side
            x         = rightBound;    // Place against right edge.
            velocityX = -velocityX;  // Reverse direction.
        }
        
        if (y < 0) {                 // if we're at top
            y       = 0;
            velocityY = -velocityY;
            
        } else if (y > bottomBound) { // if we're at bottom
            y       =  bottomBound;
            velocityY = -velocityY;
        }
    }
    
    public void draw(Graphics g) {
    	if (x == rightBound || x ==0){
    		g.fillRect(x, y, DIAMETER, DIAMETER);
    		g.clearRect(x, y, DIAMETER-2, DIAMETER-2);
    	}else if (y == bottomBound || y ==0){
    		g.fillRect(x, y, DIAMETER, DIAMETER);
    		g.clearRect(x, y, DIAMETER-2, DIAMETER-2);
    	}else{
    		g.fillOval(x, y, DIAMETER, DIAMETER);
    		g.setColor(Color.WHITE);
    		g.fillOval(x, y, DIAMETER-2, DIAMETER-2);
    		g.setColor(Color.BLACK);
    	}
    }
    
    public int  getDiameter() { 
    	return DIAMETER;
    }
    
    public int  getX() { 
    	return x;
    }
    
    public int  getY() { 
    	return y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}