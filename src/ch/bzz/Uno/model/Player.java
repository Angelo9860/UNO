package ch.bzz.Uno.model;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private String userName;
    private int points;
    public Player(String username){
        this.userName = username;
    }

    public void setHand(Card card){
        hand.add(card);
    }

    public void setPoints(int points){
        this.points += points;
    }

    public int getPoints(){
        return points;
    }
}
