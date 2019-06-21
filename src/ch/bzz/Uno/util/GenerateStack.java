package ch.bzz.Uno.util;

import ch.bzz.Uno.model.ActionCard;
import ch.bzz.Uno.model.ColorCard;

import java.awt.*;
import java.util.ArrayList;

public class GenerateStack {

    private ArrayList<ColorCard> stack;

    public ArrayList<ColorCard> generateStack(){
        generateCards();
        generateActionCards();
        return stack;
    }

    private void generateCards(){
        for(int i = 0; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.blue);
            stack.add(card);
        }
        for(int i = 1; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.blue);
            stack.add(card);
        }
        for(int i = 0; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.yellow);
            stack.add(card);
        }
        for(int i = 1; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.yellow);
            stack.add(card);
        }
        for(int i = 0; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.red);
            stack.add(card);
        }
        for(int i = 1; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.red);
            stack.add(card);
        }
        for(int i = 0; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.green);
            stack.add(card);
        }
        for(int i = 0; i < 10;i++){
            ColorCard card = new ColorCard(String.valueOf(i), false, Color.green);
            stack.add(card);
        }

    }

    private void generateActionCards(){
        stack.add(new ActionCard("+2", false, Color.green, 1));
        stack.add(new ActionCard("+2", false, Color.green, 1));
        stack.add(new ActionCard("+2", false, Color.blue, 1));
        stack.add(new ActionCard("+2", false, Color.blue, 1));
        stack.add(new ActionCard("+2", false, Color.red, 1));
        stack.add(new ActionCard("+2", false, Color.red, 1));
        stack.add(new ActionCard("+2", false, Color.yellow, 1));
        stack.add(new ActionCard("+2", false, Color.yellow, 1));

        stack.add(new ActionCard("Reverse", false, Color.green, 2));
        stack.add(new ActionCard("Reverse", false, Color.green, 2));
        stack.add(new ActionCard("Reverse", false, Color.blue, 2));
        stack.add(new ActionCard("Reverse", false, Color.blue, 2));
        stack.add(new ActionCard("Reverse", false, Color.red, 2));
        stack.add(new ActionCard("Reverse", false, Color.red, 2));
        stack.add(new ActionCard("Reverse", false, Color.yellow, 2));
        stack.add(new ActionCard("Reverse", false, Color.yellow, 2));

        stack.add(new ActionCard("Skip", false, Color.green, 3));
        stack.add(new ActionCard("Skip", false, Color.green, 3));
        stack.add(new ActionCard("Skip", false, Color.blue, 3));
        stack.add(new ActionCard("Skip", false, Color.blue, 3));
        stack.add(new ActionCard("Skip", false, Color.red, 3));
        stack.add(new ActionCard("Skip", false, Color.red, 3));
        stack.add(new ActionCard("Skip", false, Color.yellow, 3));
        stack.add(new ActionCard("Skip", false, Color.yellow, 3));

        stack.add(new ActionCard("+4", false, Color.black, 4));
        stack.add(new ActionCard("+4", false, Color.black, 4));
        stack.add(new ActionCard("+4", false, Color.black, 4));
        stack.add(new ActionCard("+4", false, Color.black, 4));
        stack.add(new ActionCard("wish", false, Color.black, 5));
        stack.add(new ActionCard("wish", false, Color.black, 5));
        stack.add(new ActionCard("wish", false, Color.black, 5));
        stack.add(new ActionCard("wish", false, Color.black, 5));




    }

}
