package arrays;

import java.util.*;

/**
* Console Memory Game (Java)
* - 4x4 board with 8 animal pairs
* - Two players alternate turns; a match grants an extra turn
* - Hidden tiles show " ? "; revealed tiles show the animal
* - Input format: two integers "row col" (0-3 each)
*/
public class MemoryGame {

   private static final int SIZE = 4;
   private static final long CONSOLE_PAUSE_MS = 1200;

   public static void main(String[] args) throws InterruptedException {
       //TODO Make an ArrayList of Strings called "animals" to hold animal emojis

       //TODO Make a 2D array of Strings called "board"

       //TODO Make a 2D array of booleans called "revealed" to track which tiles have been revealed

       //TODO Make an array of two integers called "playerScores" to track each player's score

       int currentPlayer = 0;
       int matchesFound = 0;

       //TODO Fill this method call in to initialize the board and revealed arrays
       setupBoard(________, ________, ________, new Random());

       Scanner playerInput = new Scanner(System.in);

       //Play until all matches have been found
       while (matchesFound < animals.size()) {
           printBoard(board, revealed);
           System.out.printf("%nPlayer %d's turn — Score: %d%n",
                   (currentPlayer + 1), playerScores[currentPlayer]);

           // First pick
           int[] first = pickTile(playerInput, revealed);
           //TODO Reveal the first picked tile


           printBoard(board, revealed);

           // Second pick
           int[] second = pickTile(playerInput, revealed);
           while (first[0] == second[0] && first[1] == second[1]) {
               System.out.println("You already chose that square. Pick a different one.");
               second = pickTile(playerInput, revealed);
           }

           //TODO Reveal the second picked tile


           printBoard(board, revealed);
           //Temporarily pause to let players see the board
           Thread.sleep(CONSOLE_PAUSE_MS);

           //TODO Check for a match
           if (________) {
               System.out.println("🎉 It's a match! You get another turn.");
               //TODO Give player a point

               matchesFound += 1;
           } else {
               System.out.println("❌ Not a match.");
               //TODO Hide both tiles again


               currentPlayer = 1 - currentPlayer; // switch player
           }
           Thread.sleep(CONSOLE_PAUSE_MS);
       }

       // Game over
    printBoard(board, revealed);
       System.out.println("\n🏁 Game over!");
       System.out.printf("Player 1 score: %d%n", playerScores[0]);
       System.out.printf("Player 2 score: %d%n", playerScores[1]);
       if (playerScores[0] > playerScores[1]) {
           System.out.println("🏆 Player 1 wins!");
       } else if (playerScores[1] > playerScores[0]) {
           System.out.println("🏆 Player 2 wins!");
       } else {
           System.out.println("🤝 It's a tie!");
       }

   }

   private static void setupBoard(String[][] board, boolean[][] revealed, List<String> animals, Random rng) {
       //TODO Duplicate animals into a temporary list called "tiles"

       //TODO Shuffle the tiles list with rng

       //TODO Fill the board and mark each revealed cell false
   }

   private static void printBoard(String[][] board, boolean[][] revealed) {
       System.out.println();
       System.out.println("    0    1    2    3");
       System.out.println("  +----+----+----+----+");
       //TODO Print the board using two for loops
       for (________) {
           StringBuilder row = new StringBuilder();
           row.append(r).append(" |");
           for (________) {
               //Tile is either revealed (show animal) or hidden (show "?")
               String tile = revealed[r][c] ? board[r][c] : "??";
               row.append(String.format(" %s |", tile));
           }
           System.out.println(row);
           System.out.println("  +----+----+----+----+");
       }
   }

   // Reads, validates, and returns a tile location choice in the form [row, col]
   private static int[] pickTile(Scanner kb, boolean[][] revealed) {
       while (true) {
           System.out.print("Enter a row and column (e.g., 1 2): ");
           String line = kb.nextLine().trim();
           //Break input into each coordinate
           String[] parts = line.split("\\s+");

           if (parts.length != 2) {
               System.out.println("Invalid input. Please enter two numbers with a space between.");
               continue;
           }

           int row = Integer.parseInt(parts[0]);
           int col = Integer.parseInt(parts[1]);
           if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
               System.out.println("Invalid input. Please enter two valid numbers with a space between.");
               continue;
           }
           if (revealed[row][col]) {
               System.out.println("That space is already revealed. Try another.");
               continue;
           }
           return new int[]{row, col};

       }
   }

}
