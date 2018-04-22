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
	private int max = 100;
	
	public Dictionary() {
		
	}
	
	/**
	 * Znajduje wyrazy o określonej długości, zawierające wszystkie podane znaki
	 * @param length
	 * @param chars
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> findMatchingWords(int length, ArrayList<Character> chars) throws IOException {
		ArrayList<String> matchingWords = new ArrayList<String>();
		
		ArrayList<String> words = findWordsByLength(length);
		
		int charLength = chars.size();
		
		mainLoop:
		for(String word : words){
			int matches = 0;
			String wordCut = word;
			
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
		ArrayList<String> words = new ArrayList<String>();
		
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
	
	/**
	 * Dodaje wyraz do słownika
	 * @param word
	 * @throws IOException
	 */
	public void add(String word) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("slownik.txt", true));
		
		bw.append(word);
		bw.newLine();
		bw.close();
	}
}
