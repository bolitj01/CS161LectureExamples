package immutable;

import java.time.LocalDateTime;

public final class User {
    private final String username;
    private final String email;
    //LocalDateTime class itself is immutable, so we can safely use it as a field in our immutable class
    private final LocalDateTime birthDate;

    enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }

    // Constructor to initialize all fields
    public User(String username, String email, LocalDateTime birthDate) {
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
    }
    // Getter for username
    public String getUsername() {
        return username;
    }
    // Getter for email
    public String getEmail() {
        return email;
    }
    // Getter for date of birth
    public LocalDateTime getBirthDate() {
        return birthDate;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public static void main(String[] args) {
        User user = new User("Tommy Bolinger", "bolitj01@purdue.edu", LocalDateTime.of(1995, 7, 31, 0, 0, 0));
        System.out.println(user);

        System.out.println("Date of birth: " + user.getBirthDate());

        // Attempting to modify the fields will result in compilation errors
        // user.username = "NewUsername"; // Error: cannot assign a new value to final variable
        LocalDateTime newDate = user.getBirthDate().plusDays(1); // This creates a new LocalDateTime object, but does not modify the original birthDate
        System.out.println("Modified date of birth: " + newDate);
        System.out.println("Original date of birth: " + user.getBirthDate());

        Day WorkDay = Day.TUESDAY;

        System.out.println("User " + user.getUsername() + "'s next work day: " + WorkDay);
    }
}