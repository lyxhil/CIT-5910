import java.util.ArrayList;

public class Calculator {
    private Combinations combi;
    private Card card;

    // All combinations are in arraylist named combinations. For each combination, we have to determine the value of the cards and sum them up.
    public int totalScore(String[][] grid){
        int totalScore = 0;

        // Generate all combinations from grid
        Combinations combi = new Combinations();
        ArrayList<String> combinations = combi.collectAllCombi(grid);

        // Sum the score for each combination
        for (int i = 0; i < combinations.size(); i++) {
            totalScore += combiScore(combinations.get(i));
        }

        return totalScore;
    }

    private int combiScore(String cardsInCombi) {
        int combiScore = 0;

        // Split string into array of individual cards
        String[] cardsArray = cardsInCombi.split(", ");

        // Calculate sum of card values and indicate if Ace exists in combination
        int arrayValue = 0;
        boolean aceExists = false;
        for (int i = 0; i < cardsArray.length; i++) {
            String rank = cardsArray[i].substring(0,cardsArray[i].length() - 1);
            if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
                arrayValue += 10;
            } else if (rank.equals("A")) {
                arrayValue += 1;
                aceExists = true;
            } else {
                arrayValue += Integer.parseInt(rank);
            }
        }

        // Calculate score for combination while accounting for Ace card
        if (aceExists) {
            if (arrayValue + 10 > 21) {
                combiScore = valueToScore(arrayValue, cardsArray.length);
            } else {
                combiScore = valueToScore(arrayValue + 10, cardsArray.length);
            }
        } else {
            combiScore = valueToScore(arrayValue, cardsArray.length);
        }

        return combiScore;
    }

    private int valueToScore(int arrayValue, int numberOfCards) {
        int combiScore = 0;

        if (arrayValue == 21) {
            if (numberOfCards == 2) {
                combiScore += 10;
            } else {
                combiScore += 7;
            }
        } else if (arrayValue == 20) {
            combiScore += 5;
        } else if (arrayValue == 19) {
            combiScore += 4;
        } else if (arrayValue == 18) {
            combiScore += 3;
        } else if (arrayValue == 17) {
            combiScore += 2;
        } else if (arrayValue <= 16) {
            combiScore += 1;
        }
        return combiScore;
    }

    public static void main(String[] args) {
        String[][] test1 = {
                {" ", "3C", "AC", "4S", " "}
        };

        Calculator calc = new Calculator();
        System.out.println("Test 1 - Expected: 6, Actual: " + calc.totalScore(test1));

        String[][] test2 = {
                {"KH", "3H", "JH", "10H", "QH"},
                {" ", "3C", "AC", "4S", " "}
        };

        System.out.println("Test 2 - Expected: 52, Actual: " + calc.totalScore(test2));

        String[][] test3 = {
                {"AD", "5H", "7S", "10C", "AH"},
        };

        System.out.println("Test 3 - Expected: 57, Actual: " + calc.totalScore(test3));

        String[][] test4 = {
                {"AD", "AH"},
                {"7S", "10C"},
                {" ", "AD"},
        };
        System.out.println("Test 4 - Expected: 28, Actual: " + calc.totalScore(test4));

    }
}
