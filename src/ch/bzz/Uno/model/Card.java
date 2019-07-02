package ch.bzz.Uno.model;

import java.awt.*;

public class Card {
    private String value;
    private boolean isActionCard;
    private Color color;
    private int action;

    public Card() {

    }

    public Card(String value, boolean isActionCard, Color color, int action) {
        this.value = value;
        this.isActionCard = isActionCard;
        this.color = color;
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public boolean isActionCard() {
        return isActionCard;
    }

    public Color getColor() {
        return color;
    }

    public int getAction() {
        return action;
    }


}
