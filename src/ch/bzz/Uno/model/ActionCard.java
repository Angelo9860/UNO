package ch.bzz.Uno.model;


import java.awt.*;

public class ActionCard extends ColorCard {


    private static int ACTION;

    public ActionCard(String value, boolean isActionCard, Color color, int action) {
        super(value, isActionCard, color);
        this.ACTION = action;
    }


    public static int getACTION() {
        return ACTION;
    }
}
