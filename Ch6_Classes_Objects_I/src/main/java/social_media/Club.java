package social_media;

import java.util.ArrayList;

public class Club {

	private String name;
	private String topic;
	private ArrayList<Profile> members;

	/**
	 * Overloaded constructor: creates a Club with a default topic
	 * @param name
	 */
	public Club(String name) {
		this(name, "General");
	}

	/**
	 * Overloaded constructor: creates a Club with a specific topic
	 * @param name
	 * @param topic
	 */
	public Club(String name, String topic) {
		this.name = name;
		this.topic = topic;
		members = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getTopic() {
		return topic;
	}

	public int getMemberCount() {
		return members.size();
	}

	/**
	 * Adds a Profile object as a member of this Club
	 * @param member the Profile object joining the Club
	 */
	public void addMember(Profile member) {
		if (!members.contains(member)) {
			members.add(member);
		}
	}

	public String toString() {
		String result = name + " (" + topic + ") - " + members.size() + " member(s)\n";
		for (Profile member : members) {
			result += "\t@" + member.getUsername() + "\n";
		}
		return result;
	}
}
