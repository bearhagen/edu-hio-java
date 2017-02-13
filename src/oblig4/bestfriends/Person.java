package oblig4.bestfriends;

public class Person {
	private String nameFirst;
	private String nameLast;
	private Person bestfriend;
	
	public Person(String nameFirst, String nameLast) {
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
	}

	public String getNameFirst() {
		return nameFirst;
	}
	
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	
	public String getNameLast() {
		return nameLast;
	}
	
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public Person getBestfriend() {
		return bestfriend;
	}

	public void setBestfriend(Person bestfriend) {
		this.bestfriend = bestfriend;
	}
}
