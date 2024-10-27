import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private int currentIndex;

    public Deck() {
        deck = new ArrayList<Card>();
        char[] suit = {'D', 'H', 'S', 'C'};
        String[] rank = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Deck of 52 cards
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck.add(new Card(rank[j], suit[i]));
            }
        }

        Collections.shuffle(deck);
        currentIndex = 0;
    }

    public Card getTopCard() {
        if (!deck.isEmpty()) {
            return deck.get(0);
        }
        return null;
    }

    public void removeTopCard() {
        deck.remove(0);
    }
}
