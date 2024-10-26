import java.util.Scanner;
import java.util.ArrayList;

public class BlackjackSolitaire {
    private Deck deck;
    private String[][] grid;
    private int discardsRemaining;
    private int cardsInGrid;
    private Calculator calculator;

    public BlackjackSolitaire() {
        deck = new Deck();

        grid =  new String[4][5];

        discardsRemaining = 4;
        cardsInGrid = 0;

        calculator = new Calculator();
    }

    public void play() {
        Scanner in = new Scanner(System.in);

        while (cardsInGrid < 16) {
            displayGrid();
            Card top = deck.getTopCard();
            deck.removeTopCard();
            System.out.println("You drew: " + top.toString());
            System.out.println("Are you placing this card in the grid (key in 1) or discarding this card (key in 2)?");
            int placeInGrid = in.nextInt();
            if (placeInGrid == 1) {
                System.out.println("Please select the position (1 to 16) to place this card.");
                selectGridPosition();
            } else if (placeInGrid == 2 && discardsRemaining > 0) {
                discardsRemaining--;
            } else if (placeInGrid == 2 && discardsRemaining == 0) {
                System.out.println("You have hit the maximum discards. Please select the position (1 to 16) to place this card");
                selectGridPosition();
            } else {
                System.out.println("Invalid input: Please key in 1 to place card in grid or 2 to discard card");
            }
        }

        int score = Calculator.score();
        System.out.println("Game over! You scored " + score + " points.");
    }

    public void displayGrid() {
        grid[0] = {"1", "2", "3", "4", "5"};
        grid [1] = {"6", "7", "8", "9", "10"};
        grid [2] = {" ", "11", "12", "13", " "};
        grid [3] = {" ", "14", "15", "16", " "};
        System.out.println(grid);
        System.out.println("Discards remaining: " + discardsRemaining);
        }

    public void selectGridPosition() {
        boolean validPosition = false;

        Scanner in = new Scanner(System.in);
        String position = in.next();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (position,equals(grid[i][j])) {
                    validPosition = true;
                }
            }
        }

        if (validPosition) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (position.equals(grid[i][j])) {
                        grid[i][j] = position;
                        cardsInGrid++;
                    }
                }
            }
        } else {
            System.out.println("Position " + position + "has been filled. Please select another unfilled position.");
            selectGridPosition();
        }
    }

}
