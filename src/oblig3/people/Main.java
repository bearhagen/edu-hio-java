package oblig3.people;

public class Main {
	public static void main(String[] args) {
		// Public Person //
		Person publicPerson = new Person();
		publicPerson.sayHi();
		
		publicPerson.firstName = "John";
		publicPerson.lastName = "Doe";
		publicPerson.age = 18;
		publicPerson.sayHi();
		
		// Private Person //
		PrivatePerson privatePerson = new PrivatePerson();
		privatePerson.sayHi();
		
		privatePerson.setFirstName("Jane");
		privatePerson.setLastName("Doe");
		privatePerson.setAge(23);
		privatePerson.sayHi();
	}
}
