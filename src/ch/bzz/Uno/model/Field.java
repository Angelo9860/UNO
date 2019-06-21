package ch.bzz.Uno.model;

import javax.smartcardio.Card;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Field {

    private ArrayList<Card> stack;
    private ArrayList<Player> players;

    public Field(ArrayList<Card> stack, ArrayList<Player> players){
        this.stack = stack;
        this.players = players;
    }


    public ArrayList<Card> getStack() {
        return stack;
    }

    public void setStack(ArrayList<Card> stack) {
        this.stack = stack;
    }

    public Card drawCard(){
        Card card = stack.get(0);
        stack.remove(0);
        return card;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
