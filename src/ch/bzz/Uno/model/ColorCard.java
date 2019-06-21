package ch.bzz.Uno.model;

import java.awt.*;

public class ColorCard {
    private String value;
    private boolean isActionCard;
    private Color color;

    public ColorCard(String value, boolean isActionCard, Color color){
        this.value = value;
        this.isActionCard = isActionCard;
        this.color = color;
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





}
