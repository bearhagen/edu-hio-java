package oblig4.bestfriends;

public class Main {

	public static void main(String[] args) {
		Person ole = new Person("Ole", "Nordmann");
		Person kari = new Person("Kari", "Nordmann");
		ole.setBestfriend(kari);
		kari.setBestfriend(ole);
		
		System.out.println(ole.getNameFirst() + " " + ole.getNameLast() + " er bestevenn med " + ole.getBestfriend().getNameFirst() + " " + ole.getBestfriend().getNameLast());
		System.out.println(kari.getNameFirst() + " " + kari.getNameLast() + " er bestevenn med " + kari.getBestfriend().getNameFirst() + " " + kari.getBestfriend().getNameLast());
	}

}
