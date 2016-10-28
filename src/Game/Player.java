package Game;

public class Player {


    private final String name;
    private boolean isTurn;
    private final Account account;
    private int carSpot = 0;


    public Player(String playerName) {
        name = playerName;
        account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public void setIsTurn(boolean turn) {
        isTurn = turn;
    }

    public boolean getIsTurn() {
        return isTurn;
    }

    // Method for checking if someone has won
    public boolean hasWon() {

        int currentBalance = account.getBalance();

        return currentBalance >= 3000;

    }

    public int getCarSpot() {
        return carSpot;
    }

    public void setCarSpot(int carSpot) {
        this.carSpot = carSpot;
    }
}
