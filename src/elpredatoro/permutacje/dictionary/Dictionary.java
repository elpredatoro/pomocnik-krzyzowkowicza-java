package elpredatoro.permutacje.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Andrzej Sobel <andrzej.sobel@gmail.com>
 */
public class Dictionary {
	private int max = 1000;
	
	private String DICTIONARY_FILE = "slownik.txt";
	
	private ArrayList<String> words;
	
	public Dictionary() {
		try {
			loadDictionary();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ladowanie pliku słownika do pamięci
	 * @throws IOException
	 */
	private void loadDictionary() throws IOException {
		this.words = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_FILE));
		
		String line = br.readLine();

		while (line != null) {
			line = line.trim();
			
			this.words.add(line);
			
			line = br.readLine();
		}
		
		br.close();
	}
	
	/**
	 * Znajduje wyrazy o określonej długości, zawierające wszystkie podane znaki
	 * @param length
	 * @param chars
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> findMatchingWords(int length, ArrayList<Character> chars) throws IOException {
		ArrayList<String> matchingWords = new ArrayList<>();
		
		ArrayList<String> words = findWordsByLength(length);
		
		int charLength = chars.size();
		
		mainLoop:
		for(String word : words){
			int matches = 0;
			String wordCut = word.toLowerCase();
			
			for(Character c : chars) {
				int index = wordCut.indexOf(c);
				if(index != -1) {
					wordCut = wordCut.substring(0, index) + wordCut.substring(index+1);
					matches++;
				}else{
					continue mainLoop;
				}
			}
			
			if(matches == charLength){
				matchingWords.add(word);
				
				if(matchingWords.size() >= max) {
					break mainLoop;
				}
			}
		}
		
		return matchingWords;
		
	}
	
	/**
	 * Znajduje wyrazy ze słownika zawierające określoną ilość znaków
	 * @param length
	 * @return
	 * @throws IOException
	 */
	private ArrayList<String> findWordsByLength(int length) throws IOException {
		ArrayList<String> words = new ArrayList<>();
		
		for (String word : this.words) {
			if(word.length() == length) {
				words.add(word);
			}
		}
		
		return words;
	}
	
	/*
	 * Sprawdza czy wyraz istnieje w słowniku
	 * @param length
	 * @return boolean
	 * @throws IOException
	 */
	private boolean findWord(String searched) throws IOException {
		for (String word : this.words) {
			if(word.equals(searched)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Dodaje wyraz do słownika
	 * @param word
	 * @throws IOException
	 */
	public void add(String word) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(DICTIONARY_FILE, true));
		
		if(!findWord(word)) {
			bw.append(word);
			bw.newLine();
		}
		
		bw.close();
		
		loadDictionary();
	}
}
