package klaue.schematic2blueprint;

import javax.swing.SwingUtilities;

/**
 * Launcher for the Schematic-to-blueprint application
 * @author klaue
 */
public class Schematic2Blueprint {
	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame(args);
			}
		});
	}
}
