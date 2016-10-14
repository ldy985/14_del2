package game;

import java.util.Random;

/**
 * Created by s165240 on 23-09-2016.
 */
public class Dice {

    private final Random rand = new Random();

    private int faceValue;

    public void Roll() {

        faceValue = rand.nextInt(6) + 1;

    }

    public int getFaceValue() {

        return faceValue;
    }
}