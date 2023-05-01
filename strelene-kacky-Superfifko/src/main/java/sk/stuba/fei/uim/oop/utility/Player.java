package sk.stuba.fei.uim.oop.utility;
import sk.stuba.fei.uim.oop.utility.actionCards.ActionCards;

import java.util.ArrayList;

public class Player {
    private int playerIndex;
    private String playerName;
    private int lifeAmount = 5;
    public ArrayList<ActionCards> cards;

    public String getPlayerName(){
        return this.playerName;
    }

    public void getCard(ActionCards card){
        cards.add(card);
    }

    public void playerHit(){
        this.lifeAmount--;
        System.out.println(playerName +"'s health is now " + this.lifeAmount + ".");
        System.out.println();
    }
    public int getLifeAmount(){
        return this.lifeAmount;
    }
    public void playerDies(){
        System.out.println(this.getPlayerName()+" dies. :(");
    }
    public int getPlayerIndex(){
        return this.playerIndex;
    }
    public Player(int index, String meno){
        playerIndex = index;
        playerName = meno;
        cards = new ArrayList<>();
    }
}
