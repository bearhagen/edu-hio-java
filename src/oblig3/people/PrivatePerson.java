package oblig3.people;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrivatePerson {
	private String firstName;
	private String lastName;
	private int age;
	private static ArrayList<PrivatePerson> objectList = new ArrayList<>();
	
	public PrivatePerson() {
		objectList.add(this);
	}
	
	public void sayHi() {
		if (this.getFirstName() == null) {
			JOptionPane.showMessageDialog(null, "Someone says: Hi!");
		} else {
			JOptionPane.showMessageDialog(null, this.getFirstName() + " " + this.getLastName() + " (" + this.getAge() + ") " + "says: Hi!");
		}
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
