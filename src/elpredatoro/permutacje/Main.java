package elpredatoro.permutacje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import elpredatoro.permutacje.dictionary.Dictionary;

public class Main {

	public static void main(String[] args) {
		Dictionary dc = new Dictionary();
		try {
			String str = "oo";
			ArrayList<Character> chars = new ArrayList<Character>();
			for (char c : str.toCharArray()) {
				chars.add(c);
			}
			
			ArrayList<String> lista = dc.findMatchingWords(3, chars);
			System.out.print(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
