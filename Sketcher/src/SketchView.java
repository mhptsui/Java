import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;


public class SketchView extends JComponent implements Observer {
	SketchView(Sketcher app) {
		this.app = app;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
	private Sketcher app;
}
