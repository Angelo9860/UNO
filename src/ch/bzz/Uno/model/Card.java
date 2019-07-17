package ch.bzz.Uno.model;

import java.awt.*;

/**
 * @author : Angelo Lachnit
 * @version : 1.0
 * @description: Card with a value ,a color, an action and a flag if its an action card or not
 */

public class Card {
    private String value;
    private boolean isActionCard;
    private Color color;
    private int action;

    public Card() {

    }

    /**
     *
     * @param value String value
     * @param isActionCard boolean isActionCard
     * @param color Color color
     * @param action int action
     */
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
