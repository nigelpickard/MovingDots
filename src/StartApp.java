import javax.swing.JFrame;


public class StartApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BallFrame ballFrame = new BallFrame();
		ballFrame.setTitle("Ball animation");
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ballFrame.setSize(500, 500);
		ballFrame.add(new BallPanel()); // add MainPanel JPanel to JFrame
		ballFrame.setVisible(true); // show class

	}

}
