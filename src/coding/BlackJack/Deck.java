package coding.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 52 cards in one deck.
 */
class Deck {
    private static final Random random = new Random();
    private final List<Card> cards = new ArrayList<>();
    private int defaultIndex = 0;

    Deck() {
        for (int i = 1; i <= 13; i++) {
            for (Suit s : Suit.values()) {
                cards.add(new Card(i, s));
            }
        }
    }

    /**
     * return a random order of this list of cards.
     */
    void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    /**
     * send a list of cards to one user, return this list of card.
     *
     * @param number how many cards need to be send.
     * @return <tt>null</tt> if there is no enough cards to deal.
     */
    Card[] dealHands(int number) {
        if (number > cards.size() - defaultIndex) {
            return null;
        }
        Card[] cards = new Card[number];
        for (int i = 0; i < number; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }

    /**
     * send one card to a user, return this card.
     *
     * @return this card.
     */
    Card dealCard() {
        return remainingCards() == 0 ? null : cards.get(defaultIndex++);
    }

    /**
     * return the remaining number of cards in the deck.
     *
     * @return the number of remaining cards.
     */
    private int remainingCards() {
        return cards.size() - defaultIndex;
    }
}
