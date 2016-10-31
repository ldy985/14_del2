package Game;

import desktop_codebehind.Car;
import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_resources.GUI;

import java.awt.*;
import java.util.Random;

/**
 * Created by razze on 25-10-2016.
 */

// Controls the logic and the flow of the game.
// Creates the player objects and the GUI.
// Handles input from the GUI.
public final class GameController {

    private static final Shaker shaker = new Shaker(2); // max 2 dice due to GUI limitation.
    private static final Player[] playerArray = new Player[2]; // max 6 players due to GUI limitation.
    private static final FieldNew[] fields = new FieldNew[40];
    private static final Random rand = new Random();
    private static boolean gameWon = false;

    //Prevent creation of a game controller object.
    private GameController() {
    }

    // Generates the fields for the board in a field array
    public static void initializeGui() {


        fields[0] = new FieldNew()
                .setTitle("Tower")
                .setRent(250)
                .setActionText("You climb a massive tower to find a chest of gold coins!");
        //.setSubText("r");

        fields[1] = new FieldNew()
                .setTitle("Crater")
                .setRent(-100)
                .setActionText("Oh no! You’ve fallen into a crater dropping valuables and coins trying to make your way back to the surface.");


        fields[2] = new FieldNew()
                .setTitle("Palace gates")
                .setRent(100)
                .setActionText("You perform a small act as the king of the palace goes through the palace gates and he gives you some coins from his pockets.");


        fields[3] = new FieldNew()
                .setTitle("Cold desert")
                .setRent(-20)
                .setActionText("You freeze in the darkness of the cold desert night. You use some of your goods to burn for warmth.");


        fields[4] = new FieldNew()
                .setTitle("Walled city")
                .setRent(180)
                .setActionText("You enter a Walled city with a grand market where you haggle your way to a nice profit!");


        fields[5] = new FieldNew()
                .setTitle("Monastery")
                .setRent(0)
                .setActionText("You enter the quiet monastery and nothing happens.");


        fields[6] = new FieldNew()
                .setTitle("Black cave")
                .setRent(-70)
                .setActionText("A bear blocks the exit to the black cave. You throw some of your meat wares to lure it away and escape with your life intact.");


        fields[7] = new FieldNew()
                .setTitle("Huts in the mountain")
                .setRent(60)
                .setActionText("You sell some of your stocked goods to the villagers from the huts in the mount making a small profit.");


        fields[8] = new FieldNew()
                .setTitle("The Werewall")
                .setRent(-80)
                .setActionText("You get bit by a werewolf. To counteract the effects you buy an antidote." +
                        " The antidote is expensive however it also gives you renewed strength and energy for another journey.");


        fields[9] = new FieldNew()
                .setTitle("The pit")
                .setRent(-50)
                .setActionText("You fell in a pit! Some of your equipment broke from the fall and needs to be repaired...");


        fields[10] = new FieldNew()
                .setTitle("Goldmine")
                .setRent(650)
                .setActionText("You reached the goldmine! You mine immense amounts of gold and sells it to great profit in the nearby town!");


        Field[] tempField = new Field[40];

        for (int i = 0; i < 11; i++) {
            tempField[i] = fields[i].toField();
        }

        // Leaves the rest of the fields available in the GUI empty
        for (int i = 11; i < 40; i++) {

            tempField[i] = new Empty.Builder().build();
        }


        // Creates the GUI with the fieldarray
        GUI.create(tempField);


    }

    // Method for the game initialization.
    public static void startGame() {


        initializePlayers();

        // Sets the first turn to player 1.
        playerArray[0].setIsTurn(true);

        // Loops the game until a player has won.
        while (!gameWon) {

            //Go though all players
            for (int i = 0; i <= playerArray.length - 1; i++) {

                // Checks which player has the turn.
                while (playerArray[i].getIsTurn() && !gameWon) {

                    shaker.shake();

                    displayDice(shaker);


                    handleFieldAction(shaker.getSum(), playerArray[i]);

                    if (playerArray[i].hasWon()) {
                        GUI.showMessage(playerArray[i].getName() + " Won");
                        gameWon = true;
                    } else {

                        // When the player should have more than 1 turn
                        if (shaker.getSum() != 10) {

                            if (i + 1 <= playerArray.length - 1) {
                                playerArray[i + 1].setIsTurn(true);
                            } else {
                                playerArray[0].setIsTurn(true);

                            }

                            playerArray[i].setIsTurn(false);
                        }
                    }
                }
            }
        }
        GUI.close();
    }

    private static void initializePlayers() {
        // Two player objects are instantiated with names in turn.
        // The player objects are then added the playerArray.
        for (int i = 0; i <= playerArray.length - 1; i++) {
            String name = GUI.getUserString("Insert name of player " + (i + 1));
            Player player = new Player(name);
            playerArray[i] = player;

            // Adds player to the GUI
            // Adds a car object which has a new color, specified by a random-method between the integers 0-255
            GUI.addPlayer(player.getName(), 1000, new Car.Builder()
                    .primaryColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)))
                    .build());
        }
    }

    private static void displayDice(Shaker shaker) {

        // Declares face values to show the die in the GUI
        int faceValue1 = shaker.getDice()[0].getFaceValue();
        int faceValue2 = shaker.getDice()[1].getFaceValue();


        // Displays the dice on the board
        GUI.setDice(faceValue1, faceValue2);
    }


    // Method for the gamelogic
    private static void handleFieldAction(int sum, Player player) {




        //"Moves" the car on the board by removing it in the previous location
        // and then set it to the new location.
        GUI.removeAllCars(player.getName());
        GUI.setCar(sum - 1, player.getName());

        // Finds the modifier of the specific field.
        int points = fields[sum - 2].getRent();

        // Adds or subtracts points to/from the players balance
        player.getAccount().addBalance(points);

        // Displays new balance in the GUI
        GUI.setBalance(player.getName(), player.getAccount().getBalance());

        GUI.showMessage(fields[sum - 2].getActionText());

    }

}
