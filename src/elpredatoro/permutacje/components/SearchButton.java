package elpredatoro.permutacje.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import elpredatoro.permutacje.components.frames.MainFrame;
import elpredatoro.permutacje.dictionary.Dictionary;
import elpredatoro.permutacje.exceptions.MissingParametersException;
import elpredatoro.permutacje.exceptions.TooManyInputLettersException;

public class SearchButton extends JButton implements ActionListener {
	private static final long serialVersionUID = -5685971972540992464L;
	
	private MainFrame main;
	
	public SearchButton(MainFrame main, String label) {
		super(label);
		
		this.main = main;
		
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		SwingWorker<Boolean, Void> backgroundWorker = new SwingWorker<Boolean, Void>(){
			@Override
			public Boolean doInBackground() {
				
				// System.out.printf("\nButton clicked, input: %s, legth: %s", main.getInputText().getText(), main.getWordLength().getSelectedItem().toString());
				Dictionary dc = new Dictionary();
				try {
					String str = null;
					int len = 0;
					if(main.getInputText().getText() != null && !main.getInputText().getText().isEmpty()
							&& main.getWordLength().getSelectedItem().toString() != null && !main.getWordLength().getSelectedItem().toString().isEmpty()
							&& main.getInputText().getText().length() <= Integer.parseInt(main.getWordLength().getSelectedItem().toString())) {
						str = main.getInputText().getText();
						len = Integer.parseInt(main.getWordLength().getSelectedItem().toString());
					} else if(main.getInputText().getText().length() > Integer.parseInt(main.getWordLength().getSelectedItem().toString())) {
						// System.err.println("Too many input letters");
						throw new TooManyInputLettersException("Too many input letters");
						//JOptionPane.showMessageDialog(main, "Wpisałeś za dużo liter", "Błąd", JOptionPane.PLAIN_MESSAGE);
					} else {
						// System.err.println("Missing parameters");
						throw new MissingParametersException("Missing parameters");
						// JOptionPane.showMessageDialog(main, "Wpisałeś za dużo liter", "Błąd", JOptionPane.PLAIN_MESSAGE);
					}
					
					ArrayList<Character> chars = new ArrayList<Character>();
					for (char c : str.toCharArray()) {
						chars.add(Character.toLowerCase(c));
					}
					
					ArrayList<String> lista = dc.findMatchingWords(len, chars);
					// System.out.printf("\nFound: %s", lista);
					
					StringBuffer sb = new StringBuffer();
					
					for(String w : lista) {
						sb.append(w+"\n");
					}
					
					main.getOutputText().setText(sb.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}
		};
		
		//System.out.printf("\nButton clicked, input: %s, legth: %s", this.inputText.getText(), this.wordLength.getSelectedItem().toString());
		
		main.getSearchButton().setEnabled(false);
		main.getInputText().setEditable(false);
		
		backgroundWorker.execute();
		
		while(!backgroundWorker.isDone()){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		main.getSearchButton().setEnabled(true);
		main.getInputText().setEditable(true);
	}
}
