package sk.stuba.fei.uim.oop.utility.boardCards;

import java.util.ArrayList;

public abstract class BoardCards {
    protected int index;
    protected String desc;

    public void isHit(ArrayList<BoardCards> lake,ArrayList<BoardCards> boardDeck,int index){
        System.out.println("You hit water!");

    }

    public int getIndex(){
        return index;
    }
    public String getDesc(){
        return this.desc;
    }
    public void discard(){
        //placeholder
    };
    public void putToDeck(){
        //placeholder
    }
}
