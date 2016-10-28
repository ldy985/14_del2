package Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Tests the Shaker class
public class ShakerTest {

    // Declares object of the "Shaker" class in the folder "game".
    private final Game.Shaker shake = new Game.Shaker(2);

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

        for (int i = 0; i < 60000; i++) {

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
        // Checks if all values, of the die (2-12), has been rolled and equal amount of times
        // with a deviation of 593 times.
        assertEquals(0, forkertnr);
        assertEquals(1667, to, 593);
        assertEquals(3334, tre, 593);
        assertEquals(5000, fire, 593);
        assertEquals(6666, fem, 593);
        assertEquals(8333, seks, 593);
        assertEquals(10000, syv, 593);
        assertEquals(8333, otte, 593);
        assertEquals(6666, ni, 593);
        assertEquals(5000, ti, 593);
        assertEquals(3334, elleve, 593);
        assertEquals(1667, tolv, 593);

    }

    // Tests if the getSum() method works in the Shaker class
    @Test
    public void getSumTest() throws Exception {

        // Calls the Shake() method in the class Shaker, through the object "shake".
        shake.shake();

        // Checks if the sum given by the Shaker class is between 2 and 12.
        // Returns a boolean whether it works.
        int sum = shake.getDice()[0].getFaceValue()+shake.getDice()[1].getFaceValue();

        assertEquals(sum, shake.getSum());


    }

}