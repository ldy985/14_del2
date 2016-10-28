package Game;

public class Shaker {

    //initialising variables
    private int sum;
    private final Die[] die;


    //The Constructor for the Shaker class
    public Shaker(int dieCount) {
        die = new Die[dieCount];
        for (int i = 0; i < dieCount; i++) {
            die[i] = new Die();
        }
    }

    public void shake() {
        sum = 0;
        for (Die die : this.die) {
            die.roll();
            sum += die.getFaceValue();
        }
    }


    public int getSum() {
        return sum;
    }

    public Die[] getDice() {
        return die;
    }

}



