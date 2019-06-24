package ch.bzz.Uno.model;

import ch.bzz.Uno.model.Card;

import java.util.ArrayList;

public class Player {
    private int id;
    private ArrayList<Card> hand;
    private String userName;
    private int points;

    public Player(String username) {
        this.userName = username;
    }

    public void setHand(Card card) {
        hand.add(card);
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }
    public ArrayList<Card> getHand(){
        return  hand;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
