package elpredatoro.permutacje.components;

import java.awt.Dimension;

import javax.swing.JComboBox;
import elpredatoro.permutacje.components.frames.MainFrame;

public class SelectWordLength extends JComboBox<String> {
	private static final long serialVersionUID = 51101849526370386L;

	//private MainFrame main;
	
	private int width = 350;
	private int height = 30;
	
	public SelectWordLength(MainFrame main) {
		super();
		
		//this.main = main;
		
		for(int x=0; x<30; x++) {
			this.addItem(String.valueOf(x+1));
		}
		
		this.setPreferredSize(new Dimension(width, height));
	}
}
