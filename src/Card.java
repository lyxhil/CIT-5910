public class Card {
    private String rank;
    private char suit;

    public Card (String rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public String toString() {
        return rank + suit;
    }

}
