package elpredatoro.permutacje.components;

import javax.swing.JTextField;

import elpredatoro.permutacje.components.frames.MainFrame;

public class InputTextField extends JTextField {
	private MainFrame main;
	
	public InputTextField(MainFrame main, String value) {
		super(value);
		
		this.main = main;
		
		this.setToolTipText("Wpisz szukane litery");
		this.setColumns(30);
	}
}
