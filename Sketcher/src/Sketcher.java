import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Sketcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					sketcherApp = new Sketcher();
					sketcherApp.CreateGUI();
				}
			}
		);
	}
	
	
	private void CreateGUI() {
		window = new SketchFrame("Sketcher", this);

		Dimension screenSize = window.getToolkit().getScreenSize();
		window.setBounds(screenSize.width/4, screenSize.height/4, screenSize.width/2, screenSize.height/2);
		
		model = new SketchModel(this);
		view = new SketchView(this);
		model.addObserver(view);

		window.getContentPane().add(view, BorderLayout.CENTER);
		window.setVisible(true);
	}

	public SketchFrame getWindow() {
		return window;
	}

	public SketchModel getModel() {
		return model;
	}

	public SketchView getView() {
		return view;
	}
	
	private static Sketcher sketcherApp;
	private SketchFrame window;
	private SketchModel model;
	private SketchView view;
}
