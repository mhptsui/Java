import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class SketchFrame extends JFrame {

	public SketchFrame(String title, Sketcher app) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		newAction = new FileAction("New", "Create a new sketch", KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		openAction = new FileAction("Open", "Open an existing sketch", KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		closeAction = new FileAction("Close", "Close the current sketch", KeyStroke.getKeyStroke('W', InputEvent.CTRL_DOWN_MASK));
		saveAction = new FileAction("Save", "Save the current sketch", KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
		saveAsAction = new FileAction("Save As...", "Save the current sketch as a different file");
		printAction = new FileAction("Print...", "Print the current sketch", KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
		
		lineAction = new TypeAction("Line", "Draw a line", TYPE_LINE);
		rectangleAction = new TypeAction("Rectangle", "Draw a rectangle", TYPE_RECTANGLE);
		circleAction = new TypeAction("Circle", "Draw a circle", TYPE_CIRCLE);
		curveAction = new TypeAction("Curve", "Draw a curve", TYPE_CURVE);
		
		redAction = new ColorAction("Red", "Draw in red", COLOR_RED);
		greenAction = new ColorAction("Green", "Draw in green", COLOR_GREEN);
		blueAction = new ColorAction("Blue", "Draw in blue", COLOR_BLUE);
		whiteAction = new ColorAction("White", "Draw in white", COLOR_WHITE);
		blackAction = new ColorAction("Black", "Draw in black", COLOR_BLACK);

		addMenuItem(fileMenu, newAction);
		addMenuItem(fileMenu, openAction);
		addMenuItem(fileMenu, closeAction);
		fileMenu.addSeparator();
		addMenuItem(fileMenu, saveAction);
		addMenuItem(fileMenu, saveAsAction);
		fileMenu.addSeparator();
		addMenuItem(fileMenu, printAction);
		
		addMenuItem(editMenu, lineAction);
		addMenuItem(editMenu, rectangleAction);
		addMenuItem(editMenu, circleAction);
		addMenuItem(editMenu, curveAction);
		editMenu.addSeparator();

		JMenu colorMenu = new JMenu("Color");
		editMenu.add(colorMenu);
		addMenuItem(colorMenu, redAction);
		addMenuItem(colorMenu, greenAction);
		addMenuItem(colorMenu, blueAction);
		addMenuItem(colorMenu, whiteAction);
		addMenuItem(colorMenu, blackAction);
		
		getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		
		addToolBarButton(toolBar, newAction);
		addToolBarButton(toolBar, openAction);
//		addToolBarButton(toolBar, closeAction);
		addToolBarButton(toolBar, saveAction);
		addToolBarButton(toolBar, saveAsAction);
		addToolBarButton(toolBar, printAction);
		toolBar.addSeparator();
		addToolBarButton(toolBar, lineAction);
		addToolBarButton(toolBar, rectangleAction);
		addToolBarButton(toolBar, circleAction);
		addToolBarButton(toolBar, curveAction);
		toolBar.addSeparator();		
		addToolBarButton(toolBar, redAction);
		addToolBarButton(toolBar, greenAction);
		addToolBarButton(toolBar, blueAction);
		addToolBarButton(toolBar, whiteAction);
		addToolBarButton(toolBar, blackAction);
	}
	private JMenuItem addMenuItem(JMenu menu, Action action) {
		JMenuItem item = menu.add(action);
//		item.setIcon(null);
		return item;
	}

	private JButton addToolBarButton(JToolBar toolBar, Action action) {
		JButton button = toolBar.add(action);
		return button;
	}

	private class FileAction extends AbstractAction {
		FileAction(String name, String tooltip) {
			super(name);
			putValue(Action.SHORT_DESCRIPTION, tooltip);
			putValue(Action.SMALL_ICON, new ImageIcon("resource/icon/"+name.toLowerCase().replaceAll("[ .]", "")+".gif"));
		}
		
		FileAction(String name, String tooltip, KeyStroke accelerator) {
			this(name, tooltip);
			putValue(Action.ACCELERATOR_KEY, accelerator);
		}

		public void actionPerformed(ActionEvent e) {
			
		}
	}

	private class TypeAction extends AbstractAction {
		TypeAction(String name, String tooltip, int typeID) {
			super(name);
			putValue(Action.SHORT_DESCRIPTION, tooltip);
			this.typeID = typeID;
		}
		
		public void actionPerformed(ActionEvent e) {
			elementType = this.typeID;
		}
		
		private int typeID;
	}

	private class ColorAction extends AbstractAction {
		ColorAction(String name, String tooltip, Color color) {
			super(name);
			putValue(Action.SHORT_DESCRIPTION, tooltip);
			this.color = color;
		}
		
		public void actionPerformed(ActionEvent e) {
			elementColor = this.color;
		}
		
		private Color color;
	}

	public static final int TYPE_LINE = 1, 
							TYPE_RECTANGLE = 2,
							TYPE_CIRCLE = 3,
							TYPE_CURVE = 4;

	public static final Color 	COLOR_RED = new Color(255, 0, 0),
	  							COLOR_GREEN = new Color(0, 255, 0),
	  							COLOR_BLUE = new Color(0, 0, 255),
	  							COLOR_WHITE = new Color(255, 255, 255),
	  							COLOR_BLACK = new Color(0, 0, 0);

	private FileAction newAction, openAction, closeAction, saveAction, saveAsAction, printAction;
	private TypeAction lineAction, rectangleAction, circleAction, curveAction;
	private ColorAction redAction, greenAction, blueAction, whiteAction, blackAction;
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar toolBar = new JToolBar();
	
	private int elementType = TYPE_LINE;
	private Color elementColor = COLOR_BLACK;
	
	private Sketcher app;
}
