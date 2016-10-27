package Game;

public class Player {


    private String name;
    private boolean isTurn;
    private boolean extraTurn;
    private Account account;
    private int sumTemp = 999;


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

    // Rasmus lækre hack for at få GameController til at virke
    public boolean getExtraTurn() {return extraTurn; }

    public void setExtraTurn(boolean extraTurn) {this.extraTurn = extraTurn;}

    public int getSumTemp() {return sumTemp;}

    public void setSumTemp(int sum){ sumTemp = sum;}
}
