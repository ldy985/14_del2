package test;

import static org.junit.Assert.*;

/**
 * Created by Matt_Lab on 26/09/2016.
 */
public class DiceTest {
    game.Dice dice = new game.Dice();

    // Declares variables
    @org.junit.Test
    public void Roll() throws Exception {

        int value;
        int en = 0;
        int to = 0;
        int tre = 0;
        int fire = 0;
        int fem = 0;
        int seks = 0;
        int forkertnr = 0;

        // Rolling the dice 60000 times.
        // Counts the values a specific value has been rolled.

        for (int i = 0; i < 60000; i++) {
            dice.Roll();
            value = dice.getFaceValue();
            // System.out.println(value + " ");
            switch (value) {
                case 1:
                    en++;
                    break;
                case 2:
                    to++;
                    break;
                case 3:
                    tre++;
                    break;
                case 4:
                    fire++;
                    break;
                case 5:
                    fem++;
                    break;
                case 6:
                    seks++;
                    break;
                default:
                    forkertnr++;
                    break;
            }

        }

        // Tests the program.
        // Checks if all values, of the dice (1-6), has been rolled and equal amount of times (10000/60000)
        // with a deviation of 400 times.
        assertEquals(0, forkertnr);
        assertEquals(10000, en, 400);
        assertEquals(10000, to, 400);
        assertEquals(10000, tre, 400);
        assertEquals(10000, fire, 400);
        assertEquals(10000, fem, 400);
        assertEquals(10000, seks, 400);


    }


}