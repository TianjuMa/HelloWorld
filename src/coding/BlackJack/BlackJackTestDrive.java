package coding.BlackJack;

/**
 * main function for testing the feasibility of Black Jack Game.
 */
public class BlackJackTestDrive {
    public static void main(String[] args) {
        String[] nameList = {"Jason", "Tom", "Leo", "Mike", "Richard"};
        BlackJackGameAutomator automator = new BlackJackGameAutomator(nameList);
        automator.simulate();
    }
}
