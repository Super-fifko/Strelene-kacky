package sk.stuba.fei.uim.oop.utility.actionCards;
import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;

import static sk.stuba.fei.uim.oop.utility.ZKlavesnice.readInt;


public class Shoot extends ActionCards{

    public int useCard(ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                       ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck){
        while(true){
            do {
            indexOfTarget = readInt("Please, choose an aimed target!");
            indexOfTarget--;
            if(indexOfTarget <0|| indexOfTarget >5) {
                System.out.println("Choose from range 1 to 6!");

            }else{

                if (aimBoard.get(indexOfTarget).getState().equals("Aimed")) {
                    lake.get(indexOfTarget).isHit(lake,boardDeck, indexOfTarget);
                    aimBoard.get(indexOfTarget).setStateToFalse();
                    return 0;
                } else {
                    System.out.println("Chosen target is not aimed!");
                }}
            }while(indexOfTarget <0|| indexOfTarget >6);
        }
    }
    public Shoot(){
        name = "Shoot";
    }
}
