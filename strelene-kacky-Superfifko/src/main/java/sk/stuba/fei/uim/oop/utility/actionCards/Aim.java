package sk.stuba.fei.uim.oop.utility.actionCards;

import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;

import static sk.stuba.fei.uim.oop.utility.ZKlavesnice.readInt;

public class Aim extends ActionCards{
    public int useCard(ArrayList<Aimer> aimBoard,ArrayList<BoardCards> lake,
                       ArrayList<Player> players, ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck){

           do {
               indexOfTarget = readInt("Please, choose an unaimed target!");
               indexOfTarget--;
               if(indexOfTarget <0|| indexOfTarget >5) {
                   System.out.println("Choose from range 1 to 6!");
               }
           }while(indexOfTarget <0|| indexOfTarget >5);
           while(true) {
               if (aimBoard.get(indexOfTarget).getState().equals("Unaimed")) {
                   aimBoard.get(indexOfTarget).setStateToTrue();
                   return 0;
               } else {
                   System.out.println("Chosen target is already aimed!");
               }
           }
        }

    public Aim(){
        name = "Aim";

    }
}
