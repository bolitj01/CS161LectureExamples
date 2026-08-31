package social_media;

import java.util.ArrayList;

public class Profile {

	private String username;
	private String bio;
	private ArrayList<Profile> friends;
	private ArrayList<Club> clubs;

	/**
	 * Overloaded constructor: creates a Profile with a default bio
	 * @param username
	 */
	public Profile(String username) {
		this(username, "No bio yet.");
	}

	/**
	 * Overloaded constructor: creates a Profile with a custom bio
	 * @param username
	 * @param bio
	 */
	public Profile(String username, String bio) {
		//"this." distinguishes the instance field from the constructor parameter of the same name
		this.username = username;
		this.bio = bio;
		friends = new ArrayList<>();
		clubs = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public String getBio() {
		return bio;
	}

	public int getFriendCount() {
		return friends.size();
	}

	/**
	 * Makes friendship mutual by passing this Profile object
	 * as an argument to the other Profile's addFriend method
	 * @param friend the Profile object to befriend
	 */
	public void addFriend(Profile friend) {
		if (friend == this || isFriendsWith(friend)) {
			return;
		}
		friends.add(friend);
		friend.friends.add(this);
	}

	/**
	 * Overloaded method: checks friendship using a Profile object
	 * @param friend
	 * @return true if this Profile is friends with the given Profile
	 */
	public boolean isFriendsWith(Profile friend) {
		return friends.contains(friend);
	}

	/**
	 * Overloaded method: checks friendship using a username instead of a Profile object
	 * @param username
	 * @return true if this Profile is friends with a Profile with the given username
	 */
	public boolean isFriendsWith(String username) {
		for (Profile friend : friends) {
			if (friend.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Joins a Club by passing this Profile object to the Club's addMember method
	 * @param club the Club object to join
	 */
	public void joinClub(Club club) {
		if (clubs.contains(club)) {
			return;
		}
		clubs.add(club);
		club.addMember(this);
	}

	public int getClubCount() {
		return clubs.size();
	}

	public String toString() {
		String result = "@" + username + " - " + bio + "\n";
		result += "Friends: " + friends.size() + ", Clubs: " + clubs.size();
		return result;
	}
}
