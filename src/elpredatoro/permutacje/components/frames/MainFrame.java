package elpredatoro.permutacje.components.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import elpredatoro.permutacje.components.buttons.SearchButton;

/**
 * @author Andrzej Sobel <andrzej.sobel@gmail.com>
 */
public class MainFrame extends JFrame {

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
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initFrame();
				initComponents();
			}
		});
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
		searchButton = new SearchButton(this, "Szukaj");
		
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
	
	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JTextField getInputText() {
		return inputText;
	}

	public void setInputText(JTextField inputText) {
		this.inputText = inputText;
	}

	public JTextArea getOutputText() {
		return outputText;
	}

	public void setOutputText(JTextArea outputText) {
		this.outputText = outputText;
	}

	public JComboBox<String> getWordLength() {
		return wordLength;
	}

	public void setWordLength(JComboBox<String> wordLength) {
		this.wordLength = wordLength;
	}
}