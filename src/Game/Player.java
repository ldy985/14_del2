package Game;

// Represents each player as an object.
// Keeps track of whether the player has his turn, has won, and the car spot for the previous turn.
public class Player {

    private final String name;
    private boolean isTurn;
    private final Account account;
    private int carSpot = 0;

    //
    public Player(String playerName) {
        name = playerName;
        account = new Account(1000);
    }

    // Returns the account object.
    public Account getAccount() {
        return account;
    }

    // Returns the name
    public String getName() {
        return name;
    }

    // Changes whether the player has the turn or not.
    public void setIsTurn(boolean turn) {
        isTurn = turn;
    }

    // Returns the turn boolean.
    public boolean getIsTurn() {
        return isTurn;
    }

    // Method for checking if someone has won
    public boolean hasWon() {

        int currentBalance = account.getBalance();

        // Win condition: If the player has 3000 points or over, he/she wins.
        if (currentBalance >= 3000) {
            return true;
        }
        else {
            return false;
        }

    }

}
