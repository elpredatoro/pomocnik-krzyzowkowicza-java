package elpredatoro.permutacje;

import java.awt.EventQueue;

import elpredatoro.permutacje.components.frames.MainFrame;

/**
 * @author Andrzej Sobel <andrzej.sobel@gmail.com>
 */
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
	}
}
