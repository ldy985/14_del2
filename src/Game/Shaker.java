package Game;

public class Shaker {

    //initialising variables
    private int sum;
    private Dice[] dice;


    //The Constructor for the Shaker class
    public Shaker(int dieCount) {
        dice = new Dice[dieCount];
    }

    public void shake() {
        sum = 0;
        for (Dice die : dice) {
            die.Roll();
            sum += die.getFaceValue();
        }
    }

    public int getSum() {
        return sum;
    }

    public Dice[] getDice() {
        return dice;
    }

}



