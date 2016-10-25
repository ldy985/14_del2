package Game;

import java.util.Scanner;
import desktop_resources.GUI;

/**
 * Created by razze on 25-10-2016.
 */
public final class GameController {

   public static String name;


    private static Shaker shake = new Shaker(2);
    private static Player[] playerArray = new Player[2];
    private static Scanner input = new Scanner(System.in);


    private GameController(){

        // Two player objects are instantiated with names in turn.
        // The player objects are then added the playerArray.
        for(int i = 1; i <= 2; i++){

            name = input.nextLine();

            Player player = new Player(name);
            playerArray[i] = player;

            //NOT SURE ABOUT THIS
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


              //Checks what happens on each field corresponding to the sum rolled.





           }

        }

    }

    boolean hasWon(Player player) {


        return true;
    }

    int handleFieldAction(int sum) {



        return 0;
    }



}
