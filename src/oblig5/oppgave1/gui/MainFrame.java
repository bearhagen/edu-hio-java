package oblig5.oppgave1.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {

	 private JButton button;
	 private Container cont = getContentPane();

	 public MainFrame(String title){
		 Color green = new Color(0, 255, 0);
		 Color blue = new Color(0, 0, 255);
		 
		 JPanel panel = new JPanel();
		 panel.setLayout(new BorderLayout());

		 JButton button = new JButton("Knapp");		 
		 panel.add(button, BorderLayout.CENTER);
		 
		 cont.add(panel, BorderLayout.NORTH);
		 cont.setBackground(green);
		 
		 button.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				  if (cont.getBackground() == green) {
					  cont.setBackground(blue);
				  } else {
					  cont.setBackground(green);
				  }
			 }
		 });

	 }
}
