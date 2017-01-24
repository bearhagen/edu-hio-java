package Oblig1;

import javax.swing.*;

/**
 * Created by bjorn on 1/13/2017.
 */
public class Oppgave4 {
    public static void main(String[] args) {
        String name = ask("???", "What is your name?");
        speak(name, "My name is " + name);
        speak("???", "Hello " + name);
        speak("Hal", "My name is Hal!");
        String iWouldLikeTo = ask("Hal", "What would you like me to do?");
        speak(name, iWouldLikeTo);
        speak("Hal", "I'm sorry, " + name + ". I'm afraid I can't do that");
    }

    public static void speak(String name, String says) {
        System.out.println(name + ": " + says);
    }

    public static String ask(String name, String asks) {
        speak(name, asks);
        return JOptionPane.showInputDialog(asks);
    }
}
