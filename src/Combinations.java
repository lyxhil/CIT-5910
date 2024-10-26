import java.util.ArrayList;
import static java.awt.AWTEventMulticaster.add;

public class Combinations {
    public static void ArrayList<String> cardCombinations(String[] elements, int combiLength; ArrayList<String> final) {
        helper(elements, combiLength, 0, new ArrayList<String>, final);
    }

    public static void helper(String[] elements, int combiLength, int start, ArrayList<String> currentCombi, ArrayList<String> final) {
        // Once current combination has hit combiLength, convert it into a string and add the combination to the list of combinations (final)
        if (currentCombi.size() == combiLength) {
            final.add(String.join("", currentCombi));
            return;
        }

        for (int i = start; i < elements.length; i++) {
            currentCombi.add(elements[i]);
            helper(elements, combiLength, start + 1, currentCombi, final);
        }
    }
}
