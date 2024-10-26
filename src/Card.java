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

    public int getValue() {
        int value;
        if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            value = 10;
        } else if (rank == "A") {
            value = 1;
        } else {
            value = Integer.parseInt(rank);
        }
        return value;
    }

}
