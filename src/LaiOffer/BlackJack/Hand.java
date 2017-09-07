package LaiOffer.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * one hand represents one user.
 */
public abstract class Hand{
    protected final List<Card> cards = new ArrayList<>();
    protected String name;
    private static final String DEFAULT_NAME = "Lao Wang";


    Hand() {
        this.name = DEFAULT_NAME;
    }


    /**
     * calculate the current score based on the game type and the cards this user holds.
     *
     * @return
     */
    public abstract int score();

    /**
     * receive one card form deck.
     *
     * @param c
     */
    public void addCard(Card c) {
        cards.add(c);
    }

    /**
     * receive a list of cards from deck.
     *
     * @param c
     */
    public void addCard(Card[] c) {
        Collections.addAll(cards, c);
    }

    /**
     * return how many cards this user has.
     *
     * @return
     */
    public int size() {
        return cards.size();
    }
}
