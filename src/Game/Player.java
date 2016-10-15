package Game;
public class Player {


    private String name;
    private boolean isTurn;
    private Account account;

    public Player(String playerName) {
        name = playerName;
        account = new Account();
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
