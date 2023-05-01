package sk.stuba.fei.uim.oop.utility.actionCards;
import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;

import static sk.stuba.fei.uim.oop.utility.ZKlavesnice.readInt;

public class TurboDuck extends ActionCards{

    public int useCard(ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                       ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck) {
        do{
            do{
                indexOfTarget = readInt("Please, choose a target!");
                indexOfTarget--;
                if(indexOfTarget <0|| indexOfTarget >5)
                    System.out.println("Choose from range 1 to 6!");

            }while(indexOfTarget <0|| indexOfTarget >5);
            if(lake.get(indexOfTarget).getDesc()=="Water"){
                System.out.println("Must not be a water!\n");
            }
        }while(lake.get(indexOfTarget).getDesc()=="Water");
        lake.add(0,lake.get(indexOfTarget));
        lake.remove((indexOfTarget +1));
        return 0;
    }
    public TurboDuck(){
        name = "Turbo duck";
    }
}
