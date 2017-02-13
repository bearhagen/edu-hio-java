package oblig1;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Created by bjorn on 1/13/2017.
 */
public class AssignmentFinished {
    private JPanel mainPane;
    private JLabel picLabel;
    private JLabel label1;

    public AssignmentFinished() {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyForm");
        frame.setContentPane(new AssignmentFinished().mainPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() throws IOException {
        String filepath = "/Oblig1/meme.png";
        URL file = AssignmentFinished.class.getResource(filepath);
        try {
            picLabel = new JLabel(new ImageIcon(ImageIO.read(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
