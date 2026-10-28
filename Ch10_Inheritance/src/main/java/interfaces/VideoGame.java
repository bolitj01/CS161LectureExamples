package interfaces;

/**
 * VideoGame class
 */
public class VideoGame implements RetailItem {
    private String title;       // The video game's title
    private String platform;    // The gaming platform
    private double retailPrice; // The video game's retail price

    /**
     * Constructor
     * @param gameTitle The video game title.
     * @param gamePlatform The gaming platform.
     * @param gamePrice The video game's price.
     */
    public VideoGame(String gameTitle, String gamePlatform, double gamePrice) {
        title = gameTitle;
        platform = gamePlatform;
        retailPrice = gamePrice;
    }

    /**
     * getTitle method
     * @return The video game's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * getPlatform method
     * @return The gaming platform.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * getRetailPrice method (Required by the RetailItem interface)
     * @return The retail price of the video game.
     */
    @Override
    public double getRetailPrice() {
        return retailPrice;
    }
}
