package ch.bzz.Uno.model;


import ch.bzz.Uno.model.Card;

import java.util.ArrayList;

public class Field {

    private ArrayList<Card> stack;
    private ArrayList<Card> doneStack;
    private ArrayList<Player> players;
    private Player onTurnPlayer;
    private Player currentlyPlaying;

    public Field(ArrayList<Card> stack, ArrayList<Player> players) {
        this.stack = stack;
        this.players = players;
    }


    public ArrayList<Card> getStack() {
        return stack;
    }

    public void setStack(ArrayList<Card> stack) {
        this.stack = stack;
    }

    public Card drawCard() {
        Card card = stack.get(0);
        stack.remove(0);
        currentlyPlaying.setHand(card);
        return card;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }



    public void setCurrentlyPlaying(Player player) {
        currentlyPlaying = player;
    }
    //TODO: Return Player who is currently playing
    public Player getCurrentlyPlaying() {
        return currentlyPlaying;

    }

    //TODO: Return current card on donestack
    public Card getCurrentCard() {
        //Idea, size is always one bigger then the card added last.
        return doneStack.get(doneStack.size() - 1);
    }

    public void setOnTurnPlayer(Player player) {
        onTurnPlayer = player;
    }

}




