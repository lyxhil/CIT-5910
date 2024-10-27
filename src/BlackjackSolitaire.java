import java.util.Scanner;
import java.util.ArrayList;

public class BlackjackSolitaire {
    private Deck deck;
    private String[][] grid;
    private int discardsRemaining;
    private int cardsInGrid;
    private Combinations combi; // to test
    private Calculator calculator;

    public BlackjackSolitaire() {
        deck = new Deck();

        grid =  new String[][] {
            {"1", "2", "3", "4", "5"},
            {"6", "7", "8", "9", "10"},
            {" ", "11", "12", "13", " "},
            {" ", "14", "15", "16", " "}
        };

        discardsRemaining = 4;
        cardsInGrid = 0;

        combi = new Combinations(); // to test
        calculator = new Calculator();
    }

    public void play() {
        while (cardsInGrid < 16) {
            displayGrid();

            // Draw card and remove card from deck
            Card top = deck.getTopCard();
            deck.removeTopCard();

            System.out.println("You drew: " + top.toString());
            System.out.println("Are you placing this card in the grid (key in 1) or discarding this card (key in 2)?");
            gridOrDiscard(top.toString());
        }

        // When cardsInGrid == 16, game is over so scores should be calculated
        System.out.println("Number of Combinations: " + combi.collectAllCombi(grid).size()); // Expected: 95
        int score = calculator.totalScore(grid);
        System.out.println("Game over! You scored " + score + " points.");
    }

    public void displayGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Discards remaining: " + discardsRemaining);
    }

    public void gridOrDiscard(String card) {
        Scanner in = new Scanner(System.in);

        int choice = in.nextInt();

        // Valid input
        if (choice == 1 || choice == 2) {
            if (choice == 1) {
                System.out.println("Please select the position (1 to 16) to place this card.");
                selectGridPosition(card);
            } else if (choice == 2 && discardsRemaining > 0) {
                discardsRemaining--;
            } else if (choice == 2 && discardsRemaining == 0) {
                System.out.println("You have hit the maximum discards. Please select the position (1 to 16) to place this card.");
                selectGridPosition(card);
            }
        } else { // Invalid input
            System.out.println("Invalid input: Please key in 1 to place card in grid or 2 to discard card");
            gridOrDiscard(card);
        }
    }


    public void selectGridPosition(String card) {
        boolean validPosition = false;

        Scanner in = new Scanner(System.in);
        String position = in.next();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (position.equals(grid[i][j])) {
                    validPosition = true;
                }
            }
        }

        if (validPosition) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (position.equals(grid[i][j])) {
                        grid[i][j] = card;
                        cardsInGrid++;
                    }
                }
            }
        } else {
            System.out.println("Please select another position.");
            selectGridPosition(card);
        }
    }
}
