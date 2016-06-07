import java.util.Observable;


public class SketchModel extends Observable {
	public SketchModel(Sketcher app) {
		this.app = app;
	}
	private Sketcher app;
}
