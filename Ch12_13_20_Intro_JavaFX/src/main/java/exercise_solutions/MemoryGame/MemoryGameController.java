package exercise_solutions.MemoryGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MemoryGameController {

    @FXML
    private Label p1ScoreLbl;

    @FXML
    private Label p2ScoreLbl;

    @FXML
    private Button nextTurnBtn;

    @FXML
    private GridPane gameGrid;

    private final int SIZE = 4;
    private final Random random = new Random();
    private boolean firstPick = true;
    private int currentPlayer = 0;
    private Button firstChoice;
    private Button secondChoice;
    private int[] playerScores = new int[] { 0, 0 };
    private String[][] board = new String[SIZE][SIZE];
    private boolean[][] revealed = new boolean[SIZE][SIZE];

    ArrayList<String> animals = new ArrayList<>(List.of(new String[] {
            "\uD83D\uDC31", // 🐱 cat
            "\uD83D\uDC36", // 🐶 dog
            "\uD83E\uDD8A", // 🦊 fox
            "\uD83D\uDC39", // 🐹 hamster
            "\uD83D\uDC3A", // 🐺 wolf
            "\uD83D\uDC1C", // 🐜 ant
            "\uD83D\uDC2E", // 🐮 cow
            "\uD83D\uDC37" // 🐷 pig
    }));

    // Starts on launch
    public void initialize() {
        setupBoard();
    }

    private void setupBoard() {
        //Make tiles
        ArrayList<String> tiles = new ArrayList<>(animals);
        tiles.addAll(animals);

        //Shuffle the animal tiles
        Collections.shuffle(tiles, random);

        //Reset the player scores
        playerScores[0] = 0;
        playerScores[1] = 0;
        p1ScoreLbl.setText("Player 1 Score: 0");
        p2ScoreLbl.setText("Player 2 Score: 0");

        //Reset choices
        firstChoice = null;
        secondChoice = null;

        //Reset next turn button
        nextTurnBtn.setVisible(false);
        nextTurnBtn.setText("Next Turn");
        nextTurnBtn.setOnAction(e -> {
            nextTurn();
        });

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                board[r][c] = tiles.get(r * SIZE + c);
                revealed[r][c] = false;
                Button gridSymbol = new Button("?");
                gameGrid.add(gridSymbol, c, r);
                final int row = r;
                final int col = c;
                gridSymbol.setOnAction(event -> {
                    //TODO: Avoid letting a player select more than two tiles
                    //Don't do anything if the first and second choices are already selected
                    //The next turn needs to be taken before selecting new tiles
                    if (firstChoice != null && secondChoice != null) {
                        return;
                    }

                    Button callingBtn = (Button) event.getSource();
                    callingBtn.setText(board[row][col]);

                    if (firstPick) {
                        firstChoice = callingBtn;
                    } else {
                        // Don't let player choose firstChoice again
                        if (callingBtn == firstChoice) {
                            return;
                        }

                        // Check for match, update score
                        secondChoice = callingBtn;
                        if (firstChoice.getText().equals(secondChoice.getText())) {
                            if (currentPlayer == 0) {
                                playerScores[0]++;
                                p1ScoreLbl.setText("Player " + (currentPlayer + 1) + " Score: " + playerScores[0]);
                            } else {
                                playerScores[1]++;
                                p2ScoreLbl.setText("Player " + (currentPlayer + 1) + " Score: " + playerScores[1]);
                            }
                            // TODO: Remove action event from the buttons
                            firstChoice.setOnAction(null);
                            secondChoice.setOnAction(null);
                            // TODO: Update revealed array for the matched tiles
                            int firstRow = GridPane.getRowIndex(firstChoice);
                            int firstCol = GridPane.getColumnIndex(firstChoice);
                            int secondRow = GridPane.getRowIndex(secondChoice);
                            int secondCol = GridPane.getColumnIndex(secondChoice);
                            revealed[firstRow][firstCol] = true;
                            revealed[secondRow][secondCol] = true;

                            firstChoice = null;
                            secondChoice = null;
                            checkGameOver();
                        } else {
                            // Hide the tiles if they don't match
                            nextTurnBtn.setVisible(true);
                        }
                    }
                    firstPick = !firstPick;
                });
            }
        }
    }

    @FXML
    public void nextTurn() {
        currentPlayer = (currentPlayer + 1) % 2;
        firstPick = true;
        // TODO: Put the ? symbol back if there was no match
        if (!firstChoice.getText().equals(secondChoice.getText())) {
            firstChoice.setText("?");
            secondChoice.setText("?");
        }
        firstChoice = null;
        secondChoice = null;
        nextTurnBtn.setVisible(false);
    }

    // TODO: Method that checks for game over and
    // changes Next Turn button to Play Again
    public void checkGameOver() {
        // TODO: Check if all tiles are revealed
        boolean allRevealed = true;
        for (int revRow = 0; revRow < SIZE; revRow++) {
            for (int revCol = 0; revCol < SIZE; revCol++) {
                if (!revealed[revRow][revCol]) {
                    allRevealed = false;
                    break; // We immediately know that not all tiles are revealed
                }
            }
            if (!allRevealed)
                break;
        }
        if (allRevealed) {
            //Reuse the p1 label to show the game result
            p2ScoreLbl.setText("");
            p1ScoreLbl.setText("Game Over! Player " + (currentPlayer + 1) + " wins!");
            //Reuse the next turn button to play again
            nextTurnBtn.setText("Play Again");
            nextTurnBtn.setVisible(true);
            nextTurnBtn.setOnAction(e -> {
                setupBoard();
            });
        }
    }

    // private static void printBoard(String[][] board, boolean[][] revealed) {
    // System.out.println();
    // System.out.println(" 0 1 2 3");
    // System.out.println(" +----+----+----+----+");
    // for (int r = 0; r < SIZE; r++) {
    // StringBuilder row = new StringBuilder();
    // row.append(r).append(" |");
    // for (int c = 0; c < SIZE; c++) {
    // //Tile is either revealed (show animal) or hidden (show "?")
    // String tile = revealed[r][c] ? board[r][c] : "??";
    // row.append(String.format(" %s |", tile));
    // }
    // System.out.println(row);
    // System.out.println(" +----+----+----+----+");
    // }
    // }

}
