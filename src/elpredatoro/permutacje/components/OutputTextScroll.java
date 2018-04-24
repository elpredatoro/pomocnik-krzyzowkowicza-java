package elpredatoro.permutacje.components;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import elpredatoro.permutacje.components.frames.MainFrame;

public class OutputTextScroll extends JScrollPane {
	private static final long serialVersionUID = -3843833462941825037L;

	//private MainFrame main;
	
	private int width = 360;
	private int height = 540;
	
	public OutputTextScroll(MainFrame main, JComponent component) {
		super(component);
		
		//this.main = main;
		
		this.setPreferredSize(new Dimension(width, height));
	}
}
