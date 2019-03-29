package LaiOffer.BlackJack;

/**
 * one card has one value (0 ~ 13)and one suit (4 kinds).
 */
public class Card {
    public final int faceValue;
    public final Suit suit;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public int getValue() {
        return faceValue;
    }

    public Suit getSuit() {
        return suit;
    }
}
