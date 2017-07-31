package LaiOffer.BlackJack;

import java.util.ArrayList;
import java.util.List;

/**
 * the black jack pattern extends the general hand class.
 */
public class BlackJackHand extends Hand {
    BlackJackHand(String name) {
        this.name = name;
    }

    /**
     * compute the score based on the BlackJack rule.
     *
     * @return this value.
     */
    @Override
    public int score() {
        List<Integer> possibleScores = getPossibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : possibleScores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    /**
     * determine whether a user succeed to has a BlackJack pattern.
     * BlackJack pattern: A + (J / Q / K)
     *
     * @return <tt>true</tt> if this user's score equals 21.
     */
    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        return isAce(card1) && isFaceCard(card2) || isAce(card2) && isFaceCard(card1);
    }

    /**
     * determine whether a user's score exceed 21.
     *
     * @return <tt>true</tt> if this user's score exceeds 21.
     */
    public boolean busted() {
        return score() > 21;
    }

    /**
     * print all cards (including suit and face value) for this player.
     */
    public void print() {
        for (Card card : cards) {
            System.out.println(card.suit + " " + card.faceValue);
        }
    }

    /**
     * get all permutations of possible scores of cards in hand.
     *
     * @return a list of all possible scores.
     */
    private List<Integer> getPossibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card c : cards) {
            updateScore(c, scores);
        }
        return scores;
    }

    /**
     * update all the values in the present score result, for a particular card value.
     *
     * @param c      one particular card.
     * @param scores the score list need to be updated.
     */
    private void updateScore(Card c, List<Integer> scores) {
        int[] toAdd = getValueToAdd(c);
        if (scores.isEmpty()) {
            for (int value : toAdd) {
                scores.add(value);
            }
        } else {
            final int length = scores.size();
            for (int i = 0; i < length; i++) {
                int oldValue = scores.get(i);
                scores.set(i, oldValue + toAdd[0]);
                for (int j = 1; j < toAdd.length; j++) {
                    scores.add(oldValue + toAdd[j]);
                }
            }
        }
    }

    /**
     * return its face value for all cards except Ace. return two possible values for Ace.
     *
     * @param c one particular card.
     * @return a list of all possible value of this card.
     */
    private int[] getValueToAdd(Card c) {
        if (c.getValue() > 1) {
            return new int[]{Math.min(c.getValue(), 10)};
        } else {
            return new int[]{1, 11};
        }
    }

    private boolean isAce(Card card) {
        return card.faceValue == 1;
    }

    private boolean isFaceCard(Card card) {
        return card.faceValue >= 11 && card.faceValue <= 13;
    }
}
