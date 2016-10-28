package Game;

import java.util.Scanner;

import desktop_fields.Field;
import desktop_resources.GUI;
import desktop_fields.*;

/**
 * Created by razze on 25-10-2016.
 */
public final class GameController {

    private static String name;
    private static Shaker shake = new Shaker(2);
    private static Player[] playerArray = new Player[2];
    private static Field[] fields = new Field[40];
    private static int[] points = new int[11];
    private static Scanner input = new Scanner(System.in);
    private static boolean gameWon = false;
    private static int turn;



    private GameController(){


    }

    // Generates the fields for the board in a field array
    public static void generateFields(){


        fields[1] = new Street.Builder()
                .setTitle("Tower")
                .setRent("250")
                .build();
        fields[2] = new Street.Builder()
                .setTitle("Crater")
                .setRent("-100")
                .build();
        fields[3] = new Street.Builder()
                .setTitle("Palace gates")
                .setRent("100")
                .build();
        fields[4] = new Street.Builder()
                .setTitle("Cold desert")
                .setRent("-20")
                .build();
        fields[5] = new Street.Builder()
                .setTitle("Walled city")
                .setRent("180")
                .build();
        fields[6] = new Street.Builder()
                .setTitle("Monastery")
                .setRent("0")
                .build();
        fields[7] = new Street.Builder()
                .setTitle("Black cave")
                .setRent("-70")
                .build();
        fields[8] = new Street.Builder()
                .setTitle("Huts in the mountain")
                .setRent("60")
                .build();
        fields[9] = new Street.Builder()
                .setTitle("The Werewall")
                .setRent("-80")
                .build();
        fields[10] = new Street.Builder()
                .setTitle("The pit")
                .setRent("-50")
                .build();
        fields[11] = new Street.Builder()
                .setTitle("Goldmine")
                .setRent("650")
                .build();
        fields[0] = new Empty.Builder().build();

        // Leaves the rest of the fields available in the GUI empty
        for(int i = 12; i < 40; i++ ){

            fields[i] = new Empty.Builder().build();
        }

        // Declares facevalues to show the die in the GUI
        int faceValue1 = shake.getDie()[0].getFaceValue();
        int faceValue2 = shake.getDie()[1].getFaceValue();

        // Creates the GUI with the fieldarray
        GUI.create(fields);

        // Displays the dice on the board
        GUI.setDice(faceValue1,faceValue2);


    }

    public static void gameStart(){

        // Two player objects are instantiated with names in turn.
        // The player objects are then added the playerArray.
        for(int i = 0; i <= 1; i++){

            name = input.nextLine();
            Player player = new Player(name);
            playerArray[i] = player;
            GUI.addPlayer(player.getName(), 1000);

        }

        // Initial parameters first time the game has started
        turn = 1;
        playerArray[0].setIsTurn(true);
        playerArray[1].setIsTurn(false);


        // Loops the game until a player has won
        while(!gameWon){

            // One player has to start out
            for(int i = 0; i < 2; i++){

                Player player = playerArray[i];

                // Checks which turn it is.
                if(player.getIsTurn() == true){

                    // EVERYTHING THAT HAPPENS IN THE PLAYER'S TURN

                    // Rolls the dice
                    shake.shake();

                    // Gamelogic: Decides what to do with the sum rolled
                    handleFieldAction(shake.getSum(), player);

                    // Players get an extra turn if they land on board 9 (The Werewall)
                    if(shake.getSum() == 10){
                        player.setExtraTurn(true);
                    }

                    // Checks if the player has won
                    if(hasWon(player) == true){

                        System.out.println(player.getName() + " has won!");
                        gameWon = true;
                    }

                    // Switches turn based on array position if extraTurn is false
                    if(i == 0 && player.getExtraTurn() == false){

                        playerArray[0].setIsTurn(false);
                        playerArray[1].setIsTurn(true);

                    }
                    if(i == 1 && player.getExtraTurn() == false){

                        playerArray[0].setIsTurn(true);
                        playerArray[1].setIsTurn(false);
                    }

                    // Makes sure to deactivate the extraTurn priviledge to false again
                    player.setExtraTurn(false);

                    // KAN ÆNDRES TIL MOUSECLICK, "next" KNAP, ELLER NOGET HELT ANDET
                    // Makes the for-loop wait for input for next move
                    input.nextLine();

                    // Increments the turn value
                    turn++;

                }

            }

        }

    }

   // Method for checking if someone has won
   private static boolean hasWon(Player player) {

       int currentBalance = player.getAccount().getBalance();

       if(currentBalance >= 3000){

           return true;

       } else {

           return false;
       }

    }

   // Method for the gamelogic
   private static void handleFieldAction(int sum, Player player) {

        // BARE EN DEBUG TING
        System.out.println(sum);

        // Finds the value of the board
        String pointsString = ((Street)fields[(sum - 1)]).getLeje();
        int points = Integer.parseInt(pointsString);

        // If-statement to make sure we only place new cars for the two players
        if(turn <= 2) {

            // Places a car on the board
            GUI.setCar((sum), player.getName());

            // Saves the previous location (sum).
            player.setSumTemp(shake.getSum());

        // After the new cars have been added, we can remove and add a car to "move" it
        } else {

            GUI.removeCar((player.getSumTemp()), player.getName());
            GUI.setCar((sum), player.getName());

            player.setSumTemp(shake.getSum());

            }

            // Adds or subtracts points to/from the players balance
            player.getAccount().addBalance(points);

            // Displays new balance in the GUI
            GUI.setBalance(player.getName(), player.getAccount().getBalance());

        }

}
