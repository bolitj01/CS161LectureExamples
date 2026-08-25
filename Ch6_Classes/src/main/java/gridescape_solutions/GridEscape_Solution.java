package gridescape_solutions;

import java.util.Random;
import java.util.Scanner;

/**
 * GridEscape
 * - 4x4 grid with player at (2,2) and monster and exit at random distinct tiles.
 * - Each turn: player moves U/D/L/R (bounded by board edges).
 * - After the player's move, show Manhattan distance to EXIT and to MONSTER.
 * - If player reaches EXIT, they win (even if the monster also reaches them that same turn).
 * - If player and monster land on the same non-exit tile, the player loses.
 * <p>
 * - Bonus: Monster has a 25% chance to move one step toward the player each turn.
 */
public class GridEscape_Solution {
    private static final int GRID_SIZE = 4;               // 4x4 board: valid coords 0..3
    private static final double MONSTER_MOVE_P = 0.25;
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Random RNG = new Random(7);
    private static final int START_X = 2, START_Y = 2; // Player start position

    public static void main(String[] args) {
        GridEntity_Solution player = new GridEntity_Solution(START_X, START_Y);
        GridEntity_Solution exit = randomEmpty(START_X, START_Y);
        GridEntity_Solution monster;
        // Ensure monster is not at the exit or player position
        do {
            monster = randomEmpty(START_X, START_Y);
        } while (monster.equals(exit) || monster.equals(player));

        System.out.println("-------------- Escape the 4x4 Grid! --------------");
        System.out.println("Reach the EXIT and avoid being caught by the MONSTER.");
        System.out.println();

        while (true) {
            //Debug: print the grid
            printGrid(player, monster, exit);

            System.out.printf("You are at (%d,%d).%n", player.getX(), player.getY());

            boolean moved = false;
            int oldPlayerX = player.getX();
            int oldPlayerY = player.getY();

            while (!moved) {
                System.out.print("Move (up/down/left/right or w/s/a/d): ");
                String s = INPUT.nextLine().trim().toLowerCase();
                if ((s.equals("w") || s.equals("up")) && player.getY() + 1 != GRID_SIZE) {
                    player.moveTo(player.getX(), player.getY() + 1);
                } else if ((s.equals("s") || s.equals("down")) && player.getY() - 1 != -1) {
                    player.moveTo(player.getX(), player.getY() - 1);
                } else if ((s.equals("a") || s.equals("left")) && player.getX() - 1 != -1) {
                    player.moveTo(player.getX() - 1, player.getY());
                } else if ((s.equals("d") || s.equals("right")) && player.getX() + 1 != GRID_SIZE) {
                    player.moveTo(player.getX() + 1, player.getY());
                } else {
                    System.out.println("Invalid move. Try again.");
                }
                if (player.getX() != oldPlayerX || player.getY() != oldPlayerY) {
                    moved = true;
                }
            }

            // Win check: reaching the exit this turn wins immediately (ties go to player)
            if (player.distanceFrom(exit) == 0) {
                System.out.println("You reached the EXIT! You win! 🎉");
                break;
            }
            // Lose check: if you stepped onto the monster (and it's not the exit), you lose
            else if (player.distanceFrom(monster) == 0) {
                System.out.println("The MONSTER was on that tile… You were caught! 💀");
                break;
            } else {
                // Distances AFTER the player moves (Manhattan)
                int distToExit = player.distanceFrom(exit);
                int distToMonster = player.distanceFrom(monster);
                System.out.printf("Distance to EXIT: %d   |   Distance to MONSTER: %d%n",
                        distToExit, distToMonster);
            }
            System.out.println();
        }

        System.out.println("\nGame over. Thanks for playing!");
    }

    //Helper methods-----------------------------------------

    // Find a random empty position that is not at x or y
    private static GridEntity_Solution randomEmpty(int x, int y) {
        while (true) {
            int rx = RNG.nextInt(GRID_SIZE);
            int ry = RNG.nextInt(GRID_SIZE);
            if (rx != x && ry != y) return new GridEntity_Solution(rx, ry);
        }
    }

    //Debug method to print the grid
    private static void printGrid(GridEntity_Solution player, GridEntity_Solution monster, GridEntity_Solution exit) {
        System.out.println("Current grid:");
        for (int y = GRID_SIZE - 1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if (player.getX() == x && player.getY() == y) {
                    System.out.print(" P "); // Player
                } else if (monster.getX() == x && monster.getY() == y) {
                    System.out.print(" M "); // Monster
                } else if (exit.getX() == x && exit.getY() == y) {
                    System.out.print(" E "); // Exit
                } else {
                    System.out.print(" . "); // Empty tile
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
