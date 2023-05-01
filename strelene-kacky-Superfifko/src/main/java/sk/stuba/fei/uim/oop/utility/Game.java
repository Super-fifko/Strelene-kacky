package sk.stuba.fei.uim.oop.utility;

import sk.stuba.fei.uim.oop.utility.actionCards.*;
import sk.stuba.fei.uim.oop.utility.boardCards.BoardCards;
import sk.stuba.fei.uim.oop.utility.boardCards.Duck;
import sk.stuba.fei.uim.oop.utility.boardCards.Water;
import java.util.ArrayList;
import java.util.Collections;
import static sk.stuba.fei.uim.oop.utility.ZKlavesnice.readInt;
import static sk.stuba.fei.uim.oop.utility.ZKlavesnice.readString;

public class Game {
    ArrayList<ActionCards> actionDeck = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<BoardCards> boardDeck = new ArrayList<>();
    ArrayList<BoardCards> lake = new ArrayList<>();
    ArrayList<Aimer> aimBoard = new ArrayList<>();
    int amountOfPlayers;


    public void innitDeck() {
        for (int i = 0; i < 10; i++) {
            this.actionDeck.add(new Aim());
        }
        for (int i = 0; i < 12; i++) {
            this.actionDeck.add(new Shoot());
        }
        for (int i = 0; i < 6; i++) {
            this.actionDeck.add(new DuckMarch());
        }
        for (int i = 0; i < 2; i++) {
            this.actionDeck.add(new WildBill());
        }
        for (int i = 0; i < 2; i++) {
            this.actionDeck.add(new Roshambo());
        }
        this.actionDeck.add(new TurboDuck());
        this.actionDeck.add(new DuckDance());
        Collections.shuffle(actionDeck);
    }
    public boolean playerNameCheck(ArrayList<Player> players, String name) {
        if (players.size()>0) {
            for (Player i : players) {
                if (i.getPlayerName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void innitPlayer(int amount_of_players, ArrayList<ActionCards> Cards,ArrayList<Player> players) {
        String name;
        boolean bool;
        for (int i = 0; i < amount_of_players; i++) {
            do{name=readString("Insert name of a player");
            bool = playerNameCheck(players, name);
            if(bool){System.out.println("The name is already used");}
            }while(bool);

            players.add(new Player(i, name));
            for (int a = 0; a < 3; a++) {
                players.get(i).getCard(Cards.get(0));
                Cards.remove(0);
            }
            for (int x = 0; x < 5; x++) {
                this.boardDeck.add(new Duck(i, players.get(i)));
            }
        }
        for (int x = 0; x < 5; x++) {
            this.boardDeck.add(new Water());
        }
        Collections.shuffle(boardDeck);
    }

    public void createBoard() {
        for (int x = 0; x < 6; x++) {
            aimBoard.add(new Aimer());
            lake.add(boardDeck.get(0));
            boardDeck.remove(0);
        }
    }

    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + 1 + ". " + aimBoard.get(i).getState() + " - " + lake.get(i).getDesc());
        }
        System.out.println();
    }

    public void printHandWithoutUsability(Player player) {
        System.out.println(player.getPlayerName()+", these are your cards:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1)+". "+player.cards.get(i).name);
        }
    }
    public void printHandWithUsability(Player player) {
        System.out.println(player.getPlayerName()+", these are your cards:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1)+". "+player.cards.get(i).name + " - " +player.cards.get(i).getUsabilityVerbally());
        }
    }
    public boolean checkAimed(ArrayList<Aimer> aimBoard){
        int aimCount=0;
        for(int i = 0; i<6; i++){
            if (aimBoard.get(i).getState().equals("Aimed")){
                aimCount++;
            }
        }
        if (aimCount==6){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkUnaimed(ArrayList<Aimer> aimBoard){
        int aimCount=0;
        for(int i = 0; i<6; i++){
            if (aimBoard.get(i).getState().equals("Unaimed")){
                aimCount++;
            }
        }
        if (aimCount==6){
            return true;
        }
        else{
            return false;
        }
    }

    public int usabilityCheck(Player player) {
        int unusableCards = 0;
        if (checkAimed(aimBoard)) {
            for (int i = 0; i < 3; i++) {
                if (player.cards.get(i).name.equals("Aim")) {
                    player.cards.get(i).setUsabilityToFalse();
                    unusableCards++;
                }
            }
        } else if (checkUnaimed(aimBoard)) {
            for (int i = 0; i < 3; i++) {
                if (player.cards.get(i).name.equals("Shoot")) {
                    player.cards.get(i).setUsabilityToFalse();
                    unusableCards++;
                }
            }
        }
        return unusableCards;
    }

    public void makeHandUsable(Player player){
        for(int i=0;i<3;i++){
            player.cards.get(i).setUsabilityToTrue();
        }

    }

    public ActionCards playCard(Player player){
        int usedCardIndex;
        ActionCards usedCard;
        if(usabilityCheck(player)==3){
            printHandWithoutUsability(player);
            System.out.println("All cards are unusable.");
                do {
                    usedCardIndex = readInt("Choose a card to discard! (1-3)");
                    usedCardIndex--;
                    if(usedCardIndex < 0 || usedCardIndex >2){
                        System.out.println("From 1 to 3...");
                    }
                } while (usedCardIndex < 0 || usedCardIndex > 2);

            actionDeck.add(player.cards.get(usedCardIndex));
            player.cards.remove(usedCardIndex);
            player.cards.add(actionDeck.get(0));
            actionDeck.remove(0);
            makeHandUsable(player);
            return new PseudoCard();
        }
        else{
        do {
            do {
                printHandWithUsability(player);
                usedCardIndex = readInt("\nChoose a card to play! (1-3)");
                usedCardIndex--;
                if (usedCardIndex < 0 || usedCardIndex > 2) {
                    System.out.println("From 1 to 3...\n");
                }
            } while (usedCardIndex < 0 || usedCardIndex > 2);
            if(!player.cards.get(usedCardIndex).getUsability()){
                System.out.println("Unusable card, choose another\n");
            }
        }while(!player.cards.get(usedCardIndex).getUsability());
        usedCard=player.cards.get(usedCardIndex);
        actionDeck.add(player.cards.get(usedCardIndex));
        player.cards.remove(usedCardIndex);
        player.cards.add(actionDeck.get(0));
        actionDeck.remove(0);
        makeHandUsable(player);
        return usedCard;
        }
    }

    public void useCard(ActionCards usedCard, ArrayList<Aimer> aimBoard, ArrayList<BoardCards> lake,
                        ArrayList<Player> players,ArrayList<ActionCards> actionDeck,ArrayList<BoardCards> boardDeck){
        usedCard.useCard( aimBoard,  lake, players, actionDeck, boardDeck);

    }



    public Game() {
        System.out.println("Greetings, please, set the number of players.");
        do {
            amountOfPlayers = readInt("The number of players must be at least 2, maximum 6.");
        } while (amountOfPlayers < 2 || amountOfPlayers > 6);

        innitDeck();
        innitPlayer(amountOfPlayers, actionDeck, players);
        createBoard();


        while(players.size()!=1) {
            for(int i=0;i<players.size();i++){
                printBoard();
                useCard(playCard(players.get(i)), aimBoard, lake,
                        players,actionDeck,boardDeck);

                }

            for(int x=0;x<players.size();x++){
                if(players.get(x).getLifeAmount()==0){
                    players.get(x).playerDies();
                    players.remove(x);
                }
            }
        }
        System.out.println("\nThe winner is: " + players.get(0).getPlayerName());
    }



}
