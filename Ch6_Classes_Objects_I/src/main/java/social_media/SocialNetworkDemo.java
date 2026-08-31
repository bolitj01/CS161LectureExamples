package social_media;

public class SocialNetworkDemo {

	public static void main(String[] args) {

		// Objects and Classes: each variable below is a separate Profile object
		// built from the same Profile class blueprint
		Profile alice = new Profile("alice");
		Profile bob = new Profile("bob", "Coffee enthusiast and hiker.");
		Profile carla = new Profile("carla", "Loves board games.");

		// Scope of Instance Fields: each Profile has its OWN friends/clubs fields.
		// Changing bob's friend count below has no effect on alice's or carla's fields.
		System.out.println(alice.getFriendCount() + " " + bob.getFriendCount() + " " + carla.getFriendCount());

		// Passing Objects as Arguments: a Profile object is passed to addFriend
		alice.addFriend(bob);
		bob.addFriend(carla);

		System.out.println(alice);
		System.out.println(bob);
		System.out.println(carla);

		// Overloading Methods: isFriendsWith can take a Profile object OR a username String
		System.out.println("alice & bob friends (by object)? " + alice.isFriendsWith(bob));
		System.out.println("alice & carla friends (by username)? " + alice.isFriendsWith("carla"));

		// Overloading Constructors: Club(name) uses a default topic, Club(name, topic) is custom
		Club bookClub = new Club("Page Turners", "Books");
		Club hikingClub = new Club("Trailblazers");

		// Passing Objects as Arguments: a Club object is passed to joinClub
		alice.joinClub(bookClub);
		bob.joinClub(bookClub);
		bob.joinClub(hikingClub);
		carla.joinClub(hikingClub);

		System.out.println(bookClub);
		System.out.println(hikingClub);

		System.out.println("bob is in " + bob.getClubCount() + " club(s)");
	}
}
