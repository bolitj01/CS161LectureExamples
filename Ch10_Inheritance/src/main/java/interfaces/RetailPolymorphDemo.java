package interfaces;
/**
   This program demonstrates that an interface type may
   be used to create a polymorphic reference.
 */

public class RetailPolymorphDemo
{
	public static void main(String[] args)
	{
		// Create a CompactDisc object.
		CD cd =
				new CD("Greatest Hits",
						"Joe Looney Band",
						18.95);
		// Create a DvdMovie object.
		DVD movie =
				new DVD("Wheels of Fury",
						137, 12.95);

		// Create a VideoGame object for Minecraft
		VideoGame game = new VideoGame("Minecraft", "PC", 26.99);
		VideoGame game2 = new VideoGame("Rocket League", "PC/PS5/XBox", 0);

        // Create a Cassette tape
        CassetteTape tape = new CassetteTape("Greatest Hits", "Joe Looney Band", 9.95, 85);

		RetailItem[] items = {cd, movie, game, game2, tape};
		
		// Display the CD's title.                      
		System.out.println("Item #1: " +
				cd.getTitle());
		

		// Display the DVD's title.
		System.out.println("Item #2: " +
				movie.getTitle());
		
		// Display the VideoGame's title.
		System.out.println("Item #3: " + game.getTitle());

		//Show all prices
		for (RetailItem item : items) {
			showPrice(item);
		}
	}

	/**
      The showPrice method displays the price
      of a RetailItem object.
      @param item A reference to a RetailItem object.
	 */

	private static void showPrice(RetailItem item)
	{
		System.out.printf("Price: $%,.2f\n", item.getRetailPrice());
	}
}
