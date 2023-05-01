package sk.stuba.fei.uim.oop.utility.actionCards;


import sk.stuba.fei.uim.oop.utility.Aimer;
import sk.stuba.fei.uim.oop.utility.Player;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;

import java.util.ArrayList;

public abstract class ActionCards {
    public String name;
    public int indexOfTarget;
    private boolean usability=true;
    public int useCard(ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                       ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck) {
        return 0;
    }
    public void setUsabilityToTrue(){
        this.usability=true;
    }
    public void setUsabilityToFalse(){
        this.usability=false;
    }
    public boolean getUsability(){
        return this.usability;
    }
    public String getUsabilityVerbally(){
        if(this.usability){
            return "Usable";
        }
        else{
            return "Not usable";
        }
    }


    public int getIndexOfTarget(){
        return this.indexOfTarget;
    }
}
