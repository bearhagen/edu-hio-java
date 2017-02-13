package oblig1;

/**
 * Created by bjorn on 1/13/2017.
 */
public class Oppgave3 {
    public static void main(String[] args) {
        // StandardCharsets.UTF_8;
        System.out.println(String.format("%66s", "").replace(" ", "-"));
        System.out.print(translate("English", "Norsk", " "));
        System.out.print(translate("Good morning.", "God morgen.", " "));
        System.out.print(translate("It's a pleasure to meet you.", "Hyggelig a mote deg.", " "));
        System.out.print(translate("Please call me tomrrow.", "Vennligst ring meg i morgen.", " "));
        System.out.print(translate("Have a nice day!", "Ha en fin dag!", " "));
    }

    public static String translate(String a, String b, String padder) {
        String out;
        out = "| " + String.format("%-30s", a).replace(" ", padder);
        out += "| " + String.format("%-30s", b).replace(" ", padder) + " |\n";
        out += String.format("%66s", "").replace(" ", "-") + "\n";
        return out;
    }
}
