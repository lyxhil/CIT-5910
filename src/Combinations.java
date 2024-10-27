import java.util.ArrayList;

public class Combinations {
    private ArrayList<String> allCombi;

    public Combinations() {
        allCombi = new ArrayList<String>();
    }

    private void generateCombi(String[] arr, int combiLength, int startPosition, ArrayList<String> currentCombi) {
        // Once length of current combination hits the length required for this combination, add it to the allCombi arraylist
        if (currentCombi.size() == combiLength) {
            allCombi.add(String.join("", currentCombi));
            return;
        }

        // Add card to combination before conducting recursive call
        for (int i = startPosition; i < arr.length; i++) {
            currentCombi.add(arr[i]);
            generateCombi(arr, combiLength, i + 1, currentCombi);

            // To ensure all combinations are found, backtrack after recursive call
            currentCombi.remove(currentCombi.size() - 1);
        }
    }

    public ArrayList<String> collectAllCombi(String[][] grid) {
        // Iterate through rows
        for (int row = 0; row < grid.length; row++) {
            // Create new array of cards in each row to filter out spaces
            ArrayList<String> validCards = new ArrayList<String>();
            for (int col = 0; col < grid[row].length; col++) {
                if (!grid[row][col].trim().isEmpty()) {
                    validCards.add(grid[row][col]);
                }
            }

            // Convert arraylist to array
            String[] rowArray = validCards.toArray(new String[validCards.size()]);

            // Generate combinations for each row
            for (int combiLength = 2; combiLength <= (Math.min(5, rowArray.length)); combiLength++) {
                generateCombi(rowArray, combiLength, 0, new ArrayList<>());
            }
        }

        // Iterate through columns
        for (int col = 0; col < grid[0].length; col++) {
            // Create new array of cards in each column to filter out spaces
            ArrayList<String> validCards = new ArrayList<String>();
            for (int row = 0; row < grid.length; row++) {
                if (!grid[row][col].trim().isEmpty()) {
                    validCards.add(grid[row][col]);
                }
            }

            // Convert arraylist to array
            String[] colArray = validCards.toArray(new String[validCards.size()]);

            // Generate combinations for each row
            for (int combiLength = 2; combiLength <= (Math.min(5, colArray.length)); combiLength++) {
                generateCombi(colArray, combiLength, 0, new ArrayList<>());
            }
        }

        return allCombi;
    }

    // To test Combinations.java
    public static void main(String[] args) {
        String[][] testGrid = {
                {"2H", "3H", "4H", "5H", "6H"},
                {"KD", "QD", "JD", "10D", "AD"},
                {" ", "3C", "AC", "4S", " "}
        };

        Combinations combi = new Combinations();
        ArrayList<String> results = combi.collectAllCombi(testGrid);

        System.out.println("Total combi found: " + results.size()); // Expected: 70
        System.out.println("Combinations:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}

