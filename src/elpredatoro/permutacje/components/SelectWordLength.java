package elpredatoro.permutacje.components;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import elpredatoro.permutacje.components.frames.MainFrame;

public class SelectWordLength extends JComboBox<String> {
	private MainFrame main;
	
	private int width = 350;
	private int height = 30;
	
	public SelectWordLength(MainFrame main) {
		super();
		
		this.main = main;
		
		for(int x=0; x<15; x++) {
			this.addItem(String.valueOf(x+1));
		}
		
		this.setPreferredSize(new Dimension(width, height));
	}
}
