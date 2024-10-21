import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card>;
    private int currentIndex;

    public Deck() {
        ArrayList<Card> deck = new ArrayList<Card>();
        char[] suit = {'D', 'H', 'S', 'C'};
        String[] rank = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'};

        // Deck of 52 cards
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck.add(new Card(rank, suit));
            }
        }

        Collections.shuffle(deck);
        currentIndex = 0;
    }
}
