package elpredatoro.permutacje.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import elpredatoro.permutacje.components.frames.MainFrame;

public class RightPanel extends JPanel {
	private MainFrame main;
	
	private int width = 385;
	private int height = 550;
	
	public RightPanel(MainFrame main) {
		super();
		
		this.main = main;
		
		this.setSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
//		this.setBackground(new Color(111, 111, 111));
	}
}
