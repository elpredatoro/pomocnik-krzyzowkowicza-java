package elpredatoro.permutacje.components.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import elpredatoro.permutacje.dictionary.Dictionary;

public class MainFrame extends JFrame implements ActionListener {

	private int width = 800;
	private int height = 600;
	
	private int minWidth = 400;
	private int minHeight = 300;
	
	private String iconImage = "";
	
	private JButton searchButton;
	private JTextField inputText;
	private JTextArea outputText;
	private JComboBox<String> wordLength;
	
	public MainFrame() {
		super("Permutacje");
		
		initFrame();
		initComponents();
	}
	
	private void initFrame() {
		//this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		this.setSize(width, height);
		this.setMinimumSize(new Dimension(minWidth, minHeight));
		//this.setIconImage();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents() {
		searchButton = new JButton("Szukaj");
		searchButton.addActionListener(this);
		
		wordLength = new JComboBox<String>();
		for(int x=0; x<15; x++) {
			wordLength.addItem(String.valueOf(x+1));
		}
		
		inputText = new JTextField("input");
		inputText.setToolTipText("Wpisz szukane litery");
		inputText.setColumns(50);
		
		outputText = new JTextArea("output", 20, 30);
		outputText.setEditable(false);
		
		this.add(searchButton);
		this.add(wordLength);
		this.add(inputText);
		this.add(outputText);
	}
	
	private void loadConfig() {
		
	}
	
	private void saveConfig() {
		
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println("Do Something Clicked, input: "+this.inputText.getText()+" length: "+this.wordLength.getSelectedItem().toString());
		
		Dictionary dc = new Dictionary();
		try {
			String str;
			int len;
			if(this.inputText.getText() != null && !this.inputText.getText().isEmpty()
					&& this.wordLength.getSelectedItem().toString() != null && !this.wordLength.getSelectedItem().toString().isEmpty()) {
				str = this.inputText.getText();
				len = Integer.parseInt(this.wordLength.getSelectedItem().toString());
			}else{
				throw new Exception("missing parameters");
			}
			
			ArrayList<Character> chars = new ArrayList<Character>();
			for (char c : str.toCharArray()) {
				chars.add(c);
			}
			
			ArrayList<String> lista = dc.findMatchingWords(len, chars);
			System.out.print(lista);
			
			this.outputText.setText("");
			for(String w : lista) {
				this.outputText.setText(this.outputText.getText() + w + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}