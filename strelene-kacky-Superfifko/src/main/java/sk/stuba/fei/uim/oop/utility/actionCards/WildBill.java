package sk.stuba.fei.uim.oop.utility.actionCards;
import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;

import static sk.stuba.fei.uim.oop.utility.ZKlavesnice.readInt;


public class WildBill extends ActionCards{

    public int useCard(ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                       ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck) {
        do{
        indexOfTarget = readInt("Please, choose a target!");
        indexOfTarget--;
        if (indexOfTarget <0|| indexOfTarget >5){
            System.out.println("Choose from range 1 to 6!");
        }
        }while(indexOfTarget <0|| indexOfTarget >5);
        if (aimBoard.get(indexOfTarget).getState().equals("Aimed")){
            actionDeck.add(new Aim());
            aimBoard.get(indexOfTarget).setStateToFalse();
        }
        lake.get(indexOfTarget).isHit(lake,boardDeck, indexOfTarget);
        return 0;
    }
    public WildBill(){
        name = "Wild Bill";
    }
}
