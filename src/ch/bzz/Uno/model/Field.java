package ch.bzz.Uno.model;

import ch.bzz.Uno.util.ShuffleDeck;

import java.awt.*;
import java.util.ArrayList;

public class Field {

    private ArrayList<Card> drawStack = new ArrayList<>();
    private ArrayList<Card> onFieldStack = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private Player currentlyPlaying;
    public Field() {
    }

    public Card drawCard() {
        Card card;
        if (drawStack.size() != 0) {
            card = drawStack.get(0);
            drawStack.remove(0);
            return card;
        } else {
            Card onFieldStackLastCard = onFieldStack.get(onFieldStack.size()-1);
            setNewOnFieldStack(ShuffleDeck.shuffleDeck(getOnFieldStack()));
            setOnFieldStack(onFieldStackLastCard);
            card = drawStack.get(0);
            drawStack.remove(0);
            return card;
        }
    }


    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setCurrentlyPlaying(Player player) {
        currentlyPlaying = player;
    }

    public Player getCurrentlyPlaying() {
        return currentlyPlaying;

    }

    //TODO: Return current card on donestack
    public Card getCurrentCard() {
        //Idea, size is always one bigger then the card added last.
        return onFieldStack.get(onFieldStack.size() - 1);
    }
//TODO: IMPLEMENT REVERSE
    public void setPlayer(Player player) {
        player.setId(players.size());
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }


    public void handOutCards() {
        for (int i = 0; i < 7; i++) {
            for (int x = 0; x < players.size(); x++) {
                players.get(x).setHand(drawCard());
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

    //TODO: Not sure if needed.
    public ArrayList<Card> getDrawStack() {
        return drawStack;
    }

    public void setDrawStack(ArrayList<Card> stack) {
        this.drawStack = stack;
    }


}




