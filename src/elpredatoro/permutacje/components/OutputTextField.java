package elpredatoro.permutacje.components;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import elpredatoro.permutacje.components.frames.MainFrame;

public class OutputTextField extends JTextArea {
	private MainFrame main;
	
	private int width = 340;
	private int height = 550;
	
	private int rows = 1000;
	
	public OutputTextField(MainFrame main, String value) {
		super(value);
		
		this.main = main;
		
		this.setPreferredSize(new Dimension(width, height));
		this.setRows(rows);
		this.setEditable(false);
	}
}
