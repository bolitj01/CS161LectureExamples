package arrays;

import java.util.*;

/**
 * Console Memory Game (Java)
 * - 4x4 board with 8 animal pairs
 * - Two players alternate turns; a match grants an extra turn
 * - Hidden tiles show " ? "; revealed tiles show the animal
 * - Input format: two integers "row col" (0-3 each)
 */
public class MemoryGame_Solution {

    private static final int SIZE = 4;
    private static final long CONSOLE_PAUSE_MS = 1200;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> animals = new ArrayList<>(List.of(new String[]{
                "\uD83D\uDC31", // 🐱 cat
                "\uD83D\uDC36", // 🐶 dog
                "\uD83E\uDD8A", // 🦊 fox
                "\uD83D\uDC39", // 🐹 hamster
                "\uD83D\uDC3A", // 🐺 wolf
                "\uD83D\uDC1C", // 🐜 ant
                "\uD83D\uDC2E", // 🐮 cow
                "\uD83D\uDC37"  // 🐷 pig
        }));

        String[][] board = new String[SIZE][SIZE];
        boolean[][] revealed = new boolean[SIZE][SIZE];
        int[] playerScores = new int[]{0, 0};
        int currentPlayer = 0;
        int matchesFound = 0;

        setupBoard(board, revealed, animals, new Random());

        Scanner playerInput = new Scanner(System.in);

        //Play until all matches have been found
        while (matchesFound < animals.size()) {
            printBoard(board, revealed);
            System.out.printf("%nPlayer %d's turn — Score: %d%n",
                    (currentPlayer + 1), playerScores[currentPlayer]);

            // First pick
            int[] first = pickTile(playerInput, revealed);
            revealed[first[0]][first[1]] = true;
            printBoard(board, revealed);

            // Second pick
            int[] second = pickTile(playerInput, revealed);
            while (first[0] == second[0] && first[1] == second[1]) {
                System.out.println("You already chose that square. Pick a different one.");
                second = pickTile(playerInput, revealed);
            }
            revealed[second[0]][second[1]] = true;

            printBoard(board, revealed);
            //Temporarily pause to let players see the board
            Thread.sleep(CONSOLE_PAUSE_MS);

            // Check match
            if (board[first[0]][first[1]].equals(board[second[0]][second[1]])) {
                System.out.println("🎉 It's a match! You get another turn.");
                playerScores[currentPlayer] += 1;
                matchesFound += 1;
            } else {
                System.out.println("❌ Not a match.");
                revealed[first[0]][first[1]] = false;
                revealed[second[0]][second[1]] = false;
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
        ArrayList<String> tiles = new ArrayList<>(animals);
        tiles.addAll(animals);

        Collections.shuffle(tiles, rng);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                board[r][c] = tiles.get(r * SIZE + c);
                revealed[r][c] = false;
            }
        }
    }

    private static void printBoard(String[][] board, boolean[][] revealed) {
        System.out.println();
        System.out.println("    0    1    2    3");
        System.out.println("  +----+----+----+----+");
        for (int r = 0; r < SIZE; r++) {
            StringBuilder row = new StringBuilder();
            row.append(r).append(" |");
            for (int c = 0; c < SIZE; c++) {
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
