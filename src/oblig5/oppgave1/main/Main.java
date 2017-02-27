package oblig5.oppgave1.main;

import oblig5.oppgave1.gui.MainFrame;
import javax.swing.*;

public class Main {

	 public static void main(String[] args) {

		 SwingUtilities.invokeLater(new Runnable() {

			 @Override
			 public void run() {
				 MainFrame frame = new MainFrame("Tittel");
				 frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				 frame.setLocationRelativeTo(null);		
				 frame.setSize(400, 300);
				 frame.setVisible(true);
			}
		 });
	 }
}