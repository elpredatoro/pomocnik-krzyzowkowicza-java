package elpredatoro.permutacje.components;

import javax.swing.JTextArea;

import elpredatoro.permutacje.components.frames.MainFrame;

public class OutputTextField extends JTextArea {
	private MainFrame main;
	
	public OutputTextField(MainFrame main, String value) {
		super(value, 20, 30);
		
		this.main = main;
		
		this.setEditable(false);
	}
}
