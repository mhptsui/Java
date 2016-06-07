import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class LotteryApplet extends JApplet {
	public void init() {
		SwingUtilities.invokeLater(
					new Runnable() {
						public void run() {
							createGUI();
						}
					}
				);
	}
	
	private void createGUI() {
		Container content = getContentPane();
		content.setLayout(new GridLayout(0, 1));
		
		JPanel choicesPanel = new JPanel();
		choicesPanel.setBorder(
				BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(), 
						"Choices"
				)
		);
		choicesPanel.setLayout(new GridLayout(0, 3));
		generateSeries();
		for (int i=0; i<numChoices; i++) {
			buttonArray[i] = new Selection(choices[i], i);
			choicesPanel.add(buttonArray[i]);
		}
		content.add(choicesPanel);

		JPanel controlPanel = new JPanel();
		JButton regenButton = new JButton("Regenerate");
		regenButton.setBorder(BorderFactory.createRaisedBevelBorder());
		regenButton.setPreferredSize(new Dimension(100, 50));
		regenButton.addMouseListener(new MouseHandler());
		regenButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					generateSeries();
					for (int i=0; i<numChoices; i++) {
						buttonArray[i].setText(Integer.toString(choices[i]));
					}
				}
			}
		);
		controlPanel.add(regenButton);
		content.add(controlPanel);		
	}
	
	private void generateSeries() {
		for (int i=0; i<numChoices; i++) {
			boolean collided;
			int candidate;
			do {
				collided = false;
				candidate = domain[random.nextInt(domain.length)];
				for (int j=0; j<i && !collided; j++) {
					 collided = (candidate==choices[j]);
				}	// j
			} while (collided);
			choices[i] = candidate;
		}	// i
		Arrays.sort(choices);
	}
	
	public class Selection extends JButton implements ActionListener {
		public Selection(Integer value, Integer index) {
			super(value.toString());
			this.index = index;
			addActionListener(this);
			setPreferredSize(new Dimension(100, 50));
			addMouseListener(new MouseHandler());
		}
		
		public void actionPerformed(ActionEvent e) {
			boolean collided;
			int candidate;
			do {
				collided = false;
				candidate = domain[random.nextInt(domain.length)];
				for (int i=0; (i<numChoices) && (!collided); i++) {
					collided = (candidate==choices[i]);
				}
			} while (collided);

			setText(Integer.toString(candidate));
			choices[this.index] = candidate;
		}

		private Integer index = 0;
	}
	
	public final static int minValue = 1;
	public final static int maxValue = 45;
	public final static int numChoices = 6;
	public final static int[] domain = new int[maxValue-minValue+1];
	static {
		for (int i=0; i<domain.length; i++) {
			domain[i] = i+minValue;
		}
	}
	public static Random random = new Random(); 
	
	int[] choices = new int[numChoices];
	Selection[] buttonArray = new Selection[numChoices];
}
