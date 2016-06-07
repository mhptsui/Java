import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class TestFrame {

	/**
	 * @param args
	 */
	static JFrame aFrame = new JFrame("This is a Frame");

	public static void main(String[] args) {
		Toolkit env = aFrame.getToolkit();
		Dimension screenSize = env.getScreenSize();
		
		aFrame.setBounds(screenSize.height/4, screenSize.height/4, screenSize.width/2, screenSize.height/2);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setVisible(true);
		System.out.println("main() terminated");
	}

}
