package Game;

import java.util.Random;


//*******************************************************************
//  Die
//
// Rolls and returns a random value between 1 and 6.
//*******************************************************************
public class Die {

    private final Random rand = new Random();
    private int faceValue;

    // Method for rolling the die.
    public void roll() {

        faceValue = rand.nextInt(6) + 1;
    }

    // Returns the face value.
    public int getFaceValue() {

        return faceValue;
    }
}