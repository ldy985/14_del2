package Game;

import java.util.Scanner;

import desktop_fields.Field;
import desktop_resources.GUI;
import desktop_fields.*;

/**
 * Created by razze on 25-10-2016.
 */
public final class GameController {

    private static final Shaker shake = new Shaker(2);
    private static final Player[] playerArray = new Player[6]; // max 6 players
    private static final Field[] fields = new Field[40];
    private static final Scanner input = new Scanner(System.in);
    private static boolean gameWon = false;
    private static final Random rand = new Random();

    //Prevent creation of a game controller object.
    private GameController() {
    }

    // Generates the fields for the board in a field array
    public static void generateFields() {

        //fields[0] = new Empty.Builder().build();

        fields[0] = new Street.Builder()
                .setTitle("Tower")
                .setRent("250")
                .build();
        fields[1] = new Street.Builder()
                .setTitle("Crater")
                .setRent("-100")
                .build();
        fields[2] = new Street.Builder()
                .setTitle("Palace gates")
                .setRent("100")
                .build();
        fields[3] = new Street.Builder()
                .setTitle("Cold desert")
                .setRent("-20")
                .build();
        fields[4] = new Street.Builder()
                .setTitle("Walled city")
                .setRent("180")
                .build();
        fields[5] = new Street.Builder()
                .setTitle("Monastery")
                .setRent("0")
                .build();
        fields[6] = new Street.Builder()
                .setTitle("Black cave")
                .setRent("-70")
                .build();
        fields[7] = new Street.Builder()
                .setTitle("Huts in the mountain")
                .setRent("60")
                .build();
        fields[8] = new Street.Builder()
                .setTitle("The Werewall")
                .setRent("-80")
                .build();
        fields[9] = new Street.Builder()
                .setTitle("The pit")
                .setRent("-50")
                .build();
        fields[10] = new Street.Builder()
                .setTitle("Goldmine")
                .setRent("650")
                .build();


        // Leaves the rest of the fields available in the GUI empty
        for (int i = 11; i < 40; i++) {

            fields[i] = new Empty.Builder().build();
        }


        // Creates the GUI with the fieldarray
        GUI.create(fields);

        // Declares face values to show the die in the GUI
        int faceValue1 = shake.getDie()[0].getFaceValue();
        int faceValue2 = shake.getDie()[1].getFaceValue();


        // Displays the dice on the board
        GUI.setDice(faceValue1, faceValue2);
    }

    public static void gameStart() {

        // Two player objects are instantiated with names in turn.
        // The player objects are then added the playerArray.
        for (int i = 0; i <= playerArray.length - 1; i++) {
            String name = input.nextLine();
            Player player = new Player(name);
            playerArray[i] = player;

            // Adds player to the GUI
            // Adds a car object which has a new color, specified by a random-method between the integers 0-255
            GUI.addPlayer(player.getName(), 1000, new Car.Builder().primaryColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))).build());
        }


        // Initial parameters first time the game has started
        playerArray[0].setIsTurn(true);

        // Loops the game until a player has won
        while (!gameWon) {

            for (int i = 0; i <= playerArray.length - 1; i++) {

                while (playerArray[i].getIsTurn() && !gameWon) {

                    shake.shake();

                    handleFieldAction(shake.getSum(), playerArray[i]);

                    if (playerArray[i].hasWon()) {
                        System.out.println(playerArray[i].getName() + " Won");
                        gameWon = true;
                    } else {

                        //When the player should have more than 1 turn
                        if (shake.getSum() != 10) {

                            if (i + 1 <= playerArray.length - 1) {
                                playerArray[i + 1].setIsTurn(true);
                            } else {
                                playerArray[0].setIsTurn(true);

                            }

                            playerArray[i].setIsTurn(false);
                        }

                    }
                    input.nextLine();

                }

            }

        }

    }


    // Method for the gamelogic
    private static void handleFieldAction(int sum, Player player) {


        // Finds the value of the board
        String pointsString = ((Street) fields[sum - 2]).getLeje();
        int points = Integer.parseInt(pointsString);

        if (player.getCarSpot() != 0) {
            GUI.removeCar((player.getCarSpot()), player.getName());
        }

        GUI.setCar(sum - 1, player.getName());

        player.setCarSpot(sum - 1);

        // Adds or subtracts points to/from the players balance
        player.getAccount().addBalance(points);

        // Displays new balance in the GUI
        GUI.setBalance(player.getName(), player.getAccount().getBalance());

    }

}
