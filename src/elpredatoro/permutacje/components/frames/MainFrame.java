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
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import elpredatoro.permutacje.dictionary.Dictionary;

/**
 * @author Andrzej Sobel <andrzej.sobel@gmail.com>
 */
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
		SwingWorker worker = new SwingWorker<Boolean, Void>(){
			@Override
			public Boolean doInBackground() {
				
				System.out.printf("\nButton clicked, input: %s, legth: %s", inputText.getText(), wordLength.getSelectedItem().toString());
				Dictionary dc = new Dictionary();
				try {
					String str = null;
					int len = 0;
					if(inputText.getText() != null && !inputText.getText().isEmpty()
							&& wordLength.getSelectedItem().toString() != null && !wordLength.getSelectedItem().toString().isEmpty()) {
						str = inputText.getText();
						len = Integer.parseInt(wordLength.getSelectedItem().toString());
					}else{
						System.err.println("Missing parameters");
					}
					
					ArrayList<Character> chars = new ArrayList<Character>();
					for (char c : str.toCharArray()) {
						chars.add(c);
					}
					
					ArrayList<String> lista = dc.findMatchingWords(len, chars);
					System.out.printf("\nFound: %s", lista);
					
					outputText.setText("");
					for(String w : lista) {
						outputText.insert(w+"\n", 0);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}
		};
		
		//System.out.printf("\nButton clicked, input: %s, legth: %s", this.inputText.getText(), this.wordLength.getSelectedItem().toString());
		
		this.searchButton.setEnabled(false);
		this.inputText.setEditable(false);
		
		worker.execute();
		
		while(!worker.isDone()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.searchButton.setEnabled(true);
		this.inputText.setEditable(true);
	}
}