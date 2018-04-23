package elpredatoro.permutacje.components;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import elpredatoro.permutacje.components.frames.MainFrame;

public class SelectWordLength extends JComboBox<String> {
	private MainFrame main;
	
	public SelectWordLength(MainFrame main) {
		super();
		
		this.main = main;
		
		for(int x=0; x<15; x++) {
			this.addItem(String.valueOf(x+1));
		}
	}
}
