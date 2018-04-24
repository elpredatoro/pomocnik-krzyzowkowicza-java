package elpredatoro.permutacje.components;

import java.awt.Dimension;

import javax.swing.JPanel;
import elpredatoro.permutacje.components.frames.MainFrame;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 2267056001267027881L;

	//private MainFrame main;
	
	private int width = 385;
	private int height = 550;
	
	public LeftPanel(MainFrame main) {
		super();
		
		//this.main = main;
		
		this.setSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
	}
}
