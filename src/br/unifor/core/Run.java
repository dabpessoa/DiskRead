package br.unifor.core;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				new Controller().run();
			}
		});
	}
}
