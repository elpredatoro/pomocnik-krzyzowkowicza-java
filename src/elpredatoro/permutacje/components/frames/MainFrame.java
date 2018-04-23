package elpredatoro.permutacje.components.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import elpredatoro.permutacje.components.InputTextField;
import elpredatoro.permutacje.components.LeftPanel;
import elpredatoro.permutacje.components.OutputTextField;
import elpredatoro.permutacje.components.OutputTextScroll;
import elpredatoro.permutacje.components.RightPanel;
import elpredatoro.permutacje.components.SearchButton;
import elpredatoro.permutacje.components.SelectWordLength;

/**
 * @author Andrzej Sobel <andrzej.sobel@gmail.com>
 */
public class MainFrame extends JFrame {

	private int width = 800;
	private int height = 600;
	
	private int minWidth = 800;
	private int minHeight = 600;
	
	private String iconImage = "";
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton searchButton;
	private JTextField inputText;
	private JScrollPane outputTextScroll;
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
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		this.setSize(width, height);
		this.setMinimumSize(new Dimension(minWidth, minHeight));
		//this.setIconImage();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents() {
		leftPanel = new LeftPanel(this);
		rightPanel = new RightPanel(this);
		searchButton = new SearchButton(this, "Szukaj");
		wordLength = new SelectWordLength(this);
		inputText = new InputTextField(this, "");
		JLabel inputTextLabel = new JLabel("Wpisz szukane litery");
		inputTextLabel.setLabelFor(inputText);
		outputText = new OutputTextField(this, "Wynik wyszukiwania");
		
		outputTextScroll = new OutputTextScroll(this, outputText);
		
		this.add(leftPanel);
		this.add(rightPanel);
		
		leftPanel.add(inputTextLabel);
		leftPanel.add(inputText);
		leftPanel.add(new JLabel("Wybierz długość szukanego wyrazu"));
		leftPanel.add(wordLength);
		leftPanel.add(searchButton);
		
		rightPanel.add(outputTextScroll);
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

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public JScrollPane getOutputTextScroll() {
		return outputTextScroll;
	}

	public void setOutputTextScroll(JScrollPane outputTextScroll) {
		this.outputTextScroll = outputTextScroll;
	}
}