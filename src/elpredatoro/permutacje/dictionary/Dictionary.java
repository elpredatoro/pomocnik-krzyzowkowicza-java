package elpredatoro.permutacje.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
	private ArrayList<String> words = new ArrayList<String>();
	
	public Dictionary() {
		
	}
	
	public ArrayList<String> find(int length) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("slownik.txt"));
		
		String line = br.readLine();

		while (line != null) {
			line = line.trim();
			
			if(line.length() == length) {
				words.add(line);
			}
			
			line = br.readLine();
		}
		
		br.close();
		
		return words;
	}
	
	public void add(String word) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("slownik.txt", true));
		
		bw.append(word);
		bw.newLine();
		bw.close();
	}
}
