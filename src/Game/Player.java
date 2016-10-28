package Game;

public class Player {


    private String name;
    private boolean isTurn;
    private Account account;
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

        if(currentBalance >= 3000){

            return true;

        } else {

            return false;
        }

    }

    public int getCarSpot() {
        return carSpot;
    }

    public void setCarSpot(int carSpot) {
        this.carSpot = carSpot;
    }
}
