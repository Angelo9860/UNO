package ch.bzz.Uno.model;
import java.util.ArrayList;

public class Player {
    private int id;
    private ArrayList<Card> hand = new ArrayList<>();
    private String userName;
    private int points;

    public Player(String username) {
        this.userName = username;
    }

    public Card setHand(Card card) {
        hand.add(card);
        return card;
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
    public String getUserName(){
        return userName;
    }
    public void removeCard(Card card){
    }
}
