package ch.bzz.Uno.model;


import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.util.ShuffleDeck;

import java.util.ArrayList;

public class Field {

    private ArrayList<Card> stack;
    private ArrayList<Card> onFieldStack;
    private ArrayList<Player> players;
    private Player onTurnPlayer;
    private Player currentlyPlaying;

    public Field(ArrayList<Card> stack, ArrayList<Player> players) {
        this.stack = stack;
        this.players = players;
    }

    //TODO: Not sure if needed.
    public ArrayList<Card> getStack() {
        return stack;
    }

    public void setStack(ArrayList<Card> stack) {
        this.stack = stack;
    }

    public Card drawCard() {
        Card card;
        if (stack.size() != 0) {
            card = stack.get(0);
            stack.remove(0);
            currentlyPlaying.setHand(card);
            return card;
        } else {
            setNewOnFieldStack(ShuffleDeck.shuffleDeck(getOnFieldStack()));
            card = stack.get(0);
            stack.remove(0);
            currentlyPlaying.setHand(card);
            return card;
        }
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
        return onFieldStack.get(onFieldStack.size() - 1);
    }

    public void setPlayer(Player player) {
        player.setId(players.size());
        players.add(player);
    }

    public void setOnTurnPlayer(Player player) {
        onTurnPlayer = player;
    }

    public void handOutCards() {
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < players.size(); x++) {
                players.get(i).setHand(drawCard());
            }
        }
    }

    public void setOnFieldStack(Card card) {
        onFieldStack.add(card);
    }

    public ArrayList<Card> getOnFieldStack() {
        return onFieldStack;
    }

    public void setNewOnFieldStack(ArrayList<Card> stack) {
        onFieldStack = stack;
    }

    public void setFirstCard() {
        setOnFieldStack(drawCard());
    }
}




