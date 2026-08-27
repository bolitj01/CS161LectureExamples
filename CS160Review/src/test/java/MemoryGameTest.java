import arrays.MemoryGame_Solution;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

// Tests exercise MemoryGame_Solution's private static helpers via reflection,
// since the game logic isn't exposed through any public API besides main().
public class MemoryGameTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream capturedOut;

    @BeforeEach
    void redirectOut() {
        capturedOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOut));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private static Method getMethod(String name, Class<?>... paramTypes) throws NoSuchMethodException {
        Method method = MemoryGame_Solution.class.getDeclaredMethod(name, paramTypes);
        method.setAccessible(true);
        return method;
    }

    // MemoryGame_Solution always builds a 4x4 (16-tile) board, so 8 animal pairs are required
    private static List<String> sampleAnimals() {
        return new ArrayList<>(List.of("cat", "dog", "fox", "hamster", "wolf", "ant", "cow", "pig"));
    }

    @Test
    void setupBoardFillsEachAnimalExactlyTwice() throws Exception {
        List<String> animals = sampleAnimals();
        String[][] board = new String[4][4];
        boolean[][] revealed = new boolean[4][4];

        Method setupBoard = getMethod("setupBoard", String[][].class, boolean[][].class, List.class, Random.class);
        setupBoard.invoke(null, board, revealed, animals, new Random(42));

        Map<String, Integer> counts = new HashMap<>();
        for (String[] row : board) {
            for (String tile : row) {
                counts.merge(tile, 1, Integer::sum);
            }
        }

        assertEquals(animals.size(), counts.size(), "Board should contain every animal");
        for (String animal : animals) {
            assertEquals(2, counts.get(animal), "Each animal should appear exactly twice");
        }
    }

    @Test
    void setupBoardStartsWithAllTilesHidden() throws Exception {
        List<String> animals = sampleAnimals();
        String[][] board = new String[4][4];
        boolean[][] revealed = new boolean[4][4];
        // Pre-fill revealed with true to confirm setupBoard resets it to false
        for (boolean[] row : revealed) {
            java.util.Arrays.fill(row, true);
        }

        Method setupBoard = getMethod("setupBoard", String[][].class, boolean[][].class, List.class, Random.class);
        setupBoard.invoke(null, board, revealed, animals, new Random(1));

        for (boolean[] row : revealed) {
            for (boolean isRevealed : row) {
                assertFalse(isRevealed, "All tiles should start hidden");
            }
        }
    }

    @Test
    void pickTileReturnsValidCoordinates() throws Exception {
        boolean[][] revealed = new boolean[4][4];
        System.setIn(new ByteArrayInputStream("1 2\n".getBytes()));
        Scanner scanner = new Scanner(System.in);

        Method pickTile = getMethod("pickTile", Scanner.class, boolean[][].class);
        int[] result = (int[]) pickTile.invoke(null, scanner, revealed);

        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void pickTileRejectsOutOfBoundsThenAcceptsValidInput() throws Exception {
        boolean[][] revealed = new boolean[4][4];
        System.setIn(new ByteArrayInputStream("5 5\n0 0\n".getBytes()));
        Scanner scanner = new Scanner(System.in);

        Method pickTile = getMethod("pickTile", Scanner.class, boolean[][].class);
        int[] result = (int[]) pickTile.invoke(null, scanner, revealed);

        assertArrayEquals(new int[]{0, 0}, result);
        assertTrue(capturedOut.toString().contains("Invalid input"));
    }

    @Test
    void pickTileRejectsAlreadyRevealedTile() throws Exception {
        boolean[][] revealed = new boolean[4][4];
        revealed[1][2] = true;
        System.setIn(new ByteArrayInputStream("1 2\n3 3\n".getBytes()));
        Scanner scanner = new Scanner(System.in);

        Method pickTile = getMethod("pickTile", Scanner.class, boolean[][].class);
        int[] result = (int[]) pickTile.invoke(null, scanner, revealed);

        assertArrayEquals(new int[]{3, 3}, result);
        assertTrue(capturedOut.toString().contains("already revealed"));
    }

    @Test
    void printBoardHidesUnrevealedTilesAndShowsRevealedOnes() throws Exception {
        String[][] board = new String[4][4];
        for (String[] row : board) {
            java.util.Arrays.fill(row, "cat");
        }
        boolean[][] revealed = new boolean[4][4];
        revealed[0][0] = true;

        Method printBoard = getMethod("printBoard", String[][].class, boolean[][].class);
        printBoard.invoke(null, board, revealed);

        String output = capturedOut.toString();
        assertTrue(output.contains("cat"), "Revealed tile should show its animal");
        assertTrue(output.contains("??"), "Hidden tiles should show the placeholder");
    }
}
