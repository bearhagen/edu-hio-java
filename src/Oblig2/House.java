package Oblig2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bjorn on 1/24/2017.
 */
public class House {
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.add(new HouseComponent());
        frame.setLocationRelativeTo(null);  // Center the frame on the screen
        frame.setVisible(true);             // Show the frame
    }

    private static class HouseComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            draw(g);
        }
        private void draw(Graphics g) {
            final int t = 100;  // Top
            final int r = frame.getWidth()-100; // Right
            final int b = frame.getHeight()-100; // Bottom
            final int l = 100;  // Left

            Graphics2D g2 = (Graphics2D) g;        // Cast the type
            g2.setStroke(new BasicStroke(5)); // To get some width on the lines
            g.setColor(new Color(0, 0, 0));

            g.drawRect(l, t, r-100, b-100);          // Walls
            g.drawRect(l+100, b-200, 200, 100); // Window
            g.drawRect(r-200, b-150, 100, 150); // Door

            // Roof
            int roofX[] = { l-50, l+75, r-75, r+50 };
            int roofY[] = { t+25, t-50, t-50, t+25 };
            Polygon poly = new Polygon(roofX, roofY, roofX.length);
            g.fillPolygon(poly);
        }
    }
}
