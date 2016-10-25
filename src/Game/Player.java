package game;

public class Player {


    private String name;
    private int point = 0;
    private boolean isTurn;
    private boolean double6 = false;


    public Player(String playerName) {
        name = playerName;
    }

    public String getName() {
        return name;
    }

    public void setDouble6(boolean six) {
        double6 = six;
    }

    public boolean getDouble6() {
        return double6;
    }

    public void setIsTurn(boolean turn) {
        isTurn = turn;
    }

    public boolean getIsTurn() {
        return isTurn;
    }

    public void setPoints(int points) {
        this.point = points;
    }

    public void addPoints(int sum) {

        this.point = point + sum;
    }

    public int getPoints() {
        return point;
    }
}
