package Game;

import java.util.Scanner;

import desktop_fields.Field;
import desktop_resources.GUI;
import desktop_fields.*;

/**
 * Created by razze on 25-10-2016.
 */
public final class GameController {

    public static String name;


    private static Shaker shake = new Shaker(2);
    private static Player[] playerArray = new Player[2];
    private static Field[] fields = new Field[40];
    private static int[] points = new int[11];



    private GameController(){


    }

    public static void generateFields(){




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

        for(int i = 11; i < 40; i++ ){

            fields[i] = new Empty.Builder().build();
        }

        GUI.create(fields);
        GUI.setDice(1,1);


    }

    public static void gameStart(){

        // Two player objects are instantiated with names in turn.
        // The player objects are then added the playerArray.
        for(int i = 1; i <= 2; i++){

            Player player = new Player(name);
            playerArray[i] = player;
            GUI.addPlayer(player.getName(), 1000);

        }



        for(Player player : playerArray){

            // Checks which turn it is.
            if(player.getIsTurn() == true){

                // Checks if the player has won
                if(hasWon(player) == true){

                    //Something something
                    System.out.println(player.getName() + " has won!");

                }

               // EVERYTHING THAT HAPPENS IN THE PLAYER'S TURN

                // Rolls the dice
                shake.shake();
                handleFieldAction(shake.getSum(), player);

            }

        }
    }

   private static boolean hasWon(Player player) {

       int currentBalance = player.getAccount().getBalance();

       if(currentBalance <= 3000){

           return true;

       } else {

           return false;
       }

    }

   private static void handleFieldAction(int sum, Player player) {

        String points = ((Street)fields[4]).getLeje();

        GUI.setCar(sum, player.getName());



        //player.getAccount().addBalance()

    }



}
