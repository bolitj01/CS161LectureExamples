package interfaces;

public class CassetteTape implements RetailItem {
    private String title;
    private String artist;
    private double price;
    private int playingTime; // in minutes

    public CassetteTape(String title, String artist, double price, int playingTime) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.playingTime = playingTime;
    }

    public String getDescription() {
        return "Cassette Tape: " + title + " by " + artist + ", Playing Time: " + playingTime + " mins";
    }

    @Override
    public double getRetailPrice() {
        return price;
    }
}
