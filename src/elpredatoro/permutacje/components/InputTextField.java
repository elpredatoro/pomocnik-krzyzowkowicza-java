package elpredatoro.permutacje.components;

import java.awt.Dimension;

import javax.swing.JTextField;

import elpredatoro.permutacje.components.frames.MainFrame;

public class InputTextField extends JTextField {
	private MainFrame main;
	
	private int width = 350;
	private int height = 30;
	
	public InputTextField(MainFrame main, String value) {
		super(value);
		
		this.main = main;
		
		this.setToolTipText("Wpisz szukane litery");
		
		this.setPreferredSize(new Dimension(width, height));
	}
}
