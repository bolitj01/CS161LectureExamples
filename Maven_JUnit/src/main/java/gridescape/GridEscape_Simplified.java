package gridescape;

import java.util.Random;
import java.util.Scanner;

public class GridEscape_Simplified {
    private static final int GRID_SIZE = 4;
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Random RNG = new Random(11);

    public static void main(String[] args) {
        int playerX = 2, playerY = 2;
        int exitX, exitY;
        // Make sure exit is not at the player's starting position
        //TODO Write the loop!

        System.out.println("-------------- Escape the 4x4 Grid! --------------");
        System.out.println("Reach the EXIT.");
        System.out.println();

        //Play until the player reaches the exit
        while (true) {
            System.out.printf("You are at (%d,%d).%n", playerX, playerY);

            //DEBUG AID, not part of the intended gameplay
            printGrid(playerX, playerY, exitX, exitY);

            boolean moved = false;
            while (!moved) {
                System.out.print("Move (up/down/left/right or w/s/a/d): ");
                String move = INPUT.nextLine().trim().toLowerCase();
                int oldPlayerX = playerX;
                int oldPlayerY = playerY;
                //TODO Write if statements to move the player
                if () {

                } else {
                    System.out.println("Invalid move. Try again.");
                }
                if (playerX != oldPlayerX || playerY != oldPlayerY) {
                    moved = true;
                }
            }

            int distToExit = Math.abs(playerX - exitX) + Math.abs(playerY - exitY);
            System.out.printf("Distance to EXIT: %d%n", distToExit);

            if (playerX == exitX && playerY == exitY) {
                System.out.println("You reached the EXIT! You win! 🎉");
                break;
            }
            System.out.println();
        }

        System.out.println("\nGame over. Thanks for playing!");

    }

    //TODO Write a method to find the (Manhattan) distance between two points

    //DEBUGGING AID, not part of the intended gameplay
    private static void printGrid(int playerX, int playerY, int exitX, int exitY) {
        System.out.println("Current grid:");
        // Print column headers
        System.out.print("   ");
        for (int x = 0; x < GRID_SIZE; x++) {
            System.out.print(" " + x + " ");
        }
        System.out.println();
        for (int y = GRID_SIZE - 1; y >= 0; y--) {
            System.out.print(" " + y + " "); // Print row header
            for (int x = 0; x < GRID_SIZE; x++) {
                if (playerX == x && playerY == y) {
                    System.out.print(" P ");
                } else if (exitX == x && exitY == y) {
                    System.out.print(" E ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
