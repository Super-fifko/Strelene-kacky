package sk.stuba.fei.uim.oop.utility.boardCards;

import sk.stuba.fei.uim.oop.utility.Player;

import java.util.ArrayList;

public class Duck extends BoardCards {
    Player owner;

    public void isHit(ArrayList<BoardCards> lake, ArrayList<BoardCards> boardDeck,int index){
        System.out.println("You hit "+ this.getDesc());
        lake.remove(index);
        lake.add(boardDeck.get(0));
        boardDeck.remove(0);
        owner.playerHit();
    }
    public Duck(int duckIndex, Player ownerer){
        index = duckIndex;
        this.owner=ownerer;
        desc = owner.getPlayerName() + "'s duck";

    }
}
