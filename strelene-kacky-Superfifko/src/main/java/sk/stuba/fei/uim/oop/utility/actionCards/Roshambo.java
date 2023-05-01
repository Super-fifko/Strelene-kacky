package sk.stuba.fei.uim.oop.utility.actionCards;

import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;
import java.util.Collections;

public class Roshambo extends ActionCards{

    public int useCard(ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                       ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck) {
        Collections.shuffle(lake);
        return 0;
    }
    public Roshambo(){
        name = "Roshambo";
    }
}
