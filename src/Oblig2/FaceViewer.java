package oblig2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bjorn on 1/24/2017.
 */
public class FaceViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new FaceComponent());
        frame.setLocationRelativeTo(null);  // Center the frame on the screen
        frame.setVisible(true);             // Show the frame
    }

    private static class FaceComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5)); // To get some width on the lines
            g.setColor(new Color(0, 0, 0));

            // Face
            g.drawOval(75, 50, 150, 150);

            // Eyes
            g.fillOval(125, 100, 10, 10);
            g.fillOval(155, 100, 10, 10);

            // Mouth
            g.drawArc(125, 125, 40, 20, 180, 180);
        }
    }
}
