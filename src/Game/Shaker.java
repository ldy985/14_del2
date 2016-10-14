package game;

/**
 * Created by timot on 03-10-2016.
 */

public class Shaker {

    //initialising variables

    private int sum;
    private int valueDice1;
    private int valueDice2;
    private boolean isDouble;

    //Creating two objects from the Dice class.

    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();


    //The Constructor for the Shaker class

    public Shaker() {

    }

    //Creating the shake Method returning a string with the values fot Dice1 and dice2

    public String Shake() {

        dice1.Roll();
        dice2.Roll();

        valueDice1 = dice1.getFaceValue();
        valueDice2 = dice2.getFaceValue();

        sum = valueDice1 + valueDice2;

        return "The value for the first dice is " + valueDice1 + " and the value for the second dice is " + valueDice2 + ".";
    }

    public int getDie1Value() {
        return valueDice1;
    }

    public int getDie2Value() {
        return valueDice2;
    }


    //Creating the method for storing the sum of the Dice values

    public int getSum() {
        return sum;
    }

    //Creating the method to evaluate if the values on the Dice rolled are the same

    public boolean getDouble() {


        if (valueDice1 == valueDice2) {

            isDouble = true;

        } else {

            isDouble = false;
        }

        return isDouble;
    }

}



