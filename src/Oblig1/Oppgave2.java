package oblig1;

import javax.swing.*;

/**
 * Created by bjorn on 1/13/2017.
 */
public class Oppgave2 {
    public static void main(String[] args) {
        String output = JOptionPane.showInputDialog("Say something");
        cowsay(output);
    }

    public static void cowsay(String cowsays) {
        int i;

        System.out.print("  ");
        for (i = 0; i < cowsays.length(); i++) {
            System.out.print("-");
        }

        System.out.println();
        System.out.println("< " + cowsays + " >");

        System.out.print("  ");
        for (i = 0; i < cowsays.length(); i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println("       \\    ^__^");
        System.out.println("        \\   (oo)\\________");
        System.out.println("            (__)\\        )\\/\\");
        System.out.println("                 ||----w |");
        System.out.println("                 ||     ||");
    }
}
