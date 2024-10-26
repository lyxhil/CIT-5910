import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private int currentIndex;

    public Deck() {
        ArrayList<Card> cards = new ArrayList<Card>();
        char[] suit = {'D', 'H', 'S', 'C'};
        String[] rank = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'};

        // Deck of 52 cards
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                cards.add(new Card(rank, suit));
            }
        }

        Collections.shuffle(cards);
        currentIndex = 0;
    }

    public Card getTopCard() {
        if (!cards.isEmpty()) {
            return cards.get(0);
        }
        return null;
    }

    public void removeTopCard() {
        cards.remove(0);
    }
}
