package Game;
public class Player {


    private String name;
    private boolean isTurn;
    private Account account;


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
}
