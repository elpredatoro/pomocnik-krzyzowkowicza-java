package elpredatoro.permutacje.components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import elpredatoro.permutacje.components.frames.MainFrame;
import elpredatoro.permutacje.dictionary.Dictionary;

public class SearchButton extends JButton implements ActionListener {
	private MainFrame main;
	
	public SearchButton(MainFrame main, String label) {
		super(label);
		
		this.main = main;
		
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		SwingWorker bw = new SwingWorker<Boolean, Void>(){
			@Override
			public Boolean doInBackground() {
				
				System.out.printf("\nButton clicked, input: %s, legth: %s", main.getInputText().getText(), main.getWordLength().getSelectedItem().toString());
				Dictionary dc = new Dictionary();
				try {
					String str = null;
					int len = 0;
					if(main.getInputText().getText() != null && !main.getInputText().getText().isEmpty()
							&& main.getWordLength().getSelectedItem().toString() != null && !main.getWordLength().getSelectedItem().toString().isEmpty()) {
						str = main.getInputText().getText();
						len = Integer.parseInt(main.getWordLength().getSelectedItem().toString());
					}else{
						System.err.println("Missing parameters");
					}
					
					ArrayList<Character> chars = new ArrayList<Character>();
					for (char c : str.toCharArray()) {
						chars.add(c);
					}
					
					ArrayList<String> lista = dc.findMatchingWords(len, chars);
					System.out.printf("\nFound: %s", lista);
					
					main.getOutputText().setText("");
					for(String w : lista) {
						main.getOutputText().insert(w+"\n", 0);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}
		};
		
		//System.out.printf("\nButton clicked, input: %s, legth: %s", this.inputText.getText(), this.wordLength.getSelectedItem().toString());
		
		main.getSearchButton().setEnabled(false);
		main.getInputText().setEditable(false);
		
		bw.execute();
		
		while(!bw.isDone()){
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
