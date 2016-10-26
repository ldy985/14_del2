package Game;

public class Shaker {

    //initialising variables
    private int sum;
    private Die[] dice;


    //The Constructor for the Shaker class
    public Shaker(int dieCount) {
        dice = new Die[dieCount];
        for (int i = 0; i < dieCount; i++) {
            dice[i] = new Die();
        }
    }
    
    public void shake() {
        sum = 0;
        for (Die die : this.dice) {
            die.roll();
            sum += die.getFaceValue();
        }
    }

    public int getSum() {
        return sum;
    }

    public Die[] getDie() {
        return dice;
    }

}



