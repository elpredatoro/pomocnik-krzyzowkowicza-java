package elpredatoro.permutacje;

import java.io.IOException;
import java.util.List;

import elpredatoro.permutacje.dictionary.Dictionary;

public class Main {

	public static void main(String[] args) {
		Dictionary dc = new Dictionary();
		try {
			List<String> lista = dc.find(4);
			System.out.print(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
