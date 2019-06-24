package ch.bzz.Uno.model;

import java.awt.*;

public class Card {
    private String value;
    private boolean isActionCard;
    private Color color;
    private int action;

    public Card(String value, boolean isActionCard, Color color, int action) {
        this.value = value;
        this.isActionCard = isActionCard;
        this.color = color;
        this.action = action;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isActionCard() {
        return isActionCard;
    }

    public void setActionCard(boolean actionCard) {
        isActionCard = actionCard;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAction() {
        return action;
    }


}
