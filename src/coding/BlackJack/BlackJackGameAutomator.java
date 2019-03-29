package coding.BlackJack;

import java.util.ArrayList;
import java.util.List;

/**
 * the automator which can activate the game system.
 */
class BlackJackGameAutomator {
    private Deck deck;
    private BlackJackHand[] players;
    private final static int HIT_UNTIL = 16;

    public BlackJackGameAutomator(String[] nameList) {
        players = new BlackJackHand[nameList.length];
        for (int i = 0; i < nameList.length; i++) {
            players[i] = new BlackJackHand(nameList[i]);
        }
    }

    void initializeDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    boolean dealInitial() {
        for (BlackJackHand oneUser : players) {
            Card[] cards = deck.dealHands(2);
            if (cards == null) {
                return false;
            }
            oneUser.addCard(cards);
        }
        return true;
    }

    /**
     * get all players who hold Black Jack.
     *
     * @return a list of players.
     */
    List<Hand> getBlackJacks() {
        List<Hand> winners = new ArrayList<>();
        for (BlackJackHand player : players) {
            if (player.isBlackJack()) {
                winners.add(player);
            }
        }
        return winners;
    }

    /**
     * one user's operation, require cards until reach HIT_UNTIL to get as maximum score as possible.
     *
     * @param player this user.
     * @return <tt>true</tt> if this user require at least one card.
     */
    boolean playHand(BlackJackHand player) {
        while (player.score() < HIT_UNTIL) {
            Card card = deck.dealCard();
            if (card == null) {
                return false;
            }
            player.addCard(card);
        }
        return true;
    }

    /**
     * check if there is any play doesn't need card any more.
     *
     * @return <tt>true</tt> when there is at least one player doesn't need card any more.
     */
    boolean playAllHand() {
        for (BlackJackHand player : players) {
            if (!playHand(player)) {
                return false;
            }
        }
        return true;
    }

    /**
     * get the user whose score is highest. traverse all users iteratively.
     *
     * @return this player.
     */
    List<Hand> getWinners() {
        List<Hand> winners = new ArrayList<>();
        int winnerScore = 0;
        for (BlackJackHand player : players) {
            if (!player.busted()) {
                if (player.score() > winnerScore) {
                    winnerScore = player.score();
                    winners.clear();
                    winners.add(player);
                } else if (player.score() == winnerScore) {
                    winners.add(player);
                }
            }
        }
        return winners;
    }

    /**
     * print all players cards, including suit and face value.
     */
    void printPlayersAndScores() {
        for (BlackJackHand player : players) {
            System.out.println(player.name + "(" + player.score() + "):");
            player.print();
            System.out.println();
        }
    }

    /**
     * the complete game process.
     */
    void simulate() {
        initializeDeck();
        boolean success = dealInitial();
        if (!success) {
            System.out.print("Error: Run out of cards.");
        } else {
            System.out.println("---Initial----");
            printPlayersAndScores();
            List<Hand> blackJacks = getBlackJacks();
            if (blackJacks.size() > 0) {
                System.out.print("Black Jack lies in:");
                for (Hand h : blackJacks) {
                    System.out.print(h.name + " ");
                }
                System.out.println();
                System.out.println("done.");
            } else {
                success = playAllHand();
                if (!success) {
                    System.out.println("Error: cards out of bound.");
                }
                System.out.println("---Completed Game---");
                printPlayersAndScores();
                List<Hand> winners = getWinners();
                if (winners.size() > 0) {
                    System.out.println("Winners:");
                    for (Hand h : winners) {
                        System.out.println(h.name);
                    }
                    System.out.println();
                } else {
                    System.out.println("Draw. All players have busted.");
                }
            }
        }
    }
}
