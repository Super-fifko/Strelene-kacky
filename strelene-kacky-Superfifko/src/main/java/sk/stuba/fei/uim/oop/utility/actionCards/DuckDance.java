package sk.stuba.fei.uim.oop.utility.actionCards;


import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;
import java.util.Collections;

public class DuckDance extends ActionCards{

    public int useCard(ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                       ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck) {
        for(int i=0;i<6;i++){
            boardDeck.add(lake.get(0));
            lake.remove(0);
        }
        Collections.shuffle(boardDeck);
        for(int i=0;i<6;i++){
            lake.add(boardDeck.get(0));
            boardDeck.remove(0);
        }
        return 0;
    }

    public DuckDance(){
        name = "Duck dance";
    }
}
