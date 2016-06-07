import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setCursor(handCursor);
	}
	
	public void mouseExited(MouseEvent e) {
		e.getComponent().setCursor(defaultCursor);
	}

	Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
	Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
}

