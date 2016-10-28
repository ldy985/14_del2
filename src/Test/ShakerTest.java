package Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Tests the Shaker class
public class ShakerTest {

    // Declares object of the "Shaker" class in the folder "game".
    private final Game.Shaker shake = new Game.Shaker(2);

    // Declares variables.
    private boolean getSumTestComplete = false;

    @Test
    public void probTest() {
        int value;

        int to = 0;
        int tre = 0;
        int fire = 0;
        int fem = 0;
        int seks = 0;
        int syv = 0;
        int otte = 0;
        int ni = 0;
        int ti = 0;
        int elleve = 0;
        int tolv = 0;
        int forkertnr = 0;

        // Rolling the die 60000 times.
        // Counts the values a specific value has been rolled.

        for (int i = 0; i < 1000; i++) {

            shake.shake();

            value = shake.getSum();

            switch (value) {
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
                case 7:
                    syv++;
                    break;
                case 8:
                    otte++;
                    break;
                case 9:
                    ni++;
                    break;
                case 10:
                    ti++;
                    break;
                case 11:
                    elleve++;
                    break;
                case 12:
                    tolv++;
                    break;
                default:
                    forkertnr++;
                    break;
            }

        }

        // Tests the program.
        // Checks if all values, of the die (2-12), has been rolled and equal amount of times (1000/12000)
        // with a deviation of 400 times.
        assertEquals(0, forkertnr);
        assertEquals(28, to, 24);
        assertEquals(56, tre, 24);
        assertEquals(83, fire, 24);
        assertEquals(111, fem, 24);
        assertEquals(139, seks, 24);
        assertEquals(167, syv, 24);
        assertEquals(139, otte, 24);
        assertEquals(111, ni, 24);
        assertEquals(83, ti, 24);
        assertEquals(56, elleve, 24);
        assertEquals(28, tolv, 24);

    }

    // Tests if the getSum() method works in the Shaker class
    @Test
    public void getSumTest() throws Exception {

        // Calls the Shake() method in the class Shaker, through the object "shake".
        shake.shake();

        // Checks if the sum given by the Shaker class is between 2 and 12.
        // Returns a boolean whether it works.
        if (shake.getSum() >= 2 && shake.getSum() <= 12) {

            getSumTestComplete = true;
        }


        // Checks if the booleans are true.
        assertEquals(true, getSumTestComplete);

    }

}