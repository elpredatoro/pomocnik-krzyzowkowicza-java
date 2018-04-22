package elpredatoro.permutacje;

import java.awt.EventQueue;

import elpredatoro.permutacje.components.frames.MainFrame;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
		
		/*
		Dictionary dc = new Dictionary();
		try {
			String str = "oko";
			ArrayList<Character> chars = new ArrayList<Character>();
			for (char c : str.toCharArray()) {
				chars.add(c);
			}
			
			ArrayList<String> lista = dc.findMatchingWords(4, chars);
			System.out.print(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

	}

}
