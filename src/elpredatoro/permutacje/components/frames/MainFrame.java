package elpredatoro.permutacje.components.frames;

import java.awt.*;
import javax.swing.*;

import elpredatoro.permutacje.Data;
import elpredatoro.permutacje.components.*;
import elpredatoro.permutacje.dictionary.Dictionary;

/**
 * @author Andrzej Sobel <andrzej.sobel@gmail.com>
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 6762993361955762012L;
	
	private int width = 800;
	private int height = 600;
	
	private int minWidth = 800;
	private int minHeight = 600;
	
	//private String iconImage = "";
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton searchButton;
	private JTextField inputText;
	private JScrollPane outputTextScroll;
	private JTextArea outputText;
	private JComboBox<String> wordLength;
	
	public static Dictionary dictionary;
	
	public MainFrame() {
		super();
		
		dictionary = new Dictionary();
		
		Data data = new Data();
		this.setTitle("Pomocnik krzyżówkowicza v"+data.getVersion()+" by "+data.getAuthorNick());
		
		initFrame();
		initComponents();
		
		// TODO sprawdzanie czy plik słownika istnieje
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
		outputText = new OutputTextField(this, "Wynik wyszukiwania (max 1000)");
		
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