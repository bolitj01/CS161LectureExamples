package gridescape_solutions;

import java.util.Random;
import java.util.Scanner;

public class GridEscape_Simplified_Solution {
    private static final int GRID_SIZE = 4;
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Random RNG = new Random(11);

    public static void main(String[] args) {
        int playerX = 2, playerY = 2;
        int exitX, exitY;
        // Make sure exit is not at the player's starting position
        do {
            exitX = RNG.nextInt(GRID_SIZE);
            exitY = RNG.nextInt(GRID_SIZE);
        } while (exitX == playerX && exitY == playerY);

        System.out.println("-------------- Escape the 4x4 Grid! --------------");
        System.out.println("Reach the EXIT.");
        System.out.println();

        while (true) {
            System.out.printf("You are at (%d,%d).%n", playerX, playerY);

            //DEBUG AID, not part of the intended gameplay
            printGrid(playerX, playerY, exitX, exitY);

            boolean moved = false;
            while (!moved) {
                System.out.print("Move (up/down/left/right or w/s/a/d): ");
                String s = INPUT.nextLine().trim().toLowerCase();
                int oldPlayerX = playerX;
                int oldPlayerY = playerY;
                if ((s.equals("w") || s.equals("up")) && playerY + 1 != GRID_SIZE) {
                    playerY += 1;
                } else if ((s.equals("s") || s.equals("down")) && playerY - 1 != -1) {
                    playerY -= 1;
                } else if ((s.equals("a") || s.equals("left")) && playerX - 1 != -1) {
                    playerX -= 1;
                } else if ((s.equals("d") || s.equals("right")) && playerX + 1 != GRID_SIZE) {
                    playerX += 1;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
                if (playerX != oldPlayerX || playerY != oldPlayerY) {
                    moved = true;
                }
            }

            int distToExit = distanceBetween(playerX, playerY, exitX, exitY);
            System.out.printf("Distance to EXIT: %d%n", distToExit);

            if (playerX == exitX && playerY == exitY) {
                System.out.println("You reached the EXIT! You win! 🎉");
                break;
            }
            System.out.println();
        }

        System.out.println("\nGame over. Thanks for playing!");
    }

    // Method to calculate the Manhattan distance between two points
    private static int distanceBetween(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

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