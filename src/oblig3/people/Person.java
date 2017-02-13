package oblig3.people;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Person {
	public String firstName;
	public String lastName;
	public int age;
	public static ArrayList<Person> objectList = new ArrayList<>();
	
	public Person() {
		objectList.add(this);
	}
	
	public void sayHi() {
		if (firstName == null) {
			JOptionPane.showMessageDialog(null, "Someone says: Hi!");
		} else {
			JOptionPane.showMessageDialog(null, firstName + " " + lastName + " (" + age + ") " + "says: Hi!");
		}
	}
}
