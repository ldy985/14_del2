package Game;

//
public class Shaker {

    //Initializing variables
    private int sum;
    private final Die[] dice;


    //The Constructor for the Shaker class
    public Shaker(int dieCount) {
        dice = new Die[dieCount];
        for (int i = 0; i < dieCount; i++) {
            dice[i] = new Die();
        }
    }

    // Rolls the two dice
    public void shake() {
        sum = 0;
        for (Die die : this.dice) {
            die.roll();
            sum += die.getFaceValue();
        }
    }

    // Returns the sum
    public int getSum() {
        return sum;
    }

    // 
    public Die[] getDice() {
        return dice;
    }

}



